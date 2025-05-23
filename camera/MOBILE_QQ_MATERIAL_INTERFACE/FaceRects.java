package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FaceRects extends JceStruct {
    public double H;
    public double W;
    public double X;
    public double Y;

    public FaceRects() {
        this.X = 0.0d;
        this.Y = 0.0d;
        this.W = 0.0d;
        this.H = 0.0d;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.X = jceInputStream.read(this.X, 0, false);
        this.Y = jceInputStream.read(this.Y, 1, false);
        this.W = jceInputStream.read(this.W, 2, false);
        this.H = jceInputStream.read(this.H, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.X, 0);
        jceOutputStream.write(this.Y, 1);
        jceOutputStream.write(this.W, 2);
        jceOutputStream.write(this.H, 3);
    }

    public FaceRects(double d16, double d17, double d18, double d19) {
        this.X = d16;
        this.Y = d17;
        this.W = d18;
        this.H = d19;
    }
}
