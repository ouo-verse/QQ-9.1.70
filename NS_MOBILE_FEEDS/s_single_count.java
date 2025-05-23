package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_single_count extends JceStruct {
    public int iControl;
    public long uCount;

    public s_single_count() {
        this.uCount = 0L;
        this.iControl = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uCount = jceInputStream.read(this.uCount, 0, false);
        this.iControl = jceInputStream.read(this.iControl, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uCount, 0);
        jceOutputStream.write(this.iControl, 1);
    }

    public s_single_count(long j3, int i3) {
        this.uCount = j3;
        this.iControl = i3;
    }
}
