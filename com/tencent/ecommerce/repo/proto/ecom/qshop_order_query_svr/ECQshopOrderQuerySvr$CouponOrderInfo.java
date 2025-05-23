package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$CouponShowInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$CouponOrderInfo extends MessageMicro<ECQshopOrderQuerySvr$CouponOrderInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public ECCouponCommon$CouponShowInfo coupon_show_info = new ECCouponCommon$CouponShowInfo();
    public final PBStringField coupon_id = PBField.initString("");
    public final PBBoolField is_in_best_options = PBField.initBool(false);
    public final PBBoolField is_user_select = PBField.initBool(false);
    public final PBBoolField can_use = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 160, 168, 184}, new String[]{"coupon_show_info", "coupon_id", "is_in_best_options", "is_user_select", "can_use"}, new Object[]{null, "", bool, bool, bool}, ECQshopOrderQuerySvr$CouponOrderInfo.class);
    }
}
