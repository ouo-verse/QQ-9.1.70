package com.qzone.business.lbsv2.business.protocol;

import LBS_V2_PROTOCOL.GetBatchPoiReq_V2;
import LBS_V2_PROTOCOL.GetBatchPoiRsp_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import com.qzone.common.protocol.request.QZoneRequest;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class GetBatchPoiRequest extends QZoneRequest {
    private static final String CMD_STRING = "getBatchPoi";
    public int eventId;

    public GetBatchPoiRequest(ArrayList<LbsDataV2.GpsInfo> arrayList, int i3, int i16, Map<String, String> map, boolean z16) {
        super(CMD_STRING);
        this.eventId = i16;
        GetBatchPoiReq_V2 getBatchPoiReq_V2 = new GetBatchPoiReq_V2();
        ReqCommon_V2 reqCommon_V2 = new ReqCommon_V2();
        getBatchPoiReq_V2.stCommon = reqCommon_V2;
        reqCommon_V2.iAppId = i3;
        reqCommon_V2.iDeviceType = 1;
        getBatchPoiReq_V2.vecGpsInfo = new ArrayList<>();
        if (map != null) {
            getBatchPoiReq_V2.map_ext = map;
        }
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            getBatchPoiReq_V2.vecGpsInfo.add(LbsDataV2.convertToGPS_V2(arrayList.get(i17)));
        }
        if (z16) {
            getBatchPoiReq_V2.opMask = 10;
        } else {
            getBatchPoiReq_V2.opMask = 1;
        }
        this.req = getBatchPoiReq_V2;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    public GetBatchPoiRsp_V2 getResp() {
        return (GetBatchPoiRsp_V2) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
