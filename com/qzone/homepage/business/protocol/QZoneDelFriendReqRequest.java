package com.qzone.homepage.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_del_friendreq_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneDelFriendReqRequest extends QZoneRequest {
    private static final String CMD_STRING = "delFriendReq";

    public QZoneDelFriendReqRequest(long j3) {
        super(CMD_STRING);
        mobile_sub_del_friendreq_req mobile_sub_del_friendreq_reqVar = new mobile_sub_del_friendreq_req();
        mobile_sub_del_friendreq_reqVar.fuin = j3;
        this.req = mobile_sub_del_friendreq_reqVar;
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
