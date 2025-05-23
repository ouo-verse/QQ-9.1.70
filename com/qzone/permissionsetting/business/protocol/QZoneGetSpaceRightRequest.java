package com.qzone.permissionsetting.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_getspaceright_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetSpaceRightRequest extends QZoneRequest {
    private static final String GET_SPACE_RIGHT_CMD = "getspaceright";

    public QZoneGetSpaceRightRequest(long j3) {
        super(GET_SPACE_RIGHT_CMD);
        mobile_sub_getspaceright_req mobile_sub_getspaceright_reqVar = new mobile_sub_getspaceright_req();
        mobile_sub_getspaceright_reqVar.uin = j3;
        mobile_sub_getspaceright_reqVar.getDetail = 0;
        this.req = mobile_sub_getspaceright_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return GET_SPACE_RIGHT_CMD;
    }

    public QZoneGetSpaceRightRequest(long j3, boolean z16) {
        super(GET_SPACE_RIGHT_CMD);
        mobile_sub_getspaceright_req mobile_sub_getspaceright_reqVar = new mobile_sub_getspaceright_req();
        mobile_sub_getspaceright_reqVar.uin = j3;
        mobile_sub_getspaceright_reqVar.getDetail = z16 ? 1 : 0;
        this.req = mobile_sub_getspaceright_reqVar;
    }
}
