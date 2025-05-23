package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$AddRsp extends MessageMicro<ECQshopAddressSvr$AddRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"address_id"}, new Object[]{0L}, ECQshopAddressSvr$AddRsp.class);
    public final PBInt64Field address_id = PBField.initInt64(0);
}
