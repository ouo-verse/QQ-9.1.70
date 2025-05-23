package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class RespOffFilePack extends JceStruct {
    static byte[] cache_vBody;
    public int iReplyCode;
    public long lUIN;
    public byte[] vBody;

    public RespOffFilePack() {
        this.lUIN = 0L;
        this.iReplyCode = 0;
        this.vBody = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.iReplyCode = jceInputStream.read(this.iReplyCode, 1, true);
        if (cache_vBody == null) {
            cache_vBody = r0;
            byte[] bArr = {0};
        }
        this.vBody = jceInputStream.read(cache_vBody, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.iReplyCode, 1);
        jceOutputStream.write(this.vBody, 2);
    }

    public RespOffFilePack(long j3, int i3, byte[] bArr) {
        this.lUIN = j3;
        this.iReplyCode = i3;
        this.vBody = bArr;
    }
}
