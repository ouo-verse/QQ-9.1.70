package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$GetEcommerceCenterAddressRsp extends MessageMicro<ECWindowInfoSvr$GetEcommerceCenterAddressRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ecommerce_center_url"}, new Object[]{""}, ECWindowInfoSvr$GetEcommerceCenterAddressRsp.class);
    public final PBStringField ecommerce_center_url = PBField.initString("");
}
