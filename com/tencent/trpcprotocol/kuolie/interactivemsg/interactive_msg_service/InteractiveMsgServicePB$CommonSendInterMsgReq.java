package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$CommonSendInterMsgReq extends MessageMicro<InteractiveMsgServicePB$CommonSendInterMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"peer_tiny_id", "scene_id"}, new Object[]{0L, 0}, InteractiveMsgServicePB$CommonSendInterMsgReq.class);
    public final PBUInt64Field peer_tiny_id = PBField.initUInt64(0);
    public final PBEnumField scene_id = PBField.initEnum(0);
}
