package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TimeRange extends JceStruct {
    public long iTimeBegin;
    public long iTimeEnd;

    public TimeRange() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTimeBegin = jceInputStream.read(this.iTimeBegin, 0, true);
        this.iTimeEnd = jceInputStream.read(this.iTimeEnd, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTimeBegin, 0);
        jceOutputStream.write(this.iTimeEnd, 1);
    }

    public TimeRange(long j3, long j16) {
        this.iTimeBegin = j3;
        this.iTimeEnd = j16;
    }
}
