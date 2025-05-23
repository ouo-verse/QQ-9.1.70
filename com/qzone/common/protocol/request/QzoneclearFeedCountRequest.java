package com.qzone.common.protocol.request;

import NS_UNDEAL_COUNT.clear_count_req;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneclearFeedCountRequest extends QZoneRequest {
    public static final String CMD_STRING = "clearFeedCount";

    public QzoneclearFeedCountRequest(String str) {
        super(CMD_STRING, true);
        clear_count_req clear_count_reqVar = new clear_count_req();
        clear_count_reqVar.clearType = 1;
        clear_count_reqVar.LastUndealCountTime = str;
        this.req = clear_count_reqVar;
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
