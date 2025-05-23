package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$QueryBuyerOrderListRsp extends MessageMicro<ECQshopOrderQuerySvr$QueryBuyerOrderListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 810}, new String[]{"order_infos", "cookie", "token"}, new Object[]{null, "", ""}, ECQshopOrderQuerySvr$QueryBuyerOrderListRsp.class);
    public final PBRepeatMessageField<ECOrderInfo$OrderInfo> order_infos = PBField.initRepeatMessage(ECOrderInfo$OrderInfo.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBStringField token = PBField.initString("");
}
