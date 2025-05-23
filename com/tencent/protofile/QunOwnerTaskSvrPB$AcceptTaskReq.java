package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$AcceptTaskReq extends MessageMicro<QunOwnerTaskSvrPB$AcceptTaskReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"task_id", "group_id"}, new Object[]{"", 0L}, QunOwnerTaskSvrPB$AcceptTaskReq.class);
    public final PBStringField task_id = PBField.initString("");
    public final PBUInt64Field group_id = PBField.initUInt64(0);
}
