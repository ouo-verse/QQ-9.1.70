package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes22.dex */
public final class PPCLoginAuth$plat_info extends MessageMicro<PPCLoginAuth$plat_info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"implat", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, PPCLoginAuth$plat_info.class);
    public final PBInt64Field implat = PBField.initInt64(0);
    public final PBStringField osver = PBField.initString("");
    public final PBStringField mqqver = PBField.initString("");
}
