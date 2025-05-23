package com.qzone.personalize.phonetail.protocol;

import NS_MOBILE_EXTRA.SetUserTailReq;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSetUserTailRequest extends QZoneRequest {
    public static final String CMD_STRING = "setUserTail";

    public QZoneSetUserTailRequest(String str, String str2, int i3) {
        super(CMD_STRING);
        this.req = new SetUserTailReq(str, str2, i3);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
