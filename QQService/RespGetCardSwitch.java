package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetCardSwitch extends JceStruct {
    static RespHead cache_stHeader;
    public RespHead stHeader;
    public long uCloseNeighborVote;
    public long uCloseTimeGateVote;

    public RespGetCardSwitch() {
        this.stHeader = null;
        this.uCloseNeighborVote = 0L;
        this.uCloseTimeGateVote = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.uCloseNeighborVote = jceInputStream.read(this.uCloseNeighborVote, 1, true);
        this.uCloseTimeGateVote = jceInputStream.read(this.uCloseTimeGateVote, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.uCloseNeighborVote, 1);
        jceOutputStream.write(this.uCloseTimeGateVote, 2);
    }

    public RespGetCardSwitch(RespHead respHead, long j3, long j16) {
        this.stHeader = respHead;
        this.uCloseNeighborVote = j3;
        this.uCloseTimeGateVote = j16;
    }
}
