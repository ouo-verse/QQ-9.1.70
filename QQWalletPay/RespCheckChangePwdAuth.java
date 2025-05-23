package QQWalletPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RespCheckChangePwdAuth extends JceStruct {
    public int retCode;
    public String retMsg;

    public RespCheckChangePwdAuth() {
        this.retCode = 0;
        this.retMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retCode = jceInputStream.read(this.retCode, 0, true);
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

    public RespCheckChangePwdAuth(int i3, String str) {
        this.retCode = i3;
        this.retMsg = str;
    }
}
