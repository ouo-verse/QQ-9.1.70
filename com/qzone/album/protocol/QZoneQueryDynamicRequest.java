package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.active_photo;
import NS_MOBILE_PHOTO.publish_active_album_req;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQueryDynamicRequest extends QZoneRequest {
    private static final String CMD_STRING = "asy_photo.CreateActiveAlbum";

    public QZoneQueryDynamicRequest() {
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "CreateActiveAlbum";
    }

    public QZoneQueryDynamicRequest(ArrayList<active_photo> arrayList, Map<String, String> map, shuoshuo_privacy shuoshuo_privacyVar, long j3, long j16) {
        super(CMD_STRING, true);
        publish_active_album_req publish_active_album_reqVar = new publish_active_album_req();
        publish_active_album_reqVar.uin = j16;
        publish_active_album_reqVar.added_photo = arrayList;
        publish_active_album_reqVar.map_params = map;
        publish_active_album_reqVar.ss_info = shuoshuo_privacyVar;
        publish_active_album_reqVar.pic_total = j3;
        this.req = publish_active_album_reqVar;
    }
}
