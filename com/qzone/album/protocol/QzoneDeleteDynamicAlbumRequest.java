package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.delete_active_album_req;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDeleteDynamicAlbumRequest extends QZoneRequest {
    private static final String CMD_STRING = "asy_photo.DeleteActiveAlbum";

    public QzoneDeleteDynamicAlbumRequest(String str, Map<String, String> map) {
        super(CMD_STRING, true);
        delete_active_album_req delete_active_album_reqVar = new delete_active_album_req();
        delete_active_album_reqVar.uin = LoginData.getInstance().getUin();
        delete_active_album_reqVar.mgz_id = str;
        delete_active_album_reqVar.map_params = map;
        this.req = delete_active_album_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "DeleteActiveAlbum";
    }
}
