package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$CreateOrderReq extends MessageMicro<ECQshopSampleSvr$CreateOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"sku_id", "spu_id", "shop_id", "count", "token"}, new Object[]{"", "", "", 0, ""}, ECQshopSampleSvr$CreateOrderReq.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField shop_id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField token = PBField.initString("");
}
