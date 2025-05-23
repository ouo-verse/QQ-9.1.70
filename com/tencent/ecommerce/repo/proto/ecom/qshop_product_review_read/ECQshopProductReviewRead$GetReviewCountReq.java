package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewRead$GetReviewCountReq extends MessageMicro<ECQshopProductReviewRead$GetReviewCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID}, new Object[]{""}, ECQshopProductReviewRead$GetReviewCountReq.class);
    public final PBStringField product_id = PBField.initString("");
}
