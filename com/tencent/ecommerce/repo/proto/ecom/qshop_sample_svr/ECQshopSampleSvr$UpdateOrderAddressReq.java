package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$UpdateOrderAddressReq extends MessageMicro<ECQshopSampleSvr$UpdateOrderAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"order_id", "address", "refresh", "token"}, new Object[]{"", null, Boolean.FALSE, ""}, ECQshopSampleSvr$UpdateOrderAddressReq.class);
    public final PBStringField order_id = PBField.initString("");
    public ECDeliveryAddress$Address address = new ECDeliveryAddress$Address();
    public final PBBoolField refresh = PBField.initBool(false);
    public final PBStringField token = PBField.initString("");
}
