package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_nearby_user_control$EnterNearbyUserContrlReq extends MessageMicro<ilive_nearby_user_control$EnterNearbyUserContrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"user_id", "user_type", "source"}, new Object[]{0L, 0, ""}, ilive_nearby_user_control$EnterNearbyUserContrlReq.class);
    public final PBUInt64Field user_id = PBField.initUInt64(0);
    public final PBUInt32Field user_type = PBField.initUInt32(0);
    public final PBStringField source = PBField.initString("");
}
