package com.tencent.mobileqq.vashealth.websso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class WebSSOAgent$UniSsoServerReqComm extends MessageMicro<WebSSOAgent$UniSsoServerReqComm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, WebSSOAgent$UniSsoServerReqComm.class);
    public final PBInt64Field platform = PBField.initInt64(0);
    public final PBStringField osver = PBField.initString("");
    public final PBStringField mqqver = PBField.initString("");
}
