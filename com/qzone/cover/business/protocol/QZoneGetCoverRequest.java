package com.qzone.cover.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetCoverRequest extends QZoneRequest {
    private static final String CMD_STRING = "getCover";

    public QZoneGetCoverRequest(long j3, boolean z16) {
        super("getCover");
        mobile_sub_get_cover_req mobile_sub_get_cover_reqVar = new mobile_sub_get_cover_req();
        mobile_sub_get_cover_reqVar.uin = j3;
        mobile_sub_get_cover_reqVar.flag = z16 ? 1 : 0;
        this.req = mobile_sub_get_cover_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getCover";
    }
}
