package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$QueryOrderDetailReq extends MessageMicro<ECQshopOrderQuerySvr$QueryOrderDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 808}, new String[]{"order_id", "pay_status_from_client", WadlProxyConsts.CHANNEL}, new Object[]{"", 0, 0}, ECQshopOrderQuerySvr$QueryOrderDetailReq.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt32Field pay_status_from_client = PBField.initUInt32(0);
    public final PBInt32Field channel = PBField.initInt32(0);
}
