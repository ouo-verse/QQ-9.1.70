package com.qzone.feed.business.protocol;

import NS_MOBILE_FEEDS.mobile_client_action_report_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQQStoryClearNotReadRequest extends QZoneRequest {
    private static final String CMD_STRING = "ClearUnreadVideo";

    public QZoneQQStoryClearNotReadRequest(int i3, long j3, int i16, Map<String, String> map) {
        super(CMD_STRING, true);
        this.req = new mobile_client_action_report_req(i3, j3, map, i16);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.Feeds.ClearUnreadVideo";
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
