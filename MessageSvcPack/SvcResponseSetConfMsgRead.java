package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcResponseSetConfMsgRead extends JceStruct {
    public byte cReplyCode;
    public long lConfMsgSeq;
    public long lConfUin;
    public long lMemberMsgSeq;
    public String strResult;

    public SvcResponseSetConfMsgRead() {
        this.cReplyCode = (byte) 0;
        this.strResult = "";
        this.lConfUin = 0L;
        this.lMemberMsgSeq = 0L;
        this.lConfMsgSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 0, true);
        this.strResult = jceInputStream.readString(1, true);
        this.lConfUin = jceInputStream.read(this.lConfUin, 2, true);
        this.lMemberMsgSeq = jceInputStream.read(this.lMemberMsgSeq, 3, true);
        this.lConfMsgSeq = jceInputStream.read(this.lConfMsgSeq, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cReplyCode, 0);
        jceOutputStream.write(this.strResult, 1);
        jceOutputStream.write(this.lConfUin, 2);
        jceOutputStream.write(this.lMemberMsgSeq, 3);
        jceOutputStream.write(this.lConfMsgSeq, 4);
    }

    public SvcResponseSetConfMsgRead(byte b16, String str, long j3, long j16, long j17) {
        this.cReplyCode = b16;
        this.strResult = str;
        this.lConfUin = j3;
        this.lMemberMsgSeq = j16;
        this.lConfMsgSeq = j17;
    }
}
