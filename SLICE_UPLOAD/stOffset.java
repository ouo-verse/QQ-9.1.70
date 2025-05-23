package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stOffset extends JceStruct {
    public long begin;
    public long end;

    public stOffset() {
        this.begin = 0L;
        this.end = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.begin = jceInputStream.read(this.begin, 1, true);
        this.end = jceInputStream.read(this.end, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.begin, 1);
        jceOutputStream.write(this.end, 2);
    }

    public stOffset(long j3, long j16) {
        this.begin = j3;
        this.end = j16;
    }
}
