package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRecommandUpload extends JceStruct {
    static int cache_type;
    public long begin;
    public long end;
    public long left_days;
    public int type;

    public stRecommandUpload() {
        this.type = 1;
        this.left_days = 0L;
        this.begin = 0L;
        this.end = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.left_days = jceInputStream.read(this.left_days, 1, false);
        this.begin = jceInputStream.read(this.begin, 2, false);
        this.end = jceInputStream.read(this.end, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.left_days, 1);
        jceOutputStream.write(this.begin, 2);
        jceOutputStream.write(this.end, 3);
    }

    public stRecommandUpload(int i3, long j3, long j16, long j17) {
        this.type = i3;
        this.left_days = j3;
        this.begin = j16;
        this.end = j17;
    }
}
