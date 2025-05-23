package ColorNick.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class readItemInfoReq extends JceStruct {
    public long implat;
    public int index;
    public String qqver;

    public readItemInfoReq() {
        this.implat = 0L;
        this.qqver = "";
        this.index = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.implat = jceInputStream.read(this.implat, 0, false);
        this.qqver = jceInputStream.readString(1, false);
        this.index = jceInputStream.read(this.index, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.implat, 0);
        String str = this.qqver;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.index, 2);
    }

    public readItemInfoReq(long j3, String str, int i3) {
        this.implat = j3;
        this.qqver = str;
        this.index = i3;
    }
}
