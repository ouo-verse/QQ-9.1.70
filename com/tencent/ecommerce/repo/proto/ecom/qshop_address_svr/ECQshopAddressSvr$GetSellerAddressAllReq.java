package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$GetSellerAddressAllReq extends MessageMicro<ECQshopAddressSvr$GetSellerAddressAllReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"address_type"}, new Object[]{0}, ECQshopAddressSvr$GetSellerAddressAllReq.class);
    public final PBUInt32Field address_type = PBField.initUInt32(0);
}
