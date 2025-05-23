package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWeatherInfo extends JceStruct {
    static Map<String, AlarmInfo> cache_mapAlarminfo;
    static Map<Short, ForecastInfo> cache_mapForecastInfo;
    public int iCityCode;
    public int iHour;
    public int iHumidity;
    public int iPM2p5;
    public int iRet;
    public int iTempCurr;
    public int iTempMax;
    public int iTempMin;
    public int iWeather;
    public int iWind;
    public int iWindForce;
    public Map<String, AlarmInfo> mapAlarminfo;
    public Map<Short, ForecastInfo> mapForecastInfo;
    public String strCityName;
    public String strDate;
    public String strDeviceName;
    public String strPressure;
    public String strSunriseTime;
    public String strSunsetTime;

    public stWeatherInfo() {
        this.iRet = 0;
        this.iCityCode = 0;
        this.strCityName = "";
        this.strDate = "";
        this.iHour = 0;
        this.iWeather = 0;
        this.iWind = 0;
        this.iTempCurr = 0;
        this.iTempMax = 0;
        this.iTempMin = 0;
        this.iHumidity = 0;
        this.strSunriseTime = "";
        this.strSunsetTime = "";
        this.strPressure = "";
        this.iWindForce = 0;
        this.strDeviceName = "";
        this.iPM2p5 = 0;
        this.mapForecastInfo = null;
        this.mapAlarminfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
        this.iCityCode = jceInputStream.read(this.iCityCode, 1, true);
        this.strCityName = jceInputStream.readString(2, true);
        this.strDate = jceInputStream.readString(3, true);
        this.iHour = jceInputStream.read(this.iHour, 4, true);
        this.iWeather = jceInputStream.read(this.iWeather, 5, true);
        this.iWind = jceInputStream.read(this.iWind, 6, true);
        this.iTempCurr = jceInputStream.read(this.iTempCurr, 7, true);
        this.iTempMax = jceInputStream.read(this.iTempMax, 8, true);
        this.iTempMin = jceInputStream.read(this.iTempMin, 9, true);
        this.iHumidity = jceInputStream.read(this.iHumidity, 10, true);
        this.strSunriseTime = jceInputStream.readString(11, false);
        this.strSunsetTime = jceInputStream.readString(12, false);
        this.strPressure = jceInputStream.readString(13, false);
        this.iWindForce = jceInputStream.read(this.iWindForce, 14, false);
        this.strDeviceName = jceInputStream.readString(15, false);
        this.iPM2p5 = jceInputStream.read(this.iPM2p5, 16, false);
        if (cache_mapForecastInfo == null) {
            cache_mapForecastInfo = new HashMap();
            cache_mapForecastInfo.put((short) 0, new ForecastInfo());
        }
        this.mapForecastInfo = (Map) jceInputStream.read((JceInputStream) cache_mapForecastInfo, 17, false);
        if (cache_mapAlarminfo == null) {
            cache_mapAlarminfo = new HashMap();
            cache_mapAlarminfo.put("", new AlarmInfo());
        }
        this.mapAlarminfo = (Map) jceInputStream.read((JceInputStream) cache_mapAlarminfo, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        jceOutputStream.write(this.iCityCode, 1);
        jceOutputStream.write(this.strCityName, 2);
        jceOutputStream.write(this.strDate, 3);
        jceOutputStream.write(this.iHour, 4);
        jceOutputStream.write(this.iWeather, 5);
        jceOutputStream.write(this.iWind, 6);
        jceOutputStream.write(this.iTempCurr, 7);
        jceOutputStream.write(this.iTempMax, 8);
        jceOutputStream.write(this.iTempMin, 9);
        jceOutputStream.write(this.iHumidity, 10);
        String str = this.strSunriseTime;
        if (str != null) {
            jceOutputStream.write(str, 11);
        }
        String str2 = this.strSunsetTime;
        if (str2 != null) {
            jceOutputStream.write(str2, 12);
        }
        String str3 = this.strPressure;
        if (str3 != null) {
            jceOutputStream.write(str3, 13);
        }
        jceOutputStream.write(this.iWindForce, 14);
        String str4 = this.strDeviceName;
        if (str4 != null) {
            jceOutputStream.write(str4, 15);
        }
        jceOutputStream.write(this.iPM2p5, 16);
        Map<Short, ForecastInfo> map = this.mapForecastInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 17);
        }
        Map<String, AlarmInfo> map2 = this.mapAlarminfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 18);
        }
    }

    public stWeatherInfo(int i3, int i16, String str, String str2, int i17, int i18, int i19, int i26, int i27, int i28, int i29, String str3, String str4, String str5, int i36, String str6, int i37, Map<Short, ForecastInfo> map, Map<String, AlarmInfo> map2) {
        this.iRet = i3;
        this.iCityCode = i16;
        this.strCityName = str;
        this.strDate = str2;
        this.iHour = i17;
        this.iWeather = i18;
        this.iWind = i19;
        this.iTempCurr = i26;
        this.iTempMax = i27;
        this.iTempMin = i28;
        this.iHumidity = i29;
        this.strSunriseTime = str3;
        this.strSunsetTime = str4;
        this.strPressure = str5;
        this.iWindForce = i36;
        this.strDeviceName = str6;
        this.iPM2p5 = i37;
        this.mapForecastInfo = map;
        this.mapAlarminfo = map2;
    }
}
