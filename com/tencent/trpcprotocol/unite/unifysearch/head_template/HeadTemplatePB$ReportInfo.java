package com.tencent.trpcprotocol.unite.unifysearch.head_template;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* loaded from: classes27.dex */
public final class HeadTemplatePB$ReportInfo extends MessageMicro<HeadTemplatePB$ReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"eid", QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO}, new Object[]{"", ""}, HeadTemplatePB$ReportInfo.class);
    public final PBStringField eid = PBField.initString("");
    public final PBStringField report_info = PBField.initString("");
}
