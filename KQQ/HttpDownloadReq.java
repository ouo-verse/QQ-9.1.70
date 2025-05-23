package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HttpDownloadReq extends JceStruct {
    static byte[] cache_vFileKey;
    static byte[] cache_vSignature;
    public long lAppID;
    public long lToMID;
    public short shPicScale;
    public byte[] vFileKey;
    public byte[] vSignature;

    public HttpDownloadReq() {
        this.lToMID = 0L;
        this.lAppID = 0L;
        this.vFileKey = null;
        this.vSignature = null;
        this.shPicScale = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lToMID = jceInputStream.read(this.lToMID, 0, true);
        this.lAppID = jceInputStream.read(this.lAppID, 1, true);
        if (cache_vFileKey == null) {
            cache_vFileKey = r0;
            byte[] bArr = {0};
        }
        this.vFileKey = jceInputStream.read(cache_vFileKey, 2, true);
        if (cache_vSignature == null) {
            cache_vSignature = r0;
            byte[] bArr2 = {0};
        }
        this.vSignature = jceInputStream.read(cache_vSignature, 3, true);
        this.shPicScale = jceInputStream.read(this.shPicScale, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lToMID, 0);
        jceOutputStream.write(this.lAppID, 1);
        jceOutputStream.write(this.vFileKey, 2);
        jceOutputStream.write(this.vSignature, 3);
        jceOutputStream.write(this.shPicScale, 4);
    }

    public HttpDownloadReq(long j3, long j16, byte[] bArr, byte[] bArr2, short s16) {
        this.lToMID = j3;
        this.lAppID = j16;
        this.vFileKey = bArr;
        this.vSignature = bArr2;
        this.shPicScale = s16;
    }
}
