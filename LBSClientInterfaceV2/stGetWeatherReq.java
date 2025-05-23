package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetWeatherReq extends JceStruct {
    static stGPS cache_stGps;
    public int iForecastDay;
    public stGPS stGps;
    public String strClientIP;
    public String strDate;

    public stGetWeatherReq() {
        this.stGps = null;
        this.strClientIP = "";
        this.strDate = "";
        this.iForecastDay = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new stGPS();
        }
        this.stGps = (stGPS) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        this.strClientIP = jceInputStream.readString(1, true);
        this.strDate = jceInputStream.readString(2, true);
        this.iForecastDay = jceInputStream.read(this.iForecastDay, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write(this.strClientIP, 1);
        jceOutputStream.write(this.strDate, 2);
        jceOutputStream.write(this.iForecastDay, 3);
    }

    public stGetWeatherReq(stGPS stgps, String str, String str2, int i3) {
        this.stGps = stgps;
        this.strClientIP = str;
        this.strDate = str2;
        this.iForecastDay = i3;
    }
}
