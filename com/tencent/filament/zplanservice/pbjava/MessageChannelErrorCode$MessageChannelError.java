package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class MessageChannelErrorCode$MessageChannelError extends MessageMicro<MessageChannelErrorCode$MessageChannelError> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"domain", "code", "message"}, new Object[]{"", 0, ""}, MessageChannelErrorCode$MessageChannelError.class);
    public final PBStringField domain = PBField.initString("");
    public final PBUInt32Field code = PBField.initUInt32(0);
    public final PBStringField message = PBField.initString("");
}
