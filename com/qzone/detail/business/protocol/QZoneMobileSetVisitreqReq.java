package com.qzone.detail.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_set_visitreq_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneMobileSetVisitreqReq extends QZoneRequest {
    private static final String CMD_STRING = "setVisitReq";

    public QZoneMobileSetVisitreqReq(int i3, long j3, String str) {
        super(CMD_STRING);
        this.req = new mobile_set_visitreq_req(i3, j3, str);
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
