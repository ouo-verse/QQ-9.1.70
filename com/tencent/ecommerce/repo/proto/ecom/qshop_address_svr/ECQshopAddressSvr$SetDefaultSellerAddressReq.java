package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$SetDefaultSellerAddressReq extends MessageMicro<ECQshopAddressSvr$SetDefaultSellerAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"address_id", "address_type"}, new Object[]{0L, 0}, ECQshopAddressSvr$SetDefaultSellerAddressReq.class);
    public final PBInt64Field address_id = PBField.initInt64(0);
    public final PBUInt32Field address_type = PBField.initUInt32(0);
}
