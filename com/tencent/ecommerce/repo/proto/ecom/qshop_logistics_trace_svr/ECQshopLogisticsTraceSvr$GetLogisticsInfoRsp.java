package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_trace_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$LogisticsInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTraceSvr$GetLogisticsInfoRsp extends MessageMicro<ECQshopLogisticsTraceSvr$GetLogisticsInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"logistics_infos"}, new Object[]{null}, ECQshopLogisticsTraceSvr$GetLogisticsInfoRsp.class);
    public final PBRepeatMessageField<ECLogisticsCommon$LogisticsInfo> logistics_infos = PBField.initRepeatMessage(ECLogisticsCommon$LogisticsInfo.class);
}
