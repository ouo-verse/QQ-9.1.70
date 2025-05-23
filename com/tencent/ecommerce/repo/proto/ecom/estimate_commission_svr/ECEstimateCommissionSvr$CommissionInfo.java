package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$CommissionInfo extends MessageMicro<ECEstimateCommissionSvr$CommissionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"commission"}, new Object[]{0L}, ECEstimateCommissionSvr$CommissionInfo.class);
    public final PBInt64Field commission = PBField.initInt64(0);
}
