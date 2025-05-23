package com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewCommon$ReviewProductID extends MessageMicro<ECQshopProductReviewCommon$ReviewProductID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"spu_id", "sku_id"}, new Object[]{"", ""}, ECQshopProductReviewCommon$ReviewProductID.class);
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField sku_id = PBField.initString("");
}
