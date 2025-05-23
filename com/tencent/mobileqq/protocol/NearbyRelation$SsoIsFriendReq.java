package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyRelation$SsoIsFriendReq extends MessageMicro<NearbyRelation$SsoIsFriendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"to_tinyids"}, new Object[]{0L}, NearbyRelation$SsoIsFriendReq.class);
    public final PBRepeatField<Long> to_tinyids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
