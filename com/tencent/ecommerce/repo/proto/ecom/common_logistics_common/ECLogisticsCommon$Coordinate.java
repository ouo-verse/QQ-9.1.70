package com.tencent.ecommerce.repo.proto.ecom.common_logistics_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLogisticsCommon$Coordinate extends MessageMicro<ECLogisticsCommon$Coordinate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"lat_and_lng", "location"}, new Object[]{"", ""}, ECLogisticsCommon$Coordinate.class);
    public final PBStringField lat_and_lng = PBField.initString("");
    public final PBStringField location = PBField.initString("");
}
