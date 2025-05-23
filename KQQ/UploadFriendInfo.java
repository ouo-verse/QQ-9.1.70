package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadFriendInfo extends JceStruct {
    static byte[] cache_vSignature;
    static byte[] cache_vToMID;
    public long lAppID;
    public long lFromMID;
    public long lGroupMID;
    public int nType;
    public short shType;
    public byte[] vSignature;
    public byte[] vToMID;

    public UploadFriendInfo() {
        this.lFromMID = 0L;
        this.nType = 0;
        this.vToMID = null;
        this.lGroupMID = 0L;
        this.lAppID = 0L;
        this.shType = (short) 0;
        this.vSignature = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromMID = jceInputStream.read(this.lFromMID, 0, true);
        this.nType = jceInputStream.read(this.nType, 1, true);
        if (cache_vToMID == null) {
            cache_vToMID = r0;
            byte[] bArr = {0};
        }
        this.vToMID = jceInputStream.read(cache_vToMID, 2, false);
        this.lGroupMID = jceInputStream.read(this.lGroupMID, 3, false);
        this.lAppID = jceInputStream.read(this.lAppID, 4, true);
        this.shType = jceInputStream.read(this.shType, 5, true);
        if (cache_vSignature == null) {
            cache_vSignature = r0;
            byte[] bArr2 = {0};
        }
        this.vSignature = jceInputStream.read(cache_vSignature, 6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromMID, 0);
        jceOutputStream.write(this.nType, 1);
        byte[] bArr = this.vToMID;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        jceOutputStream.write(this.lGroupMID, 3);
        jceOutputStream.write(this.lAppID, 4);
        jceOutputStream.write(this.shType, 5);
        jceOutputStream.write(this.vSignature, 6);
    }

    public UploadFriendInfo(long j3, int i3, byte[] bArr, long j16, long j17, short s16, byte[] bArr2) {
        this.lFromMID = j3;
        this.nType = i3;
        this.vToMID = bArr;
        this.lGroupMID = j16;
        this.lAppID = j17;
        this.shType = s16;
        this.vSignature = bArr2;
    }
}
