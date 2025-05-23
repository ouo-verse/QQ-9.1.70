package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeatherForecastList extends MessageMicro<WeatherReportStore$WeatherForecastList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24, 34, 42}, new String[]{"weatherForecast", "updatetime", "tomorrowPrompt", "weeklyPrompt"}, new Object[]{null, 0L, "", ""}, WeatherReportStore$WeatherForecastList.class);
    public final PBRepeatMessageField<WeatherReportStore$WeatherForecast> weatherForecast = PBField.initRepeatMessage(WeatherReportStore$WeatherForecast.class);
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
    public final PBStringField tomorrowPrompt = PBField.initString("");
    public final PBStringField weeklyPrompt = PBField.initString("");
}
