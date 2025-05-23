package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$GetTaskMsgRsp extends MessageMicro<QunOwnerTaskSvrPB$GetTaskMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"task_num", VasQQSettingMeImpl.EXPIRE_TIME, "latest_task_time", "jump_url", "total_task_num"}, new Object[]{0, 0, 0, "", 0}, QunOwnerTaskSvrPB$GetTaskMsgRsp.class);
    public final PBUInt32Field task_num = PBField.initUInt32(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field latest_task_time = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field total_task_num = PBField.initUInt32(0);
}
