package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$QueryBuyerOrderListReq extends MessageMicro<ECQshopOrderQuerySvr$QueryBuyerOrderListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 808}, new String[]{"query_option", "cookie", WadlProxyConsts.CHANNEL}, new Object[]{null, "", 0}, ECQshopOrderQuerySvr$QueryBuyerOrderListReq.class);
    public ECQshopOrderQuerySvr$QueryOption query_option = new MessageMicro<ECQshopOrderQuerySvr$QueryOption>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$QueryOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"keyword", "state_option"}, new Object[]{"", 0}, ECQshopOrderQuerySvr$QueryOption.class);
        public final PBStringField keyword = PBField.initString("");
        public final PBUInt32Field state_option = PBField.initUInt32(0);
    };
    public final PBStringField cookie = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
}
