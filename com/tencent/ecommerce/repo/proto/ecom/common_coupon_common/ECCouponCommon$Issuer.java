package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$Issuer extends MessageMicro<ECCouponCommon$Issuer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "id", "name"}, new Object[]{0, "", ""}, ECCouponCommon$Issuer.class);
    public final PBEnumField type = PBField.initEnum(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105226id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
}
