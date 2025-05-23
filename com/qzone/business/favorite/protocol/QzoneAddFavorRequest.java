package com.qzone.business.favorite.protocol;

import NS_MOBILE_OPERATION.PhotoInformation;
import NS_MOBILE_OPERATION.operation_addfavour_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneAddFavorRequest extends QZoneRequest {
    public static final String CMD_STRING = "addFav";

    public QzoneAddFavorRequest(long j3, long j16, long j17, String str, String str2, String str3, ArrayList<PhotoInformation> arrayList, String str4, HashMap<String, String> hashMap) {
        super(CMD_STRING);
        operation_addfavour_req operation_addfavour_reqVar = new operation_addfavour_req();
        operation_addfavour_reqVar.owner_uin = j3;
        operation_addfavour_reqVar.appid = j16;
        operation_addfavour_reqVar.subid = j17;
        operation_addfavour_reqVar.cellid = str;
        operation_addfavour_reqVar.sid = str2;
        operation_addfavour_reqVar.ugc_key = str3;
        operation_addfavour_reqVar.photo_url = arrayList;
        operation_addfavour_reqVar.text = str4;
        operation_addfavour_reqVar.busi_params = hashMap;
        this.req = operation_addfavour_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return getRequestCmd();
    }

    public QzoneAddFavorRequest() {
    }
}
