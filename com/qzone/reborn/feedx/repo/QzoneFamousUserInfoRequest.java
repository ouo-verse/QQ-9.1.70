package com.qzone.reborn.feedx.repo;

import NS_FAMOUS_SHARE.get_famous_share_req;
import NS_FAMOUS_SHARE.get_famous_share_rsp;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QzoneFamousUserInfoRequest extends QZoneRequest {
    private static final String CMD_STRING = "getFamousCoverData";

    public QzoneFamousUserInfoRequest(long j3) {
        super(CMD_STRING);
        this.req = new get_famous_share_req(j3);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public get_famous_share_rsp getResponse() {
        return (get_famous_share_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
