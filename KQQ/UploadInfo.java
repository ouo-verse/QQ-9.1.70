package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadInfo extends JceStruct {
    static byte[] cache_vSignature;
    public long lAppID;
    public long lFromMID;
    public long lToMID;
    public short shType;
    public byte[] vSignature;

    public UploadInfo() {
        this.lFromMID = 0L;
        this.lToMID = 0L;
        this.lAppID = 0L;
        this.shType = (short) 0;
        this.vSignature = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromMID = jceInputStream.read(this.lFromMID, 0, true);
        this.lToMID = jceInputStream.read(this.lToMID, 1, true);
        this.lAppID = jceInputStream.read(this.lAppID, 2, true);
        this.shType = jceInputStream.read(this.shType, 3, true);
        if (cache_vSignature == null) {
            cache_vSignature = r0;
            byte[] bArr = {0};
        }
        this.vSignature = jceInputStream.read(cache_vSignature, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromMID, 0);
        jceOutputStream.write(this.lToMID, 1);
        jceOutputStream.write(this.lAppID, 2);
        jceOutputStream.write(this.shType, 3);
        jceOutputStream.write(this.vSignature, 4);
    }

    public UploadInfo(long j3, long j16, long j17, short s16, byte[] bArr) {
        this.lFromMID = j3;
        this.lToMID = j16;
        this.lAppID = j17;
        this.shType = s16;
        this.vSignature = bArr;
    }
}
