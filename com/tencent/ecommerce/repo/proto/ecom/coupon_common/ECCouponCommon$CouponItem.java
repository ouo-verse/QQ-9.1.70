package com.tencent.ecommerce.repo.proto.ecom.coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponItem extends MessageMicro<ECCouponCommon$CouponItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"basic_info", "privilege"}, new Object[]{null, null}, ECCouponCommon$CouponItem.class);
    public ECCouponCommon$CouponBasicInfo basic_info = new MessageMicro<ECCouponCommon$CouponBasicInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.coupon_common.ECCouponCommon$CouponBasicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58}, new String[]{"coupon_bacth_id", "coupon_id", "coupon_name", "coupon_comment", "get_time", "status", "order_ids"}, new Object[]{"", "", "", "", 0L, 0, ""}, ECCouponCommon$CouponBasicInfo.class);
        public final PBStringField coupon_bacth_id = PBField.initString("");
        public final PBStringField coupon_id = PBField.initString("");
        public final PBStringField coupon_name = PBField.initString("");
        public final PBStringField coupon_comment = PBField.initString("");
        public final PBInt64Field get_time = PBField.initInt64(0);
        public final PBEnumField status = PBField.initEnum(0);
        public final PBRepeatField<String> order_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public ECCouponCommon$CouponPrivilege privilege = new ECCouponCommon$CouponPrivilege();
}
