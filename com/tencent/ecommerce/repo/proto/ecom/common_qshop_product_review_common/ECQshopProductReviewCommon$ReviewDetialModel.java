package com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.component.cache.database.table.photo.PhotoQualityInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewCommon$ReviewDetialModel extends MessageMicro<ECQshopProductReviewCommon$ReviewDetialModel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{PublicAccountMessageUtilImpl.META_NAME, "content", "audit_status"}, new Object[]{null, null, null}, ECQshopProductReviewCommon$ReviewDetialModel.class);
    public ECQshopProductReviewCommon$ReviewMetaData meta = new MessageMicro<ECQshopProductReviewCommon$ReviewMetaData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$ReviewMetaData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 72, 80, 88}, new String[]{"review_first_id", "review_id", "review_to_id", "order_id", ReportDataBuilder.KEY_PRODUCT_ID, "review_level", "user_id", "to_user_id", AlbumCacheData.CREATE_TIME, "update_time", "review_type"}, new Object[]{"", "", "", "", null, 0, "", "", 0L, 0L, 0}, ECQshopProductReviewCommon$ReviewMetaData.class);
        public final PBStringField review_first_id = PBField.initString("");
        public final PBStringField review_id = PBField.initString("");
        public final PBStringField review_to_id = PBField.initString("");
        public final PBStringField order_id = PBField.initString("");
        public ECQshopProductReviewCommon$ReviewProductID product_id = new ECQshopProductReviewCommon$ReviewProductID();
        public final PBInt32Field review_level = PBField.initInt32(0);
        public final PBStringField user_id = PBField.initString("");
        public final PBStringField to_user_id = PBField.initString("");
        public final PBInt64Field create_time = PBField.initInt64(0);
        public final PBInt64Field update_time = PBField.initInt64(0);
        public final PBInt32Field review_type = PBField.initInt32(0);
    };
    public ECQshopProductReviewCommon$ReviewContentData content = new MessageMicro<ECQshopProductReviewCommon$ReviewContentData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$ReviewContentData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66}, new String[]{"contents", PhotoQualityInfo.QUALITY_SCORE, "logistics_score", "seller_score", "pic_urls", "thumbnail_urls", "video_urls", "product_specification"}, new Object[]{null, 0, 0, 0, "", "", "", ""}, ECQshopProductReviewCommon$ReviewContentData.class);
        public final PBRepeatField<String> pic_urls;
        public final PBRepeatField<String> product_specification;
        public final PBRepeatField<String> thumbnail_urls;
        public final PBRepeatField<String> video_urls;
        public final PBRepeatMessageField<ECQshopProductReviewCommon$RptData> contents = PBField.initRepeatMessage(ECQshopProductReviewCommon$RptData.class);
        public final PBInt32Field quality_score = PBField.initInt32(0);
        public final PBInt32Field logistics_score = PBField.initInt32(0);
        public final PBInt32Field seller_score = PBField.initInt32(0);

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.pic_urls = PBField.initRepeat(pBStringField);
            this.thumbnail_urls = PBField.initRepeat(pBStringField);
            this.video_urls = PBField.initRepeat(pBStringField);
            this.product_specification = PBField.initRepeat(pBStringField);
        }
    };
    public ECQshopProductReviewCommon$AuditStatus audit_status = new MessageMicro<ECQshopProductReviewCommon$AuditStatus>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$AuditStatus
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"busi_audit", "yuheng_audit", "operator_audit"}, new Object[]{null, null, null}, ECQshopProductReviewCommon$AuditStatus.class);
        public ECQshopProductReviewCommon$BeatStatus busi_audit = new MessageMicro<ECQshopProductReviewCommon$BeatStatus>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$BeatStatus
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"passed", "beat_code", "beat_reasoin", "send_count"}, new Object[]{0, 0, "", 0}, ECQshopProductReviewCommon$BeatStatus.class);
            public final PBInt32Field passed = PBField.initInt32(0);
            public final PBInt32Field beat_code = PBField.initInt32(0);
            public final PBStringField beat_reasoin = PBField.initString("");
            public final PBInt32Field send_count = PBField.initInt32(0);
        };
        public ECQshopProductReviewCommon$BeatStatus yuheng_audit = new MessageMicro<ECQshopProductReviewCommon$BeatStatus>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$BeatStatus
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"passed", "beat_code", "beat_reasoin", "send_count"}, new Object[]{0, 0, "", 0}, ECQshopProductReviewCommon$BeatStatus.class);
            public final PBInt32Field passed = PBField.initInt32(0);
            public final PBInt32Field beat_code = PBField.initInt32(0);
            public final PBStringField beat_reasoin = PBField.initString("");
            public final PBInt32Field send_count = PBField.initInt32(0);
        };
        public ECQshopProductReviewCommon$BeatStatus operator_audit = new MessageMicro<ECQshopProductReviewCommon$BeatStatus>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common.ECQshopProductReviewCommon$BeatStatus
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"passed", "beat_code", "beat_reasoin", "send_count"}, new Object[]{0, 0, "", 0}, ECQshopProductReviewCommon$BeatStatus.class);
            public final PBInt32Field passed = PBField.initInt32(0);
            public final PBInt32Field beat_code = PBField.initInt32(0);
            public final PBStringField beat_reasoin = PBField.initString("");
            public final PBInt32Field send_count = PBField.initInt32(0);
        };
    };
}
