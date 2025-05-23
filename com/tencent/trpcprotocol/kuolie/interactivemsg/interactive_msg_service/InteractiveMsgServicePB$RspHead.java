package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$RspHead extends MessageMicro<InteractiveMsgServicePB$RspHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0, ""}, InteractiveMsgServicePB$RspHead.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
}
