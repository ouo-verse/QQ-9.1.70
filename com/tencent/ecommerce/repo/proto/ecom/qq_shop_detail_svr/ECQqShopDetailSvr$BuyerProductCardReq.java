package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_comm.ECComm$ReqExt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$BuyerProductCardReq extends MessageMicro<ECQqShopDetailSvr$BuyerProductCardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 162, 242}, new String[]{"shop_id", "spu_id", WadlProxyConsts.CHANNEL, "req_ext", "ext"}, new Object[]{"", "", 0, null, null}, ECQqShopDetailSvr$BuyerProductCardReq.class);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
    public ECComm$ReqExt req_ext = new ECComm$ReqExt();
    public final PBRepeatMessageField<ECQqShopDetailSvr$ExtInfo> ext = PBField.initRepeatMessage(ECQqShopDetailSvr$ExtInfo.class);
}
