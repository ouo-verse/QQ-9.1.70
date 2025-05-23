package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$CombineWeather extends MessageMicro<WeatherReportStore$CombineWeather> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74, 82}, new String[]{"weather_info", "air_info", "forecast_list", "hourinfo_list", "warning_list", "tips_list", "update_time", "lifeindex_list", "lifeindex_forecast_list", "weekly_summary"}, new Object[]{null, null, null, null, null, null, 0, null, null, null}, WeatherReportStore$CombineWeather.class);
    public WeatherReportStore$WeatherInfo weather_info = new WeatherReportStore$WeatherInfo();
    public WeatherReportStore$AirInfo air_info = new WeatherReportStore$AirInfo();
    public WeatherReportStore$WeatherForecastList forecast_list = new WeatherReportStore$WeatherForecastList();
    public WeatherReportStore$WeatherHourInfoList hourinfo_list = new WeatherReportStore$WeatherHourInfoList();
    public WeatherReportStore$WeatherWarningList warning_list = new WeatherReportStore$WeatherWarningList();
    public WeatherReportStore$TipsList tips_list = new WeatherReportStore$TipsList();
    public final PBUInt32Field update_time = PBField.initUInt32(0);
    public WeatherReportStore$LifeIndexList lifeindex_list = new WeatherReportStore$LifeIndexList();
    public final PBRepeatMessageField<WeatherReportStore$LifeIndexList> lifeindex_forecast_list = PBField.initRepeatMessage(WeatherReportStore$LifeIndexList.class);
    public WeatherReportStore$WeeklySummary weekly_summary = new WeatherReportStore$WeeklySummary();
}
