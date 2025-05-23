package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class readUserInfoReq extends JceStruct {
    public int implat;
    public int index;
    public String qqver;

    public readUserInfoReq() {
        this.qqver = "";
        this.implat = 0;
        this.index = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qqver = jceInputStream.readString(0, false);
        this.implat = jceInputStream.read(this.implat, 1, false);
        this.index = jceInputStream.read(this.index, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.qqver;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.implat, 1);
        jceOutputStream.write(this.index, 2);
    }

    public readUserInfoReq(String str, int i3, int i16) {
        this.qqver = str;
        this.implat = i3;
        this.index = i16;
    }
}
