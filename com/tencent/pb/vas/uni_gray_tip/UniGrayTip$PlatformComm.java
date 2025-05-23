package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes22.dex */
public final class UniGrayTip$PlatformComm extends MessageMicro<UniGrayTip$PlatformComm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platForm", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, UniGrayTip$PlatformComm.class);
    public final PBInt64Field platForm = PBField.initInt64(0);
    public final PBStringField osver = PBField.initString("");
    public final PBStringField mqqver = PBField.initString("");
}
