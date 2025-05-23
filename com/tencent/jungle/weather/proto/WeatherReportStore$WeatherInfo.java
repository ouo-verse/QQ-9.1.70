package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$WeatherInfo extends MessageMicro<WeatherReportStore$WeatherInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74, 80, 88, 98, 106}, new String[]{"temper", "air_humidity", "wind_power", "wind_direct", "weather", "pubtime", "updatetime", "weather_type", "weather_type_id", "type_id_new", "concrete_type", "sunrise", "sunset"}, new Object[]{"", "", "", "", "", "", 0L, "", "", 1, 1, "", ""}, WeatherReportStore$WeatherInfo.class);
    public final PBStringField temper = PBField.initString("");
    public final PBStringField air_humidity = PBField.initString("");
    public final PBStringField wind_power = PBField.initString("");
    public final PBStringField wind_direct = PBField.initString("");
    public final PBStringField weather = PBField.initString("");
    public final PBStringField pubtime = PBField.initString("");
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
    public final PBStringField weather_type = PBField.initString("");
    public final PBStringField weather_type_id = PBField.initString("");
    public final PBEnumField type_id_new = PBField.initEnum(1);
    public final PBEnumField concrete_type = PBField.initEnum(1);
    public final PBStringField sunrise = PBField.initString("");
    public final PBStringField sunset = PBField.initString("");
}
