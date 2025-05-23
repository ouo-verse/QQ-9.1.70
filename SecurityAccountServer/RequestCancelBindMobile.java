package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestCancelBindMobile extends JceStruct {
    static byte[] cache_encrptCancelMobileInfo;
    public byte[] encrptCancelMobileInfo;
    public boolean isFromChangeBind;
    public boolean isFromUni;
    public boolean isSecNewReq;
    public String mobileNo;
    public String nationCode;

    static {
        cache_encrptCancelMobileInfo = r0;
        byte[] bArr = {0};
    }

    public RequestCancelBindMobile() {
        this.nationCode = "";
        this.mobileNo = "";
        this.isFromUni = false;
        this.isFromChangeBind = false;
        this.isSecNewReq = false;
        this.encrptCancelMobileInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nationCode = jceInputStream.readString(0, true);
        this.mobileNo = jceInputStream.readString(1, true);
        this.isFromUni = jceInputStream.read(this.isFromUni, 2, false);
        this.isFromChangeBind = jceInputStream.read(this.isFromChangeBind, 3, false);
        this.isSecNewReq = jceInputStream.read(this.isSecNewReq, 4, false);
        this.encrptCancelMobileInfo = jceInputStream.read(cache_encrptCancelMobileInfo, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nationCode, 0);
        jceOutputStream.write(this.mobileNo, 1);
        jceOutputStream.write(this.isFromUni, 2);
        jceOutputStream.write(this.isFromChangeBind, 3);
        jceOutputStream.write(this.isSecNewReq, 4);
        byte[] bArr = this.encrptCancelMobileInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
    }

    public RequestCancelBindMobile(String str, String str2, boolean z16, boolean z17, boolean z18, byte[] bArr) {
        this.nationCode = str;
        this.mobileNo = str2;
        this.isFromUni = z16;
        this.isFromChangeBind = z17;
        this.isSecNewReq = z18;
        this.encrptCancelMobileInfo = bArr;
    }
}
