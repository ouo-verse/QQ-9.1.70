package com.qzone.detail.business.protocol;

import NS_MOBILE_FEEDS.operation_topfeeds_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneSetFeedTopRequest extends QZoneRequest {
    private static final String CMD_STRING = "operTopFeeds";

    public QzoneSetFeedTopRequest(long j3, int i3, int i16, String str) {
        super(CMD_STRING);
        this.req = new operation_topfeeds_req(j3, i3, i16, str);
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
