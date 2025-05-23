package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.active_photo;
import NS_MOBILE_PHOTO.modify_active_album_req;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneModifyDynamicRequest extends QZoneRequest {
    private static final String CMD_STRING = "asy_photo.ModifyActiveAlbum";

    public QZoneModifyDynamicRequest() {
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "ModifyActiveAlbum";
    }

    public QZoneModifyDynamicRequest(String str, ArrayList<active_photo> arrayList, Map<String, String> map, shuoshuo_privacy shuoshuo_privacyVar, long j3) {
        super(CMD_STRING, true);
        modify_active_album_req modify_active_album_reqVar = new modify_active_album_req();
        modify_active_album_reqVar.uin = LoginData.getInstance().getUin();
        modify_active_album_reqVar.added_photo = arrayList;
        modify_active_album_reqVar.map_params = map;
        modify_active_album_reqVar.ss_info = shuoshuo_privacyVar;
        modify_active_album_reqVar.mgz_id = str;
        modify_active_album_reqVar.pic_total = j3;
        this.req = modify_active_album_reqVar;
    }
}
