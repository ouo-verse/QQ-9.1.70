package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$QueryOrderDetailInternalRsp extends MessageMicro<ECQshopOrderQuerySvr$QueryOrderDetailInternalRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"order_info"}, new Object[]{null}, ECQshopOrderQuerySvr$QueryOrderDetailInternalRsp.class);
    public ECOrderInfo$OrderInfo order_info = new ECOrderInfo$OrderInfo();
}
