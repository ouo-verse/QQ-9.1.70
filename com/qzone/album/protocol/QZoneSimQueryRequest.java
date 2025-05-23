package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.query_order_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSimQueryRequest extends QZoneRequest {
    private static final String CMD = "Feeds.queryOrderCard";
    private static final String UNI_KEY = "queryOrderCard";

    public QZoneSimQueryRequest(long j3, String str, String str2) {
        super(CMD);
        this.req = new query_order_req(j3, str, str2, null);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return CMD;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }
}
