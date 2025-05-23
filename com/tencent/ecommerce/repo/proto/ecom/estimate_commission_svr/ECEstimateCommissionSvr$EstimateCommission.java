package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$EstimateCommission extends MessageMicro<ECEstimateCommissionSvr$EstimateCommission> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"product_info", "order_info", "commission_info"}, new Object[]{null, null, null}, ECEstimateCommissionSvr$EstimateCommission.class);
    public ECEstimateCommissionSvr$ProductInfo product_info = new ECEstimateCommissionSvr$ProductInfo();
    public ECEstimateCommissionSvr$OrderInfo order_info = new ECEstimateCommissionSvr$OrderInfo();
    public ECEstimateCommissionSvr$CommissionInfo commission_info = new ECEstimateCommissionSvr$CommissionInfo();
}
