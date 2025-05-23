package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestQueryQQMobileContacts extends JceStruct {
    static byte[] cache_sessionSid;
    public boolean Compressd;
    public long nextFlag;
    public byte[] sessionSid;
    public long timeStamp;
    public byte version;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
    }

    public RequestQueryQQMobileContacts() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.sessionSid = null;
        this.version = (byte) 0;
        this.Compressd = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 1, true);
        this.sessionSid = jceInputStream.read(cache_sessionSid, 2, true);
        this.version = jceInputStream.read(this.version, 3, false);
        this.Compressd = jceInputStream.read(this.Compressd, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write(this.version, 3);
        jceOutputStream.write(this.Compressd, 4);
    }

    public RequestQueryQQMobileContacts(long j3, long j16, byte[] bArr, byte b16, boolean z16) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.sessionSid = bArr;
        this.version = b16;
        this.Compressd = z16;
    }
}
