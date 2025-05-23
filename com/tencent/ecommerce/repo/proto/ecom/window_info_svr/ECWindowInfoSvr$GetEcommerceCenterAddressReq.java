package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$GetEcommerceCenterAddressReq extends MessageMicro<ECWindowInfoSvr$GetEcommerceCenterAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"req_source"}, new Object[]{0}, ECWindowInfoSvr$GetEcommerceCenterAddressReq.class);
    public final PBUInt32Field req_source = PBField.initUInt32(0);
}
