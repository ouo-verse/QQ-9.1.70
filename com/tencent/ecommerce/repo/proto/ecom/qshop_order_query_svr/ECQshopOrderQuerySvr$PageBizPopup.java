package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$PageBizPopup extends MessageMicro<ECQshopOrderQuerySvr$PageBizPopup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"buzi_code", "msg", "action_type", "refresh_req_ext", "clear_active_id"}, new Object[]{0, "", 0, "", Boolean.FALSE}, ECQshopOrderQuerySvr$PageBizPopup.class);
    public final PBUInt32Field buzi_code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f105254msg = PBField.initString("");
    public final PBUInt32Field action_type = PBField.initUInt32(0);
    public final PBStringField refresh_req_ext = PBField.initString("");
    public final PBBoolField clear_active_id = PBField.initBool(false);
}
