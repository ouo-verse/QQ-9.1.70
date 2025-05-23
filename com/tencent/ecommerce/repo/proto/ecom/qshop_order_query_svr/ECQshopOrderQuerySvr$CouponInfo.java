package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$CouponInfo extends MessageMicro<ECQshopOrderQuerySvr$CouponInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<ECQshopOrderQuerySvr$CouponOrderInfo> coupon_order_info = PBField.initRepeatMessage(ECQshopOrderQuerySvr$CouponOrderInfo.class);
    public final PBBoolField is_best_discount = PBField.initBool(false);
    public final PBInt64Field discount_price = PBField.initInt64(0);
    public final PBInt32Field can_use_coupon_num = PBField.initInt32(0);
    public final PBBoolField is_price_below_zero = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 80, 160, 240, 320}, new String[]{"coupon_order_info", "is_best_discount", "discount_price", "can_use_coupon_num", "is_price_below_zero"}, new Object[]{null, bool, 0L, 0, bool}, ECQshopOrderQuerySvr$CouponInfo.class);
    }
}
