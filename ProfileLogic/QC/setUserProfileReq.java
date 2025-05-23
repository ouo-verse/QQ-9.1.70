package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class setUserProfileReq extends JceStruct {
    public int implat;
    public int itemid;
    public String qqver;

    public setUserProfileReq() {
        this.itemid = 0;
        this.qqver = "";
        this.implat = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.itemid = jceInputStream.read(this.itemid, 0, false);
        this.qqver = jceInputStream.readString(1, false);
        this.implat = jceInputStream.read(this.implat, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.itemid, 0);
        String str = this.qqver;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.implat, 2);
    }

    public setUserProfileReq(int i3, String str, int i16) {
        this.itemid = i3;
        this.qqver = str;
        this.implat = i16;
    }
}
