package com.tencent.ecommerce.repo.proto.ecom.common_customer_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCustomerInfo$ShopInfo extends MessageMicro<ECCustomerInfo$ShopInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"shop_id", "shop_name", "shop_log"}, new Object[]{"", "", ""}, ECCustomerInfo$ShopInfo.class);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField shop_name = PBField.initString("");
    public final PBStringField shop_log = PBField.initString("");
}
