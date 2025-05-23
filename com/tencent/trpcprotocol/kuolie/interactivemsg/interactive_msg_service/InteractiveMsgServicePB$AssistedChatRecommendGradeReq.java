package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$AssistedChatRecommendGradeReq extends MessageMicro<InteractiveMsgServicePB$AssistedChatRecommendGradeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"scene", "peer_tiny_id", "result", "dialogs"}, new Object[]{0, 0L, 0, null}, InteractiveMsgServicePB$AssistedChatRecommendGradeReq.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBUInt64Field peer_tiny_id = PBField.initUInt64(0);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBRepeatMessageField<InteractiveMsgServicePB$AssistedChatDialog> dialogs = PBField.initRepeatMessage(InteractiveMsgServicePB$AssistedChatDialog.class);
}
