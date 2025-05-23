package com.tencent.jungle.weather;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$WeatherForecast extends MessageMicro<WeatherReportInfo$WeatherForecast> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96}, new String[]{"day_weather", "night_weather", "day_temper", "night_temper", "day_wind_direct", "night_wind_direct", "day_wind_power", "night_wind_power", "sunrise_time", "sunset_time", "pubtime", "day"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", 0}, WeatherReportInfo$WeatherForecast.class);
    public final PBStringField day_weather = PBField.initString("");
    public final PBStringField night_weather = PBField.initString("");
    public final PBStringField day_temper = PBField.initString("");
    public final PBStringField night_temper = PBField.initString("");
    public final PBStringField day_wind_direct = PBField.initString("");
    public final PBStringField night_wind_direct = PBField.initString("");
    public final PBStringField day_wind_power = PBField.initString("");
    public final PBStringField night_wind_power = PBField.initString("");
    public final PBStringField sunrise_time = PBField.initString("");
    public final PBStringField sunset_time = PBField.initString("");
    public final PBStringField pubtime = PBField.initString("");
    public final PBUInt32Field day = PBField.initUInt32(0);
}
