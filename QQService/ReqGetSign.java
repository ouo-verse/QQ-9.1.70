package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetSign extends JceStruct {
    static byte[] cache_vA2;
    static byte[] cache_vCiphertext;
    public byte cA2Type;
    public long lUIN;
    public long uAppID;
    public long uSSOVer;
    public byte[] vA2;
    public byte[] vCiphertext;

    public ReqGetSign() {
        this.lUIN = 0L;
        this.uSSOVer = 0L;
        this.uAppID = 0L;
        this.cA2Type = (byte) 0;
        this.vA2 = null;
        this.vCiphertext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.uSSOVer = jceInputStream.read(this.uSSOVer, 1, true);
        this.uAppID = jceInputStream.read(this.uAppID, 2, true);
        this.cA2Type = jceInputStream.read(this.cA2Type, 3, true);
        if (cache_vA2 == null) {
            cache_vA2 = r0;
            byte[] bArr = {0};
        }
        this.vA2 = jceInputStream.read(cache_vA2, 4, true);
        if (cache_vCiphertext == null) {
            cache_vCiphertext = r0;
            byte[] bArr2 = {0};
        }
        this.vCiphertext = jceInputStream.read(cache_vCiphertext, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.uSSOVer, 1);
        jceOutputStream.write(this.uAppID, 2);
        jceOutputStream.write(this.cA2Type, 3);
        jceOutputStream.write(this.vA2, 4);
        byte[] bArr = this.vCiphertext;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
    }

    public ReqGetSign(long j3, long j16, long j17, byte b16, byte[] bArr, byte[] bArr2) {
        this.lUIN = j3;
        this.uSSOVer = j16;
        this.uAppID = j17;
        this.cA2Type = b16;
        this.vA2 = bArr;
        this.vCiphertext = bArr2;
    }
}
