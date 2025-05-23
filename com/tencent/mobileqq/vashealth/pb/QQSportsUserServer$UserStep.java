package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class QQSportsUserServer$UserStep extends MessageMicro<QQSportsUserServer$UserStep> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "step"}, new Object[]{0L, 0}, QQSportsUserServer$UserStep.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field step = PBField.initUInt32(0);
}
