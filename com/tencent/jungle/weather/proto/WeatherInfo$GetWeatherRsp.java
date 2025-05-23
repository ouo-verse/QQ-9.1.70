package com.tencent.jungle.weather.proto;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherInfo$GetWeatherRsp extends MessageMicro<WeatherInfo$GetWeatherRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58}, new String[]{"weathers", "almanac", "astro", "all_astro", QCircleSchemeAttr.Detail.CURRENT_TIME, "user_weekly_astro", "weekly_astro"}, new Object[]{null, "", null, null, 0, null, null}, WeatherInfo$GetWeatherRsp.class);
    public WeatherInfo$Weather weathers = new WeatherInfo$Weather();
    public final PBStringField almanac = PBField.initString("");
    public WeatherReportStore$DailyAstroFortune astro = new WeatherReportStore$DailyAstroFortune();
    public final PBRepeatMessageField<WeatherReportStore$DailyAstroFortune> all_astro = PBField.initRepeatMessage(WeatherReportStore$DailyAstroFortune.class);
    public final PBUInt32Field current_time = PBField.initUInt32(0);
    public WeatherReportStore$WeeklyAstroFortune user_weekly_astro = new WeatherReportStore$WeeklyAstroFortune();
    public final PBRepeatMessageField<WeatherReportStore$WeeklyAstroFortune> weekly_astro = PBField.initRepeatMessage(WeatherReportStore$WeeklyAstroFortune.class);
}
