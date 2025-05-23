package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$GetInterMsgListReq extends MessageMicro<InteractiveMsgServicePB$GetInterMsgListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"end_time", "max_size"}, new Object[]{0L, 0}, InteractiveMsgServicePB$GetInterMsgListReq.class);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
    public final PBUInt32Field max_size = PBField.initUInt32(0);
}
