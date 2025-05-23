package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_patch extends JceStruct {
    public long uTestNum;

    public cell_patch() {
        this.uTestNum = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uTestNum = jceInputStream.read(this.uTestNum, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uTestNum, 0);
    }

    public cell_patch(long j3) {
        this.uTestNum = j3;
    }
}
