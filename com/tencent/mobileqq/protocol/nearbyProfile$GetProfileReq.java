package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes35.dex */
public final class nearbyProfile$GetProfileReq extends MessageMicro<nearbyProfile$GetProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"fields"}, new Object[]{""}, nearbyProfile$GetProfileReq.class);
    public final PBRepeatField<String> fields = PBField.initRepeat(PBStringField.__repeatHelper__);
}
