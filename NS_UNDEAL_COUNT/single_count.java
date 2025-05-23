package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class single_count extends JceStruct {
    public byte iControl;
    public long uCount;

    public single_count() {
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

    public single_count(long j3, byte b16) {
        this.uCount = j3;
        this.iControl = b16;
    }
}
