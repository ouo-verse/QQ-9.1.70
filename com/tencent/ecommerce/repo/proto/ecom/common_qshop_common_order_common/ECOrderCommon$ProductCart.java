package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class ECOrderCommon$ProductCart extends MessageMicro<ECOrderCommon$ProductCart> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"sku_num", "order_sku", "service", "refund_cash"}, new Object[]{0, null, null, 0L}, ECOrderCommon$ProductCart.class);
    public final PBUInt32Field sku_num = PBField.initUInt32(0);
    public ECOrderCommon$OrderSku order_sku = new ECOrderCommon$OrderSku();
    public ECOrderCommon$Service service = new ECOrderCommon$Service();
    public final PBUInt64Field refund_cash = PBField.initUInt64(0);
}
