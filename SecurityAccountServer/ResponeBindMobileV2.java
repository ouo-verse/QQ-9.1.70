package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeBindMobileV2 extends JceStruct {
    static byte[] cache_sessionSid;
    public String alreadyBindedUin;
    public boolean bindSuccess;
    public byte[] sessionSid;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
    }

    public ResponeBindMobileV2() {
        this.sessionSid = null;
        this.alreadyBindedUin = "";
        this.bindSuccess = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sessionSid = jceInputStream.read(cache_sessionSid, 0, true);
        this.alreadyBindedUin = jceInputStream.readString(1, false);
        this.bindSuccess = jceInputStream.read(this.bindSuccess, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sessionSid, 0);
        String str = this.alreadyBindedUin;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.bindSuccess, 2);
    }

    public ResponeBindMobileV2(byte[] bArr, String str, boolean z16) {
        this.sessionSid = bArr;
        this.alreadyBindedUin = str;
        this.bindSuccess = z16;
    }
}
