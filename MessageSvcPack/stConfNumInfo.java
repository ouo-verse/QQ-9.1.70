package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stConfNumInfo extends JceStruct {
    public long lConfUin;
    public long uConfMsgSeq;
    public long uMemberMsgSeq;

    public stConfNumInfo() {
        this.lConfUin = 0L;
        this.uConfMsgSeq = 0L;
        this.uMemberMsgSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lConfUin = jceInputStream.read(this.lConfUin, 0, true);
        this.uConfMsgSeq = jceInputStream.read(this.uConfMsgSeq, 1, true);
        this.uMemberMsgSeq = jceInputStream.read(this.uMemberMsgSeq, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lConfUin, 0);
        jceOutputStream.write(this.uConfMsgSeq, 1);
        jceOutputStream.write(this.uMemberMsgSeq, 2);
    }

    public stConfNumInfo(long j3, long j16, long j17) {
        this.lConfUin = j3;
        this.uConfMsgSeq = j16;
        this.uMemberMsgSeq = j17;
    }
}
