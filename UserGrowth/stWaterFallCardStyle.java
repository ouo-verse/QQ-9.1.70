package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWaterFallCardStyle extends JceStruct {
    public int cardType;
    public boolean isFullSpan;
    public boolean isVertical;
    public int ratioH;
    public int ratioW;

    public stWaterFallCardStyle() {
        this.cardType = 0;
        this.ratioW = 0;
        this.ratioH = 0;
        this.isFullSpan = true;
        this.isVertical = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cardType = jceInputStream.read(this.cardType, 0, false);
        this.ratioW = jceInputStream.read(this.ratioW, 1, false);
        this.ratioH = jceInputStream.read(this.ratioH, 2, false);
        this.isFullSpan = jceInputStream.read(this.isFullSpan, 3, false);
        this.isVertical = jceInputStream.read(this.isVertical, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cardType, 0);
        jceOutputStream.write(this.ratioW, 1);
        jceOutputStream.write(this.ratioH, 2);
        jceOutputStream.write(this.isFullSpan, 3);
        jceOutputStream.write(this.isVertical, 4);
    }

    public stWaterFallCardStyle(int i3, int i16, int i17, boolean z16, boolean z17) {
        this.cardType = i3;
        this.ratioW = i16;
        this.ratioH = i17;
        this.isFullSpan = z16;
        this.isVertical = z17;
    }
}
