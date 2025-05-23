package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestSetConfMsgRead extends JceStruct {
    public byte cVerifyType;
    public long lConfUin;
    public long lLastReadSeq;

    public SvcRequestSetConfMsgRead() {
        this.lConfUin = 0L;
        this.lLastReadSeq = 0L;
        this.cVerifyType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lConfUin = jceInputStream.read(this.lConfUin, 0, true);
        this.lLastReadSeq = jceInputStream.read(this.lLastReadSeq, 1, true);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lConfUin, 0);
        jceOutputStream.write(this.lLastReadSeq, 1);
        jceOutputStream.write(this.cVerifyType, 2);
    }

    public SvcRequestSetConfMsgRead(long j3, long j16, byte b16) {
        this.lConfUin = j3;
        this.lLastReadSeq = j16;
        this.cVerifyType = b16;
    }
}
