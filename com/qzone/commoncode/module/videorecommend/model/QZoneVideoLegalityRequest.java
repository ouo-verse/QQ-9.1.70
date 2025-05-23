package com.qzone.commoncode.module.videorecommend.model;

import NS_MOBILE_VIDEO.UrlInput;
import NS_MOBILE_VIDEO.check_video_illegal_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneVideoLegalityRequest extends QZoneRequest {
    private static final String CMD_STRING = "asy_photo.checkVideoIllegal";
    private static final String UNI_KEY = "checkVideoIllegal";

    public QZoneVideoLegalityRequest(ArrayList<UrlInput> arrayList) {
        super("asy_photo.checkVideoIllegal");
        this.req = new check_video_illegal_req(arrayList);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }
}
