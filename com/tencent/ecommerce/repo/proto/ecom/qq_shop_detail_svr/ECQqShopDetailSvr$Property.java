package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$Property extends MessageMicro<ECQqShopDetailSvr$Property> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "name", "value"}, new Object[]{"", "", ""}, ECQqShopDetailSvr$Property.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105244id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
