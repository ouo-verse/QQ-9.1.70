package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$WeatherForecastList extends MessageMicro<WeatherReportInfo$WeatherForecastList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24}, new String[]{"weatherForecast", "updatetime"}, new Object[]{null, 0L}, WeatherReportInfo$WeatherForecastList.class);
    public final PBRepeatMessageField<WeatherReportInfo$WeatherForecast> weatherForecast = PBField.initRepeatMessage(WeatherReportInfo$WeatherForecast.class);
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
}
