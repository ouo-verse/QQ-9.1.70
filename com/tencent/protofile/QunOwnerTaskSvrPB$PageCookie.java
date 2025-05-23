package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$PageCookie extends MessageMicro<QunOwnerTaskSvrPB$PageCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"index", "size"}, new Object[]{0, 0}, QunOwnerTaskSvrPB$PageCookie.class);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(0);
}
