package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;

/* loaded from: classes18.dex */
public final class ReportData$ReqMqqParam extends MessageMicro<ReportData$ReqMqqParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT, "opername", "action"}, new Object[]{"", "", ""}, ReportData$ReqMqqParam.class);
    public final PBStringField department = PBField.initString("");
    public final PBStringField opername = PBField.initString("");
    public final PBStringField action = PBField.initString("");
}
