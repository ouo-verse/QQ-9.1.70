package com.qzone.proxy.feedcomponent.adapter.feedreport.protocol;

import ELABORATE_FEED_REPORT.elaborate_feed_report_req;
import ELABORATE_FEED_REPORT.session_report;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneElaborateFeedReportRequest extends QZoneRequest {
    private static final String CMD_STRING = "elaborateFeedReport";

    public QzoneElaborateFeedReportRequest(ArrayList<session_report> arrayList) {
        super(CMD_STRING);
        this.req = new elaborate_feed_report_req(arrayList);
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
