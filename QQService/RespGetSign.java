package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetSign extends JceStruct {
    static byte[] cache_vKey;
    static byte[] cache_vSign;
    public int iReplyCode;
    public long lUIN;
    public byte[] vKey;
    public byte[] vSign;

    public RespGetSign() {
        this.lUIN = 0L;
        this.iReplyCode = 0;
        this.vKey = null;
        this.vSign = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.iReplyCode = jceInputStream.read(this.iReplyCode, 1, true);
        if (cache_vKey == null) {
            cache_vKey = r0;
            byte[] bArr = {0};
        }
        this.vKey = jceInputStream.read(cache_vKey, 2, true);
        if (cache_vSign == null) {
            cache_vSign = r0;
            byte[] bArr2 = {0};
        }
        this.vSign = jceInputStream.read(cache_vSign, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.iReplyCode, 1);
        jceOutputStream.write(this.vKey, 2);
        jceOutputStream.write(this.vSign, 3);
    }

    public RespGetSign(long j3, int i3, byte[] bArr, byte[] bArr2) {
        this.lUIN = j3;
        this.iReplyCode = i3;
        this.vKey = bArr;
        this.vSign = bArr2;
    }
}
