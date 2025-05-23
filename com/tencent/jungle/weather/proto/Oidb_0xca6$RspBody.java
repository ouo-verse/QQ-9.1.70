package com.tencent.jungle.weather.proto;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class Oidb_0xca6$RspBody extends MessageMicro<Oidb_0xca6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 122, 128, 138, 146, 152, 162, 170, 178, 186}, new String[]{"ret", "weather_info", "air_info", "forecast_list", "forecast", "hourinfo_list", "almanac", "warning_list", "astro", "city", GdtGetUserInfoHandler.KEY_AREA, "adcode", "area_id", "all_astro", "en_name", "update_time", "tips_list", "lifeindex_list", QCircleSchemeAttr.Detail.CURRENT_TIME, "lifeindex_forecast_list", "user_weekly_astro", "weekly_astro", "weekly_summary"}, new Object[]{0, null, null, null, null, null, "", null, null, "", "", 0, 0, null, "", 0, null, null, 0, null, null, null, null}, Oidb_0xca6$RspBody.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public WeatherReportStore$WeatherInfo weather_info = new WeatherReportStore$WeatherInfo();
    public WeatherReportStore$AirInfo air_info = new WeatherReportStore$AirInfo();
    public WeatherReportStore$WeatherForecastList forecast_list = new WeatherReportStore$WeatherForecastList();
    public WeatherReportStore$WeatherForecast forecast = new WeatherReportStore$WeatherForecast();
    public WeatherReportStore$WeatherHourInfoList hourinfo_list = new WeatherReportStore$WeatherHourInfoList();
    public final PBStringField almanac = PBField.initString("");
    public WeatherReportStore$WeatherWarningList warning_list = new WeatherReportStore$WeatherWarningList();
    public WeatherReportStore$DailyAstroFortune astro = new WeatherReportStore$DailyAstroFortune();
    public final PBStringField city = PBField.initString("");
    public final PBStringField area = PBField.initString("");
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<WeatherReportStore$DailyAstroFortune> all_astro = PBField.initRepeatMessage(WeatherReportStore$DailyAstroFortune.class);
    public final PBStringField en_name = PBField.initString("");
    public final PBUInt32Field update_time = PBField.initUInt32(0);
    public WeatherReportStore$TipsList tips_list = new WeatherReportStore$TipsList();
    public WeatherReportStore$LifeIndexList lifeindex_list = new WeatherReportStore$LifeIndexList();
    public final PBUInt32Field current_time = PBField.initUInt32(0);
    public final PBRepeatMessageField<WeatherReportStore$LifeIndexList> lifeindex_forecast_list = PBField.initRepeatMessage(WeatherReportStore$LifeIndexList.class);
    public WeatherReportStore$WeeklyAstroFortune user_weekly_astro = new WeatherReportStore$WeeklyAstroFortune();
    public final PBRepeatMessageField<WeatherReportStore$WeeklyAstroFortune> weekly_astro = PBField.initRepeatMessage(WeatherReportStore$WeeklyAstroFortune.class);
    public WeatherReportStore$WeeklySummary weekly_summary = new WeatherReportStore$WeeklySummary();
}
