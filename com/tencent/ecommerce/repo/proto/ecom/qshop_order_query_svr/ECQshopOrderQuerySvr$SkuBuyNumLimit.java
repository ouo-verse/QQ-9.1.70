package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$SkuBuyNumLimit extends MessageMicro<ECQshopOrderQuerySvr$SkuBuyNumLimit> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"sku_id", "buy_num_limit", "exceed_limit", "excceed_limit_msg", "min_buy_num"}, new Object[]{"", 0, Boolean.FALSE, "", 0}, ECQshopOrderQuerySvr$SkuBuyNumLimit.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBUInt32Field buy_num_limit = PBField.initUInt32(0);
    public final PBBoolField exceed_limit = PBField.initBool(false);
    public final PBStringField excceed_limit_msg = PBField.initString("");
    public final PBUInt32Field min_buy_num = PBField.initUInt32(0);
}
