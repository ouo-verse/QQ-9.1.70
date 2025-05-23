package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReqOffFilePack extends JceStruct {
    static byte[] cache_vBody;
    public long lUIN;
    public byte[] vBody;

    public ReqOffFilePack() {
        this.lUIN = 0L;
        this.vBody = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        if (cache_vBody == null) {
            cache_vBody = r0;
            byte[] bArr = {0};
        }
        this.vBody = jceInputStream.read(cache_vBody, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.vBody, 1);
    }

    public ReqOffFilePack(long j3, byte[] bArr) {
        this.lUIN = j3;
        this.vBody = bArr;
    }
}
