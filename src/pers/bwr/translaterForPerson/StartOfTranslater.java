package pers.bwr.translaterForPerson;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import pers.bwr.translaterForPerson.GUI.Progress;
import pers.bwr.translaterForPerson.initialization.IniReader;
import pers.bwr.translaterForPerson.mode.ReadingMode;
import pers.bwr.translaterForPerson.mode.TranslatePart;
import pers.bwr.translaterForPerson.mode.part.WorkPart;
import pers.bwr.translaterForPerson.work.WorkInLongTxt;
import pers.bwr.translaterForPerson.work.WorkInLongTxtWithRandom;
import pers.bwr.translaterForPerson.work.WorkInShortTxt;
import pers.bwr.translaterForPerson.work.fac.Work;

public class StartOfTranslater {

	public static void main(String[] args) {
		try {
		//正式代码
		
		//测试用代码
		
		/* //测试枚举
		ReadingMode test = ReadingMode.ReadLineFromShortTxt;
		System.out.println(test.name());
		*/
		
		/*（测试从txt中读取一行的代码
		try {
			String txtLine = new ReadLineFromShortTxt().readLine("oneLine.txt");
			System.out.println(txtLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//测试从txt中读取一行的代码）*/
		
		//new Progress();
		@SuppressWarnings("rawtypes")
		Map ini = new HashMap();
		
		//》测试从txt中读取配置
		try {
			IniReader nrdr = new IniReader();
			ini = nrdr.readIni();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//《测试从txt中读取配置
		
		//从ShortTxt中读取
		if(ini.get(WorkPart.ReadingMode) == ReadingMode.ReadLineFromShortTxt) {		
			@SuppressWarnings("unchecked")
			Work workPro = new WorkInShortTxt(ini.get(WorkPart.ReadingFrom).toString() , (HashSet<TranslatePart>)ini.get(WorkPart.TranslateMode) , ini.get(WorkPart.WritingTo).toString());
			//System.out.println(workPro.getWorkResult());
			workPro.getWorkResult();
		}
		if(ini.get(WorkPart.ReadingMode) == ReadingMode.ReadLineFromLongTxt) {
			@SuppressWarnings("unchecked")
			Work workPro = new WorkInLongTxt(ini.get(WorkPart.ReadingFrom).toString() , (HashSet<TranslatePart>)ini.get(WorkPart.TranslateMode) , ini.get(WorkPart.WritingTo).toString());
			workPro.getWorkResult();
		}
		if(ini.get(WorkPart.ReadingMode) == ReadingMode.ReadLongTxtWithRandom) {
			@SuppressWarnings("unchecked")
			Work workPro = new WorkInLongTxtWithRandom(ini.get(WorkPart.ReadingFrom).toString() , (HashSet<TranslatePart>)ini.get(WorkPart.TranslateMode) , ini.get(WorkPart.WritingTo).toString());
			workPro.getWorkResult();
		}
		
		System.out.println("程序执行结束，任务已完成。请关闭程序。");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
