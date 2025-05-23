package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyReport$SsoReportNearbyReq extends MessageMicro<nearbyReport$SsoReportNearbyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"tinyid", "channelID"}, new Object[]{0L, 0}, nearbyReport$SsoReportNearbyReq.class);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBUInt32Field channelID = PBField.initUInt32(0);
}
