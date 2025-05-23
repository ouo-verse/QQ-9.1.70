package com.tencent.trpcprotocol.kuolie.message_list.message_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class message_list$SetMsgListListenerStateReq extends MessageMicro<message_list$SetMsgListListenerStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"can_listener_msg_list_update"}, new Object[]{Boolean.FALSE}, message_list$SetMsgListListenerStateReq.class);
    public final PBBoolField can_listener_msg_list_update = PBField.initBool(false);
}
