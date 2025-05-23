package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_write;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewWrite$WriteRsp extends MessageMicro<ECQshopProductReviewWrite$WriteRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"review_id", "state"}, new Object[]{"", 0}, ECQshopProductReviewWrite$WriteRsp.class);
    public final PBStringField review_id = PBField.initString("");
    public final PBUInt32Field state = PBField.initUInt32(0);
}
