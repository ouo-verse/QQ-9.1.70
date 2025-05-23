package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$ReviewProductID;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$RptData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewRead$ReviewDetail extends MessageMicro<ECQshopProductReviewRead$ReviewDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 82, 90, 98, 162, 170, 178, 202, 208, 240, 248, 256}, new String[]{"review_id", ReportDataBuilder.KEY_PRODUCT_ID, "order_id", "review_type", "user_id", "user_nick", "user_icon", "review_content", "picture_urls", "thumb_picture_urls", "product_specification", AlbumCacheData.CREATE_TIME, "product_quality_score", "logistics_quality_score", "shop_quality_score"}, new Object[]{"", null, "", 0, "", "", "", null, "", "", "", 0L, 0, 0, 0}, ECQshopProductReviewRead$ReviewDetail.class);
    public final PBInt64Field create_time;
    public final PBInt32Field logistics_quality_score;
    public final PBRepeatField<String> picture_urls;
    public final PBInt32Field product_quality_score;
    public final PBStringField product_specification;
    public final PBInt32Field shop_quality_score;
    public final PBRepeatField<String> thumb_picture_urls;
    public final PBStringField review_id = PBField.initString("");
    public ECQshopProductReviewCommon$ReviewProductID product_id = new ECQshopProductReviewCommon$ReviewProductID();
    public final PBStringField order_id = PBField.initString("");
    public final PBInt32Field review_type = PBField.initInt32(0);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField user_nick = PBField.initString("");
    public final PBStringField user_icon = PBField.initString("");
    public final PBRepeatMessageField<ECQshopProductReviewCommon$RptData> review_content = PBField.initRepeatMessage(ECQshopProductReviewCommon$RptData.class);

    public ECQshopProductReviewRead$ReviewDetail() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.picture_urls = PBField.initRepeat(pBStringField);
        this.thumb_picture_urls = PBField.initRepeat(pBStringField);
        this.product_specification = PBField.initString("");
        this.create_time = PBField.initInt64(0L);
        this.product_quality_score = PBField.initInt32(0);
        this.logistics_quality_score = PBField.initInt32(0);
        this.shop_quality_score = PBField.initInt32(0);
    }
}
