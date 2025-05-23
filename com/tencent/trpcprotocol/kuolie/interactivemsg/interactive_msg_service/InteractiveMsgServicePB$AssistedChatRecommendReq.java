package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$AssistedChatRecommendReq extends MessageMicro<InteractiveMsgServicePB$AssistedChatRecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48}, new String[]{"scene", "peer_tiny_id", "dialogs", "biz_type", "peer_uid", "req_count"}, new Object[]{0, 0L, null, 0, 0L, 0}, InteractiveMsgServicePB$AssistedChatRecommendReq.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt64Field peer_tiny_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<InteractiveMsgServicePB$AssistedChatDialog> dialogs = PBField.initRepeatMessage(InteractiveMsgServicePB$AssistedChatDialog.class);
    public final PBEnumField biz_type = PBField.initEnum(0);
    public final PBUInt64Field peer_uid = PBField.initUInt64(0);
    public final PBUInt32Field req_count = PBField.initUInt32(0);
}
