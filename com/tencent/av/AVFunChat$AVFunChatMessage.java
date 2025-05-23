package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AVFunChat$AVFunChatMessage extends MessageMicro<AVFunChat$AVFunChatMessage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"enum_operator", "uint64_type", "str_msg"}, new Object[]{0, 0L, ""}, AVFunChat$AVFunChatMessage.class);
    public final PBEnumField enum_operator = PBField.initEnum(0);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0);
    public final PBStringField str_msg = PBField.initString("");
}
