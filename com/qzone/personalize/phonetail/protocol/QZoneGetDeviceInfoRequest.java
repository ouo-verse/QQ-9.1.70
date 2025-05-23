package com.qzone.personalize.phonetail.protocol;

import NS_MOBILE_EXTRA.GetDeviceInfoReq;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetDeviceInfoRequest extends QZoneRequest {
    public static final String CMD_STRING = "getDeviceInfo";

    public QZoneGetDeviceInfoRequest(long j3) {
        super("getDeviceInfo");
        GetDeviceInfoReq getDeviceInfoReq = new GetDeviceInfoReq();
        getDeviceInfoReq.iUin = j3;
        this.req = getDeviceInfoReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getDeviceInfo";
    }
}
