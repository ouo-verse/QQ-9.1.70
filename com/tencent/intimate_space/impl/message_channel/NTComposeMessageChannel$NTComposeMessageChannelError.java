package com.tencent.intimate_space.impl.message_channel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class NTComposeMessageChannel$NTComposeMessageChannelError extends MessageMicro<NTComposeMessageChannel$NTComposeMessageChannelError> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"domain", "code", "message"}, new Object[]{"", 0, ""}, NTComposeMessageChannel$NTComposeMessageChannelError.class);
    public final PBStringField domain = PBField.initString("");
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
}
