package TianShuJce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Gps extends JceStruct {
    public int accuracy;
    public int lat;
    public int lon;

    public Gps() {
        this.lat = 0;
        this.lon = 0;
        this.accuracy = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lat = jceInputStream.read(this.lat, 1, false);
        this.lon = jceInputStream.read(this.lon, 2, false);
        this.accuracy = jceInputStream.read(this.accuracy, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lat, 1);
        jceOutputStream.write(this.lon, 2);
        jceOutputStream.write(this.accuracy, 3);
    }

    public Gps(int i3, int i16, int i17) {
        this.lat = i3;
        this.lon = i16;
        this.accuracy = i17;
    }
}
