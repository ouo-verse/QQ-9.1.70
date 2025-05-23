package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$GetListRsp extends MessageMicro<ECQshopAddressSvr$GetListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"address_list", "total_num"}, new Object[]{null, 0}, ECQshopAddressSvr$GetListRsp.class);
    public final PBRepeatMessageField<ECDeliveryAddress$Address> address_list = PBField.initRepeatMessage(ECDeliveryAddress$Address.class);
    public final PBUInt32Field total_num = PBField.initUInt32(0);
}
