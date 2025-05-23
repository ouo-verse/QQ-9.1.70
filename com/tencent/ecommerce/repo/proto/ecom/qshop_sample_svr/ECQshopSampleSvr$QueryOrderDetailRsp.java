package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$QueryOrderDetailRsp extends MessageMicro<ECQshopSampleSvr$QueryOrderDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"order_detail", "token"}, new Object[]{null, ""}, ECQshopSampleSvr$QueryOrderDetailRsp.class);
    public ECQshopSampleSvr$OrderDetail order_detail = new ECQshopSampleSvr$OrderDetail();
    public final PBStringField token = PBField.initString("");
}
