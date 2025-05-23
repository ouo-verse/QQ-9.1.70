package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShowRangeTime extends JceStruct {
    public long beginTime;
    public long endTime;

    public ShowRangeTime() {
        this.beginTime = 0L;
        this.endTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.beginTime = jceInputStream.read(this.beginTime, 0, false);
        this.endTime = jceInputStream.read(this.endTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "ShowRangeTime{beginTime=" + this.beginTime + ", endTime=" + this.endTime + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.beginTime, 0);
        jceOutputStream.write(this.endTime, 1);
    }

    public ShowRangeTime(long j3, long j16) {
        this.beginTime = j3;
        this.endTime = j16;
    }
}
