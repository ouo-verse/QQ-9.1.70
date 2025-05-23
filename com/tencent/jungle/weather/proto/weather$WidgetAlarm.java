package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$WidgetAlarm extends MessageMicro<weather$WidgetAlarm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"icon", "name", "level", "pubtime"}, new Object[]{"", "", 0, 0L}, weather$WidgetAlarm.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt64Field pubtime = PBField.initUInt64(0);
}
