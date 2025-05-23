package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_write;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$ReviewProductID;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$RptData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewWrite$WriteReq extends MessageMicro<ECQshopProductReviewWrite$WriteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 42, 82, 122, 160, 168, 176}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "order_id", "product_specification", "review_content", "picture_urls", "product_quality_score", "logistics_quality_score", "shop_quality_score"}, new Object[]{null, "", "", null, "", 0, 0, 0}, ECQshopProductReviewWrite$WriteReq.class);
    public final PBInt32Field logistics_quality_score;
    public final PBRepeatField<String> picture_urls;
    public final PBInt32Field product_quality_score;
    public final PBRepeatField<String> product_specification;
    public final PBRepeatMessageField<ECQshopProductReviewCommon$RptData> review_content;
    public final PBInt32Field shop_quality_score;
    public ECQshopProductReviewCommon$ReviewProductID product_id = new ECQshopProductReviewCommon$ReviewProductID();
    public final PBStringField order_id = PBField.initString("");

    public ECQshopProductReviewWrite$WriteReq() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.product_specification = PBField.initRepeat(pBStringField);
        this.review_content = PBField.initRepeatMessage(ECQshopProductReviewCommon$RptData.class);
        this.picture_urls = PBField.initRepeat(pBStringField);
        this.product_quality_score = PBField.initInt32(0);
        this.logistics_quality_score = PBField.initInt32(0);
        this.shop_quality_score = PBField.initInt32(0);
    }
}
