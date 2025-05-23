package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$OrderPageBizErrorMsg extends MessageMicro<ECQshopOrderQuerySvr$OrderPageBizErrorMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"order_page_biz_error_type", "msg"}, new Object[]{0, ""}, ECQshopOrderQuerySvr$OrderPageBizErrorMsg.class);
    public final PBUInt32Field order_page_biz_error_type = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f105253msg = PBField.initString("");
}
