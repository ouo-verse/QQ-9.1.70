package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$GetHotRsp extends MessageMicro<ECQshopAddressSvr$GetHotRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cities"}, new Object[]{null}, ECQshopAddressSvr$GetHotRsp.class);
    public final PBRepeatMessageField<ECQshopAddressSvr$HotItem> cities = PBField.initRepeatMessage(ECQshopAddressSvr$HotItem.class);
}
