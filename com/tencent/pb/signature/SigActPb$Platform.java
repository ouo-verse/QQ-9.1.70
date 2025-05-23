package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes22.dex */
public final class SigActPb$Platform extends MessageMicro<SigActPb$Platform> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, SigActPb$Platform.class);
    public final PBInt64Field platform = PBField.initInt64(0);
    public final PBStringField osver = PBField.initString("");
    public final PBStringField mqqver = PBField.initString("");
}
