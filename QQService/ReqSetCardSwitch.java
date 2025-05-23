package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSetCardSwitch extends JceStruct {
    static ReqHead cache_stHeader;
    public ReqHead stHeader;
    public long uCloseNeighborVote;
    public long uCloseTimeGateVote;

    public ReqSetCardSwitch() {
        this.stHeader = null;
        this.uCloseNeighborVote = 2L;
        this.uCloseTimeGateVote = 2L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.uCloseNeighborVote = jceInputStream.read(this.uCloseNeighborVote, 1, true);
        this.uCloseTimeGateVote = jceInputStream.read(this.uCloseTimeGateVote, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.uCloseNeighborVote, 1);
        jceOutputStream.write(this.uCloseTimeGateVote, 2);
    }

    public ReqSetCardSwitch(ReqHead reqHead, long j3, long j16) {
        this.stHeader = reqHead;
        this.uCloseNeighborVote = j3;
        this.uCloseTimeGateVote = j16;
    }
}
