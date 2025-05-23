package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$UpdateRsp extends MessageMicro<ECQshopLogisticsTemplateSvr$UpdateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 802}, new String[]{"retmsg", "retcode", "rsp", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{"", 0, null, ""}, ECQshopLogisticsTemplateSvr$UpdateRsp.class);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public ECQshopLogisticsTemplateSvr$UpdateRspData rsp = new MessageMicro<ECQshopLogisticsTemplateSvr$UpdateRspData>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$UpdateRspData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"id"}, new Object[]{0L}, ECQshopLogisticsTemplateSvr$UpdateRspData.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBInt64Field f105252id = PBField.initInt64(0);
    };
    public final PBStringField errmsg = PBField.initString("");
}
