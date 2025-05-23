package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$CancelOrderReq extends MessageMicro<ECQshopSampleSvr$CancelOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"order_id", "token"}, new Object[]{"", ""}, ECQshopSampleSvr$CancelOrderReq.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBStringField token = PBField.initString("");
}
