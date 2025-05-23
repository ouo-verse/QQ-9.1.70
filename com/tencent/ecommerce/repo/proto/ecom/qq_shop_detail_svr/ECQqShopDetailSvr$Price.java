package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$Price extends MessageMicro<ECQqShopDetailSvr$Price> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 82}, new String[]{"origin_price_txt", "counple_after_price_txt", "price_txt", "desc"}, new Object[]{"", "", "", ""}, ECQqShopDetailSvr$Price.class);
    public final PBStringField origin_price_txt = PBField.initString("");
    public final PBStringField counple_after_price_txt = PBField.initString("");
    public final PBStringField price_txt = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
