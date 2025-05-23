package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$UpdateOrderAddressReq extends MessageMicro<ECQshopOrderSvr$UpdateOrderAddressReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 810}, new String[]{"order_id", "address_info", WadlProxyConsts.CHANNEL, "need_latest_order", "token"}, new Object[]{"", null, 0, Boolean.FALSE, ""}, ECQshopOrderSvr$UpdateOrderAddressReq.class);
    public final PBStringField order_id = PBField.initString("");
    public ECDeliveryAddress$Address address_info = new ECDeliveryAddress$Address();
    public final PBInt32Field channel = PBField.initInt32(0);
    public final PBBoolField need_latest_order = PBField.initBool(false);
    public final PBStringField token = PBField.initString("");
}
