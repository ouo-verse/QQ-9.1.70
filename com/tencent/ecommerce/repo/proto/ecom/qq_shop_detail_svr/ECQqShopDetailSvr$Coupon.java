package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$Coupon extends MessageMicro<ECQqShopDetailSvr$Coupon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"id", "type", "name", "desc"}, new Object[]{"", "", "", ""}, ECQqShopDetailSvr$Coupon.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105243id = PBField.initString("");
    public final PBStringField type = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
