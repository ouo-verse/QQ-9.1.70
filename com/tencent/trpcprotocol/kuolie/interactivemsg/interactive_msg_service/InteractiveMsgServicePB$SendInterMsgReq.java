package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$SendInterMsgReq extends MessageMicro<InteractiveMsgServicePB$SendInterMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50}, new String[]{"peer_open_id", "feed_id", "scene_id", "inter_emoj_id", "msg_id", "msg_info"}, new Object[]{"", 0L, 0, 0, "", null}, InteractiveMsgServicePB$SendInterMsgReq.class);
    public final PBStringField peer_open_id = PBField.initString("");
    public final PBUInt64Field feed_id = PBField.initUInt64(0);
    public final PBEnumField scene_id = PBField.initEnum(0);
    public final PBUInt32Field inter_emoj_id = PBField.initUInt32(0);
    public final PBStringField msg_id = PBField.initString("");
    public InteractiveMsgServicePB$MsgInfo msg_info = new InteractiveMsgServicePB$MsgInfo();
}
