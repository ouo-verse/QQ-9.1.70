package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_comm.ECComm$ReqExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$GetActiveBuyFloatPageReq extends MessageMicro<ECQqShopDetailSvr$GetActiveBuyFloatPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 162, 242}, new String[]{"spu_id", "active_id", "req_ext", "ext"}, new Object[]{"", "", null, null}, ECQqShopDetailSvr$GetActiveBuyFloatPageReq.class);
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField active_id = PBField.initString("");
    public ECComm$ReqExt req_ext = new ECComm$ReqExt();
    public final PBRepeatMessageField<ECQqShopDetailSvr$ExtInfo> ext = PBField.initRepeatMessage(ECQqShopDetailSvr$ExtInfo.class);
}
