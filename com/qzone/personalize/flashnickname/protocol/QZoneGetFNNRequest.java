package com.qzone.personalize.flashnickname.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_get_uimbitmap_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetFNNRequest extends QZoneRequest {
    private static final String CMD = "getNickBlinkFlag";

    public QZoneGetFNNRequest() {
        super(CMD);
        this.req = new mobile_get_uimbitmap_req();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD;
    }

    public QZoneGetFNNRequest(long j3) {
        super(CMD);
        mobile_get_uimbitmap_req mobile_get_uimbitmap_reqVar = new mobile_get_uimbitmap_req();
        mobile_get_uimbitmap_reqVar.uin = j3;
        this.req = mobile_get_uimbitmap_reqVar;
    }
}
