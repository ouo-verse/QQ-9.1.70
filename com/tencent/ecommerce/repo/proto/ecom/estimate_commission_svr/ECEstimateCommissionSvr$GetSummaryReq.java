package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$GetSummaryReq extends MessageMicro<ECEstimateCommissionSvr$GetSummaryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WadlProxyConsts.CHANNEL}, new Object[]{0}, ECEstimateCommissionSvr$GetSummaryReq.class);
    public final PBUInt32Field channel = PBField.initUInt32(0);
}
