package com.qzone.feed.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_visit_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetVisitNotifyRequest extends QZoneRequest {
    private static final String CMD_STRING = "getVisitorNotify";

    public QZoneGetVisitNotifyRequest(long j3, String str) {
        super(CMD_STRING);
        this.req = new mobile_sub_get_visit_req(j3, str);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneGetVisitNotifyRequest(String str, boolean z16) {
        super(str, z16);
    }

    public QZoneGetVisitNotifyRequest() {
    }
}
