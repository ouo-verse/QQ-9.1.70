package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$ShippingDetail extends MessageMicro<ECOrderCommon$ShippingDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"shipper_code", "shipping_id", "send_type", "delivery_address"}, new Object[]{"", "", 0, null}, ECOrderCommon$ShippingDetail.class);
    public final PBStringField shipper_code = PBField.initString("");
    public final PBStringField shipping_id = PBField.initString("");
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public ECOrderCommon$Address delivery_address = new ECOrderCommon$Address();
}
