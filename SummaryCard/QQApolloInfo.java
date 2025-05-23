package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQApolloInfo extends JceStruct {
    public long uTimestamp;
    public long uUserFlag;
    public long uVipFlag;
    public long uVipLevel;

    public QQApolloInfo() {
        this.uVipFlag = 0L;
        this.uVipLevel = 0L;
        this.uUserFlag = 0L;
        this.uTimestamp = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uVipFlag = jceInputStream.read(this.uVipFlag, 0, false);
        this.uVipLevel = jceInputStream.read(this.uVipLevel, 1, false);
        this.uUserFlag = jceInputStream.read(this.uUserFlag, 2, false);
        this.uTimestamp = jceInputStream.read(this.uTimestamp, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uVipFlag, 0);
        jceOutputStream.write(this.uVipLevel, 1);
        jceOutputStream.write(this.uUserFlag, 2);
        jceOutputStream.write(this.uTimestamp, 3);
    }

    public QQApolloInfo(long j3, long j16, long j17, long j18) {
        this.uVipFlag = j3;
        this.uVipLevel = j16;
        this.uUserFlag = j17;
        this.uTimestamp = j18;
    }
}
