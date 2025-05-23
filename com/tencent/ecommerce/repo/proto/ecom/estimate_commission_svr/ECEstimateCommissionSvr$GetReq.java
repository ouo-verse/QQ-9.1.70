package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$GetReq extends MessageMicro<ECEstimateCommissionSvr$GetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{WadlProxyConsts.CHANNEL, "cookie"}, new Object[]{0, ByteStringMicro.EMPTY}, ECEstimateCommissionSvr$GetReq.class);
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
