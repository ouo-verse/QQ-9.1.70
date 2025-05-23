package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$VerifyWpaUinAndKeyRsp extends MessageMicro<mobileqq_qidian$VerifyWpaUinAndKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"int32_result", "uint32_is_valid", "str_welcome_word"}, new Object[]{0, 0, ""}, mobileqq_qidian$VerifyWpaUinAndKeyRsp.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt32Field uint32_is_valid = PBField.initUInt32(0);
    public final PBStringField str_welcome_word = PBField.initString("");
}
