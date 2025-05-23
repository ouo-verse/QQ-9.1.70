package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeatherForecast extends MessageMicro<WeatherReportStore$WeatherForecast> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130, 136, 144, 152, 160, 170, 178}, new String[]{"day_weather", "night_weather", "day_temper", "night_temper", "day_wind_direct", "night_wind_direct", "day_wind_power", "night_wind_power", "sunrise_time", "sunset_time", "pubtime", "day", "day_weather_type", "night_weather_type", "day_weather_type_id", "night_weather_type_id", "day_type_id_new", "day_concrete_type", "night_type_id_new", "night_concrete_type", "pm", "wind_power_desc"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", 0, "", "", "", "", 1, 1, 1, 1, "", ""}, WeatherReportStore$WeatherForecast.class);
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
    public final PBStringField day_weather_type = PBField.initString("");
    public final PBStringField night_weather_type = PBField.initString("");
    public final PBStringField day_weather_type_id = PBField.initString("");
    public final PBStringField night_weather_type_id = PBField.initString("");
    public final PBEnumField day_type_id_new = PBField.initEnum(1);
    public final PBEnumField day_concrete_type = PBField.initEnum(1);
    public final PBEnumField night_type_id_new = PBField.initEnum(1);
    public final PBEnumField night_concrete_type = PBField.initEnum(1);

    /* renamed from: pm, reason: collision with root package name */
    public final PBStringField f116940pm = PBField.initString("");
    public final PBStringField wind_power_desc = PBField.initString("");
}
