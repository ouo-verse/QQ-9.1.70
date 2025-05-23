package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECOrderCommon$Promo extends MessageMicro<ECOrderCommon$Promo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"promo_type", "promo_price", "msg", "activity_id"}, new Object[]{0, 0L, "", ""}, ECOrderCommon$Promo.class);
    public final PBUInt32Field promo_type = PBField.initUInt32(0);
    public final PBInt64Field promo_price = PBField.initInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f105235msg = PBField.initString("");
    public final PBStringField activity_id = PBField.initString("");
}
