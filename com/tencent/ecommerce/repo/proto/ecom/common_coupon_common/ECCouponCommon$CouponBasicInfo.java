package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponBasicInfo extends MessageMicro<ECCouponCommon$CouponBasicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26, 42, 50, 58}, new String[]{"issuer", "target", "discount_rule", "use_time_rule"}, new Object[]{null, null, null, null}, ECCouponCommon$CouponBasicInfo.class);
    public ECCouponCommon$Issuer issuer = new ECCouponCommon$Issuer();
    public ECCouponCommon$ApplicableTarget target = new MessageMicro<ECCouponCommon$ApplicableTarget>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$ApplicableTarget
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82}, new String[]{"coupon_type", "target"}, new Object[]{0, null}, ECCouponCommon$ApplicableTarget.class);
        public final PBEnumField coupon_type = PBField.initEnum(0);
        public final PBRepeatMessageField<ECCouponCommon$Target> target = PBField.initRepeatMessage(ECCouponCommon$Target.class);
    };
    public ECCouponCommon$DiscountRule discount_rule = new ECCouponCommon$DiscountRule();
    public ECCouponCommon$UseTimeRule use_time_rule = new ECCouponCommon$UseTimeRule();
}
