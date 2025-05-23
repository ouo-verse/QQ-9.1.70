package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$CalculateOrderPriceRsp extends MessageMicro<ECQshopOrderQuerySvr$CalculateOrderPriceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 58}, new String[]{"sku_buy_num_limit", "order_price", "sku_num", "ori_price", "discount", "coupon_info"}, new Object[]{null, 0L, 0, 0L, 0, null}, ECQshopOrderQuerySvr$CalculateOrderPriceRsp.class);
    public ECQshopOrderQuerySvr$SkuBuyNumLimit sku_buy_num_limit = new ECQshopOrderQuerySvr$SkuBuyNumLimit();
    public final PBUInt64Field order_price = PBField.initUInt64(0);
    public final PBUInt32Field sku_num = PBField.initUInt32(0);
    public final PBUInt64Field ori_price = PBField.initUInt64(0);
    public final PBUInt32Field discount = PBField.initUInt32(0);
    public ECQshopOrderQuerySvr$CouponInfo coupon_info = new ECQshopOrderQuerySvr$CouponInfo();
}
