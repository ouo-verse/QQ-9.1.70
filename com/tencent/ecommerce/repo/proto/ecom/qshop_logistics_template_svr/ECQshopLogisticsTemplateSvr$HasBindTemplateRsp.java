package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$HasBindTemplateRsp extends MessageMicro<ECQshopLogisticsTemplateSvr$HasBindTemplateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"has_bind"}, new Object[]{Boolean.FALSE}, ECQshopLogisticsTemplateSvr$HasBindTemplateRsp.class);
    public final PBBoolField has_bind = PBField.initBool(false);
}
