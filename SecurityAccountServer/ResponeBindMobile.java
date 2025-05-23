package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeBindMobile extends JceStruct {
    static byte[] cache_sessionSid;
    public String alreadyBindedUin;
    public byte[] sessionSid;

    public ResponeBindMobile() {
        this.sessionSid = null;
        this.alreadyBindedUin = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_sessionSid == null) {
            cache_sessionSid = r0;
            byte[] bArr = {0};
        }
        this.sessionSid = jceInputStream.read(cache_sessionSid, 0, true);
        this.alreadyBindedUin = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sessionSid, 0);
        String str = this.alreadyBindedUin;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public ResponeBindMobile(byte[] bArr, String str) {
        this.sessionSid = bArr;
        this.alreadyBindedUin = str;
    }
}
