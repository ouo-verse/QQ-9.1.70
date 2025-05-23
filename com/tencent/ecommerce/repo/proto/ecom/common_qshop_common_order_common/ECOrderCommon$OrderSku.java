package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$OrderSku extends MessageMicro<ECOrderCommon$OrderSku> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sku", "spu"}, new Object[]{null, null}, ECOrderCommon$OrderSku.class);
    public ECOrderCommon$SkuInfo sku = new ECOrderCommon$SkuInfo();
    public ECOrderCommon$SpuInfo spu = new ECOrderCommon$SpuInfo();
}
