package com.qzone.personalize.music.request;

import NS_BG_VOICE_LOGIC_APP.tGetBGVoiceWebappReq;
import com.qzone.common.protocol.request.QZoneRequest;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GetBGVoiceWebappRequest extends QZoneRequest {
    public static final String CMD_STRING = "Material.GetBGVoice";
    public static final String UNIKEY_STRING = "GetBGVoice";

    public GetBGVoiceWebappRequest(long j3) {
        super(CMD_STRING);
        tGetBGVoiceWebappReq tgetbgvoicewebappreq = new tGetBGVoiceWebappReq();
        tgetbgvoicewebappreq.lLoginUin = j3;
        tgetbgvoicewebappreq.strQUA = QZoneHelper.getQUA();
        this.req = tgetbgvoicewebappreq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY_STRING;
    }
}
