package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$GetListRsp extends MessageMicro<ECQshopLogisticsTemplateSvr$GetListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 802}, new String[]{"retmsg", "retcode", "rsp", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{"", 0, null, ""}, ECQshopLogisticsTemplateSvr$GetListRsp.class);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public ECQshopLogisticsTemplateSvr$GetListRspData rsp = new MessageMicro<ECQshopLogisticsTemplateSvr$GetListRspData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$GetListRspData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{DKConfiguration.Directory.TEMPLATES, "total_count"}, new Object[]{null, 0}, ECQshopLogisticsTemplateSvr$GetListRspData.class);
        public final PBRepeatMessageField<ECQshopLogisticsTemplateSvr$Template> templates = PBField.initRepeatMessage(ECQshopLogisticsTemplateSvr$Template.class);
        public final PBUInt32Field total_count = PBField.initUInt32(0);
    };
    public final PBStringField errmsg = PBField.initString("");
}
