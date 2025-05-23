package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DouScoreInfo extends JceStruct {
    public long uiDouScoreExpTime;
    public long uiDouTimes;

    public DouScoreInfo() {
        this.uiDouTimes = 0L;
        this.uiDouScoreExpTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiDouTimes = jceInputStream.read(this.uiDouTimes, 0, false);
        this.uiDouScoreExpTime = jceInputStream.read(this.uiDouScoreExpTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiDouTimes, 0);
        jceOutputStream.write(this.uiDouScoreExpTime, 1);
    }

    public DouScoreInfo(long j3, long j16) {
        this.uiDouTimes = j3;
        this.uiDouScoreExpTime = j16;
    }
}
