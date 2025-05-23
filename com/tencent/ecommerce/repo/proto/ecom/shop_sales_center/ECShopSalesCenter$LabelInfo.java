package com.tencent.ecommerce.repo.proto.ecom.shop_sales_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECShopSalesCenter$LabelInfo extends MessageMicro<ECShopSalesCenter$LabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"background_color", "text_color", "text", "pic_url", "width", "height"}, new Object[]{"", "", "", "", 0, 0}, ECShopSalesCenter$LabelInfo.class);
    public final PBStringField background_color = PBField.initString("");
    public final PBStringField text_color = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
}
