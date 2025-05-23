package com.tencent.ecommerce.repo.proto.ecom.shop_sales_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECShopSalesCenter$SelectionCenter extends MessageMicro<ECShopSalesCenter$SelectionCenter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"buttons"}, new Object[]{null}, ECShopSalesCenter$SelectionCenter.class);
    public final PBRepeatMessageField<ECShopSalesCenter$Icon> buttons = PBField.initRepeatMessage(ECShopSalesCenter$Icon.class);
}
