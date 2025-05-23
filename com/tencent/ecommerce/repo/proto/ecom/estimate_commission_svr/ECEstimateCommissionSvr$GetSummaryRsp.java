package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$GetSummaryRsp extends MessageMicro<ECEstimateCommissionSvr$GetSummaryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"order_count", "commission_sum"}, new Object[]{0L, 0L}, ECEstimateCommissionSvr$GetSummaryRsp.class);
    public final PBInt64Field order_count = PBField.initInt64(0);
    public final PBInt64Field commission_sum = PBField.initInt64(0);
}
