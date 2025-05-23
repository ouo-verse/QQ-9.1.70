package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LunarWidgetInfo extends JceStruct {
    public byte animal;
    public String cheng;
    public String chong;

    /* renamed from: ji, reason: collision with root package name */
    public String f25059ji;
    public String jiex;
    public String lunar_d;
    public String lunar_ex;
    public String lunar_m;
    public String sha;
    public String solar;
    public String taishen;
    public String week;

    /* renamed from: yi, reason: collision with root package name */
    public String f25060yi;
    public String yiex;
    public String zhengchong;

    public LunarWidgetInfo() {
        this.lunar_m = "";
        this.lunar_d = "";
        this.lunar_ex = "";
        this.solar = "";
        this.week = "";
        this.f25060yi = "";
        this.f25059ji = "";
        this.chong = "";
        this.sha = "";
        this.cheng = "";
        this.zhengchong = "";
        this.taishen = "";
        this.yiex = "";
        this.jiex = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.animal = jceInputStream.read(this.animal, 0, false);
        this.lunar_m = jceInputStream.readString(1, false);
        this.lunar_d = jceInputStream.readString(2, false);
        this.lunar_ex = jceInputStream.readString(3, false);
        this.solar = jceInputStream.readString(4, false);
        this.week = jceInputStream.readString(5, false);
        this.f25060yi = jceInputStream.readString(6, false);
        this.f25059ji = jceInputStream.readString(7, false);
        this.chong = jceInputStream.readString(8, false);
        this.sha = jceInputStream.readString(9, false);
        this.cheng = jceInputStream.readString(10, false);
        this.zhengchong = jceInputStream.readString(11, false);
        this.taishen = jceInputStream.readString(12, false);
        this.yiex = jceInputStream.readString(13, false);
        this.jiex = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.animal, 0);
        String str = this.lunar_m;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.lunar_d;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.lunar_ex;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.solar;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.week;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.f25060yi;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.f25059ji;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.chong;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
        String str9 = this.sha;
        if (str9 != null) {
            jceOutputStream.write(str9, 9);
        }
        String str10 = this.cheng;
        if (str10 != null) {
            jceOutputStream.write(str10, 10);
        }
        String str11 = this.zhengchong;
        if (str11 != null) {
            jceOutputStream.write(str11, 11);
        }
        String str12 = this.taishen;
        if (str12 != null) {
            jceOutputStream.write(str12, 12);
        }
        String str13 = this.yiex;
        if (str13 != null) {
            jceOutputStream.write(str13, 13);
        }
        String str14 = this.jiex;
        if (str14 != null) {
            jceOutputStream.write(str14, 14);
        }
    }

    public LunarWidgetInfo(byte b16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.animal = b16;
        this.lunar_m = str;
        this.lunar_d = str2;
        this.lunar_ex = str3;
        this.solar = str4;
        this.week = str5;
        this.f25060yi = str6;
        this.f25059ji = str7;
        this.chong = str8;
        this.sha = str9;
        this.cheng = str10;
        this.zhengchong = str11;
        this.taishen = str12;
        this.yiex = str13;
        this.jiex = str14;
    }
}
