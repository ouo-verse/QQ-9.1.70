package com.qzone.personalize.descriptionsetting.protocol;

import NS_MOBILE_EXTRA.mobile_get_profile_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* loaded from: classes39.dex */
public class QZoneGetProfileRequest extends QZoneRequest {
    private static final String CMD_STRING = "getProfile";

    public QZoneGetProfileRequest(long j3) {
        super(CMD_STRING);
        mobile_get_profile_req mobile_get_profile_reqVar = new mobile_get_profile_req();
        mobile_get_profile_reqVar.uin = j3;
        this.req = mobile_get_profile_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
