package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_nearby_user_control$EnterNearbyUserContrlRsp extends MessageMicro<ilive_nearby_user_control$EnterNearbyUserContrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"check_ret", "check_msg"}, new Object[]{0, ""}, ilive_nearby_user_control$EnterNearbyUserContrlRsp.class);
    public final PBUInt32Field check_ret = PBField.initUInt32(0);
    public final PBStringField check_msg = PBField.initString("");
}
