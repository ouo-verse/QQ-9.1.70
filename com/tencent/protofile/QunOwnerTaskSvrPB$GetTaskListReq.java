package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$GetTaskListReq extends MessageMicro<QunOwnerTaskSvrPB$GetTaskListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"group_id", "task_status", "cookie"}, new Object[]{0L, 0, ""}, QunOwnerTaskSvrPB$GetTaskListReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field task_status = PBField.initUInt32(0);
    public final PBStringField cookie = PBField.initString("");
}
