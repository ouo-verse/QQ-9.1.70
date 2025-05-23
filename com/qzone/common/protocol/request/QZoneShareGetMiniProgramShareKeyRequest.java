package com.qzone.common.protocol.request;

import PHOTO_OPENID_TO_QQ.GetShareKeyReq;

/* loaded from: classes39.dex */
public class QZoneShareGetMiniProgramShareKeyRequest extends QZoneRequest {
    private static final String CMD_STRING = "asy_photo.xcx_get_share_key";

    public QZoneShareGetMiniProgramShareKeyRequest(String str, long j3) {
        super(CMD_STRING);
        GetShareKeyReq getShareKeyReq = new GetShareKeyReq();
        getShareKeyReq.uin = String.valueOf(j3);
        getShareKeyReq.albumid = str;
        this.req = getShareKeyReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "xcx_get_share_key";
    }
}
