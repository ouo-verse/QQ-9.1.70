package com.tencent.ecommerce.repo.proto.ecom.shop_sales_center;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECShopSalesCenter$SalesCenterReq extends MessageMicro<ECShopSalesCenter$SalesCenterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WadlProxyConsts.CHANNEL}, new Object[]{0L}, ECShopSalesCenter$SalesCenterReq.class);
    public final PBInt64Field channel = PBField.initInt64(0);
}
