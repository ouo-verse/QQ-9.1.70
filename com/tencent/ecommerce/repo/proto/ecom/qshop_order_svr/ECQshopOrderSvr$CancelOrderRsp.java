package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$CancelOrderRsp extends MessageMicro<ECQshopOrderSvr$CancelOrderRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"order_info", "order_change_refresh_msg"}, new Object[]{null, null}, ECQshopOrderSvr$CancelOrderRsp.class);
    public ECOrderInfo$OrderInfo order_info = new ECOrderInfo$OrderInfo();
    public ECQshopOrderSvr$OrderChangeRefreshMsg order_change_refresh_msg = new ECQshopOrderSvr$OrderChangeRefreshMsg();
}
