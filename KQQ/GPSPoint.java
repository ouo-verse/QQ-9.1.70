package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GPSPoint extends JceStruct {
    public int alt;
    public int lat;
    public int lon;

    public GPSPoint() {
        this.lat = 900000000;
        this.lon = 900000000;
        this.alt = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lat = jceInputStream.read(this.lat, 0, true);
        this.lon = jceInputStream.read(this.lon, 1, true);
        this.alt = jceInputStream.read(this.alt, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lat, 0);
        jceOutputStream.write(this.lon, 1);
        jceOutputStream.write(this.alt, 2);
    }

    public GPSPoint(int i3, int i16, int i17) {
        this.lat = i3;
        this.lon = i16;
        this.alt = i17;
    }
}
