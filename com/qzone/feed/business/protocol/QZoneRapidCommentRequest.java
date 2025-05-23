package com.qzone.feed.business.protocol;

import NS_MOBILE_USERLOGO_TIMESTAMP.mobile_get_rc_tab_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneRapidCommentRequest extends QZoneRequest {
    private static final String CMD_STRING = "getRcTabList";

    public QZoneRapidCommentRequest(long j3) {
        super(CMD_STRING);
        mobile_get_rc_tab_req mobile_get_rc_tab_reqVar = new mobile_get_rc_tab_req();
        mobile_get_rc_tab_reqVar.last_timestamp = j3;
        this.req = mobile_get_rc_tab_reqVar;
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
