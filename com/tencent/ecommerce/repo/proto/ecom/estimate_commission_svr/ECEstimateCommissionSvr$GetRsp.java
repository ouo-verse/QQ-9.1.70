package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$GetRsp extends MessageMicro<ECEstimateCommissionSvr$GetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"stimate_commissions", "cookie", "is_end"}, new Object[]{null, ByteStringMicro.EMPTY, Boolean.FALSE}, ECEstimateCommissionSvr$GetRsp.class);
    public final PBRepeatMessageField<ECEstimateCommissionSvr$EstimateCommission> stimate_commissions = PBField.initRepeatMessage(ECEstimateCommissionSvr$EstimateCommission.class);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField is_end = PBField.initBool(false);
}
