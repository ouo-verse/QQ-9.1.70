package com.qzone.proxy.personalitycomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetWeatherData {
    public static final int _CLOUDY_V2 = 1;
    public static final int _DEFAULT_V2 = -1;
    public static final int _EAST_NORTH_V2 = 1;
    public static final int _EAST_SOUTH_V2 = 3;
    public static final int _EAST_V2 = 2;
    public static final int _FOG_V2 = 5;
    public static final int _NORTH_V2 = 8;
    public static final int _NO_WIND_V2 = 0;
    public static final int _OVERCAST_V2 = 2;
    public static final int _RAINANDSNOW_V2 = 6;
    public static final int _RAINY_V2 = 3;
    public static final int _SAND_V2 = 8;
    public static final int _SNOW_V2 = 4;
    public static final int _SOUTH_V2 = 4;
    public static final int _SUNSHINE_V2 = 0;
    public static final int _THUNDERSHOWER_V2 = 7;
    public static final int _UNCERTAINTY_V2 = 9;
    public static final int _WEST_NORTHv = 7;
    public static final int _WEST_SOUTH_V2 = 5;
    public static final int _WEST_V2 = 6;
    public static final int _WIND_V2 = 9;
    public int iCityCode = 0;
    public String strCityName = "";
    public String strDate = "";
    public int iHour = 0;
    public int iWeather = 0;
    public int iWind = 0;
    public int iTempCurr = 0;
    public int iTempMax = 0;
    public int iTempMin = 0;
    public int iHumidity = 0;
    public String strSunriseTime = "";
    public String strSunsetTime = "";
    public String strPressure = "";
    public int iWindForce = 0;
    public String strDeviceName = "";
    public String strWindDesc = "";
    public int iPM2p5 = 0;
    public int iDayTime = 0;
    public long iCacheTime = 0;
    public ArrayList<Forcast> forcastList = new ArrayList<>();
    public String bgUrl = "";
    public int serverUpdateTime = 0;
    public int iUpdateTime = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class Forcast implements SmartParcelable {

        @NeedParcel
        public int iDayWeather;

        @NeedParcel
        public int iNightWeather;

        @NeedParcel
        public int iTempMax;

        @NeedParcel
        public int iTempMin;

        @NeedParcel
        public int iTimestamp;

        @NeedParcel
        public String strDayWeather;
    }

    public String toString() {
        return " iCityCode = " + this.iCityCode + " strCityName = " + this.strCityName + " iTempCurr = " + this.iTempCurr + " iPM2p5 = " + this.iPM2p5;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WidgetWeatherData)) {
            return false;
        }
        WidgetWeatherData widgetWeatherData = (WidgetWeatherData) obj;
        return widgetWeatherData.iWeather == this.iWeather && widgetWeatherData.iTempCurr == this.iTempCurr && Utils.p(widgetWeatherData.strCityName, this.strCityName) && widgetWeatherData.iPM2p5 == this.iPM2p5;
    }
}
