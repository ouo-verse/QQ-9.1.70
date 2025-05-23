package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_trace_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTraceSvr$GetLogisticsInfoReq extends MessageMicro<ECQshopLogisticsTraceSvr$GetLogisticsInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"order_id", "logistics_code"}, new Object[]{"", ""}, ECQshopLogisticsTraceSvr$GetLogisticsInfoReq.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBStringField logistics_code = PBField.initString("");
}
