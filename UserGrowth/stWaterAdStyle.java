package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWaterAdStyle extends JceStruct {
    public int HRatioW;
    public int hRatioH;
    public int vRatioH;
    public int vRatioW;

    public stWaterAdStyle() {
        this.vRatioW = 0;
        this.vRatioH = 0;
        this.HRatioW = 0;
        this.hRatioH = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vRatioW = jceInputStream.read(this.vRatioW, 0, false);
        this.vRatioH = jceInputStream.read(this.vRatioH, 1, false);
        this.HRatioW = jceInputStream.read(this.HRatioW, 2, false);
        this.hRatioH = jceInputStream.read(this.hRatioH, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vRatioW, 0);
        jceOutputStream.write(this.vRatioH, 1);
        jceOutputStream.write(this.HRatioW, 2);
        jceOutputStream.write(this.hRatioH, 3);
    }

    public stWaterAdStyle(int i3, int i16, int i17, int i18) {
        this.vRatioW = i3;
        this.vRatioH = i16;
        this.HRatioW = i17;
        this.hRatioH = i18;
    }
}
