package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$ProductInfo extends MessageMicro<ECEstimateCommissionSvr$ProductInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"product_title"}, new Object[]{""}, ECEstimateCommissionSvr$ProductInfo.class);
    public final PBStringField product_title = PBField.initString("");
}
