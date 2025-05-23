package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQVideoInfo extends JceStruct {
    public long uHollywoodLevel;
    public long uVipFlag;

    public QQVideoInfo() {
        this.uVipFlag = 0L;
        this.uHollywoodLevel = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uVipFlag = jceInputStream.read(this.uVipFlag, 0, false);
        this.uHollywoodLevel = jceInputStream.read(this.uHollywoodLevel, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uVipFlag, 0);
        jceOutputStream.write(this.uHollywoodLevel, 1);
    }

    public QQVideoInfo(long j3, long j16) {
        this.uVipFlag = j3;
        this.uHollywoodLevel = j16;
    }
}
