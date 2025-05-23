package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$OrderChangeRefreshMsg extends MessageMicro<ECQshopOrderSvr$OrderChangeRefreshMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "msg"}, new Object[]{0, ""}, ECQshopOrderSvr$OrderChangeRefreshMsg.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f105255msg = PBField.initString("");
}
