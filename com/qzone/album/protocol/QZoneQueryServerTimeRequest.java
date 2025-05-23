package com.qzone.album.protocol;

import NS_MOBILE_QUN.qun_get_time_req;
import NS_MOBILE_QUN.qun_get_time_rsp;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQueryServerTimeRequest extends QZoneRequest {
    public static final String CMD_STRING = "qunGetTime";

    public QZoneQueryServerTimeRequest(String str) {
        super(CMD_STRING);
        qun_get_time_req qun_get_time_reqVar = new qun_get_time_req(str);
        qun_get_time_reqVar.qunid = str;
        this.req = qun_get_time_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public qun_get_time_rsp getResponse() {
        return (qun_get_time_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
