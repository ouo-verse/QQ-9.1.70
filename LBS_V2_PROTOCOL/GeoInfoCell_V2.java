package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GeoInfoCell_V2 extends JceStruct {
    static GPS_V2 cache_stClientGps;
    static GeoInfo_V2 cache_stGeoInfo;
    static GPS_V2 cache_stGps;
    public int iRet;
    public GPS_V2 stClientGps;
    public GeoInfo_V2 stGeoInfo;
    public GPS_V2 stGps;

    public GeoInfoCell_V2() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new GPS_V2();
        }
        this.stGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stGps, 0, false);
        if (cache_stGeoInfo == null) {
            cache_stGeoInfo = new GeoInfo_V2();
        }
        this.stGeoInfo = (GeoInfo_V2) jceInputStream.read((JceStruct) cache_stGeoInfo, 1, false);
        this.iRet = jceInputStream.read(this.iRet, 2, false);
        if (cache_stClientGps == null) {
            cache_stClientGps = new GPS_V2();
        }
        this.stClientGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stClientGps, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        GPS_V2 gps_v2 = this.stGps;
        if (gps_v2 != null) {
            jceOutputStream.write((JceStruct) gps_v2, 0);
        }
        GeoInfo_V2 geoInfo_V2 = this.stGeoInfo;
        if (geoInfo_V2 != null) {
            jceOutputStream.write((JceStruct) geoInfo_V2, 1);
        }
        jceOutputStream.write(this.iRet, 2);
        GPS_V2 gps_v22 = this.stClientGps;
        if (gps_v22 != null) {
            jceOutputStream.write((JceStruct) gps_v22, 3);
        }
    }

    public GeoInfoCell_V2(GPS_V2 gps_v2, GeoInfo_V2 geoInfo_V2, int i3, GPS_V2 gps_v22) {
        this.stGps = gps_v2;
        this.stGeoInfo = geoInfo_V2;
        this.iRet = i3;
        this.stClientGps = gps_v22;
    }
}
