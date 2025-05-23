package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Rect extends JceStruct {
    public double ScaleHeight;
    public double ScaleOffsetX;
    public double ScaleOffsetY;
    public double ScaleWidth;

    public Rect() {
        this.ScaleOffsetX = 0.0d;
        this.ScaleOffsetY = 0.0d;
        this.ScaleWidth = 0.0d;
        this.ScaleHeight = 0.0d;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ScaleOffsetX = jceInputStream.read(this.ScaleOffsetX, 0, false);
        this.ScaleOffsetY = jceInputStream.read(this.ScaleOffsetY, 1, false);
        this.ScaleWidth = jceInputStream.read(this.ScaleWidth, 2, false);
        this.ScaleHeight = jceInputStream.read(this.ScaleHeight, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ScaleOffsetX, 0);
        jceOutputStream.write(this.ScaleOffsetY, 1);
        jceOutputStream.write(this.ScaleWidth, 2);
        jceOutputStream.write(this.ScaleHeight, 3);
    }

    public Rect(double d16, double d17, double d18, double d19) {
        this.ScaleOffsetX = d16;
        this.ScaleOffsetY = d17;
        this.ScaleWidth = d18;
        this.ScaleHeight = d19;
    }
}
