package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$QueryOrderListRsp extends MessageMicro<ECQshopSampleSvr$QueryOrderListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"cookie", "order_detail_list", "token"}, new Object[]{"", null, ""}, ECQshopSampleSvr$QueryOrderListRsp.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBRepeatMessageField<ECQshopSampleSvr$OrderDetail> order_detail_list = PBField.initRepeatMessage(ECQshopSampleSvr$OrderDetail.class);
    public final PBStringField token = PBField.initString("");
}
