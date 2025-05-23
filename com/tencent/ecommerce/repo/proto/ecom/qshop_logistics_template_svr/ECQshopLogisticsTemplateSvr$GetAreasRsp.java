package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$GetAreasRsp extends MessageMicro<ECQshopLogisticsTemplateSvr$GetAreasRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 802}, new String[]{"retmsg", "retcode", "rsp", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{"", 0, null, ""}, ECQshopLogisticsTemplateSvr$GetAreasRsp.class);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public ECQshopLogisticsTemplateSvr$GetAreasRspData rsp = new MessageMicro<ECQshopLogisticsTemplateSvr$GetAreasRspData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$GetAreasRspData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"area_classes"}, new Object[]{null}, ECQshopLogisticsTemplateSvr$GetAreasRspData.class);
        public final PBRepeatMessageField<ECQshopLogisticsTemplateSvr$AreaClass> area_classes = PBField.initRepeatMessage(ECQshopLogisticsTemplateSvr$AreaClass.class);
    };
    public final PBStringField errmsg = PBField.initString("");
}
