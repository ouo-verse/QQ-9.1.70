package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$AddSellerAddressRsp extends MessageMicro<ECQshopAddressSvr$AddSellerAddressRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "retcode", "rsp"}, new Object[]{"", 0, null}, ECQshopAddressSvr$AddSellerAddressRsp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public ECQshopAddressSvr$AddSellerAddressRspData rsp = new MessageMicro<ECQshopAddressSvr$AddSellerAddressRspData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$AddSellerAddressRspData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"address_id"}, new Object[]{0L}, ECQshopAddressSvr$AddSellerAddressRspData.class);
        public final PBInt64Field address_id = PBField.initInt64(0);
    };
}
