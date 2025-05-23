package com.qzone.homepage.business.protocol;

import NS_MOBILE_INVTRSTQZONE.InviteRegistQzoneReq;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneInviteOpenUpRequest extends QZoneRequest {
    private static final String CMD_STRING = "inviteRegistQzone";

    public QZoneInviteOpenUpRequest(long j3, long j16) {
        super(CMD_STRING);
        InviteRegistQzoneReq inviteRegistQzoneReq = new InviteRegistQzoneReq();
        inviteRegistQzoneReq.iHostUin = j3;
        inviteRegistQzoneReq.iInviteUin = j16;
        this.req = inviteRegistQzoneReq;
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
