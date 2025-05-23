package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_gps extends JceStruct {
    public int altitude;
    public int latitude;
    public int longitude;

    public s_gps() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.latitude = jceInputStream.read(this.latitude, 0, false);
        this.longitude = jceInputStream.read(this.longitude, 1, false);
        this.altitude = jceInputStream.read(this.altitude, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.latitude, 0);
        jceOutputStream.write(this.longitude, 1);
        jceOutputStream.write(this.altitude, 2);
    }

    public s_gps(int i3, int i16, int i17) {
        this.latitude = i3;
        this.longitude = i16;
        this.altitude = i17;
    }
}
