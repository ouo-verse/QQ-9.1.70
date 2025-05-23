package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stGPS extends JceStruct {
    public int eType;
    public double fLat;
    public double fLon;
    public int iAlt;

    public stGPS() {
        this.fLat = 900.0d;
        this.fLon = 900.0d;
        this.iAlt = -10000000;
        this.eType = 2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.fLat = jceInputStream.read(this.fLat, 0, true);
        this.fLon = jceInputStream.read(this.fLon, 1, true);
        this.iAlt = jceInputStream.read(this.iAlt, 2, true);
        this.eType = jceInputStream.read(this.eType, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.fLat, 0);
        jceOutputStream.write(this.fLon, 1);
        jceOutputStream.write(this.iAlt, 2);
        jceOutputStream.write(this.eType, 3);
    }

    public stGPS(double d16, double d17, int i3, int i16) {
        this.fLat = d16;
        this.fLon = d17;
        this.iAlt = i3;
        this.eType = i16;
    }
}
