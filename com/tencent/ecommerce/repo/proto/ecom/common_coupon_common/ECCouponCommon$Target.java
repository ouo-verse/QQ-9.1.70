package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$Target extends MessageMicro<ECCouponCommon$Target> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"id_type", "id", "id_name"}, new Object[]{0, "", ""}, ECCouponCommon$Target.class);
    public final PBEnumField id_type = PBField.initEnum(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105227id = PBField.initString("");
    public final PBStringField id_name = PBField.initString("");
}
