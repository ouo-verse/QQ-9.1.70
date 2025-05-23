package com.qzone.album.qun.business.protocol;

import NS_MOBILE_QUN.qun_get_batch_photo_req;
import NS_MOBILE_QUN.qun_get_photo_list_rsp;
import com.qzone.common.protocol.request.QZoneRequest;

/* loaded from: classes39.dex */
public class QZoneQunBatchPhotoRequest extends QZoneRequest {
    private static final String CMD_STRING = "qunGetBatchPhoto";

    public QZoneQunBatchPhotoRequest(String str, String str2, String str3, int i3, String str4) {
        super(CMD_STRING);
        qun_get_batch_photo_req qun_get_batch_photo_reqVar = new qun_get_batch_photo_req();
        qun_get_batch_photo_reqVar.qunid = str;
        qun_get_batch_photo_reqVar.albumid = str2;
        qun_get_batch_photo_reqVar.batchid = str3;
        qun_get_batch_photo_reqVar.count = i3;
        qun_get_batch_photo_reqVar.attach_info = str4 == null ? "" : str4;
        this.req = qun_get_batch_photo_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString() + "QunPhoto";
    }

    public qun_get_photo_list_rsp getResp() {
        return (qun_get_photo_list_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
