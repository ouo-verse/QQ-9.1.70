package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$Attach extends MessageMicro<value$Attach> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"name", "url", "size", "bus_id"}, new Object[]{"", "", 0, 0}, value$Attach.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBUInt32Field bus_id = PBField.initUInt32(0);
}
