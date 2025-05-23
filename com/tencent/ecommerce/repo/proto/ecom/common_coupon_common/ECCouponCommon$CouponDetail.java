package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponDetail extends MessageMicro<ECCouponCommon$CouponDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 80, 122, 162, 242, 322}, new String[]{"coupon_batch_id", "coupon_batch_name", "coupon_type", "issuer", "coupon_status", "coupon_discount_type", "coupon_discount_rule", "coupon_time_rule", "coupon_issue_rule", "coupon_use_info"}, new Object[]{"", "", 0, null, 0, 0, null, null, null, null}, ECCouponCommon$CouponDetail.class);
    public final PBStringField coupon_batch_id = PBField.initString("");
    public final PBStringField coupon_batch_name = PBField.initString("");
    public final PBEnumField coupon_type = PBField.initEnum(0);
    public ECCouponCommon$Issuer issuer = new ECCouponCommon$Issuer();
    public final PBEnumField coupon_status = PBField.initEnum(0);
    public final PBEnumField coupon_discount_type = PBField.initEnum(0);
    public ECCouponCommon$DiscountRule coupon_discount_rule = new ECCouponCommon$DiscountRule();
    public ECCouponCommon$UseTimeRule coupon_time_rule = new ECCouponCommon$UseTimeRule();
    public ECCouponCommon$IssueRule coupon_issue_rule = new ECCouponCommon$IssueRule();
    public ECCouponCommon$CouponUseInfo coupon_use_info = new MessageMicro<ECCouponCommon$CouponUseInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$CouponUseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"used", "have"}, new Object[]{0, 0}, ECCouponCommon$CouponUseInfo.class);
        public final PBInt32Field used = PBField.initInt32(0);
        public final PBInt32Field have = PBField.initInt32(0);
    };
}
