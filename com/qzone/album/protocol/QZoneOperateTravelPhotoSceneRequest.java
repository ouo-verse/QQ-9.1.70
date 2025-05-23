package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.modify_travel_photo_scence;
import NS_MOBILE_PHOTO.modify_travel_photo_scence_req;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.PhotoPoiArea;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneOperateTravelPhotoSceneRequest extends AbsCompatRequest<Void> {
    private static final String CMD = "asy_photo.modTravelScence";
    private static final String UIN_KEY = "modTravelScence";
    public boolean singleNodeModify;

    public QZoneOperateTravelPhotoSceneRequest(String str, int i3, PhotoPoiArea photoPoiArea, long j3, ArrayList<modify_travel_photo_scence> arrayList, Map<String, EditPhoto> map) {
        super(CMD);
        this.singleNodeModify = true;
        modify_travel_photo_scence_req modify_travel_photo_scence_reqVar = new modify_travel_photo_scence_req();
        modify_travel_photo_scence_reqVar.albumid = str;
        modify_travel_photo_scence_reqVar.opetype = i3;
        modify_travel_photo_scence_reqVar.poi = PhotoPoiArea.convertToRequest(photoPoiArea);
        modify_travel_photo_scence_reqVar.poi_area_start_time = j3;
        modify_travel_photo_scence_reqVar.scence = arrayList;
        modify_travel_photo_scence_reqVar.picid_time_list = map;
        this.req = modify_travel_photo_scence_reqVar;
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
}
