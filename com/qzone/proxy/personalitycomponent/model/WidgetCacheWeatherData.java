package com.qzone.proxy.personalitycomponent.model;

import LBS_V2_PROTOCOL.ForecastInfo;
import LBS_V2_PROTOCOL.WeatherInfo_V2;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.personalitycomponent.model.WidgetWeatherData;
import com.qzone.util.l;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetCacheWeatherData extends a {
    public static final String BGURL = "bgurl";
    public static final String CACHETIME = "CacheTime";
    public static final String CITYCODE = "CityCode";
    public static final String CITYNAME = "CityName";
    public static final String DATE = "date";
    public static final String DAYTIME = "daytime";
    public static final IDBCacheDataWrapper.a<WidgetCacheWeatherData> DB_CREATOR = new IDBCacheDataWrapper.a<WidgetCacheWeatherData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return "CityCode desc";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(WidgetCacheWeatherData.CITYCODE, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.CITYNAME, "TEXT"), new IDBCacheDataWrapper.c("date", "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.HOUR, "INTEGER"), new IDBCacheDataWrapper.c("weather", "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.WIND, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.TEMPCURR, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.TEMPMIN, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.TEMPMAX, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.HUMIDITY, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.SUNRISETIME, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.SUNSETTIME, "TEXT"), new IDBCacheDataWrapper.c("pressure", "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.WINDFORCE, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.DEVICENAME, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.WINDDESC, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.PM2P5, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.DAYTIME, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.CACHETIME, "LONG"), new IDBCacheDataWrapper.c("updatetime", "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.BGURL, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.SERVERUPDATETIME, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.LATITUDE, WidgetCacheWeatherData.TYPE_LATITUDE), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.LONGTITUDE, WidgetCacheWeatherData.TYPE_LONGTITUDE), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.GPSTYPE, WidgetCacheWeatherData.TYPE_GPSTYPE), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.SHOOTTIME, WidgetCacheWeatherData.TYPE_SHOOTTIME), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.WIDGET_FLAG, WidgetCacheWeatherData.TYPE_WIDGETFLAG), new IDBCacheDataWrapper.c(WidgetCacheWeatherData.FORCAST, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 5;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public WidgetCacheWeatherData createFromCursor(Cursor cursor) {
            WidgetCacheWeatherData widgetCacheWeatherData = new WidgetCacheWeatherData();
            widgetCacheWeatherData.iCityCode = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.CITYCODE));
            widgetCacheWeatherData.strCityName = cursor.getString(cursor.getColumnIndex(WidgetCacheWeatherData.CITYNAME));
            widgetCacheWeatherData.strDate = cursor.getString(cursor.getColumnIndex("date"));
            widgetCacheWeatherData.iHour = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.HOUR));
            widgetCacheWeatherData.iWeather = cursor.getInt(cursor.getColumnIndex("weather"));
            widgetCacheWeatherData.iWind = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.WIND));
            widgetCacheWeatherData.iTempCurr = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.TEMPCURR));
            widgetCacheWeatherData.iTempMax = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.TEMPMAX));
            widgetCacheWeatherData.iTempMin = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.TEMPMIN));
            widgetCacheWeatherData.iHumidity = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.HUMIDITY));
            widgetCacheWeatherData.strSunriseTime = cursor.getString(cursor.getColumnIndex(WidgetCacheWeatherData.SUNRISETIME));
            widgetCacheWeatherData.strSunsetTime = cursor.getString(cursor.getColumnIndex(WidgetCacheWeatherData.SUNSETTIME));
            widgetCacheWeatherData.strPressure = cursor.getString(cursor.getColumnIndex("pressure"));
            widgetCacheWeatherData.iWindForce = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.WINDFORCE));
            widgetCacheWeatherData.strDeviceName = cursor.getString(cursor.getColumnIndex(WidgetCacheWeatherData.DEVICENAME));
            widgetCacheWeatherData.strWindDesc = cursor.getString(cursor.getColumnIndex(WidgetCacheWeatherData.WINDDESC));
            widgetCacheWeatherData.iPM2p5 = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.PM2P5));
            widgetCacheWeatherData.iDayTime = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.DAYTIME));
            widgetCacheWeatherData.iCacheTime = cursor.getLong(cursor.getColumnIndex(WidgetCacheWeatherData.CACHETIME));
            widgetCacheWeatherData.iUpdateTime = cursor.getInt(cursor.getColumnIndex("updatetime"));
            widgetCacheWeatherData.bgUrl = cursor.getString(cursor.getColumnIndex(WidgetCacheWeatherData.BGURL));
            widgetCacheWeatherData.serverUpdateTime = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.SERVERUPDATETIME));
            widgetCacheWeatherData.latitude = cursor.getFloat(cursor.getColumnIndex(WidgetCacheWeatherData.LATITUDE));
            widgetCacheWeatherData.longtitude = cursor.getFloat(cursor.getColumnIndex(WidgetCacheWeatherData.LONGTITUDE));
            widgetCacheWeatherData.gpstype = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.GPSTYPE));
            widgetCacheWeatherData.shootTime = cursor.getLong(cursor.getColumnIndex(WidgetCacheWeatherData.SHOOTTIME));
            widgetCacheWeatherData.widgetFlag = cursor.getInt(cursor.getColumnIndex(WidgetCacheWeatherData.WIDGET_FLAG));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(WidgetCacheWeatherData.FORCAST));
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                widgetCacheWeatherData.forcastList = ParcelableWrapper.createArrayListFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
            return widgetCacheWeatherData;
        }
    };
    public static final String DEVICENAME = "devicename";
    public static final String FORCAST = "forcast";
    public static String GPSTYPE = "gpsType";
    public static final String HOUR = "hour";
    public static final String HUMIDITY = "humidity";
    public static String LATITUDE = "latitude";
    public static String LONGTITUDE = "longtitude";
    public static final String PM2P5 = "pm2p5";
    public static final String PRESSURE = "pressure";
    public static final String SERVERUPDATETIME = "serverupdatetime";
    public static String SHOOTTIME = "shootTime";
    public static final String SUNRISETIME = "sunrisetime";
    public static final String SUNSETTIME = "sunsettime";
    public static final String TEMPCURR = "tempcurr";
    public static final String TEMPMAX = "tempmax";
    public static final String TEMPMIN = "tempmin";
    public static final String TYPE_BGURL = "TEXT";
    public static final String TYPE_CACHETIME = "LONG";
    public static final String TYPE_CITYCODE = "INTEGER";
    public static final String TYPE_CITYNAME = "TEXT";
    public static final String TYPE_DATE = "TEXT";
    public static final String TYPE_DAYTIME = "INTEGER";
    public static final String TYPE_DEVICENAME = "TEXT";
    public static final String TYPE_FORCAST = "BLOB";
    public static String TYPE_GPSTYPE = "INTEGER";
    public static final String TYPE_HOUR = "INTEGER";
    public static final String TYPE_HUMIDITY = "INTEGER";
    public static String TYPE_LATITUDE = "FLOAT";
    public static String TYPE_LONGTITUDE = "FLOAT";
    public static final String TYPE_PM2P5 = "INTEGER";
    public static final String TYPE_PRESSURE = "TEXT";
    public static final String TYPE_SERVERUPDATETIME = "INTEGER";
    public static String TYPE_SHOOTTIME = "LONG";
    public static final String TYPE_SUNRISETIME = "TEXT";
    public static final String TYPE_SUNSETTIME = "TEXT";
    public static final String TYPE_TEMPCURR = "INTEGER";
    public static final String TYPE_TEMPMAX = "INTEGER";
    public static final String TYPE_TEMPMIN = "INTEGER";
    public static final String TYPE_UPDATETIME = "INTEGER";
    public static final String TYPE_WEATHER = "INTEGER";
    public static String TYPE_WIDGETFLAG = "INTEGER";
    public static final String TYPE_WIND = "INTEGER";
    public static final String TYPE_WINDDESC = "TEXT";
    public static final String TYPE_WINDFORCE = "INTEGER";
    public static final String UPDATETIME = "updatetime";
    public static final int VERSION = 5;
    public static final String WEATHER = "weather";
    public static String WIDGET_FLAG = "widgetFlag";
    public static final String WIND = "wind";
    public static final String WINDDESC = "winddesc";
    public static final String WINDFORCE = "windforce";
    public int gpstype;
    public float latitude;
    public float longtitude;
    public long shootTime;
    public int widgetFlag;
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
    public String bgUrl = "";
    public int serverUpdateTime = 0;
    public ArrayList<WidgetWeatherData.Forcast> forcastList = new ArrayList<>();
    public int iUpdateTime = 0;

    private static String c(int i3, int i16) {
        String str = "";
        switch (i3) {
            case 1:
                str = "" + l.a(R.string.f172929vm1);
                break;
            case 2:
                str = "" + l.a(R.string.f172930vm2);
                break;
            case 3:
                str = "" + l.a(R.string.vlx);
                break;
            case 4:
                str = "" + l.a(R.string.vlz);
                break;
            case 5:
                str = "" + l.a(R.string.vly);
                break;
            case 6:
                str = "" + l.a(R.string.f172928vm0);
                break;
            case 7:
                str = "" + l.a(R.string.vlv);
                break;
            case 8:
                str = "" + l.a(R.string.vlt);
                break;
            case 9:
                str = "" + l.a(R.string.vlu);
                break;
        }
        if (i3 == 0 || i16 <= 0) {
            return str;
        }
        return str + i16 + l.a(R.string.vlw);
    }

    public static WidgetCacheWeatherData createFromBusinessData(WidgetWeatherData widgetWeatherData) {
        if (widgetWeatherData == null) {
            return null;
        }
        WidgetCacheWeatherData widgetCacheWeatherData = new WidgetCacheWeatherData();
        widgetCacheWeatherData.iCityCode = widgetWeatherData.iCityCode;
        widgetCacheWeatherData.strCityName = widgetWeatherData.strCityName;
        widgetCacheWeatherData.strDate = widgetWeatherData.strDate;
        widgetCacheWeatherData.iHour = widgetWeatherData.iHour;
        widgetCacheWeatherData.iWeather = widgetWeatherData.iWeather;
        widgetCacheWeatherData.iWind = widgetWeatherData.iWind;
        widgetCacheWeatherData.iTempCurr = widgetWeatherData.iTempCurr;
        widgetCacheWeatherData.iTempMax = widgetWeatherData.iTempMax;
        widgetCacheWeatherData.iTempMin = widgetWeatherData.iTempMin;
        widgetCacheWeatherData.iHumidity = widgetWeatherData.iHumidity;
        widgetCacheWeatherData.strSunriseTime = widgetWeatherData.strSunriseTime;
        widgetCacheWeatherData.strSunsetTime = widgetWeatherData.strSunsetTime;
        widgetCacheWeatherData.strPressure = widgetWeatherData.strPressure;
        widgetCacheWeatherData.iWindForce = widgetWeatherData.iWindForce;
        widgetCacheWeatherData.strDeviceName = widgetWeatherData.strDeviceName;
        widgetCacheWeatherData.strWindDesc = widgetWeatherData.strWindDesc;
        widgetCacheWeatherData.iPM2p5 = widgetWeatherData.iPM2p5;
        widgetCacheWeatherData.iDayTime = widgetWeatherData.iDayTime;
        widgetCacheWeatherData.iCacheTime = widgetWeatherData.iCacheTime;
        widgetCacheWeatherData.iUpdateTime = widgetWeatherData.iUpdateTime;
        widgetCacheWeatherData.bgUrl = widgetWeatherData.bgUrl;
        widgetCacheWeatherData.serverUpdateTime = widgetWeatherData.serverUpdateTime;
        widgetCacheWeatherData.widgetFlag = 0;
        ArrayList<WidgetWeatherData.Forcast> arrayList = widgetWeatherData.forcastList;
        if (arrayList != null) {
            widgetCacheWeatherData.forcastList.addAll(arrayList);
        }
        return widgetCacheWeatherData;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(CITYCODE, Integer.valueOf(this.iCityCode));
        contentValues.put(CITYNAME, this.strCityName);
        contentValues.put("date", this.strDate);
        contentValues.put(HOUR, Integer.valueOf(this.iHour));
        contentValues.put("weather", Integer.valueOf(this.iWeather));
        contentValues.put(WIND, Integer.valueOf(this.iWind));
        contentValues.put(TEMPCURR, Integer.valueOf(this.iTempCurr));
        contentValues.put(TEMPMIN, Integer.valueOf(this.iTempMin));
        contentValues.put(TEMPMAX, Integer.valueOf(this.iTempMax));
        contentValues.put(HUMIDITY, Integer.valueOf(this.iHumidity));
        contentValues.put(SUNRISETIME, this.strSunriseTime);
        contentValues.put(SUNSETTIME, this.strSunsetTime);
        contentValues.put("pressure", this.strPressure);
        contentValues.put(WINDFORCE, Integer.valueOf(this.iWindForce));
        contentValues.put(DEVICENAME, this.strDeviceName);
        contentValues.put(WINDDESC, this.strWindDesc);
        contentValues.put(PM2P5, Integer.valueOf(this.iPM2p5));
        contentValues.put(DAYTIME, Integer.valueOf(this.iDayTime));
        contentValues.put(CACHETIME, Long.valueOf(this.iCacheTime));
        contentValues.put("updatetime", Integer.valueOf(this.iUpdateTime));
        contentValues.put(BGURL, this.bgUrl);
        contentValues.put(SERVERUPDATETIME, Integer.valueOf(this.serverUpdateTime));
        contentValues.put(LATITUDE, Float.valueOf(this.latitude));
        contentValues.put(LONGTITUDE, Float.valueOf(this.longtitude));
        contentValues.put(GPSTYPE, Integer.valueOf(this.gpstype));
        contentValues.put(SHOOTTIME, Long.valueOf(this.shootTime));
        contentValues.put(WIDGET_FLAG, Integer.valueOf(this.widgetFlag));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeArrayListToParcel(obtain, 0, this.forcastList);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(FORCAST, marshall);
    }

    public static WidgetWeatherData convertToBusinessData(WidgetCacheWeatherData widgetCacheWeatherData) {
        if (widgetCacheWeatherData == null) {
            return null;
        }
        WidgetWeatherData widgetWeatherData = new WidgetWeatherData();
        widgetWeatherData.iCityCode = widgetCacheWeatherData.iCityCode;
        widgetWeatherData.strCityName = widgetCacheWeatherData.strCityName;
        widgetWeatherData.strDate = widgetCacheWeatherData.strDate;
        widgetWeatherData.iHour = widgetCacheWeatherData.iHour;
        widgetWeatherData.iWeather = widgetCacheWeatherData.iWeather;
        widgetWeatherData.iWind = widgetCacheWeatherData.iWind;
        widgetWeatherData.iTempCurr = widgetCacheWeatherData.iTempCurr;
        widgetWeatherData.iTempMax = widgetCacheWeatherData.iTempMax;
        widgetWeatherData.iTempMin = widgetCacheWeatherData.iTempMin;
        widgetWeatherData.iHumidity = widgetCacheWeatherData.iHumidity;
        widgetWeatherData.strSunriseTime = widgetCacheWeatherData.strSunriseTime;
        widgetWeatherData.strSunsetTime = widgetCacheWeatherData.strSunsetTime;
        widgetWeatherData.strPressure = widgetCacheWeatherData.strPressure;
        widgetWeatherData.iWindForce = widgetCacheWeatherData.iWindForce;
        widgetWeatherData.strDeviceName = widgetCacheWeatherData.strDeviceName;
        widgetWeatherData.strWindDesc = widgetCacheWeatherData.strWindDesc;
        widgetWeatherData.iPM2p5 = widgetCacheWeatherData.iPM2p5;
        widgetWeatherData.iDayTime = widgetCacheWeatherData.iDayTime;
        widgetWeatherData.iCacheTime = widgetCacheWeatherData.iCacheTime;
        widgetWeatherData.iUpdateTime = widgetCacheWeatherData.iUpdateTime;
        widgetWeatherData.bgUrl = widgetCacheWeatherData.bgUrl;
        widgetWeatherData.serverUpdateTime = widgetCacheWeatherData.serverUpdateTime;
        ArrayList<WidgetWeatherData.Forcast> arrayList = widgetCacheWeatherData.forcastList;
        if (arrayList != null) {
            widgetWeatherData.forcastList.addAll(arrayList);
        }
        return widgetWeatherData;
    }

    public static WidgetWeatherData createFromResponse(WeatherInfo_V2 weatherInfo_V2) {
        if (weatherInfo_V2 == null) {
            return null;
        }
        WidgetWeatherData widgetWeatherData = new WidgetWeatherData();
        widgetWeatherData.iCityCode = weatherInfo_V2.iCityCode;
        widgetWeatherData.strCityName = weatherInfo_V2.strCityName;
        widgetWeatherData.strDate = weatherInfo_V2.strDate;
        widgetWeatherData.iHour = weatherInfo_V2.iHour;
        widgetWeatherData.iWeather = weatherInfo_V2.iWeather;
        int i3 = weatherInfo_V2.iWind;
        widgetWeatherData.iWind = i3;
        widgetWeatherData.iTempCurr = weatherInfo_V2.iTempCurr;
        widgetWeatherData.iTempMax = weatherInfo_V2.iTempMax;
        widgetWeatherData.iTempMin = weatherInfo_V2.iTempMin;
        widgetWeatherData.iHumidity = weatherInfo_V2.iHumidity;
        widgetWeatherData.strSunriseTime = weatherInfo_V2.strSunriseTime;
        widgetWeatherData.strSunsetTime = weatherInfo_V2.strSunsetTime;
        widgetWeatherData.strPressure = weatherInfo_V2.strPressure;
        int i16 = weatherInfo_V2.iWindForce;
        widgetWeatherData.iWindForce = i16;
        widgetWeatherData.strDeviceName = weatherInfo_V2.strDeviceName;
        widgetWeatherData.strWindDesc = c(i3, i16);
        widgetWeatherData.iPM2p5 = weatherInfo_V2.iPM2p5;
        widgetWeatherData.iDayTime = weatherInfo_V2.iDayTime;
        widgetWeatherData.iCacheTime = weatherInfo_V2.iCacheTime;
        widgetWeatherData.bgUrl = weatherInfo_V2.strUrl;
        widgetWeatherData.serverUpdateTime = weatherInfo_V2.iTimeUpdate;
        widgetWeatherData.iUpdateTime = (int) (System.currentTimeMillis() / 1000);
        ArrayList<ForecastInfo> arrayList = weatherInfo_V2.vecForecastInfo;
        if (arrayList != null) {
            Iterator<ForecastInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ForecastInfo next = it.next();
                WidgetWeatherData.Forcast forcast = new WidgetWeatherData.Forcast();
                forcast.iTimestamp = next.iTimestamp;
                forcast.iDayWeather = next.iDayWeather;
                forcast.iNightWeather = next.iNightWeather;
                forcast.iTempMax = next.iTempMax;
                forcast.iTempMin = next.iTempMin;
                forcast.strDayWeather = next.strDayWeather;
                widgetWeatherData.forcastList.add(forcast);
            }
        }
        return widgetWeatherData;
    }

    public static WidgetCacheWeatherData createFrom(GpsInfo4LocalImage gpsInfo4LocalImage, long j3) {
        if (gpsInfo4LocalImage == null || j3 <= 0) {
            return null;
        }
        WidgetCacheWeatherData widgetCacheWeatherData = new WidgetCacheWeatherData();
        widgetCacheWeatherData.widgetFlag = 0;
        widgetCacheWeatherData.latitude = gpsInfo4LocalImage.latitude;
        widgetCacheWeatherData.longtitude = gpsInfo4LocalImage.longtitude;
        widgetCacheWeatherData.shootTime = j3;
        widgetCacheWeatherData.gpstype = gpsInfo4LocalImage.gpsType;
        return widgetCacheWeatherData;
    }

    public static WidgetCacheWeatherData createFromBusinessData(WidgetWeatherData widgetWeatherData, GpsInfo4LocalImage gpsInfo4LocalImage, long j3) {
        if (widgetWeatherData == null || gpsInfo4LocalImage == null || j3 <= 0) {
            return null;
        }
        WidgetCacheWeatherData widgetCacheWeatherData = new WidgetCacheWeatherData();
        widgetCacheWeatherData.iCityCode = widgetWeatherData.iCityCode;
        widgetCacheWeatherData.strCityName = widgetWeatherData.strCityName;
        widgetCacheWeatherData.strDate = widgetWeatherData.strDate;
        widgetCacheWeatherData.iHour = widgetWeatherData.iHour;
        widgetCacheWeatherData.iWeather = widgetWeatherData.iWeather;
        widgetCacheWeatherData.iWind = widgetWeatherData.iWind;
        widgetCacheWeatherData.iTempCurr = widgetWeatherData.iTempCurr;
        widgetCacheWeatherData.iTempMax = widgetWeatherData.iTempMax;
        widgetCacheWeatherData.iTempMin = widgetWeatherData.iTempMin;
        widgetCacheWeatherData.iHumidity = widgetWeatherData.iHumidity;
        widgetCacheWeatherData.strSunriseTime = widgetWeatherData.strSunriseTime;
        widgetCacheWeatherData.strSunsetTime = widgetWeatherData.strSunsetTime;
        widgetCacheWeatherData.strPressure = widgetWeatherData.strPressure;
        widgetCacheWeatherData.iWindForce = widgetWeatherData.iWindForce;
        widgetCacheWeatherData.strDeviceName = widgetWeatherData.strDeviceName;
        widgetCacheWeatherData.strWindDesc = widgetWeatherData.strWindDesc;
        widgetCacheWeatherData.iPM2p5 = widgetWeatherData.iPM2p5;
        widgetCacheWeatherData.iDayTime = widgetWeatherData.iDayTime;
        widgetCacheWeatherData.iCacheTime = widgetWeatherData.iCacheTime;
        widgetCacheWeatherData.iUpdateTime = widgetWeatherData.iUpdateTime;
        widgetCacheWeatherData.bgUrl = widgetWeatherData.bgUrl;
        widgetCacheWeatherData.serverUpdateTime = widgetWeatherData.serverUpdateTime;
        widgetCacheWeatherData.widgetFlag = 1;
        widgetCacheWeatherData.latitude = gpsInfo4LocalImage.latitude;
        widgetCacheWeatherData.longtitude = gpsInfo4LocalImage.longtitude;
        widgetCacheWeatherData.gpstype = gpsInfo4LocalImage.gpsType;
        widgetCacheWeatherData.shootTime = j3;
        ArrayList<WidgetWeatherData.Forcast> arrayList = widgetWeatherData.forcastList;
        if (arrayList != null) {
            widgetCacheWeatherData.forcastList.addAll(arrayList);
        }
        return widgetCacheWeatherData;
    }
}
