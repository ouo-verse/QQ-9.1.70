package com.qzone.common.protocol.request;

import NS_MOBILE_EXTRA.mobile_video_adapter_req;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneAdaptVideoRequest extends QZoneRequest {
    public static final String CMD_STRING_ADAPTVIDEO = "adaptVideo";

    public QzoneAdaptVideoRequest(String str, int i3, String str2) {
        super(CMD_STRING_ADAPTVIDEO);
        mobile_video_adapter_req mobile_video_adapter_reqVar = new mobile_video_adapter_req();
        mobile_video_adapter_reqVar.strVideoUrl = str;
        mobile_video_adapter_reqVar.iFlash = i3;
        mobile_video_adapter_reqVar.strUserAgent = str2;
        this.req = mobile_video_adapter_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING_ADAPTVIDEO;
    }
}
