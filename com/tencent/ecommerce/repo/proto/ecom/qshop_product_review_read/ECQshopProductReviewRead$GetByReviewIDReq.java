package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewRead$GetByReviewIDReq extends MessageMicro<ECQshopProductReviewRead$GetByReviewIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"review_id"}, new Object[]{""}, ECQshopProductReviewRead$GetByReviewIDReq.class);
    public final PBStringField review_id = PBField.initString("");
}
