package com.tencent.qqprotect.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class SafeReport$RspBody extends MessageMicro<SafeReport$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "string_errmsg"}, new Object[]{0, ""}, SafeReport$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBStringField string_errmsg = PBField.initString("");
}
