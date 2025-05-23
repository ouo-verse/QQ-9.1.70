package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupMsgReadedNotify extends JceStruct {
    public long lGroupCode;
    public long lGroupMsgSeq;
    public long lMemberSeq;
    public long lOpType;

    public GroupMsgReadedNotify() {
        this.lGroupCode = 0L;
        this.lOpType = 0L;
        this.lMemberSeq = 0L;
        this.lGroupMsgSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 0, false);
        this.lOpType = jceInputStream.read(this.lOpType, 1, false);
        this.lMemberSeq = jceInputStream.read(this.lMemberSeq, 2, false);
        this.lGroupMsgSeq = jceInputStream.read(this.lGroupMsgSeq, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lGroupCode, 0);
        jceOutputStream.write(this.lOpType, 1);
        jceOutputStream.write(this.lMemberSeq, 2);
        jceOutputStream.write(this.lGroupMsgSeq, 3);
    }

    public GroupMsgReadedNotify(long j3, long j16, long j17, long j18) {
        this.lGroupCode = j3;
        this.lOpType = j16;
        this.lMemberSeq = j17;
        this.lGroupMsgSeq = j18;
    }
}
