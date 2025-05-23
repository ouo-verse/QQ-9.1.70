package com.qzone.album.protocol;

import NS_MOBILE_VIDEO.change_vkey_req;
import NS_MOBILE_VIDEO.change_vkey_rsp;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneChangeVideoVkeyRequest extends QZoneRequest {
    private static final String CMD = "asy_photo.changeVideoVkey";
    private static final String UNI_KEY = "changeVideoVkey";

    public QZoneChangeVideoVkeyRequest(String str) {
        super(CMD);
        change_vkey_req change_vkey_reqVar = new change_vkey_req();
        ArrayList<String> arrayList = new ArrayList<>();
        change_vkey_reqVar.video_urls = arrayList;
        arrayList.add(str);
        this.req = change_vkey_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return CMD;
    }

    public change_vkey_rsp getResp() {
        return (change_vkey_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }
}
