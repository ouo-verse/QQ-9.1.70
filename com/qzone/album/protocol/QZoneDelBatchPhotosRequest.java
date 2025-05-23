package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.del_batch_photo_req;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class QZoneDelBatchPhotosRequest extends AbsCompatRequest<Void> {
    private static final String CMD = "del_batch_photos";

    public QZoneDelBatchPhotosRequest(ArrayList<String> arrayList) {
        super(CMD);
        del_batch_photo_req del_batch_photo_reqVar = new del_batch_photo_req();
        del_batch_photo_reqVar.appid = 311;
        del_batch_photo_reqVar.vids = arrayList;
        this.req = del_batch_photo_reqVar;
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

    public QZoneDelBatchPhotosRequest(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        super(CMD);
        del_batch_photo_req del_batch_photo_reqVar = new del_batch_photo_req();
        del_batch_photo_reqVar.albumid = str;
        del_batch_photo_reqVar.picid_list = arrayList;
        del_batch_photo_reqVar.vids = arrayList2;
        this.req = del_batch_photo_reqVar;
    }
}
