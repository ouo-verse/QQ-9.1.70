package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponFlowBase extends MessageMicro<ECCouponCommon$CouponFlowBase> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82}, new String[]{"coupon_batch_id", "coupon_ids", "token"}, new Object[]{"", "", ""}, ECCouponCommon$CouponFlowBase.class);
    public final PBStringField coupon_batch_id = PBField.initString("");
    public final PBRepeatField<String> coupon_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField token = PBField.initString("");
}
