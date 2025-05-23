package QQWalletPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReqCheckChangePwdAuth extends JceStruct {
    public String appId;
    public String offerId;
    public String packageName;
    public String resetWordMode;
    public String signatureMode;
    public String timeStamp;

    public ReqCheckChangePwdAuth() {
        this.packageName = "";
        this.signatureMode = "";
        this.appId = "";
        this.timeStamp = "";
        this.resetWordMode = "";
        this.offerId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.packageName = jceInputStream.readString(0, true);
        this.signatureMode = jceInputStream.readString(1, true);
        this.appId = jceInputStream.readString(2, true);
        this.timeStamp = jceInputStream.readString(3, true);
        this.resetWordMode = jceInputStream.readString(4, true);
        this.offerId = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.packageName, 0);
        jceOutputStream.write(this.signatureMode, 1);
        jceOutputStream.write(this.appId, 2);
        jceOutputStream.write(this.timeStamp, 3);
        jceOutputStream.write(this.resetWordMode, 4);
        String str = this.offerId;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public ReqCheckChangePwdAuth(String str, String str2, String str3, String str4, String str5, String str6) {
        this.packageName = str;
        this.signatureMode = str2;
        this.appId = str3;
        this.timeStamp = str4;
        this.resetWordMode = str5;
        this.offerId = str6;
    }
}
