package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$ShipperCompany;
import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$TraceItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$Logistics extends MessageMicro<ECSampleData$Logistics> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"logistics_code", "shipper_company", "trace_item", "ship_time"}, new Object[]{"", null, null, 0L}, ECSampleData$Logistics.class);
    public final PBStringField logistics_code = PBField.initString("");
    public ECLogisticsCommon$ShipperCompany shipper_company = new ECLogisticsCommon$ShipperCompany();
    public ECLogisticsCommon$TraceItem trace_item = new ECLogisticsCommon$TraceItem();
    public final PBInt64Field ship_time = PBField.initInt64(0);
}
