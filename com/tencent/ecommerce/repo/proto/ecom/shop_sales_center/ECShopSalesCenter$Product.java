package com.tencent.ecommerce.repo.proto.ecom.shop_sales_center;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* loaded from: classes31.dex */
public final class ECShopSalesCenter$Product extends MessageMicro<ECShopSalesCenter$Product> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 66, 74, 82, 90, 96, 106, 114, 162, 170, 178}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "title", "price", "sales", "pic", "url", "saas_type", "saas_product_id", PictureConst.KEY_CATEGORY_ID, "category_name", "commission", "commission_range", "sales_txt", "media_product_id", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "labels"}, new Object[]{0L, "", 0L, 0L, "", "", "", "", "", "", 0L, null, "", "", null, null}, ECShopSalesCenter$Product.class);
    public final PBInt64Field product_id = PBField.initInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBInt64Field price = PBField.initInt64(0);
    public final PBInt64Field sales = PBField.initInt64(0);
    public final PBStringField pic = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField saas_type = PBField.initString("");
    public final PBStringField saas_product_id = PBField.initString("");
    public final PBStringField category_id = PBField.initString("");
    public final PBStringField category_name = PBField.initString("");
    public final PBInt64Field commission = PBField.initInt64(0);
    public ECShopSalesCenter$NumberRange commission_range = new MessageMicro<ECShopSalesCenter$NumberRange>() { // from class: com.tencent.ecommerce.repo.proto.ecom.shop_sales_center.ECShopSalesCenter$NumberRange
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"lower", "upper"}, new Object[]{0L, 0L}, ECShopSalesCenter$NumberRange.class);
        public final PBUInt64Field lower = PBField.initUInt64(0);
        public final PBUInt64Field upper = PBField.initUInt64(0);
    };
    public final PBStringField sales_txt = PBField.initString("");
    public final PBStringField media_product_id = PBField.initString("");
    public ECShopSalesCenter$ActivityInfo activity = new MessageMicro<ECShopSalesCenter$ActivityInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.shop_sales_center.ECShopSalesCenter$ActivityInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24}, new String[]{"activity_start_time", "activity_end_time"}, new Object[]{0L, 0L}, ECShopSalesCenter$ActivityInfo.class);
        public final PBUInt64Field activity_start_time = PBField.initUInt64(0);
        public final PBUInt64Field activity_end_time = PBField.initUInt64(0);
    };
    public final PBRepeatMessageField<ECShopSalesCenter$LabelInfo> labels = PBField.initRepeatMessage(ECShopSalesCenter$LabelInfo.class);
}
