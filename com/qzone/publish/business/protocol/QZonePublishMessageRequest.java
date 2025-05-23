package com.qzone.publish.business.protocol;

import NS_MOBILE_OPERATION.operation_publishmessage_req;
import NS_MOBILE_OPERATION.operation_publishmessage_rsp;
import com.qzone.common.protocol.request.QZoneRequest;

/* loaded from: classes39.dex */
public class QZonePublishMessageRequest extends QZoneRequest {
    private static final String CMD_STRING = "publishmess";

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public operation_publishmessage_rsp getRsp() {
        return (operation_publishmessage_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZonePublishMessageRequest(long j3, long j16, String str, int i3) {
        super(CMD_STRING);
        this.req = new operation_publishmessage_req(j3, j16, str, true, 0, null, null, i3);
    }
}
