package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$ConfigGroupInfo extends MessageMicro<mobileqq_mp$ConfigGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"config_info"}, new Object[]{null}, mobileqq_mp$ConfigGroupInfo.class);
    public final PBRepeatMessageField<mobileqq_mp$ConfigInfo> config_info = PBField.initRepeatMessage(mobileqq_mp$ConfigInfo.class);
}
