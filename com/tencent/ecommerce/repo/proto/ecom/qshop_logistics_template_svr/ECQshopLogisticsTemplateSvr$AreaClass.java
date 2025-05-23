package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$AreaClass extends MessageMicro<ECQshopLogisticsTemplateSvr$AreaClass> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"prifix", "areas"}, new Object[]{"", null}, ECQshopLogisticsTemplateSvr$AreaClass.class);
    public final PBStringField prifix = PBField.initString("");
    public final PBRepeatMessageField<ECQshopLogisticsTemplateSvr$Area> areas = PBField.initRepeatMessage(ECQshopLogisticsTemplateSvr$Area.class);
}
