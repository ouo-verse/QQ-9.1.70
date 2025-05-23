package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$CheckTemplateRsp extends MessageMicro<ECQshopLogisticsTemplateSvr$CheckTemplateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_empty"}, new Object[]{Boolean.FALSE}, ECQshopLogisticsTemplateSvr$CheckTemplateRsp.class);
    public final PBBoolField is_empty = PBField.initBool(false);
}
