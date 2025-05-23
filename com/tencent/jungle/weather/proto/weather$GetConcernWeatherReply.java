package com.tencent.jungle.weather.proto;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetConcernWeatherReply extends MessageMicro<weather$GetConcernWeatherReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 72, 82, 90, 98, 106, 112, 122, 130}, new String[]{"weather", QCircleSchemeAttr.Detail.CURRENT_TIME, "almanac", "astro", "all_astro", "user_weekly_astro", "weekly_astro", "dailyCards", "isActiveUser", "medicalArticle", "concernWeathers", "allConcernAreas", "nowcasting", "nowcastWeather", DownloadInfo.spKey_Config, "festivals"}, new Object[]{null, 0, "", null, null, null, null, null, Boolean.FALSE, null, null, null, "", 1, null, null}, weather$GetConcernWeatherReply.class);
    public WeatherInfo$Weather weather = new WeatherInfo$Weather();
    public final PBUInt32Field current_time = PBField.initUInt32(0);
    public final PBStringField almanac = PBField.initString("");
    public WeatherReportStore$DailyAstroFortune astro = new WeatherReportStore$DailyAstroFortune();
    public final PBRepeatMessageField<WeatherReportStore$DailyAstroFortune> all_astro = PBField.initRepeatMessage(WeatherReportStore$DailyAstroFortune.class);
    public WeatherReportStore$WeeklyAstroFortune user_weekly_astro = new WeatherReportStore$WeeklyAstroFortune();
    public final PBRepeatMessageField<WeatherReportStore$WeeklyAstroFortune> weekly_astro = PBField.initRepeatMessage(WeatherReportStore$WeeklyAstroFortune.class);
    public DayCard$DailyCards dailyCards = new DayCard$DailyCards();
    public final PBBoolField isActiveUser = PBField.initBool(false);
    public MedicalArticle$MedicalArticleDate medicalArticle = new MedicalArticle$MedicalArticleDate();
    public final PBRepeatMessageField<WeatherInfo$Weather> concernWeathers = PBField.initRepeatMessage(WeatherInfo$Weather.class);
    public final PBRepeatMessageField<weather$ConcernAreaInfo> allConcernAreas = PBField.initRepeatMessage(weather$ConcernAreaInfo.class);
    public final PBStringField nowcasting = PBField.initString("");
    public final PBEnumField nowcastWeather = PBField.initEnum(1);
    public weather$Config config = new weather$Config();
    public final PBRepeatMessageField<Festival$FestivalDate> festivals = PBField.initRepeatMessage(Festival$FestivalDate.class);
}
