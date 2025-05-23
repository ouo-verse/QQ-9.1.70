package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$GetUserInfoByUinReq extends MessageMicro<NearbyUserCenter$GetUserInfoByUinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 40}, new String[]{"fields", "uin", "is_fetch_all", "app_code"}, new Object[]{0, 0L, Boolean.FALSE, 0}, NearbyUserCenter$GetUserInfoByUinReq.class);
    public final PBRepeatField<Integer> fields = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBoolField is_fetch_all = PBField.initBool(false);
    public final PBUInt32Field app_code = PBField.initUInt32(0);
}
