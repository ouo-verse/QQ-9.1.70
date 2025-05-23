package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.edit_batch_photo_req;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneAlbumSortPhotoRequest extends AbsCompatRequest<Void> {
    private static final String CMD_STRING = "asy_photo.editPhoto";
    private static final String UIN_KEY = "editPhoto";

    public QZoneAlbumSortPhotoRequest(String str, ArrayList<String> arrayList, int i3, Map<Integer, String> map) {
        super(CMD_STRING);
        edit_batch_photo_req edit_batch_photo_reqVar = new edit_batch_photo_req();
        edit_batch_photo_reqVar.albumid = str;
        edit_batch_photo_reqVar.busi_param = map;
        EditPhoto editPhoto = new EditPhoto();
        edit_batch_photo_reqVar.PhotoInfo = editPhoto;
        editPhoto.modifytime = i3;
        edit_batch_photo_reqVar.picid_list = arrayList;
        this.req = edit_batch_photo_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.album.protocol.AbsCompatRequest
    public Void onJceRespParse(JceStruct jceStruct) throws Exception {
        return null;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UIN_KEY;
    }

    public QZoneAlbumSortPhotoRequest(String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, Map<String, EditPhoto> map2) {
        super(CMD_STRING);
        edit_batch_photo_req edit_batch_photo_reqVar = new edit_batch_photo_req();
        edit_batch_photo_reqVar.albumid = str;
        edit_batch_photo_reqVar.picid_list = arrayList;
        edit_batch_photo_reqVar.PhotoInfo = editPhoto;
        edit_batch_photo_reqVar.operatype = i3;
        edit_batch_photo_reqVar.busi_param = map;
        edit_batch_photo_reqVar.picid_time_list = map2;
        this.req = edit_batch_photo_reqVar;
    }
}
