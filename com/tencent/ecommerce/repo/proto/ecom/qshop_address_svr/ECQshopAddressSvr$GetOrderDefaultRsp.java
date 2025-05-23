package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$GetOrderDefaultRsp extends MessageMicro<ECQshopAddressSvr$GetOrderDefaultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"address"}, new Object[]{null}, ECQshopAddressSvr$GetOrderDefaultRsp.class);
    public ECDeliveryAddress$Address address = new ECDeliveryAddress$Address();
}
