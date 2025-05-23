package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$SetDefaultSellerAddressRsp extends MessageMicro<ECQshopAddressSvr$SetDefaultSellerAddressRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "retcode"}, new Object[]{"", 0}, ECQshopAddressSvr$SetDefaultSellerAddressRsp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
}
