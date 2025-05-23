package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$DiscountRule extends MessageMicro<ECCouponCommon$DiscountRule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"type", "cash_discount", "full_reduction", "reduced_rate"}, new Object[]{0, null, null, null}, ECCouponCommon$DiscountRule.class);
    public final PBEnumField type = PBField.initEnum(0);
    public ECCouponCommon$ThresholdRule cash_discount = new MessageMicro<ECCouponCommon$ThresholdRule>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$ThresholdRule
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 80}, new String[]{"threshold", "discount"}, new Object[]{0, 0}, ECCouponCommon$ThresholdRule.class);
        public final PBInt32Field threshold = PBField.initInt32(0);
        public final PBInt32Field discount = PBField.initInt32(0);
    };
    public ECCouponCommon$ThresholdRule full_reduction = new MessageMicro<ECCouponCommon$ThresholdRule>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$ThresholdRule
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 80}, new String[]{"threshold", "discount"}, new Object[]{0, 0}, ECCouponCommon$ThresholdRule.class);
        public final PBInt32Field threshold = PBField.initInt32(0);
        public final PBInt32Field discount = PBField.initInt32(0);
    };
    public ECCouponCommon$ThresholdRule reduced_rate = new MessageMicro<ECCouponCommon$ThresholdRule>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$ThresholdRule
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 80}, new String[]{"threshold", "discount"}, new Object[]{0, 0}, ECCouponCommon$ThresholdRule.class);
        public final PBInt32Field threshold = PBField.initInt32(0);
        public final PBInt32Field discount = PBField.initInt32(0);
    };
}
