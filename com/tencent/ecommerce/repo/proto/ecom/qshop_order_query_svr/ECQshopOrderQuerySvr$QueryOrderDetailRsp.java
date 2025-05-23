package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$QueryOrderDetailRsp extends MessageMicro<ECQshopOrderQuerySvr$QueryOrderDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 810}, new String[]{"order_info", "token"}, new Object[]{null, ""}, ECQshopOrderQuerySvr$QueryOrderDetailRsp.class);
    public ECOrderInfo$OrderInfo order_info = new ECOrderInfo$OrderInfo();
    public final PBStringField token = PBField.initString("");
}
