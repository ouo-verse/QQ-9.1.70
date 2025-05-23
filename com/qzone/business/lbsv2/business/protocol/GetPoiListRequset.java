package com.qzone.business.lbsv2.business.protocol;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GetPoiInfoReq_V2;
import LBS_V2_PROTOCOL.GetPoiInfoRsp_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.qzone.common.protocol.request.QZoneRequest;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class GetPoiListRequset extends QZoneRequest {
    private static final String CMD_STRING = "getPoiList";

    public GetPoiListRequset(GPS_V2 gps_v2, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, String str, String str2, int i3) {
        super(CMD_STRING);
        GetPoiInfoReq_V2 getPoiInfoReq_V2 = new GetPoiInfoReq_V2();
        ReqCommon_V2 reqCommon_V2 = new ReqCommon_V2();
        reqCommon_V2.iDeviceType = 1;
        reqCommon_V2.iAppId = i3;
        getPoiInfoReq_V2.stCommon = reqCommon_V2;
        getPoiInfoReq_V2.stGps = gps_v2;
        if (gps_v2 == null) {
            getPoiInfoReq_V2.stGps = new GPS_V2();
        }
        getPoiInfoReq_V2.vCellData = arrayList;
        getPoiInfoReq_V2.vWifiData = arrayList2;
        getPoiInfoReq_V2.strKeyWord = str == null ? "" : str;
        getPoiInfoReq_V2.iDistance = 500;
        getPoiInfoReq_V2.iAccuracy = 0;
        getPoiInfoReq_V2.strAttachInfo = str2;
        this.req = getPoiInfoReq_V2;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    public GetPoiInfoRsp_V2 getResp() {
        return (GetPoiInfoRsp_V2) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public GetPoiListRequset(LbsDataV2.GpsInfo gpsInfo, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, String str, String str2, int i3) {
        super(CMD_STRING);
        GetPoiInfoReq_V2 getPoiInfoReq_V2 = new GetPoiInfoReq_V2();
        ReqCommon_V2 reqCommon_V2 = new ReqCommon_V2();
        reqCommon_V2.iDeviceType = 1;
        reqCommon_V2.iAppId = i3;
        getPoiInfoReq_V2.stCommon = reqCommon_V2;
        GPS_V2 convertToGPS_V2 = LbsDataV2.convertToGPS_V2(gpsInfo);
        getPoiInfoReq_V2.stGps = convertToGPS_V2;
        if (convertToGPS_V2 == null) {
            getPoiInfoReq_V2.stGps = new GPS_V2();
        }
        getPoiInfoReq_V2.vCellData = arrayList;
        getPoiInfoReq_V2.vWifiData = arrayList2;
        getPoiInfoReq_V2.strKeyWord = str == null ? "" : str;
        getPoiInfoReq_V2.iDistance = 500;
        getPoiInfoReq_V2.iAccuracy = 0;
        getPoiInfoReq_V2.strAttachInfo = str2;
        this.req = getPoiInfoReq_V2;
    }
}
