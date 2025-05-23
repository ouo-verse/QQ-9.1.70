package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$OpLog extends MessageMicro<ECCouponCommon$OpLog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82, 160, 242}, new String[]{"coupon_batch_id", "coupon_batch_name", "op_content", "op_time", "op_user"}, new Object[]{"", "", "", 0L, ""}, ECCouponCommon$OpLog.class);
    public final PBStringField coupon_batch_id = PBField.initString("");
    public final PBStringField coupon_batch_name = PBField.initString("");
    public final PBStringField op_content = PBField.initString("");
    public final PBInt64Field op_time = PBField.initInt64(0);
    public final PBStringField op_user = PBField.initString("");
}
