package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$WidgetDayForcast extends MessageMicro<weather$WidgetDayForcast> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"day_temper", "night_temper", "day_weather_icon"}, new Object[]{"", "", ""}, weather$WidgetDayForcast.class);
    public final PBStringField day_temper = PBField.initString("");
    public final PBStringField night_temper = PBField.initString("");
    public final PBStringField day_weather_icon = PBField.initString("");
}
