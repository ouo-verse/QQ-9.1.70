package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$Alarm extends MessageMicro<WeatherReportInfo$Alarm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"icon", "name", "color", "level"}, new Object[]{"", "", "", 2}, WeatherReportInfo$Alarm.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBEnumField level = PBField.initEnum(2);
}
