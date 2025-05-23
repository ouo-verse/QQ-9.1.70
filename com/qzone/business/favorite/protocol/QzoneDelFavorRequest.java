package com.qzone.business.favorite.protocol;

import NS_MOBILE_OPERATION.operation_delfavour_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDelFavorRequest extends QZoneRequest {
    public static final String CMD_STRING = "delFav";

    public QzoneDelFavorRequest(long j3, String str, long j16, long j17) {
        super(CMD_STRING);
        operation_delfavour_req operation_delfavour_reqVar = new operation_delfavour_req();
        operation_delfavour_reqVar.uin = j3;
        operation_delfavour_reqVar.vecFavID = str;
        operation_delfavour_reqVar.appid = j16;
        operation_delfavour_reqVar.subid = j17;
        this.req = operation_delfavour_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return getRequestCmd();
    }

    public QzoneDelFavorRequest() {
    }
}
