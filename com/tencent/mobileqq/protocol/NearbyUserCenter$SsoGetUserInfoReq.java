package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$SsoGetUserInfoReq extends MessageMicro<NearbyUserCenter$SsoGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 40}, new String[]{"fields", "is_fetch_all", "app_code"}, new Object[]{0, Boolean.FALSE, 0}, NearbyUserCenter$SsoGetUserInfoReq.class);
    public final PBRepeatField<Integer> fields = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBBoolField is_fetch_all = PBField.initBool(false);
    public final PBUInt32Field app_code = PBField.initUInt32(0);
}
