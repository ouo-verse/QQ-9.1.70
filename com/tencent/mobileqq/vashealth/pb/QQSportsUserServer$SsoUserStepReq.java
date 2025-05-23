package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class QQSportsUserServer$SsoUserStepReq extends MessageMicro<QQSportsUserServer$SsoUserStepReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uins"}, new Object[]{0L}, QQSportsUserServer$SsoUserStepReq.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
