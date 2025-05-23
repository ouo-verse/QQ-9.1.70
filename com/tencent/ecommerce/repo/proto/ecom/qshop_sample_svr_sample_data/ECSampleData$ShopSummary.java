package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$SellerAddress;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$ShopSummary extends MessageMicro<ECSampleData$ShopSummary> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 800}, new String[]{"shop_id", "contacts", "contact_details", "update_time", "send_address", "version"}, new Object[]{"", "", "", 0L, null, 0L}, ECSampleData$ShopSummary.class);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField contacts = PBField.initString("");
    public final PBStringField contact_details = PBField.initString("");
    public final PBInt64Field update_time = PBField.initInt64(0);
    public ECDeliveryAddress$SellerAddress send_address = new ECDeliveryAddress$SellerAddress();
    public final PBInt64Field version = PBField.initInt64(0);
}
