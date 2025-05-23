package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$GetSkuInfoReq extends MessageMicro<ECQqShopDetailSvr$GetSkuInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 242}, new String[]{"sku_id", "ext"}, new Object[]{"", null}, ECQqShopDetailSvr$GetSkuInfoReq.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBRepeatMessageField<ECQqShopDetailSvr$ExtInfo> ext = PBField.initRepeatMessage(ECQqShopDetailSvr$ExtInfo.class);
}
