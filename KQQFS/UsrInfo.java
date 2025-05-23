package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UsrInfo extends JceStruct {
    static byte[] cache_otherID;
    static byte[] cache_vKey;
    public byte cNetType;
    public byte cPicType;
    public byte encryAbi;
    public long lAppID;
    public long lFromMID;
    public long lToMID;
    public byte[] otherID;
    public int sessionID;
    public short shBuisType;
    public short shKeyType;
    public short shType;
    public int uSeq;
    public byte[] vKey;

    public UsrInfo() {
        this.lFromMID = 0L;
        this.lToMID = 0L;
        this.sessionID = 0;
        this.uSeq = 0;
        this.lAppID = 0L;
        this.shBuisType = (short) 0;
        this.shType = (short) 0;
        this.shKeyType = (short) 0;
        this.vKey = null;
        this.encryAbi = (byte) 0;
        this.otherID = null;
        this.cNetType = (byte) 0;
        this.cPicType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromMID = jceInputStream.read(this.lFromMID, 0, true);
        this.lToMID = jceInputStream.read(this.lToMID, 1, true);
        this.sessionID = jceInputStream.read(this.sessionID, 2, true);
        this.uSeq = jceInputStream.read(this.uSeq, 3, true);
        this.lAppID = jceInputStream.read(this.lAppID, 4, true);
        this.shBuisType = jceInputStream.read(this.shBuisType, 5, true);
        this.shType = jceInputStream.read(this.shType, 6, true);
        this.shKeyType = jceInputStream.read(this.shKeyType, 7, true);
        if (cache_vKey == null) {
            cache_vKey = r0;
            byte[] bArr = {0};
        }
        this.vKey = jceInputStream.read(cache_vKey, 8, true);
        this.encryAbi = jceInputStream.read(this.encryAbi, 9, true);
        if (cache_otherID == null) {
            cache_otherID = r0;
            byte[] bArr2 = {0};
        }
        this.otherID = jceInputStream.read(cache_otherID, 10, false);
        this.cNetType = jceInputStream.read(this.cNetType, 11, false);
        this.cPicType = jceInputStream.read(this.cPicType, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromMID, 0);
        jceOutputStream.write(this.lToMID, 1);
        jceOutputStream.write(this.sessionID, 2);
        jceOutputStream.write(this.uSeq, 3);
        jceOutputStream.write(this.lAppID, 4);
        jceOutputStream.write(this.shBuisType, 5);
        jceOutputStream.write(this.shType, 6);
        jceOutputStream.write(this.shKeyType, 7);
        jceOutputStream.write(this.vKey, 8);
        jceOutputStream.write(this.encryAbi, 9);
        byte[] bArr = this.otherID;
        if (bArr != null) {
            jceOutputStream.write(bArr, 10);
        }
        jceOutputStream.write(this.cNetType, 11);
        jceOutputStream.write(this.cPicType, 12);
    }

    public UsrInfo(long j3, long j16, int i3, int i16, long j17, short s16, short s17, short s18, byte[] bArr, byte b16, byte[] bArr2, byte b17, byte b18) {
        this.lFromMID = j3;
        this.lToMID = j16;
        this.sessionID = i3;
        this.uSeq = i16;
        this.lAppID = j17;
        this.shBuisType = s16;
        this.shType = s17;
        this.shKeyType = s18;
        this.vKey = bArr;
        this.encryAbi = b16;
        this.otherID = bArr2;
        this.cNetType = b17;
        this.cPicType = b18;
    }
}
