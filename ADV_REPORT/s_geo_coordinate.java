package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_geo_coordinate extends JceStruct {
    public double latitude_axis;
    public double longitude_axis;

    public s_geo_coordinate() {
        this.longitude_axis = 0.0d;
        this.latitude_axis = 0.0d;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.longitude_axis = jceInputStream.read(this.longitude_axis, 0, false);
        this.latitude_axis = jceInputStream.read(this.latitude_axis, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.longitude_axis, 0);
        jceOutputStream.write(this.latitude_axis, 1);
    }

    public s_geo_coordinate(double d16, double d17) {
        this.longitude_axis = d16;
        this.latitude_axis = d17;
    }
}
