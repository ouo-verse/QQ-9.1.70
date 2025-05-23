package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$GetAbortFulfilDetailReq extends MessageMicro<ECQshopSampleSvr$GetAbortFulfilDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"order_id"}, new Object[]{""}, ECQshopSampleSvr$GetAbortFulfilDetailReq.class);
    public final PBStringField order_id = PBField.initString("");
}
