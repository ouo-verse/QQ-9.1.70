package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Fulfillment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$CreateOrderRsp extends MessageMicro<ECQshopSampleSvr$CreateOrderRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"order_detail", "fulfillment", "token"}, new Object[]{null, null, ""}, ECQshopSampleSvr$CreateOrderRsp.class);
    public ECQshopSampleSvr$OrderDetail order_detail = new ECQshopSampleSvr$OrderDetail();
    public ECSampleData$Fulfillment fulfillment = new MessageMicro<ECSampleData$Fulfillment>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Fulfillment
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"fulfil_rate", "finished_count", "total_count"}, new Object[]{0, 0, 0}, ECSampleData$Fulfillment.class);
        public final PBUInt32Field fulfil_rate = PBField.initUInt32(0);
        public final PBUInt32Field finished_count = PBField.initUInt32(0);
        public final PBUInt32Field total_count = PBField.initUInt32(0);
    };
    public final PBStringField token = PBField.initString("");
}
