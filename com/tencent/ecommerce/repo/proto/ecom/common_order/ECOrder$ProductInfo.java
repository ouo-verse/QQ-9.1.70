package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECOrder$ProductInfo extends MessageMicro<ECOrder$ProductInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 80, 88, 162, 170, 242}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "product_name", "product_pic", "product_price", "product_num", "specification1", "specification2", "show_window_product_id"}, new Object[]{"", "", "", 0L, 0L, "", "", ""}, ECOrder$ProductInfo.class);
    public final PBStringField product_id = PBField.initString("");
    public final PBStringField product_name = PBField.initString("");
    public final PBStringField product_pic = PBField.initString("");
    public final PBInt64Field product_price = PBField.initInt64(0);
    public final PBInt64Field product_num = PBField.initInt64(0);
    public final PBStringField specification1 = PBField.initString("");
    public final PBStringField specification2 = PBField.initString("");
    public final PBStringField show_window_product_id = PBField.initString("");
}
