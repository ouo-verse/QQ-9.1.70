package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiSimpleSigItem extends JceStruct {
    public String desc;
    public String fontColor;
    public int materialVersion;
    public String timeAndLocation;

    public UniBusiSimpleSigItem() {
        this.materialVersion = 0;
        this.fontColor = "";
        this.desc = "";
        this.timeAndLocation = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.materialVersion = jceInputStream.read(this.materialVersion, 0, false);
        this.fontColor = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
        this.timeAndLocation = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.materialVersion, 0);
        String str = this.fontColor;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.timeAndLocation;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public UniBusiSimpleSigItem(int i3, String str, String str2, String str3) {
        this.materialVersion = i3;
        this.fontColor = str;
        this.desc = str2;
        this.timeAndLocation = str3;
    }
}
