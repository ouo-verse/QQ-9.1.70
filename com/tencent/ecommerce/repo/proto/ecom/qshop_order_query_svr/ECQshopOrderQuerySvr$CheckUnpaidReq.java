package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$CheckUnpaidReq extends MessageMicro<ECQshopOrderQuerySvr$CheckUnpaidReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 808}, new String[]{"order_id", "pay_url_params", WadlProxyConsts.CHANNEL}, new Object[]{"", "", 0}, ECQshopOrderQuerySvr$CheckUnpaidReq.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBStringField pay_url_params = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
}
