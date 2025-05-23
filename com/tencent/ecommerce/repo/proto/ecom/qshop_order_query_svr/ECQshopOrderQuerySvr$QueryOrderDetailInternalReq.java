package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$QueryOrderDetailInternalReq extends MessageMicro<ECQshopOrderQuerySvr$QueryOrderDetailInternalReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"order_id", WadlProxyConsts.CHANNEL}, new Object[]{"", 0}, ECQshopOrderQuerySvr$QueryOrderDetailInternalReq.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt32Field channel = PBField.initUInt32(0);
}
