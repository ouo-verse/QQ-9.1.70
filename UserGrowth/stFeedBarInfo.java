package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFeedBarInfo extends JceStruct {
    static stSchema cache_jump = new stSchema();
    public String beginColor;
    public int changeTime;
    public String endColor;
    public stSchema jump;
    public int progressPercentage;
    public int switchOpen;
    public String text;

    public stFeedBarInfo() {
        this.beginColor = "";
        this.endColor = "";
        this.changeTime = 0;
        this.progressPercentage = 0;
        this.text = "";
        this.jump = null;
        this.switchOpen = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.beginColor = jceInputStream.readString(0, false);
        this.endColor = jceInputStream.readString(1, false);
        this.changeTime = jceInputStream.read(this.changeTime, 2, false);
        this.progressPercentage = jceInputStream.read(this.progressPercentage, 3, false);
        this.text = jceInputStream.readString(4, false);
        this.jump = (stSchema) jceInputStream.read((JceStruct) cache_jump, 5, false);
        this.switchOpen = jceInputStream.read(this.switchOpen, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.beginColor;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.endColor;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.changeTime, 2);
        jceOutputStream.write(this.progressPercentage, 3);
        String str3 = this.text;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        stSchema stschema = this.jump;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 5);
        }
        jceOutputStream.write(this.switchOpen, 6);
    }

    public stFeedBarInfo(String str, String str2, int i3, int i16, String str3, stSchema stschema, int i17) {
        this.beginColor = str;
        this.endColor = str2;
        this.changeTime = i3;
        this.progressPercentage = i16;
        this.text = str3;
        this.jump = stschema;
        this.switchOpen = i17;
    }
}
