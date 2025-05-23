package com.qzone.homepage.business.protocol;

import WEBAPP_FAMOUS.GetBottomNaviReq;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetBottomNaviRequest extends QZoneRequest {
    private static final String CMD = "FamousSpace.getFamousBottomNavi";
    private static final String UNI_KEY = "getFamousBottomNavi";
    private long ownerUin;

    public QZoneGetBottomNaviRequest(long j3) {
        super(CMD);
        GetBottomNaviReq getBottomNaviReq = new GetBottomNaviReq();
        getBottomNaviReq.uin = j3;
        this.req = getBottomNaviReq;
        this.ownerUin = j3;
    }

    public long getOwnerUin() {
        return this.ownerUin;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return CMD;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }
}
