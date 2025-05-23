package com.qzone.detail.business.protocol;

import NS_MOBILE_OPERATION.operation_hide_feeds_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZonehideSingleFeedRequest extends QZoneRequest {
    private static final String CMD_STRING = "hideFeeds";

    public QZonehideSingleFeedRequest(String str, long j3, long j16) {
        super(CMD_STRING);
        this.req = new operation_hide_feeds_req(str, j3, j16);
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
