package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Redpacket extends JceStruct {
    public int dwConfType;
    public String sName;

    public Redpacket() {
        this.dwConfType = 0;
        this.sName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwConfType = jceInputStream.read(this.dwConfType, 0, false);
        this.sName = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwConfType, 0);
        String str = this.sName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public Redpacket(int i3, String str) {
        this.dwConfType = i3;
        this.sName = str;
    }
}
