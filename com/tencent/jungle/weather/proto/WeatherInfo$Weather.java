package com.tencent.jungle.weather.proto;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherInfo$Weather extends MessageMicro<WeatherInfo$Weather> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 80, 90, 96, 106, 114, 122, 130, 138, 146}, new String[]{"weather_info", "air_info", "forecast_list", "forecast", "hourinfo_list", "warning_list", "city", GdtGetUserInfoHandler.KEY_AREA, "adcode", "area_id", "en_name", "update_time", "tips_list", "lifeindex_list", "lifeindex_forecast_list", "weekly_summary", "moon", "night_care"}, new Object[]{null, null, null, null, null, null, "", "", 0, 0, "", 0, null, null, null, null, "", null}, WeatherInfo$Weather.class);
    public WeatherReportStore$WeatherInfo weather_info = new WeatherReportStore$WeatherInfo();
    public WeatherReportStore$AirInfo air_info = new WeatherReportStore$AirInfo();
    public WeatherReportStore$WeatherForecastList forecast_list = new WeatherReportStore$WeatherForecastList();
    public WeatherReportStore$WeatherForecast forecast = new WeatherReportStore$WeatherForecast();
    public WeatherReportStore$WeatherHourInfoList hourinfo_list = new WeatherReportStore$WeatherHourInfoList();
    public WeatherReportStore$WeatherWarningList warning_list = new WeatherReportStore$WeatherWarningList();
    public final PBStringField city = PBField.initString("");
    public final PBStringField area = PBField.initString("");
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBStringField en_name = PBField.initString("");
    public final PBUInt32Field update_time = PBField.initUInt32(0);
    public WeatherReportStore$TipsList tips_list = new WeatherReportStore$TipsList();
    public WeatherReportStore$LifeIndexList lifeindex_list = new WeatherReportStore$LifeIndexList();
    public final PBRepeatMessageField<WeatherReportStore$LifeIndexList> lifeindex_forecast_list = PBField.initRepeatMessage(WeatherReportStore$LifeIndexList.class);
    public WeatherReportStore$WeeklySummary weekly_summary = new WeatherReportStore$WeeklySummary();
    public final PBStringField moon = PBField.initString("");
    public WeatherInfo$NightCare night_care = new WeatherInfo$NightCare();
}
