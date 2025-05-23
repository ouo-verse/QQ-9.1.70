package com.qzone.common.protocol.request;

import NS_MOBILE_FEEDS.mobile_client_action_report_req;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneMobileClientActionReportRequest extends QZoneRequest {
    private static final String CMD_STRING = "reportClientAction";

    public QzoneMobileClientActionReportRequest(int i3, long j3, int i16, Map<String, String> map) {
        super(CMD_STRING, true);
        this.req = new mobile_client_action_report_req(i3, j3, map, i16);
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
