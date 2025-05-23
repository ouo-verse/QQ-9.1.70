package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$WeatherHourInfo extends MessageMicro<WeatherReportInfo$WeatherHourInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"temper", "air_humidity", "wind_power", "wind_direct", "weather", "d_hour"}, new Object[]{"", "", "", "", "", ""}, WeatherReportInfo$WeatherHourInfo.class);
    public final PBStringField temper = PBField.initString("");
    public final PBStringField air_humidity = PBField.initString("");
    public final PBStringField wind_power = PBField.initString("");
    public final PBStringField wind_direct = PBField.initString("");
    public final PBStringField weather = PBField.initString("");
    public final PBStringField d_hour = PBField.initString("");
}
