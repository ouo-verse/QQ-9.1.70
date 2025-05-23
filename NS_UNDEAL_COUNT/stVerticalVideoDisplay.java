package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stVerticalVideoDisplay extends JceStruct {
    public int iAspectRatioHeight;
    public int iAspectRatioWidth;
    public int iFeedAspectRatio;
    public int iType;

    public stVerticalVideoDisplay() {
        this.iType = -1;
        this.iFeedAspectRatio = -1;
        this.iAspectRatioWidth = -1;
        this.iAspectRatioHeight = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, false);
        this.iFeedAspectRatio = jceInputStream.read(this.iFeedAspectRatio, 1, false);
        this.iAspectRatioWidth = jceInputStream.read(this.iAspectRatioWidth, 2, false);
        this.iAspectRatioHeight = jceInputStream.read(this.iAspectRatioHeight, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        jceOutputStream.write(this.iFeedAspectRatio, 1);
        jceOutputStream.write(this.iAspectRatioWidth, 2);
        jceOutputStream.write(this.iAspectRatioHeight, 3);
    }

    public stVerticalVideoDisplay(int i3, int i16, int i17, int i18) {
        this.iType = i3;
        this.iFeedAspectRatio = i16;
        this.iAspectRatioWidth = i17;
        this.iAspectRatioHeight = i18;
    }
}
