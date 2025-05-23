package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$GetTaskMsgReq extends MessageMicro<QunOwnerTaskSvrPB$GetTaskMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_id"}, new Object[]{0L}, QunOwnerTaskSvrPB$GetTaskMsgReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
}
