package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$CheckUnpaidRsp extends MessageMicro<ECQshopOrderQuerySvr$CheckUnpaidRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"unpaid", "alert_msg"}, new Object[]{Boolean.FALSE, ""}, ECQshopOrderQuerySvr$CheckUnpaidRsp.class);
    public final PBBoolField unpaid = PBField.initBool(false);
    public final PBStringField alert_msg = PBField.initString("");
}
