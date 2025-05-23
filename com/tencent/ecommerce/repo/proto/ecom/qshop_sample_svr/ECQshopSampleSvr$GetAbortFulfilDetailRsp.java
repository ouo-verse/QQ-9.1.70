package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$AbortReason;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$GetAbortFulfilDetailRsp extends MessageMicro<ECQshopSampleSvr$GetAbortFulfilDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"order_fulfil_detail", "abort_reason_list", "token"}, new Object[]{null, null, ""}, ECQshopSampleSvr$GetAbortFulfilDetailRsp.class);
    public ECQshopSampleSvr$OrderFulfilDetail order_fulfil_detail = new ECQshopSampleSvr$OrderFulfilDetail();
    public final PBRepeatMessageField<ECSampleData$AbortReason> abort_reason_list = PBField.initRepeatMessage(ECSampleData$AbortReason.class);
    public final PBStringField token = PBField.initString("");
}
