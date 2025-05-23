package com.tencent.trpcprotocol.kuolie.message_list.message_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class message_list$UpdateMsgListReq extends MessageMicro<message_list$UpdateMsgListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_list"}, new Object[]{null}, message_list$UpdateMsgListReq.class);
    public final PBRepeatMessageField<message_list$ConversationModel> msg_list = PBField.initRepeatMessage(message_list$ConversationModel.class);
}
