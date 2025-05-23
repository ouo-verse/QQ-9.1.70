package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes35.dex */
public final class nearbyProfile$GetMiniCardReq extends MessageMicro<nearbyProfile$GetMiniCardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"target_id"}, new Object[]{0L}, nearbyProfile$GetMiniCardReq.class);
    public final PBRepeatField<Long> target_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
