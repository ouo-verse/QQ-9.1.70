package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$DeleteInterMsgReq extends MessageMicro<InteractiveMsgServicePB$DeleteInterMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_ids"}, new Object[]{""}, InteractiveMsgServicePB$DeleteInterMsgReq.class);
    public final PBRepeatField<String> msg_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
