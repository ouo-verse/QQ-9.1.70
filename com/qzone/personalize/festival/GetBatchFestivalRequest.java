package com.qzone.personalize.festival;

import NS_QZONE_FESTIVAL.FestivalGetReq;
import NS_QZONE_FESTIVAL.FestivalGetRsp;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GetBatchFestivalRequest extends QZoneRequest {
    private static final String CMD_STRING = "getFestival";
    public int eventId;

    public GetBatchFestivalRequest(ArrayList<FestivalReqItemInfo> arrayList, int i3) {
        super(CMD_STRING);
        FestivalGetReq festivalGetReq = new FestivalGetReq();
        festivalGetReq._vec_festivals = new ArrayList<>();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            FestivalReqItemInfo festivalReqItemInfo = arrayList.get(i16);
            if (festivalReqItemInfo != null) {
                festivalGetReq._vec_festivals.add(FestivalReqItemInfo.convertToProtoReqItem(festivalReqItemInfo));
            }
        }
        this.req = festivalGetReq;
        this.eventId = i3;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    public FestivalGetRsp getResp() {
        return (FestivalGetRsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
