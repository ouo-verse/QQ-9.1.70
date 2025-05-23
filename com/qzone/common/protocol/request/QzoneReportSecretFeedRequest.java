package com.qzone.common.protocol.request;

import WUP_SECRET_UGC.ReportUgcTopicReq;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneReportSecretFeedRequest extends QZoneRequest {
    private static final String CMD_STRING = "ReportUgcTopic";

    public QzoneReportSecretFeedRequest(String str, String str2) {
        super(CMD_STRING);
        ReportUgcTopicReq reportUgcTopicReq = new ReportUgcTopicReq();
        reportUgcTopicReq.ugc_id = str;
        reportUgcTopicReq.content = str2;
        reportUgcTopicReq.time = 0L;
        this.req = reportUgcTopicReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "Secret.ReportUgcTopic";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
