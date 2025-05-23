package com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$SellerAddress;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopAddressSvr$GetSellerAddressAllRsp extends MessageMicro<ECQshopAddressSvr$GetSellerAddressAllRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "retcode", "rsp"}, new Object[]{"", 0, null}, ECQshopAddressSvr$GetSellerAddressAllRsp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public ECQshopAddressSvr$GetSellerAddressAllRspData rsp = new MessageMicro<ECQshopAddressSvr$GetSellerAddressAllRspData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_address_svr.ECQshopAddressSvr$GetSellerAddressAllRspData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"address_list", "total_num"}, new Object[]{null, 0}, ECQshopAddressSvr$GetSellerAddressAllRspData.class);
        public final PBRepeatMessageField<ECDeliveryAddress$SellerAddress> address_list = PBField.initRepeatMessage(ECDeliveryAddress$SellerAddress.class);
        public final PBUInt32Field total_num = PBField.initUInt32(0);
    };
}
