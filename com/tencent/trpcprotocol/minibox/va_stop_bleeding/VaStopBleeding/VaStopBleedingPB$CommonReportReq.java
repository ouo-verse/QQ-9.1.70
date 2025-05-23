package com.tencent.trpcprotocol.minibox.va_stop_bleeding.VaStopBleeding;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class VaStopBleedingPB$CommonReportReq extends MessageMicro<VaStopBleedingPB$CommonReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"appid", "app_version", "app_new_version", "event_name", "event_data"}, new Object[]{"", "", "", "", ""}, VaStopBleedingPB$CommonReportReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");
    public final PBStringField app_new_version = PBField.initString("");
    public final PBStringField event_name = PBField.initString("");
    public final PBStringField event_data = PBField.initString("");
}
