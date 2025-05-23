package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$GetBuyFloatPageRsp extends MessageMicro<ECQqShopDetailSvr$GetBuyFloatPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 162}, new String[]{"spu_id", "biz_type", "buy_limit", "sku_infos"}, new Object[]{"", 0, null, null}, ECQqShopDetailSvr$GetBuyFloatPageRsp.class);
    public final PBStringField spu_id = PBField.initString("");
    public final PBInt32Field biz_type = PBField.initInt32(0);
    public ECQqShopDetailSvr$BuyLimit buy_limit = new ECQqShopDetailSvr$BuyLimit();
    public final PBRepeatMessageField<ECQqShopDetailSvr$SkuInfo> sku_infos = PBField.initRepeatMessage(ECQqShopDetailSvr$SkuInfo.class);
}
