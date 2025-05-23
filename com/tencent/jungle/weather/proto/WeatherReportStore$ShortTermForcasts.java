package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WeatherReportStore$ShortTermForcasts extends MessageMicro<WeatherReportStore$ShortTermForcasts> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, WeatherReportStore$ShortTermForcasts.class);
    public final PBRepeatMessageField<WeatherReportStore$ShortTermForcastItem> items = PBField.initRepeatMessage(WeatherReportStore$ShortTermForcastItem.class);
}
