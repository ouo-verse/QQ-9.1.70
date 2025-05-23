package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyRelation$SsoSetGreetOriginReq extends MessageMicro<NearbyRelation$SsoSetGreetOriginReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"to_tinyid", "origin_id"}, new Object[]{0L, 0}, NearbyRelation$SsoSetGreetOriginReq.class);
    public final PBUInt64Field to_tinyid = PBField.initUInt64(0);
    public final PBEnumField origin_id = PBField.initEnum(0);
}
