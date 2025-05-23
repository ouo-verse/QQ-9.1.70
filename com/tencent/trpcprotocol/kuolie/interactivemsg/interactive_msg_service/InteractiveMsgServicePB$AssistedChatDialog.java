package com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class InteractiveMsgServicePB$AssistedChatDialog extends MessageMicro<InteractiveMsgServicePB$AssistedChatDialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"from", "context"}, new Object[]{0, null}, InteractiveMsgServicePB$AssistedChatDialog.class);
    public final PBEnumField from = PBField.initEnum(0);
    public InteractiveMsgServicePB$AssistedChatRecommend context = new MessageMicro<InteractiveMsgServicePB$AssistedChatRecommend>() { // from class: com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$AssistedChatRecommend
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "content", "recom_trace"}, new Object[]{"", "", ""}, InteractiveMsgServicePB$AssistedChatRecommend.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f381581id = PBField.initString("");
        public final PBStringField content = PBField.initString("");
        public final PBStringField recom_trace = PBField.initString("");
    };
}
