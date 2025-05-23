package com.qzone.common.protocol.request;

import WUP_SECRET_UGC.DelUgcTopicReq;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDeleteSecretFeedRequest extends QZoneRequest {
    private static final String CMD_STRING = "DelUgcTopic";

    public QzoneDeleteSecretFeedRequest(String str) {
        super(CMD_STRING);
        DelUgcTopicReq delUgcTopicReq = new DelUgcTopicReq();
        delUgcTopicReq.ugc_id = str;
        this.req = delUgcTopicReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "Secret.DelUgcTopic";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
