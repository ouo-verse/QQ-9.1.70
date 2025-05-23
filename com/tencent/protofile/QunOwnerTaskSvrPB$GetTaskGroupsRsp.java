package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$GetTaskGroupsRsp extends MessageMicro<QunOwnerTaskSvrPB$GetTaskGroupsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"groups", "cookie", "is_end"}, new Object[]{null, "", 0}, QunOwnerTaskSvrPB$GetTaskGroupsRsp.class);
    public final PBRepeatMessageField<QunOwnerTaskSvrPB$GroupInfo> groups = PBField.initRepeatMessage(QunOwnerTaskSvrPB$GroupInfo.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBUInt32Field is_end = PBField.initUInt32(0);
}
