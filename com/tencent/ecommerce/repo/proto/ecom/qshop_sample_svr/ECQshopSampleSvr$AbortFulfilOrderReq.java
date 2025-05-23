package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$AbortReason;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$AbortFulfilOrderReq extends MessageMicro<ECQshopSampleSvr$AbortFulfilOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"order_id", "abort_reason", "desc", "img_list", "token"}, new Object[]{"", null, "", "", ""}, ECQshopSampleSvr$AbortFulfilOrderReq.class);
    public final PBStringField order_id = PBField.initString("");
    public ECSampleData$AbortReason abort_reason = new ECSampleData$AbortReason();
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatField<String> img_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField token = PBField.initString("");
}
