package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_droplist_operate_rsp extends JceStruct {
    public int retCode;
    public String retMsg;

    public mobile_droplist_operate_rsp() {
        this.retCode = 0;
        this.retMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retCode = jceInputStream.read(this.retCode, 0, false);
        this.retMsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retCode, 0);
        String str = this.retMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_droplist_operate_rsp(int i3, String str) {
        this.retCode = i3;
        this.retMsg = str;
    }
}
