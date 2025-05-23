package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$DeleteSellerAddressReq extends MessageMicro<ECQshopAddressSvr$DeleteSellerAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"address_ids"}, new Object[]{0L}, ECQshopAddressSvr$DeleteSellerAddressReq.class);
    public final PBRepeatField<Long> address_ids = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}
