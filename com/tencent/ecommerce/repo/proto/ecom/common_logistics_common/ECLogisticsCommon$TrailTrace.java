package com.tencent.ecommerce.repo.proto.ecom.common_logistics_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLogisticsCommon$TrailTrace extends MessageMicro<ECLogisticsCommon$TrailTrace> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 74}, new String[]{"trace_items", "count", "trail_url", "pre_coordinates", "coordinates", "next_city", "receiver_city_lat_and_lng", "sender_city_lat_and_lng", "estimated_delivery_time"}, new Object[]{null, 0, "", null, null, "", "", "", ""}, ECLogisticsCommon$TrailTrace.class);
    public final PBRepeatMessageField<ECLogisticsCommon$TraceItem> trace_items = PBField.initRepeatMessage(ECLogisticsCommon$TraceItem.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField trail_url = PBField.initString("");
    public final PBRepeatMessageField<ECLogisticsCommon$Coordinate> pre_coordinates = PBField.initRepeatMessage(ECLogisticsCommon$Coordinate.class);
    public final PBRepeatMessageField<ECLogisticsCommon$Coordinate> coordinates = PBField.initRepeatMessage(ECLogisticsCommon$Coordinate.class);
    public final PBStringField next_city = PBField.initString("");
    public final PBStringField receiver_city_lat_and_lng = PBField.initString("");
    public final PBStringField sender_city_lat_and_lng = PBField.initString("");
    public final PBStringField estimated_delivery_time = PBField.initString("");
}
