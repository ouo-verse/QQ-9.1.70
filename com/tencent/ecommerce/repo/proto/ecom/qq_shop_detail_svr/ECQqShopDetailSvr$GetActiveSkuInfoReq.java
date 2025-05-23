package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$GetActiveSkuInfoReq extends MessageMicro<ECQqShopDetailSvr$GetActiveSkuInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 242}, new String[]{"sku_id", "active_id", "ext"}, new Object[]{"", "", null}, ECQqShopDetailSvr$GetActiveSkuInfoReq.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField active_id = PBField.initString("");
    public final PBRepeatMessageField<ECQqShopDetailSvr$ExtInfo> ext = PBField.initRepeatMessage(ECQqShopDetailSvr$ExtInfo.class);
}
