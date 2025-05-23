package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetLbsCombinRsp extends JceStruct {
    static stGPS cache_stGps;
    static stGetPoiInfoRsp cache_stPoiInfo;
    static stGeoInfo cache_stPosition;
    static stWeatherInfo cache_stWeather;
    public stGPS stGps;
    public stGetPoiInfoRsp stPoiInfo;
    public stGeoInfo stPosition;
    public stWeatherInfo stWeather;

    public stGetLbsCombinRsp() {
        this.stGps = null;
        this.stPosition = null;
        this.stPoiInfo = null;
        this.stWeather = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new stGPS();
        }
        this.stGps = (stGPS) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        if (cache_stPosition == null) {
            cache_stPosition = new stGeoInfo();
        }
        this.stPosition = (stGeoInfo) jceInputStream.read((JceStruct) cache_stPosition, 1, true);
        if (cache_stPoiInfo == null) {
            cache_stPoiInfo = new stGetPoiInfoRsp();
        }
        this.stPoiInfo = (stGetPoiInfoRsp) jceInputStream.read((JceStruct) cache_stPoiInfo, 2, true);
        if (cache_stWeather == null) {
            cache_stWeather = new stWeatherInfo();
        }
        this.stWeather = (stWeatherInfo) jceInputStream.read((JceStruct) cache_stWeather, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write((JceStruct) this.stPosition, 1);
        jceOutputStream.write((JceStruct) this.stPoiInfo, 2);
        jceOutputStream.write((JceStruct) this.stWeather, 3);
    }

    public stGetLbsCombinRsp(stGPS stgps, stGeoInfo stgeoinfo, stGetPoiInfoRsp stgetpoiinforsp, stWeatherInfo stweatherinfo) {
        this.stGps = stgps;
        this.stPosition = stgeoinfo;
        this.stPoiInfo = stgetpoiinforsp;
        this.stWeather = stweatherinfo;
    }
}
