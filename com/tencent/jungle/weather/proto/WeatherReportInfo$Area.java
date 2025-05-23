package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportInfo$Area extends MessageMicro<WeatherReportInfo$Area> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"area_id", "area_name", "en_name", "city", "province", "country"}, new Object[]{0, "", "", "", "", ""}, WeatherReportInfo$Area.class);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBStringField area_name = PBField.initString("");
    public final PBStringField en_name = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField country = PBField.initString("");
}
