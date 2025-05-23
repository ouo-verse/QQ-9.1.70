package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetLbsCombinRsp_V2 extends JceStruct {
    public int iMood;
    public String request_id;
    public GeoInfo_V2 stGeoInfo;
    public GPS_V2 stGps;
    public GetPoiInfoRsp_V2 stPoiInfo;
    public WeatherInfo_V2 stWeather;
    static GPS_V2 cache_stGps = new GPS_V2();
    static GeoInfo_V2 cache_stGeoInfo = new GeoInfo_V2();
    static GetPoiInfoRsp_V2 cache_stPoiInfo = new GetPoiInfoRsp_V2();
    static WeatherInfo_V2 cache_stWeather = new WeatherInfo_V2();

    public GetLbsCombinRsp_V2() {
        this.stGps = null;
        this.stGeoInfo = null;
        this.stPoiInfo = null;
        this.stWeather = null;
        this.iMood = 0;
        this.request_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stGps = (GPS_V2) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        this.stGeoInfo = (GeoInfo_V2) jceInputStream.read((JceStruct) cache_stGeoInfo, 1, true);
        this.stPoiInfo = (GetPoiInfoRsp_V2) jceInputStream.read((JceStruct) cache_stPoiInfo, 2, true);
        this.stWeather = (WeatherInfo_V2) jceInputStream.read((JceStruct) cache_stWeather, 3, true);
        this.iMood = jceInputStream.read(this.iMood, 4, false);
        this.request_id = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write((JceStruct) this.stGeoInfo, 1);
        jceOutputStream.write((JceStruct) this.stPoiInfo, 2);
        jceOutputStream.write((JceStruct) this.stWeather, 3);
        jceOutputStream.write(this.iMood, 4);
        String str = this.request_id;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public GetLbsCombinRsp_V2(GPS_V2 gps_v2, GeoInfo_V2 geoInfo_V2, GetPoiInfoRsp_V2 getPoiInfoRsp_V2, WeatherInfo_V2 weatherInfo_V2, int i3, String str) {
        this.stGps = gps_v2;
        this.stGeoInfo = geoInfo_V2;
        this.stPoiInfo = getPoiInfoRsp_V2;
        this.stWeather = weatherInfo_V2;
        this.iMood = i3;
        this.request_id = str;
    }
}
