package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcReqKikOut extends JceStruct {
    static byte[] cache_sKey;
    public long appid;
    public byte cKeyType;
    public long lUin;
    public byte[] sKey;

    public SvcReqKikOut() {
        this.lUin = 0L;
        this.appid = 0L;
        this.cKeyType = (byte) 0;
        this.sKey = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, true);
        this.cKeyType = jceInputStream.read(this.cKeyType, 2, true);
        if (cache_sKey == null) {
            cache_sKey = r0;
            byte[] bArr = {0};
        }
        this.sKey = jceInputStream.read(cache_sKey, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.cKeyType, 2);
        jceOutputStream.write(this.sKey, 3);
    }

    public SvcReqKikOut(long j3, long j16, byte b16, byte[] bArr) {
        this.lUin = j3;
        this.appid = j16;
        this.cKeyType = b16;
        this.sKey = bArr;
    }
}
