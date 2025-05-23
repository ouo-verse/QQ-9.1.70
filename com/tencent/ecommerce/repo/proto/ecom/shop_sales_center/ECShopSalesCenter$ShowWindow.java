package com.tencent.ecommerce.repo.proto.ecom.shop_sales_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECShopSalesCenter$ShowWindow extends MessageMicro<ECShopSalesCenter$ShowWindow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"products", "count", "button"}, new Object[]{null, 0L, null}, ECShopSalesCenter$ShowWindow.class);
    public final PBRepeatMessageField<ECShopSalesCenter$Product> products = PBField.initRepeatMessage(ECShopSalesCenter$Product.class);
    public final PBInt64Field count = PBField.initInt64(0);
    public ECShopSalesCenter$Icon button = new ECShopSalesCenter$Icon();
}
