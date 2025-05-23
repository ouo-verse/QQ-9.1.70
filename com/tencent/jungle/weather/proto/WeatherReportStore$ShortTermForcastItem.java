package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$ShortTermForcastItem extends MessageMicro<WeatherReportStore$ShortTermForcastItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29}, new String[]{"timestamp", "type", "rainfull"}, new Object[]{0L, 1, Float.valueOf(0.0f)}, WeatherReportStore$ShortTermForcastItem.class);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBFloatField rainfull = PBField.initFloat(0.0f);
}
