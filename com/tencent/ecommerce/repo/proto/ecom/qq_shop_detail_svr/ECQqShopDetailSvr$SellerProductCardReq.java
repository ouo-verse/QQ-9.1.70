package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$SellerProductCardReq extends MessageMicro<ECQqShopDetailSvr$SellerProductCardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"shop_id", "spu_id", WadlProxyConsts.CHANNEL}, new Object[]{"", "", 0}, ECQqShopDetailSvr$SellerProductCardReq.class);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
}
