package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$GetTaskGroupsReq extends MessageMicro<QunOwnerTaskSvrPB$GetTaskGroupsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"task_id", "cookie"}, new Object[]{"", ""}, QunOwnerTaskSvrPB$GetTaskGroupsReq.class);
    public final PBStringField task_id = PBField.initString("");
    public final PBStringField cookie = PBField.initString("");
}
