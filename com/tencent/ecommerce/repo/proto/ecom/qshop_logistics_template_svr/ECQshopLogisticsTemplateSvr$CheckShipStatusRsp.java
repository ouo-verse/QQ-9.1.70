package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$Bulletin;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$CheckShipStatusRsp extends MessageMicro<ECQshopLogisticsTemplateSvr$CheckShipStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField enable_shiped = PBField.initBool(false);
    public final PBBoolField show_bulletin = PBField.initBool(false);
    public ECOrderInfo$Bulletin bulletin = new ECOrderInfo$Bulletin();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 80, 90}, new String[]{"enable_shiped", "show_bulletin", "bulletin"}, new Object[]{bool, bool, null}, ECQshopLogisticsTemplateSvr$CheckShipStatusRsp.class);
    }
}
