package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$GetUnReadMsgCntRsp extends MessageMicro<InteractiveMsgServicePB$GetUnReadMsgCntRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rsp_head", "unread_msg_cnt"}, new Object[]{null, 0}, InteractiveMsgServicePB$GetUnReadMsgCntRsp.class);
    public InteractiveMsgServicePB$RspHead rsp_head = new InteractiveMsgServicePB$RspHead();
    public final PBUInt32Field unread_msg_cnt = PBField.initUInt32(0);
}
