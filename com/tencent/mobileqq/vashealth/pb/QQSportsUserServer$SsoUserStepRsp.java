package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class QQSportsUserServer$SsoUserStepRsp extends MessageMicro<QQSportsUserServer$SsoUserStepRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_steps"}, new Object[]{null}, QQSportsUserServer$SsoUserStepRsp.class);
    public final PBRepeatMessageField<QQSportsUserServer$UserStep> user_steps = PBField.initRepeatMessage(QQSportsUserServer$UserStep.class);
}
