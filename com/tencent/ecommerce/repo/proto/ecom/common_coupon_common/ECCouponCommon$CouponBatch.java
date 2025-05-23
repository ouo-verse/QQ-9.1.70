package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponBatch extends MessageMicro<ECCouponCommon$CouponBatch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 42, 80, 88, 96, 122}, new String[]{"batch_info", "basic_info", "issue_rule", "status", AlbumCacheData.CREATE_TIME, "modify_time", "statistics"}, new Object[]{null, null, null, 0, 0L, 0L, null}, ECCouponCommon$CouponBatch.class);
    public ECCouponCommon$CouponBatchBaseInfo batch_info = new MessageMicro<ECCouponCommon$CouponBatchBaseInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$CouponBatchBaseInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 160}, new String[]{"coupon_batch_id", "coupon_batch_name", "sence"}, new Object[]{"", "", 0}, ECCouponCommon$CouponBatchBaseInfo.class);
        public final PBStringField coupon_batch_id = PBField.initString("");
        public final PBStringField coupon_batch_name = PBField.initString("");
        public final PBEnumField sence = PBField.initEnum(0);
    };
    public ECCouponCommon$CouponBasicInfo basic_info = new ECCouponCommon$CouponBasicInfo();
    public ECCouponCommon$IssueRule issue_rule = new ECCouponCommon$IssueRule();
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field modify_time = PBField.initInt64(0);
    public ECCouponCommon$Statistics statistics = new MessageMicro<ECCouponCommon$Statistics>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$Statistics
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"already_recv_cnt", "already_use_cnt"}, new Object[]{0, 0}, ECCouponCommon$Statistics.class);
        public final PBInt32Field already_recv_cnt = PBField.initInt32(0);
        public final PBInt32Field already_use_cnt = PBField.initInt32(0);
    };
}
