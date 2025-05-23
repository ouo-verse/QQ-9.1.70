package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$BriefYiFanAward extends MessageMicro<ECOrderCommon$BriefYiFanAward> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"sku_id", "spu_id", "cnt", "order_id"}, new Object[]{"", "", 0, ""}, ECOrderCommon$BriefYiFanAward.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBUInt32Field cnt = PBField.initUInt32(0);
    public final PBStringField order_id = PBField.initString("");
}
