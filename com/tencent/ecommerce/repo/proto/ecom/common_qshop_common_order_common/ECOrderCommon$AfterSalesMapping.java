package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$AfterSalesMapping extends MessageMicro<ECOrderCommon$AfterSalesMapping> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"sku_id", "after_sales_id", "role_type", "after_sales_status", "judgement"}, new Object[]{"", "", 0, 0, Boolean.FALSE}, ECOrderCommon$AfterSalesMapping.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField after_sales_id = PBField.initString("");
    public final PBUInt32Field role_type = PBField.initUInt32(0);
    public final PBUInt32Field after_sales_status = PBField.initUInt32(0);
    public final PBBoolField judgement = PBField.initBool(false);
}
