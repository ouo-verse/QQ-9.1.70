package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$EntryRsp extends MessageMicro<ECEstimateCommissionSvr$EntryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"commission_sum", "commission_desc"}, new Object[]{0L, ""}, ECEstimateCommissionSvr$EntryRsp.class);
    public final PBInt64Field commission_sum = PBField.initInt64(0);
    public final PBStringField commission_desc = PBField.initString("");
}
