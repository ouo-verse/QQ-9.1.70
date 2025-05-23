package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$DeleteInterMsgRsp extends MessageMicro<InteractiveMsgServicePB$DeleteInterMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rsp_head", "msg_ids_del_failed"}, new Object[]{null, ""}, InteractiveMsgServicePB$DeleteInterMsgRsp.class);
    public InteractiveMsgServicePB$RspHead rsp_head = new InteractiveMsgServicePB$RspHead();
    public final PBRepeatField<String> msg_ids_del_failed = PBField.initRepeat(PBStringField.__repeatHelper__);
}
