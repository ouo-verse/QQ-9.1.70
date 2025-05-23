package com.tencent.ecommerce.repo.proto.ecom.common_logistics_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLogisticsCommon$TraceItem extends MessageMicro<ECLogisticsCommon$TraceItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"accept_time", "accept_station", "location", "remark", "status", "timestamp"}, new Object[]{"", "", "", "", null, 0L}, ECLogisticsCommon$TraceItem.class);
    public final PBStringField accept_time = PBField.initString("");
    public final PBStringField accept_station = PBField.initString("");
    public final PBStringField location = PBField.initString("");
    public final PBStringField remark = PBField.initString("");
    public ECLogisticsCommon$TraceStatus status = new ECLogisticsCommon$TraceStatus();
    public final PBInt64Field timestamp = PBField.initInt64(0);
}
