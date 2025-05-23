package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetWatermarkDictReq extends JceStruct {
    public double Lat;
    public double Lon;

    public GetWatermarkDictReq() {
        this.Lat = 0.0d;
        this.Lon = 0.0d;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Lat = jceInputStream.read(this.Lat, 0, true);
        this.Lon = jceInputStream.read(this.Lon, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Lat, 0);
        jceOutputStream.write(this.Lon, 1);
    }

    public GetWatermarkDictReq(double d16, double d17) {
        this.Lat = d16;
        this.Lon = d17;
    }
}
