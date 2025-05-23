package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleTemplateInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String AgeMapWord;
    public String DayLabelWord;
    public String DescMapWord;
    public String GenderMapWord;
    public String LocationMapWord;
    public String MonthLabelWord;
    public String NickWord;
    public String QqLogo;
    public String StarMapWord;
    public String TimeMapWord;

    public CircleTemplateInfo() {
        this.QqLogo = "";
        this.NickWord = "";
        this.TimeMapWord = "";
        this.LocationMapWord = "";
        this.DescMapWord = "";
        this.StarMapWord = "";
        this.MonthLabelWord = "";
        this.DayLabelWord = "";
        this.AgeMapWord = "";
        this.GenderMapWord = "";
    }

    public String className() {
        return "SHADOW_BACKEND_INTERFACE.CircleTemplateInfo";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.QqLogo, "QqLogo");
        jceDisplayer.display(this.NickWord, "NickWord");
        jceDisplayer.display(this.TimeMapWord, "TimeMapWord");
        jceDisplayer.display(this.LocationMapWord, "LocationMapWord");
        jceDisplayer.display(this.DescMapWord, "DescMapWord");
        jceDisplayer.display(this.StarMapWord, "StarMapWord");
        jceDisplayer.display(this.MonthLabelWord, "MonthLabelWord");
        jceDisplayer.display(this.DayLabelWord, "DayLabelWord");
        jceDisplayer.display(this.AgeMapWord, "AgeMapWord");
        jceDisplayer.display(this.GenderMapWord, "GenderMapWord");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.QqLogo, true);
        jceDisplayer.displaySimple(this.NickWord, true);
        jceDisplayer.displaySimple(this.TimeMapWord, true);
        jceDisplayer.displaySimple(this.LocationMapWord, true);
        jceDisplayer.displaySimple(this.DescMapWord, true);
        jceDisplayer.displaySimple(this.StarMapWord, true);
        jceDisplayer.displaySimple(this.MonthLabelWord, true);
        jceDisplayer.displaySimple(this.DayLabelWord, true);
        jceDisplayer.displaySimple(this.AgeMapWord, true);
        jceDisplayer.displaySimple(this.GenderMapWord, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        CircleTemplateInfo circleTemplateInfo = (CircleTemplateInfo) obj;
        if (!JceUtil.equals(this.QqLogo, circleTemplateInfo.QqLogo) || !JceUtil.equals(this.NickWord, circleTemplateInfo.NickWord) || !JceUtil.equals(this.TimeMapWord, circleTemplateInfo.TimeMapWord) || !JceUtil.equals(this.LocationMapWord, circleTemplateInfo.LocationMapWord) || !JceUtil.equals(this.DescMapWord, circleTemplateInfo.DescMapWord) || !JceUtil.equals(this.StarMapWord, circleTemplateInfo.StarMapWord) || !JceUtil.equals(this.MonthLabelWord, circleTemplateInfo.MonthLabelWord) || !JceUtil.equals(this.DayLabelWord, circleTemplateInfo.DayLabelWord) || !JceUtil.equals(this.AgeMapWord, circleTemplateInfo.AgeMapWord) || !JceUtil.equals(this.GenderMapWord, circleTemplateInfo.GenderMapWord)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo";
    }

    public String getAgeMapWord() {
        return this.AgeMapWord;
    }

    public String getDayLabelWord() {
        return this.DayLabelWord;
    }

    public String getDescMapWord() {
        return this.DescMapWord;
    }

    public String getGenderMapWord() {
        return this.GenderMapWord;
    }

    public String getLocationMapWord() {
        return this.LocationMapWord;
    }

    public String getMonthLabelWord() {
        return this.MonthLabelWord;
    }

    public String getNickWord() {
        return this.NickWord;
    }

    public String getQqLogo() {
        return this.QqLogo;
    }

    public String getStarMapWord() {
        return this.StarMapWord;
    }

    public String getTimeMapWord() {
        return this.TimeMapWord;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.QqLogo = jceInputStream.readString(0, false);
        this.NickWord = jceInputStream.readString(1, false);
        this.TimeMapWord = jceInputStream.readString(2, false);
        this.LocationMapWord = jceInputStream.readString(3, false);
        this.DescMapWord = jceInputStream.readString(4, false);
        this.StarMapWord = jceInputStream.readString(5, false);
        this.MonthLabelWord = jceInputStream.readString(6, false);
        this.DayLabelWord = jceInputStream.readString(7, false);
        this.AgeMapWord = jceInputStream.readString(8, false);
        this.GenderMapWord = jceInputStream.readString(9, false);
    }

    public void setAgeMapWord(String str) {
        this.AgeMapWord = str;
    }

    public void setDayLabelWord(String str) {
        this.DayLabelWord = str;
    }

    public void setDescMapWord(String str) {
        this.DescMapWord = str;
    }

    public void setGenderMapWord(String str) {
        this.GenderMapWord = str;
    }

    public void setLocationMapWord(String str) {
        this.LocationMapWord = str;
    }

    public void setMonthLabelWord(String str) {
        this.MonthLabelWord = str;
    }

    public void setNickWord(String str) {
        this.NickWord = str;
    }

    public void setQqLogo(String str) {
        this.QqLogo = str;
    }

    public void setStarMapWord(String str) {
        this.StarMapWord = str;
    }

    public void setTimeMapWord(String str) {
        this.TimeMapWord = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.QqLogo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.NickWord;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.TimeMapWord;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.LocationMapWord;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.DescMapWord;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.StarMapWord;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.MonthLabelWord;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        String str8 = this.DayLabelWord;
        if (str8 != null) {
            jceOutputStream.write(str8, 7);
        }
        String str9 = this.AgeMapWord;
        if (str9 != null) {
            jceOutputStream.write(str9, 8);
        }
        String str10 = this.GenderMapWord;
        if (str10 != null) {
            jceOutputStream.write(str10, 9);
        }
    }

    public CircleTemplateInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.QqLogo = str;
        this.NickWord = str2;
        this.TimeMapWord = str3;
        this.LocationMapWord = str4;
        this.DescMapWord = str5;
        this.StarMapWord = str6;
        this.MonthLabelWord = str7;
        this.DayLabelWord = str8;
        this.AgeMapWord = str9;
        this.GenderMapWord = str10;
    }
}
