package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$CheckShipStatusReq extends MessageMicro<ECQshopLogisticsTemplateSvr$CheckShipStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"spu_id", "address"}, new Object[]{"", null}, ECQshopLogisticsTemplateSvr$CheckShipStatusReq.class);
    public final PBStringField spu_id = PBField.initString("");
    public ECDeliveryAddress$Address address = new ECDeliveryAddress$Address();
}
