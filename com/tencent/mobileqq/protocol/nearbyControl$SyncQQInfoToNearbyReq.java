package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$SyncQQInfoToNearbyReq extends MessageMicro<nearbyControl$SyncQQInfoToNearbyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"key", "uin"}, new Object[]{"", 0L}, nearbyControl$SyncQQInfoToNearbyReq.class);
    public final PBStringField key = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
