package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$ShopSnapshot extends MessageMicro<ECSampleData$ShopSnapshot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"shop_id", "shop_title", "shop_icon", "shop_link", "contacts", "contact_details"}, new Object[]{"", "", "", "", "", ""}, ECSampleData$ShopSnapshot.class);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField shop_title = PBField.initString("");
    public final PBStringField shop_icon = PBField.initString("");
    public final PBStringField shop_link = PBField.initString("");
    public final PBStringField contacts = PBField.initString("");
    public final PBStringField contact_details = PBField.initString("");
}
