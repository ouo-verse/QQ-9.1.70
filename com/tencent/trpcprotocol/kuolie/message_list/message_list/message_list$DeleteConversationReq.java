package com.tencent.trpcprotocol.kuolie.message_list.message_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class message_list$DeleteConversationReq extends MessageMicro<message_list$DeleteConversationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_ids"}, new Object[]{""}, message_list$DeleteConversationReq.class);
    public final PBRepeatField<String> open_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
