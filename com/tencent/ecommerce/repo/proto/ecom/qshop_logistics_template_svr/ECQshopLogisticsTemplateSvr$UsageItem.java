package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$UsageItem extends MessageMicro<ECQshopLogisticsTemplateSvr$UsageItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "product_name", "status", "in_activity"}, new Object[]{"", "", 0, Boolean.FALSE}, ECQshopLogisticsTemplateSvr$UsageItem.class);
    public final PBStringField product_id = PBField.initString("");
    public final PBStringField product_name = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBBoolField in_activity = PBField.initBool(false);
}
