package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$SsoGetUserInfoRsp extends MessageMicro<NearbyUserCenter$SsoGetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"user_info", "code", "msg"}, new Object[]{null, 0, ""}, NearbyUserCenter$SsoGetUserInfoRsp.class);
    public NearbyUserCenter$UserInfo user_info = new NearbyUserCenter$UserInfo();
    public final PBUInt32Field code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f261126msg = PBField.initString("");
}
