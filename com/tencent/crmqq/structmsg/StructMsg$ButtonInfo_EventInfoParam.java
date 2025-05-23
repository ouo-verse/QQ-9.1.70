package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes5.dex */
public final class StructMsg$ButtonInfo_EventInfoParam extends MessageMicro<StructMsg$ButtonInfo_EventInfoParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, StructMsg$ButtonInfo_EventInfoParam.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
