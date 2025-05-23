package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$UsedCouponItem extends MessageMicro<ECOrderCommon$UsedCouponItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"coupon_batch_id", "coupon_id", "issuer", "batch_cnt"}, new Object[]{"", "", null, 0L}, ECOrderCommon$UsedCouponItem.class);
    public final PBStringField coupon_batch_id = PBField.initString("");
    public final PBRepeatField<String> coupon_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    public ECOrderCommon$Issuer issuer = new ECOrderCommon$Issuer();
    public final PBInt64Field batch_cnt = PBField.initInt64(0);
}
