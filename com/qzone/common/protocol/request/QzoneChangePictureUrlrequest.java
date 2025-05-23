package com.qzone.common.protocol.request;

import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_PHOTO.ChangePicURLReq;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QzoneChangePictureUrlrequest extends QZoneRequest {
    private static final String CMD_STRING = "changePicURL";
    private static final String FIELD_CMD = "asy_photo.changePicURL";
    Map<String, Map<Integer, s_picurl>> mNewUrls;

    public QzoneChangePictureUrlrequest(ArrayList<String> arrayList, int i3) {
        setCmdString(FIELD_CMD);
        ChangePicURLReq changePicURLReq = new ChangePicURLReq();
        changePicURLReq.urls = arrayList;
        changePicURLReq.req_from = i3;
        this.req = changePicURLReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return null;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
