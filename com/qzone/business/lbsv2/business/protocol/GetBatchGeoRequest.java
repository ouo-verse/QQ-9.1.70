package com.qzone.business.lbsv2.business.protocol;

import LBS_V2_PROTOCOL.GetBatchGeoReq_V2;
import LBS_V2_PROTOCOL.GetBatchGeoRsp_V2;
import LBS_V2_PROTOCOL.ReqCommon_V2;
import com.qzone.common.protocol.request.QZoneRequest;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GetBatchGeoRequest extends QZoneRequest {
    private static final String CMD_STRING = "getBatchGeo";
    public int eventId;

    public GetBatchGeoRequest(ArrayList<LbsDataV2.GpsInfo> arrayList, int i3) {
        super(CMD_STRING);
        this.eventId = i3;
        GetBatchGeoReq_V2 getBatchGeoReq_V2 = new GetBatchGeoReq_V2();
        ReqCommon_V2 reqCommon_V2 = new ReqCommon_V2();
        getBatchGeoReq_V2.stCommon = reqCommon_V2;
        reqCommon_V2.iAppId = 4;
        reqCommon_V2.iDeviceType = 1;
        getBatchGeoReq_V2.vecGpsInfo = new ArrayList<>();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            getBatchGeoReq_V2.vecGpsInfo.add(LbsDataV2.convertToGPS_V2(arrayList.get(i16)));
        }
        this.req = getBatchGeoReq_V2;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    public GetBatchGeoRsp_V2 getResp() {
        return (GetBatchGeoRsp_V2) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
