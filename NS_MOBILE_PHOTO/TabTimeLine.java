package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TabTimeLine extends JceStruct {
    public long begin_time;
    public long end_time;
    public long month;
    public long year;

    public TabTimeLine() {
        this.year = 0L;
        this.month = 0L;
        this.begin_time = 0L;
        this.end_time = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.year = jceInputStream.read(this.year, 0, false);
        this.month = jceInputStream.read(this.month, 1, false);
        this.begin_time = jceInputStream.read(this.begin_time, 2, false);
        this.end_time = jceInputStream.read(this.end_time, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.year, 0);
        jceOutputStream.write(this.month, 1);
        jceOutputStream.write(this.begin_time, 2);
        jceOutputStream.write(this.end_time, 3);
    }

    public TabTimeLine(long j3, long j16, long j17, long j18) {
        this.year = j3;
        this.month = j16;
        this.begin_time = j17;
        this.end_time = j18;
    }
}
