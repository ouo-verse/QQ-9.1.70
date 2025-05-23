package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$BatchGetUserInfoRsp extends MessageMicro<NearbyUserCenter$BatchGetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"user_info_list", "failed_list", "code", "msg"}, new Object[]{null, 0L, 0, ""}, NearbyUserCenter$BatchGetUserInfoRsp.class);
    public final PBRepeatMessageField<NearbyUserCenter$UserInfoMapping> user_info_list = PBField.initRepeatMessage(NearbyUserCenter$UserInfoMapping.class);
    public final PBRepeatField<Long> failed_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f261124msg = PBField.initString("");
}
