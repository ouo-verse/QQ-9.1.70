package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$BindProductReq extends MessageMicro<ECQshopLogisticsTemplateSvr$BindProductReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "template_id"}, new Object[]{"", 0L}, ECQshopLogisticsTemplateSvr$BindProductReq.class);
    public final PBStringField product_id = PBField.initString("");
    public final PBInt64Field template_id = PBField.initInt64(0);
}
