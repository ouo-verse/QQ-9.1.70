package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$AtUserMsg extends MessageMicro<MessageOuterClass$AtUserMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"text", "user_list", "show_type"}, new Object[]{"", null, 0}, MessageOuterClass$AtUserMsg.class);
    public final PBStringField text = PBField.initString("");
    public final PBRepeatMessageField<MessageOuterClass$AtUser> user_list = PBField.initRepeatMessage(MessageOuterClass$AtUser.class);
    public final PBInt32Field show_type = PBField.initInt32(0);
}
