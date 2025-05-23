package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$GetSkuInfoRsp extends MessageMicro<ECQqShopDetailSvr$GetSkuInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"sku_id", "stock_num", "stock_num_txt"}, new Object[]{"", 0L, ""}, ECQqShopDetailSvr$GetSkuInfoRsp.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBUInt64Field stock_num = PBField.initUInt64(0);
    public final PBStringField stock_num_txt = PBField.initString("");
}
