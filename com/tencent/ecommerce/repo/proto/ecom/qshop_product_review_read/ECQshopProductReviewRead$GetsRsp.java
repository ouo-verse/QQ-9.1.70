package com.tencent.ecommerce.repo.proto.ecom.qshop_product_review_read;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewRead$GetsRsp extends MessageMicro<ECQshopProductReviewRead$GetsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"review_detail", "review_count", "cookie", "is_end"}, new Object[]{null, 0, ByteStringMicro.EMPTY, Boolean.FALSE}, ECQshopProductReviewRead$GetsRsp.class);
    public final PBRepeatMessageField<ECQshopProductReviewRead$ReviewDetail> review_detail = PBField.initRepeatMessage(ECQshopProductReviewRead$ReviewDetail.class);
    public final PBUInt32Field review_count = PBField.initUInt32(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField is_end = PBField.initBool(false);
}
