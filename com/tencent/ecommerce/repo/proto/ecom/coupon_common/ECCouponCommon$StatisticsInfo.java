package com.tencent.ecommerce.repo.proto.ecom.coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$StatisticsInfo extends MessageMicro<ECCouponCommon$StatisticsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"already_gen_quantify", "already_rev_quantify", "already_use_quantify"}, new Object[]{0, 0, 0}, ECCouponCommon$StatisticsInfo.class);
    public final PBInt32Field already_gen_quantify = PBField.initInt32(0);
    public final PBInt32Field already_rev_quantify = PBField.initInt32(0);
    public final PBInt32Field already_use_quantify = PBField.initInt32(0);
}
