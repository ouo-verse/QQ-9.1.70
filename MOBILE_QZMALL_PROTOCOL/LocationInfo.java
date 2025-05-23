package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LocationInfo extends JceStruct {
    public int iBottom;
    public int iLeft;
    public int iRight;
    public int iTop;

    public LocationInfo() {
        this.iLeft = 0;
        this.iRight = 0;
        this.iTop = 0;
        this.iBottom = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iLeft = jceInputStream.read(this.iLeft, 0, false);
        this.iRight = jceInputStream.read(this.iRight, 1, false);
        this.iTop = jceInputStream.read(this.iTop, 2, false);
        this.iBottom = jceInputStream.read(this.iBottom, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iLeft, 0);
        jceOutputStream.write(this.iRight, 1);
        jceOutputStream.write(this.iTop, 2);
        jceOutputStream.write(this.iBottom, 3);
    }

    public LocationInfo(int i3, int i16, int i17, int i18) {
        this.iLeft = i3;
        this.iRight = i16;
        this.iTop = i17;
        this.iBottom = i18;
    }
}
