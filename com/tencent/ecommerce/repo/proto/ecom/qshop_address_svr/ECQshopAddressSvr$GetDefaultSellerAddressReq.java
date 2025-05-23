package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$GetDefaultSellerAddressReq extends MessageMicro<ECQshopAddressSvr$GetDefaultSellerAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"shop_id"}, new Object[]{""}, ECQshopAddressSvr$GetDefaultSellerAddressReq.class);
    public final PBStringField shop_id = PBField.initString("");
}
