package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestSendVideoMsg extends JceStruct {
    static byte[] cache_vMsg;
    public byte cVerifyType;
    public long lPeerUin;
    public long lUin;
    public long uClientIP;
    public int uDateTime;
    public byte[] vMsg;

    public SvcRequestSendVideoMsg() {
        this.lUin = 0L;
        this.lPeerUin = 0L;
        this.uDateTime = 0;
        this.cVerifyType = (byte) 0;
        this.vMsg = null;
        this.uClientIP = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.lPeerUin = jceInputStream.read(this.lPeerUin, 1, true);
        this.uDateTime = jceInputStream.read(this.uDateTime, 2, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 3, true);
        if (cache_vMsg == null) {
            cache_vMsg = r0;
            byte[] bArr = {0};
        }
        this.vMsg = jceInputStream.read(cache_vMsg, 4, true);
        this.uClientIP = jceInputStream.read(this.uClientIP, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.lPeerUin, 1);
        jceOutputStream.write(this.uDateTime, 2);
        jceOutputStream.write(this.cVerifyType, 3);
        jceOutputStream.write(this.vMsg, 4);
        jceOutputStream.write(this.uClientIP, 5);
    }

    public SvcRequestSendVideoMsg(long j3, long j16, int i3, byte b16, byte[] bArr, long j17) {
        this.lUin = j3;
        this.lPeerUin = j16;
        this.uDateTime = i3;
        this.cVerifyType = b16;
        this.vMsg = bArr;
        this.uClientIP = j17;
    }
}
