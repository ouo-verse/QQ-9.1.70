package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ConstellationWidgetInfo extends JceStruct {
    public String bad;
    public String color;
    public byte consid;
    public String date;
    public String desc;
    public String good;
    public byte health;
    public String icon;
    public String interval;
    public byte love;
    public byte lucky;
    public byte money;
    public String name;
    public String num;
    public byte work;

    public ConstellationWidgetInfo() {
        this.name = "";
        this.interval = "";
        this.good = "";
        this.bad = "";
        this.desc = "";
        this.color = "";
        this.num = "";
        this.date = "";
        this.icon = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.consid = jceInputStream.read(this.consid, 0, false);
        this.name = jceInputStream.readString(1, false);
        this.interval = jceInputStream.readString(2, false);
        this.good = jceInputStream.readString(3, false);
        this.bad = jceInputStream.readString(4, false);
        this.desc = jceInputStream.readString(5, false);
        this.color = jceInputStream.readString(6, false);
        this.num = jceInputStream.readString(7, false);
        this.love = jceInputStream.read(this.love, 8, false);
        this.work = jceInputStream.read(this.work, 9, false);
        this.money = jceInputStream.read(this.money, 10, false);
        this.health = jceInputStream.read(this.health, 11, false);
        this.date = jceInputStream.readString(12, false);
        this.lucky = jceInputStream.read(this.lucky, 13, false);
        this.icon = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.consid, 0);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.interval;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.good;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.bad;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.desc;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.color;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.num;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        jceOutputStream.write(this.love, 8);
        jceOutputStream.write(this.work, 9);
        jceOutputStream.write(this.money, 10);
        jceOutputStream.write(this.health, 11);
        String str8 = this.date;
        if (str8 != null) {
            jceOutputStream.write(str8, 12);
        }
        jceOutputStream.write(this.lucky, 13);
        String str9 = this.icon;
        if (str9 != null) {
            jceOutputStream.write(str9, 14);
        }
    }

    public ConstellationWidgetInfo(byte b16, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte b17, byte b18, byte b19, byte b26, String str8, byte b27, String str9) {
        this.consid = b16;
        this.name = str;
        this.interval = str2;
        this.good = str3;
        this.bad = str4;
        this.desc = str5;
        this.color = str6;
        this.num = str7;
        this.love = b17;
        this.work = b18;
        this.money = b19;
        this.health = b26;
        this.date = str8;
        this.lucky = b27;
        this.icon = str9;
    }
}
