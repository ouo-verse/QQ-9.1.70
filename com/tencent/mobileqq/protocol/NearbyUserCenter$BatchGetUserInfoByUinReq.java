package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$BatchGetUserInfoByUinReq extends MessageMicro<NearbyUserCenter$BatchGetUserInfoByUinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"app_code", "uin_list", "fields", "is_fetch_all"}, new Object[]{0, 0L, 0, Boolean.FALSE}, NearbyUserCenter$BatchGetUserInfoByUinReq.class);
    public final PBUInt32Field app_code = PBField.initUInt32(0);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Integer> fields = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBBoolField is_fetch_all = PBField.initBool(false);
}
