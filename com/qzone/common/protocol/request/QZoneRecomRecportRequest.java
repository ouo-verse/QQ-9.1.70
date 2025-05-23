package com.qzone.common.protocol.request;

import FEEDS_RECOM_REPORT.mobile_recom_report_req;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneRecomRecportRequest extends QZoneRequest {
    private static final String CMD_STRING = "feedsRecomReport";

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneRecomRecportRequest(long j3, int i3, short s16, int i16, int i17, String str, ArrayList<String> arrayList) {
        super(CMD_STRING, true);
        this.req = new mobile_recom_report_req(j3, i3, s16, i16, i17, str, arrayList);
    }
}
