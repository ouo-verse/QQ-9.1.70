package com.tencent.ecommerce.repo.proto.ecom.shop_sales_center;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECShopSalesCenter$SalesCenterRsp extends MessageMicro<ECShopSalesCenter$SalesCenterRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"turnover", NotificationCompat.CATEGORY_NAVIGATION, "window", "hok_window"}, new Object[]{null, null, null, null}, ECShopSalesCenter$SalesCenterRsp.class);
    public ECShopSalesCenter$TodayTurnover turnover = new ECShopSalesCenter$TodayTurnover();
    public ECShopSalesCenter$SelectionCenter navigation = new ECShopSalesCenter$SelectionCenter();
    public ECShopSalesCenter$ShowWindow window = new ECShopSalesCenter$ShowWindow();
    public ECShopSalesCenter$ShowWindow hok_window = new ECShopSalesCenter$ShowWindow();
}
