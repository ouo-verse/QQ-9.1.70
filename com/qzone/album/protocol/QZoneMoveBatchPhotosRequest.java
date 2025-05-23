package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.move_batch_photo_req;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class QZoneMoveBatchPhotosRequest extends AbsCompatRequest<Void> {
    private static final String CMD = "move_batch_photos";

    public QZoneMoveBatchPhotosRequest(String str, String str2, ArrayList<String> arrayList) {
        super(CMD);
        move_batch_photo_req move_batch_photo_reqVar = new move_batch_photo_req();
        move_batch_photo_reqVar.src_albumid = str;
        move_batch_photo_reqVar.dst_albumid = str2;
        move_batch_photo_reqVar.src_picid_list = arrayList;
        this.req = move_batch_photo_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString() + "Photo";
    }

    @Override // com.qzone.album.protocol.AbsCompatRequest
    public Void onJceRespParse(JceStruct jceStruct) throws Exception {
        return null;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD;
    }
}
