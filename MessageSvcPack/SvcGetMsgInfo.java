package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcGetMsgInfo extends JceStruct {
    static byte[] cache_vAppShareCookie;
    static byte[] cache_vMsg;
    static byte[] cache_vReserved;
    public byte cFlag;
    public long lFromUin;
    public long lLastChangeTime;
    public long lMsgUid;
    public long lToUin;
    public short shMsgSeq;
    public short shMsgType;
    public String strMsg;
    public long uAppShareID;
    public int uMsgTime;
    public int uRealMsgTime;
    public byte[] vAppShareCookie;
    public byte[] vMsg;
    public byte[] vReserved;

    public SvcGetMsgInfo() {
        this.lFromUin = 0L;
        this.uMsgTime = 0;
        this.shMsgType = (short) 0;
        this.shMsgSeq = (short) 0;
        this.strMsg = "";
        this.uRealMsgTime = 0;
        this.vMsg = null;
        this.uAppShareID = 0L;
        this.cFlag = (byte) 0;
        this.vAppShareCookie = null;
        this.lMsgUid = 0L;
        this.lToUin = 0L;
        this.lLastChangeTime = 1L;
        this.vReserved = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromUin = jceInputStream.read(this.lFromUin, 0, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 1, true);
        this.shMsgType = jceInputStream.read(this.shMsgType, 2, true);
        this.shMsgSeq = jceInputStream.read(this.shMsgSeq, 3, true);
        this.strMsg = jceInputStream.readString(4, true);
        this.uRealMsgTime = jceInputStream.read(this.uRealMsgTime, 5, false);
        if (cache_vMsg == null) {
            cache_vMsg = r0;
            byte[] bArr = {0};
        }
        this.vMsg = jceInputStream.read(cache_vMsg, 6, false);
        this.uAppShareID = jceInputStream.read(this.uAppShareID, 7, false);
        this.cFlag = jceInputStream.read(this.cFlag, 8, false);
        if (cache_vAppShareCookie == null) {
            cache_vAppShareCookie = r0;
            byte[] bArr2 = {0};
        }
        this.vAppShareCookie = jceInputStream.read(cache_vAppShareCookie, 9, false);
        this.lMsgUid = jceInputStream.read(this.lMsgUid, 10, false);
        this.lToUin = jceInputStream.read(this.lToUin, 11, false);
        this.lLastChangeTime = jceInputStream.read(this.lLastChangeTime, 12, false);
        if (cache_vReserved == null) {
            cache_vReserved = r0;
            byte[] bArr3 = {0};
        }
        this.vReserved = jceInputStream.read(cache_vReserved, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromUin, 0);
        jceOutputStream.write(this.uMsgTime, 1);
        jceOutputStream.write(this.shMsgType, 2);
        jceOutputStream.write(this.shMsgSeq, 3);
        jceOutputStream.write(this.strMsg, 4);
        jceOutputStream.write(this.uRealMsgTime, 5);
        byte[] bArr = this.vMsg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        jceOutputStream.write(this.uAppShareID, 7);
        jceOutputStream.write(this.cFlag, 8);
        byte[] bArr2 = this.vAppShareCookie;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 9);
        }
        jceOutputStream.write(this.lMsgUid, 10);
        jceOutputStream.write(this.lToUin, 11);
        jceOutputStream.write(this.lLastChangeTime, 12);
        byte[] bArr3 = this.vReserved;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 13);
        }
    }

    public SvcGetMsgInfo(long j3, int i3, short s16, short s17, String str, int i16, byte[] bArr, long j16, byte b16, byte[] bArr2, long j17, long j18, long j19, byte[] bArr3) {
        this.lFromUin = j3;
        this.uMsgTime = i3;
        this.shMsgType = s16;
        this.shMsgSeq = s17;
        this.strMsg = str;
        this.uRealMsgTime = i16;
        this.vMsg = bArr;
        this.uAppShareID = j16;
        this.cFlag = b16;
        this.vAppShareCookie = bArr2;
        this.lMsgUid = j17;
        this.lToUin = j18;
        this.lLastChangeTime = j19;
        this.vReserved = bArr3;
    }
}
