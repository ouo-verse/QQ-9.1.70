package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DisMsgReadedNotify extends JceStruct {
    public long lDisMsgSeq;
    public long lDisUin;
    public long lMemberSeq;
    public long lOpType;

    public DisMsgReadedNotify() {
        this.lDisUin = 0L;
        this.lOpType = 0L;
        this.lMemberSeq = 0L;
        this.lDisMsgSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lDisUin = jceInputStream.read(this.lDisUin, 0, false);
        this.lOpType = jceInputStream.read(this.lOpType, 1, false);
        this.lMemberSeq = jceInputStream.read(this.lMemberSeq, 2, false);
        this.lDisMsgSeq = jceInputStream.read(this.lDisMsgSeq, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lDisUin, 0);
        jceOutputStream.write(this.lOpType, 1);
        jceOutputStream.write(this.lMemberSeq, 2);
        jceOutputStream.write(this.lDisMsgSeq, 3);
    }

    public DisMsgReadedNotify(long j3, long j16, long j17, long j18) {
        this.lDisUin = j3;
        this.lOpType = j16;
        this.lMemberSeq = j17;
        this.lDisMsgSeq = j18;
    }
}
