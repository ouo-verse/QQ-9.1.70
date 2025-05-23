package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$UnreachableArea extends MessageMicro<ECQshopLogisticsTemplateSvr$UnreachableArea> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "reason"}, new Object[]{null, null}, ECQshopLogisticsTemplateSvr$UnreachableArea.class);
    public ECQshopLogisticsTemplateSvr$Area area = new MessageMicro<ECQshopLogisticsTemplateSvr$Area>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$Area
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "name"}, new Object[]{0, ""}, ECQshopLogisticsTemplateSvr$Area.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt32Field f105249id = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
    };
    public ECQshopLogisticsTemplateSvr$Reason reason = new MessageMicro<ECQshopLogisticsTemplateSvr$Reason>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$Reason
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "content"}, new Object[]{0, ""}, ECQshopLogisticsTemplateSvr$Reason.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt32Field f105250id = PBField.initUInt32(0);
        public final PBStringField content = PBField.initString("");
    };
}
