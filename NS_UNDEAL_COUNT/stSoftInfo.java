package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSoftInfo extends JceStruct {
    public long end_time;
    public long soft_type;
    public long start_time;

    public stSoftInfo() {
        this.soft_type = 0L;
        this.start_time = 0L;
        this.end_time = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.soft_type = jceInputStream.read(this.soft_type, 0, false);
        this.start_time = jceInputStream.read(this.start_time, 1, false);
        this.end_time = jceInputStream.read(this.end_time, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.soft_type, 0);
        jceOutputStream.write(this.start_time, 1);
        jceOutputStream.write(this.end_time, 2);
    }

    public stSoftInfo(long j3, long j16, long j17) {
        this.soft_type = j3;
        this.start_time = j16;
        this.end_time = j17;
    }
}
