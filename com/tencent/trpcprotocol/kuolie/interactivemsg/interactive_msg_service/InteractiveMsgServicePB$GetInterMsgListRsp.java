package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$GetInterMsgListRsp extends MessageMicro<InteractiveMsgServicePB$GetInterMsgListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"rsp_head", "msg_meta_info", "flag_end", "next_end_time"}, new Object[]{null, null, 0, 0L}, InteractiveMsgServicePB$GetInterMsgListRsp.class);
    public InteractiveMsgServicePB$RspHead rsp_head = new InteractiveMsgServicePB$RspHead();
    public final PBRepeatMessageField<InteractiveMsgServicePB$MsgMetaInfo> msg_meta_info = PBField.initRepeatMessage(InteractiveMsgServicePB$MsgMetaInfo.class);
    public final PBUInt32Field flag_end = PBField.initUInt32(0);
    public final PBUInt64Field next_end_time = PBField.initUInt64(0);
}
