package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class Festival$FestivalDate extends MessageMicro<Festival$FestivalDate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50}, new String[]{"type", "name", "date", "summary", "pic", "icon"}, new Object[]{0, "", 0L, "", 0, ""}, Festival$FestivalDate.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field date = PBField.initUInt64(0);
    public final PBStringField summary = PBField.initString("");
    public final PBEnumField pic = PBField.initEnum(0);
    public final PBStringField icon = PBField.initString("");
}
