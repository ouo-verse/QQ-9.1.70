package com.qzone.homepage.ui.Facade;

import NS_MOBILE_USERLOGO_TIMESTAMP.mobile_userlogo_timestamp_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneUserLogoTimeStampRequest extends QZoneRequest {
    public static final String CMD_STRING = "getUserLogoTimestamp";

    public QzoneUserLogoTimeStampRequest(long j3, long j16, long j17) {
        super(CMD_STRING);
        mobile_userlogo_timestamp_req mobile_userlogo_timestamp_reqVar = new mobile_userlogo_timestamp_req();
        mobile_userlogo_timestamp_reqVar.uin = j3;
        mobile_userlogo_timestamp_reqVar.last_timestamp = j17 / 1000;
        mobile_userlogo_timestamp_reqVar.pay_info_timestamp = j16;
        this.req = mobile_userlogo_timestamp_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
