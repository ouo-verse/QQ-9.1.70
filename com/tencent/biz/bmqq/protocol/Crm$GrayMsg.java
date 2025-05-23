package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Crm$GrayMsg extends MessageMicro<Crm$GrayMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "str_text", "uint64_from_uin"}, new Object[]{0, "", 0L}, Crm$GrayMsg.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
}
