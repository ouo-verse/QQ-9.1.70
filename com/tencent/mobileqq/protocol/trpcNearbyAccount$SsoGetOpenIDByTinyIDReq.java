package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class trpcNearbyAccount$SsoGetOpenIDByTinyIDReq extends MessageMicro<trpcNearbyAccount$SsoGetOpenIDByTinyIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"tinyid", "source_id", "second_source_id", "third_source_id", "scene"}, new Object[]{0L, 0L, 0L, 0L, 0L}, trpcNearbyAccount$SsoGetOpenIDByTinyIDReq.class);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBUInt64Field source_id = PBField.initUInt64(0);
    public final PBUInt64Field second_source_id = PBField.initUInt64(0);
    public final PBUInt64Field third_source_id = PBField.initUInt64(0);
    public final PBUInt64Field scene = PBField.initUInt64(0);
}
