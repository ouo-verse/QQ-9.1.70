package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_Games_OrderData extends JceStruct {
    public long uFrdRanking;
    public long uWinCount;

    public st_Games_OrderData() {
        this.uWinCount = 0L;
        this.uFrdRanking = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uWinCount = jceInputStream.read(this.uWinCount, 0, false);
        this.uFrdRanking = jceInputStream.read(this.uFrdRanking, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uWinCount, 0);
        jceOutputStream.write(this.uFrdRanking, 1);
    }

    public st_Games_OrderData(long j3, long j16) {
        this.uWinCount = j3;
        this.uFrdRanking = j16;
    }
}
