package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeatherHourInfo extends MessageMicro<WeatherReportStore$WeatherHourInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 80}, new String[]{"temper", "air_humidity", "wind_power", "wind_direct", "weather", "d_hour", "weather_type", "weather_type_id", "type_id_new", "concrete_type"}, new Object[]{"", "", "", "", "", "", "", "", 1, 1}, WeatherReportStore$WeatherHourInfo.class);
    public final PBStringField temper = PBField.initString("");
    public final PBStringField air_humidity = PBField.initString("");
    public final PBStringField wind_power = PBField.initString("");
    public final PBStringField wind_direct = PBField.initString("");
    public final PBStringField weather = PBField.initString("");
    public final PBStringField d_hour = PBField.initString("");
    public final PBStringField weather_type = PBField.initString("");
    public final PBStringField weather_type_id = PBField.initString("");
    public final PBEnumField type_id_new = PBField.initEnum(1);
    public final PBEnumField concrete_type = PBField.initEnum(1);
}
