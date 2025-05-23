package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetGeoInfoRsp_V2 extends JceStruct {
    static GeoInfo_V2 cache_stGeoInfo;
    static GPS_V2 cache_stGps;
    public GeoInfo_V2 stGeoInfo;
    public GPS_V2 stGps;

    public GetGeoInfoRsp_V2() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new GPS_V2();
        }
        this.stGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        if (cache_stGeoInfo == null) {
            cache_stGeoInfo = new GeoInfo_V2();
        }
        this.stGeoInfo = (GeoInfo_V2) jceInputStream.read((JceStruct) cache_stGeoInfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write((JceStruct) this.stGeoInfo, 1);
    }

    public GetGeoInfoRsp_V2(GPS_V2 gps_v2, GeoInfo_V2 geoInfo_V2) {
        this.stGps = gps_v2;
        this.stGeoInfo = geoInfo_V2;
    }
}
