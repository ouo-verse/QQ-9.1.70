package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommRsp extends JceStruct {
    public int iErrCode;
    public String sErrMsg;

    public CommRsp() {
        this.iErrCode = 0;
        this.sErrMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iErrCode = jceInputStream.read(this.iErrCode, 0, false);
        this.sErrMsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iErrCode, 0);
        String str = this.sErrMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public CommRsp(int i3, String str) {
        this.iErrCode = i3;
        this.sErrMsg = str;
    }
}
