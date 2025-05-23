package com.tencent.ecommerce.repo.proto.ecom.shop_sales_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECShopSalesCenter$TodayTurnover extends MessageMicro<ECShopSalesCenter$TodayTurnover> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"gmv_order_cnt", "gmv_amt", "button"}, new Object[]{"", "", null}, ECShopSalesCenter$TodayTurnover.class);
    public final PBStringField gmv_order_cnt = PBField.initString("");
    public final PBStringField gmv_amt = PBField.initString("");
    public ECShopSalesCenter$Icon button = new ECShopSalesCenter$Icon();
}
