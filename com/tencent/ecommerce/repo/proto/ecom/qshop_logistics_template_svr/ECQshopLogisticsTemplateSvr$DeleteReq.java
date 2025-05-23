package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$DeleteReq extends MessageMicro<ECQshopLogisticsTemplateSvr$DeleteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"template_id"}, new Object[]{0L}, ECQshopLogisticsTemplateSvr$DeleteReq.class);
    public final PBInt64Field template_id = PBField.initInt64(0);
}
