package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$HasBindTemplateReq extends MessageMicro<ECQshopLogisticsTemplateSvr$HasBindTemplateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"address_id"}, new Object[]{0}, ECQshopLogisticsTemplateSvr$HasBindTemplateReq.class);
    public final PBUInt32Field address_id = PBField.initUInt32(0);
}
