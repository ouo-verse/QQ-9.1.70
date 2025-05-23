package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$BindProductRsp extends MessageMicro<ECQshopLogisticsTemplateSvr$BindProductRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 802}, new String[]{"retmsg", "retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{"", 0, ""}, ECQshopLogisticsTemplateSvr$BindProductRsp.class);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
}
