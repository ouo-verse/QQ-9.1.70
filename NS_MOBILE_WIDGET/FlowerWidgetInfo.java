package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FlowerWidgetInfo extends JceStruct {
    public String flowerpicurl;
    public int love;
    public int lovemax;
    public int nutri;
    public int nutrimax;
    public int rain;
    public int rainmax;
    public int sun;
    public int sunmax;

    public FlowerWidgetInfo() {
        this.flowerpicurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sun = jceInputStream.read(this.sun, 0, false);
        this.sunmax = jceInputStream.read(this.sunmax, 1, false);
        this.rain = jceInputStream.read(this.rain, 2, false);
        this.rainmax = jceInputStream.read(this.rainmax, 3, false);
        this.love = jceInputStream.read(this.love, 4, false);
        this.lovemax = jceInputStream.read(this.lovemax, 5, false);
        this.nutri = jceInputStream.read(this.nutri, 6, false);
        this.nutrimax = jceInputStream.read(this.nutrimax, 7, false);
        this.flowerpicurl = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sun, 0);
        jceOutputStream.write(this.sunmax, 1);
        jceOutputStream.write(this.rain, 2);
        jceOutputStream.write(this.rainmax, 3);
        jceOutputStream.write(this.love, 4);
        jceOutputStream.write(this.lovemax, 5);
        jceOutputStream.write(this.nutri, 6);
        jceOutputStream.write(this.nutrimax, 7);
        String str = this.flowerpicurl;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
    }

    public FlowerWidgetInfo(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, String str) {
        this.sun = i3;
        this.sunmax = i16;
        this.rain = i17;
        this.rainmax = i18;
        this.love = i19;
        this.lovemax = i26;
        this.nutri = i27;
        this.nutrimax = i28;
        this.flowerpicurl = str;
    }
}
