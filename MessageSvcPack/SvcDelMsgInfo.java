package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcDelMsgInfo extends JceStruct {
    public long lFromUin;
    public long lMsgUid;
    public short shMsgSeq;
    public int shMsgType;
    public int uMsgTime;

    public SvcDelMsgInfo() {
        this.lFromUin = 0L;
        this.uMsgTime = 0;
        this.shMsgSeq = (short) 0;
        this.lMsgUid = 0L;
        this.shMsgType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromUin = jceInputStream.read(this.lFromUin, 0, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 1, true);
        this.shMsgSeq = jceInputStream.read(this.shMsgSeq, 2, true);
        this.lMsgUid = jceInputStream.read(this.lMsgUid, 3, false);
        this.shMsgType = jceInputStream.read(this.shMsgType, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromUin, 0);
        jceOutputStream.write(this.uMsgTime, 1);
        jceOutputStream.write(this.shMsgSeq, 2);
        jceOutputStream.write(this.lMsgUid, 3);
        jceOutputStream.write(this.shMsgType, 4);
    }

    public SvcDelMsgInfo(long j3, int i3, short s16, long j16, int i16) {
        this.lFromUin = j3;
        this.uMsgTime = i3;
        this.shMsgSeq = s16;
        this.lMsgUid = j16;
        this.shMsgType = i16;
    }
}
