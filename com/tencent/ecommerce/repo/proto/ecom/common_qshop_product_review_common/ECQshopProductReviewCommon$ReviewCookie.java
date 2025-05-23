package com.tencent.ecommerce.repo.proto.ecom.common_qshop_product_review_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopProductReviewCommon$ReviewCookie extends MessageMicro<ECQshopProductReviewCommon$ReviewCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"index", "omit_exp_write_List", "omit_exp_write_failed_list", "omit_exp_write_type", "cache_depleted"}, new Object[]{0, "", "", 0, Boolean.FALSE}, ECQshopProductReviewCommon$ReviewCookie.class);
    public final PBBoolField cache_depleted;
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBRepeatField<String> omit_exp_write_List;
    public final PBRepeatField<String> omit_exp_write_failed_list;
    public final PBInt32Field omit_exp_write_type;

    public ECQshopProductReviewCommon$ReviewCookie() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.omit_exp_write_List = PBField.initRepeat(pBStringField);
        this.omit_exp_write_failed_list = PBField.initRepeat(pBStringField);
        this.omit_exp_write_type = PBField.initInt32(0);
        this.cache_depleted = PBField.initBool(false);
    }
}
