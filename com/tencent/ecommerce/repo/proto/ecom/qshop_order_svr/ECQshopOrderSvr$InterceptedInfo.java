package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$InterceptedInfo extends MessageMicro<ECQshopOrderSvr$InterceptedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sku_num", "order_price"}, new Object[]{0, 0L}, ECQshopOrderSvr$InterceptedInfo.class);
    public final PBUInt32Field sku_num = PBField.initUInt32(0);
    public final PBUInt64Field order_price = PBField.initUInt64(0);
}
