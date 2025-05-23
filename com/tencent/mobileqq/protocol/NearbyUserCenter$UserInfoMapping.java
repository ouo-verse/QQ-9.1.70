package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$UserInfoMapping extends MessageMicro<NearbyUserCenter$UserInfoMapping> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "user_info"}, new Object[]{0L, null}, NearbyUserCenter$UserInfoMapping.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f261128id = PBField.initUInt64(0);
    public NearbyUserCenter$UserInfo user_info = new NearbyUserCenter$UserInfo();
}
