package com.qzone.publish.business.protocol;

import NS_MOBILE_EXTRA.mobile_get_urlinfo_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetUrlInfoRequest extends QZoneRequest {
    public static final String CMD_STRING = "getUrlInfo";

    public QZoneGetUrlInfoRequest(String str) {
        super(CMD_STRING);
        mobile_get_urlinfo_req mobile_get_urlinfo_reqVar = new mobile_get_urlinfo_req();
        mobile_get_urlinfo_reqVar.url = str;
        this.req = mobile_get_urlinfo_reqVar;
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
