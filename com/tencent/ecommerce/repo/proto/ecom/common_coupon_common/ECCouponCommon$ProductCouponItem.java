package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECCouponCommon$ProductCouponItem extends MessageMicro<ECCouponCommon$ProductCouponItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"coupon_batch_id", PM.BASE}, new Object[]{"", null}, ECCouponCommon$ProductCouponItem.class);
    public final PBStringField coupon_batch_id = PBField.initString("");
    public ECCouponCommon$CouponBasicInfo base = new ECCouponCommon$CouponBasicInfo();
}
