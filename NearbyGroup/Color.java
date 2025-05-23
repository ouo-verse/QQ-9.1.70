package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Color extends JceStruct {
    public long B;
    public long G;
    public long R;

    public Color() {
        this.R = 0L;
        this.G = 0L;
        this.B = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.R = jceInputStream.read(this.R, 0, true);
        this.G = jceInputStream.read(this.G, 1, true);
        this.B = jceInputStream.read(this.B, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.R, 0);
        jceOutputStream.write(this.G, 1);
        jceOutputStream.write(this.B, 2);
    }

    public Color(long j3, long j16, long j17) {
        this.R = j3;
        this.G = j16;
        this.B = j17;
    }
}
