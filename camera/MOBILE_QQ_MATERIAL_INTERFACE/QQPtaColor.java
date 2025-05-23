package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class QQPtaColor extends JceStruct {
    public int B;
    public int G;
    public int H;
    public int R;
    public int S;
    public int V;

    public QQPtaColor() {
        this.R = 0;
        this.G = 0;
        this.B = 0;
        this.H = 0;
        this.S = 0;
        this.V = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.R = jceInputStream.read(this.R, 0, false);
        this.G = jceInputStream.read(this.G, 1, false);
        this.B = jceInputStream.read(this.B, 2, false);
        this.H = jceInputStream.read(this.H, 3, false);
        this.S = jceInputStream.read(this.S, 4, false);
        this.V = jceInputStream.read(this.V, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.R, 0);
        jceOutputStream.write(this.G, 1);
        jceOutputStream.write(this.B, 2);
        jceOutputStream.write(this.H, 3);
        jceOutputStream.write(this.S, 4);
        jceOutputStream.write(this.V, 5);
    }

    public QQPtaColor(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.R = i3;
        this.G = i16;
        this.B = i17;
        this.H = i18;
        this.S = i19;
        this.V = i26;
    }
}
