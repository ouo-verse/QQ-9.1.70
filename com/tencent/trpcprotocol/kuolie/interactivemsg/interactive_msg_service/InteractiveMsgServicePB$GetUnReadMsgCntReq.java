package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$GetUnReadMsgCntReq extends MessageMicro<InteractiveMsgServicePB$GetUnReadMsgCntReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_id"}, new Object[]{""}, InteractiveMsgServicePB$GetUnReadMsgCntReq.class);
    public final PBStringField open_id = PBField.initString("");
}
