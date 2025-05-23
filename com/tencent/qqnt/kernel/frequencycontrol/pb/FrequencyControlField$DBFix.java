package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FrequencyControlField$DBFix extends MessageMicro<FrequencyControlField$DBFix> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1776808, 1776816, 1776824, 1776832, 1776842}, new String[]{"event", "db_size", "progress", "status", "db_path"}, new Object[]{222201, 0L, 0, 222301, ""}, FrequencyControlField$DBFix.class);
    public final PBEnumField event = PBField.initEnum(222201);
    public final PBUInt64Field db_size = PBField.initUInt64(0);
    public final PBUInt32Field progress = PBField.initUInt32(0);
    public final PBEnumField status = PBField.initEnum(222301);
    public final PBStringField db_path = PBField.initString("");
}
