package VideoSvrPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoCallMsg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static byte[] cache_errMsg;
    static byte[] cache_vMsg;
    public byte cVerifyType;
    public byte[] errMsg;
    public long lPeerUin;
    public long lUin;
    public byte type;
    public int uDateTime;
    public int uSeqId;
    public int uSessionId;
    public byte[] vMsg;
    public byte ver;

    public VideoCallMsg() {
        this.ver = (byte) 0;
        this.type = (byte) 0;
        this.lUin = 0L;
        this.lPeerUin = 0L;
        this.uDateTime = 0;
        this.cVerifyType = (byte) 0;
        this.uSeqId = 0;
        this.uSessionId = 0;
        this.vMsg = null;
        this.errMsg = null;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ver = jceInputStream.read(this.ver, 0, true);
        this.type = jceInputStream.read(this.type, 1, true);
        this.lUin = jceInputStream.read(this.lUin, 2, true);
        this.lPeerUin = jceInputStream.read(this.lPeerUin, 3, true);
        this.uDateTime = jceInputStream.read(this.uDateTime, 4, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 5, true);
        this.uSeqId = jceInputStream.read(this.uSeqId, 6, true);
        this.uSessionId = jceInputStream.read(this.uSessionId, 7, true);
        if (cache_vMsg == null) {
            cache_vMsg = r0;
            byte[] bArr = {0};
        }
        byte[] read = jceInputStream.read(cache_vMsg, 8, true);
        cache_vMsg = read;
        this.vMsg = read;
        if (cache_errMsg == null) {
            cache_errMsg = r0;
            byte[] bArr2 = {0};
        }
        byte[] read2 = jceInputStream.read(cache_errMsg, 9, false);
        cache_errMsg = read2;
        this.errMsg = read2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ver, 0);
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.lUin, 2);
        jceOutputStream.write(this.lPeerUin, 3);
        jceOutputStream.write(this.uDateTime, 4);
        jceOutputStream.write(this.cVerifyType, 5);
        jceOutputStream.write(this.uSeqId, 6);
        jceOutputStream.write(this.uSessionId, 7);
        jceOutputStream.write(this.vMsg, 8);
        byte[] bArr = this.errMsg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
    }

    public VideoCallMsg(byte b16, byte b17, long j3, long j16, int i3, byte b18, int i16, int i17, byte[] bArr, byte[] bArr2) {
        this.ver = b16;
        this.type = b17;
        this.lUin = j3;
        this.lPeerUin = j16;
        this.uDateTime = i3;
        this.cVerifyType = b18;
        this.uSeqId = i16;
        this.uSessionId = i17;
        this.vMsg = bArr;
        this.errMsg = bArr2;
    }
}
