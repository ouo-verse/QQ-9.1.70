package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewRead$GetsReq extends MessageMicro<ECQshopProductReviewRead$GetsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "sort_type", "cookie"}, new Object[]{"", 0, ByteStringMicro.EMPTY}, ECQshopProductReviewRead$GetsReq.class);
    public final PBStringField product_id = PBField.initString("");
    public final PBInt32Field sort_type = PBField.initInt32(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
