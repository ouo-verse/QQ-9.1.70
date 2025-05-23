package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$ShopInfo extends MessageMicro<ECOrderCommon$ShopInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"shop_id", "shop_title", "shop_icon", "shop_link"}, new Object[]{"", "", "", ""}, ECOrderCommon$ShopInfo.class);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField shop_title = PBField.initString("");
    public final PBStringField shop_icon = PBField.initString("");
    public final PBStringField shop_link = PBField.initString("");
}
