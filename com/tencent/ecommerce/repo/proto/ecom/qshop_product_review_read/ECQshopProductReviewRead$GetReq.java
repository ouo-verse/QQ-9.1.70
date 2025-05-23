package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$ReviewProductID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewRead$GetReq extends MessageMicro<ECQshopProductReviewRead$GetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"order_id", ReportDataBuilder.KEY_PRODUCT_ID}, new Object[]{"", null}, ECQshopProductReviewRead$GetReq.class);
    public final PBStringField order_id = PBField.initString("");
    public ECQshopProductReviewCommon$ReviewProductID product_id = new ECQshopProductReviewCommon$ReviewProductID();
}
