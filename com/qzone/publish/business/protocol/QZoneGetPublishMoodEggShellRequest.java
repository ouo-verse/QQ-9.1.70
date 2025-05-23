package com.qzone.publish.business.protocol;

import NS_MOBILE_OPERATION.operation_get_eggskeyword_req;
import NS_MOBILE_OPERATION.operation_get_eggskeyword_rsp;
import com.qzone.common.protocol.request.QZoneRequest;

/* loaded from: classes39.dex */
public class QZoneGetPublishMoodEggShellRequest extends QZoneRequest {
    private static final String CMD_STRING = "getShuoShuoEggsKeyWord";

    public QZoneGetPublishMoodEggShellRequest(long j3) {
        super(CMD_STRING);
        this.req = new operation_get_eggskeyword_req(j3);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public operation_get_eggskeyword_rsp getRsp() {
        return (operation_get_eggskeyword_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
