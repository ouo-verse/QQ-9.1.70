package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewRead$GetReviewCountRsp extends MessageMicro<ECQshopProductReviewRead$GetReviewCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"passed_count", "user_total_count", "user_passed_count", "total_count"}, new Object[]{0, 0, 0, 0}, ECQshopProductReviewRead$GetReviewCountRsp.class);
    public final PBUInt32Field passed_count = PBField.initUInt32(0);
    public final PBUInt32Field user_total_count = PBField.initUInt32(0);
    public final PBUInt32Field user_passed_count = PBField.initUInt32(0);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
}
