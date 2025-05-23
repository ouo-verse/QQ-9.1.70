package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes31.dex */
public final class ECCouponCommon$ProductCouponInfo extends MessageMicro<ECCouponCommon$ProductCouponInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, ECCouponCommon$ProductCouponInfo.class);
    public final PBRepeatMessageField<ECCouponCommon$ProductCouponItem> items = PBField.initRepeatMessage(ECCouponCommon$ProductCouponItem.class);
}
