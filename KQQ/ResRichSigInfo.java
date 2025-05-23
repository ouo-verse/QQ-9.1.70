package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResRichSigInfo extends JceStruct {
    static byte[] cache_vbSigInfo;
    public byte cStatus;
    public long dwTime;
    public long lUin;
    public byte[] vbSigInfo;

    public ResRichSigInfo() {
        this.cStatus = (byte) -1;
        this.lUin = 0L;
        this.dwTime = 0L;
        this.vbSigInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cStatus = jceInputStream.read(this.cStatus, 1, true);
        this.lUin = jceInputStream.read(this.lUin, 2, true);
        this.dwTime = jceInputStream.read(this.dwTime, 3, false);
        if (cache_vbSigInfo == null) {
            cache_vbSigInfo = r0;
            byte[] bArr = {0};
        }
        this.vbSigInfo = jceInputStream.read(cache_vbSigInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cStatus, 1);
        jceOutputStream.write(this.lUin, 2);
        jceOutputStream.write(this.dwTime, 3);
        byte[] bArr = this.vbSigInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
    }

    public ResRichSigInfo(byte b16, long j3, long j16, byte[] bArr) {
        this.cStatus = b16;
        this.lUin = j3;
        this.dwTime = j16;
        this.vbSigInfo = bArr;
    }
}
