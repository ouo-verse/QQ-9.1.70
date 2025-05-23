package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResponeUpdateAddressBookNotBind extends JceStruct {
    static byte[] cache_sessionSid;
    public long nextFlag;
    public byte[] sessionSid;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
    }

    public ResponeUpdateAddressBookNotBind() {
        this.nextFlag = 0L;
        this.sessionSid = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.sessionSid = jceInputStream.read(cache_sessionSid, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.sessionSid, 1);
    }

    public ResponeUpdateAddressBookNotBind(long j3, byte[] bArr) {
        this.nextFlag = j3;
        this.sessionSid = bArr;
    }
}
