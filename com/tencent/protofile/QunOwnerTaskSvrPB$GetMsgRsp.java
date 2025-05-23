package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes22.dex */
public final class QunOwnerTaskSvrPB$GetMsgRsp extends MessageMicro<QunOwnerTaskSvrPB$GetMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"group_id", "task_msg", "common_msgs", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{0L, null, null, 0}, QunOwnerTaskSvrPB$GetMsgRsp.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public QunOwnerTaskSvrPB$TaskMsg task_msg = new QunOwnerTaskSvrPB$TaskMsg();
    public final PBRepeatMessageField<QunOwnerTaskSvrPB$CommonMsg> common_msgs = PBField.initRepeatMessage(QunOwnerTaskSvrPB$CommonMsg.class);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
}
