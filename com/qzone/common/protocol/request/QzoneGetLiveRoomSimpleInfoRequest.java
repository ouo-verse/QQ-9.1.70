package com.qzone.common.protocol.request;

import NS_QQRADIO_PROTOCOL.CommonInfo;
import NS_QQRADIO_PROTOCOL.GetLiveShowRoomInfoReq;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetLiveRoomSimpleInfoRequest extends QZoneRequest {
    private static final String CMD_STRING = "getRoomSimpleInfo";

    public QzoneGetLiveRoomSimpleInfoRequest(CommonInfo commonInfo, String str, int i3, String str2, int i16) {
        super(CMD_STRING, true);
        GetLiveShowRoomInfoReq getLiveShowRoomInfoReq = new GetLiveShowRoomInfoReq();
        getLiveShowRoomInfoReq.commonInfo = commonInfo;
        getLiveShowRoomInfoReq.roomID = str;
        getLiveShowRoomInfoReq.infoType = i3;
        getLiveShowRoomInfoReq.uid = str2;
        getLiveShowRoomInfoReq.isHlsUrlSign = i16;
        this.req = getLiveShowRoomInfoReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.Liveshow.getRoomSimpleInfo";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
