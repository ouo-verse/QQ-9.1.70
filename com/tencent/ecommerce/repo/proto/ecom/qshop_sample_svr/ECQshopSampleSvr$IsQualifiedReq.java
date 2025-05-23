package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$IsQualifiedReq extends MessageMicro<ECQshopSampleSvr$IsQualifiedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"spu_id", "shop_id"}, new Object[]{"", ""}, ECQshopSampleSvr$IsQualifiedReq.class);
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField shop_id = PBField.initString("");
}
