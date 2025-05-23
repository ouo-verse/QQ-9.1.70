package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestDelRoamMsg extends JceStruct {
    public byte cVerifyType;
    public long lPeerUin;
    public long lUin;

    public SvcRequestDelRoamMsg() {
        this.lUin = 0L;
        this.cVerifyType = (byte) 0;
        this.lPeerUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 1, true);
        this.lPeerUin = jceInputStream.read(this.lPeerUin, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.cVerifyType, 1);
        jceOutputStream.write(this.lPeerUin, 2);
    }

    public SvcRequestDelRoamMsg(long j3, byte b16, long j16) {
        this.lUin = j3;
        this.cVerifyType = b16;
        this.lPeerUin = j16;
    }
}
