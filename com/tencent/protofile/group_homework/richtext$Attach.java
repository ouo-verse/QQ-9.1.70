package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class richtext$Attach extends MessageMicro<richtext$Attach> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"name", "url", "size", "busid"}, new Object[]{"", "", 0, 0}, richtext$Attach.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBUInt32Field busid = PBField.initUInt32(0);
}
