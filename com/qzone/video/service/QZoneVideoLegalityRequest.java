package com.qzone.video.service;

import NS_MOBILE_VIDEO.UrlInput;
import NS_MOBILE_VIDEO.check_video_illegal_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneVideoLegalityRequest extends QZoneRequest {
    public static final String CMD_STRING = "asy_photo.checkVideoIllegal";

    public QZoneVideoLegalityRequest(ArrayList<UrlInput> arrayList) {
        super(CMD_STRING);
        this.req = new check_video_illegal_req(arrayList);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "checkVideoIllegal";
    }
}
