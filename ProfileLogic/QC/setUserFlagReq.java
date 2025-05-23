package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class setUserFlagReq extends JceStruct {
    public int flag;
    public int implat;
    public String qqver;

    public setUserFlagReq() {
        this.flag = 0;
        this.qqver = "";
        this.implat = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.flag = jceInputStream.read(this.flag, 0, false);
        this.qqver = jceInputStream.readString(1, false);
        this.implat = jceInputStream.read(this.implat, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.flag, 0);
        String str = this.qqver;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.implat, 2);
    }

    public setUserFlagReq(int i3, String str, int i16) {
        this.flag = i3;
        this.qqver = str;
        this.implat = i16;
    }
}
