package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes15.dex */
public final class mobileqq_mp$ButtonInfo_EventInfoParam extends MessageMicro<mobileqq_mp$ButtonInfo_EventInfoParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, mobileqq_mp$ButtonInfo_EventInfoParam.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
