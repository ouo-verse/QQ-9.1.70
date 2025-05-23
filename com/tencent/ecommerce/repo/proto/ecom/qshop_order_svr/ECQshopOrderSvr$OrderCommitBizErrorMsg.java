package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$OrderCommitBizErrorMsg extends MessageMicro<ECQshopOrderSvr$OrderCommitBizErrorMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48}, new String[]{"biz_error_type", "msg", "intercepted_info", "action_type", "refresh_req_ext", "clear_active_id"}, new Object[]{0, "", null, 0, "", Boolean.FALSE}, ECQshopOrderSvr$OrderCommitBizErrorMsg.class);
    public final PBUInt32Field biz_error_type = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f105256msg = PBField.initString("");
    public ECQshopOrderSvr$InterceptedInfo intercepted_info = new ECQshopOrderSvr$InterceptedInfo();
    public final PBUInt32Field action_type = PBField.initUInt32(0);
    public final PBStringField refresh_req_ext = PBField.initString("");
    public final PBBoolField clear_active_id = PBField.initBool(false);
}
