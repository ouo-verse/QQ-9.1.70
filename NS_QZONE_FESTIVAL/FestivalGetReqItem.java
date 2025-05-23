package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FestivalGetReqItem extends JceStruct {
    public long mdays;
    public long month;
    public long time;
    public long type;
    public long year;

    public FestivalGetReqItem() {
        this.time = 0L;
        this.year = 0L;
        this.month = 0L;
        this.mdays = 0L;
        this.type = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.time = jceInputStream.read(this.time, 0, false);
        this.year = jceInputStream.read(this.year, 1, false);
        this.month = jceInputStream.read(this.month, 2, false);
        this.mdays = jceInputStream.read(this.mdays, 3, false);
        this.type = jceInputStream.read(this.type, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.time, 0);
        jceOutputStream.write(this.year, 1);
        jceOutputStream.write(this.month, 2);
        jceOutputStream.write(this.mdays, 3);
        jceOutputStream.write(this.type, 4);
    }

    public FestivalGetReqItem(long j3, long j16, long j17, long j18, long j19) {
        this.time = j3;
        this.year = j16;
        this.month = j17;
        this.mdays = j18;
        this.type = j19;
    }
}
