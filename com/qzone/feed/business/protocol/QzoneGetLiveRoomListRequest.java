package com.qzone.feed.business.protocol;

import NS_QQRADIO_KUOLIE_PROTOCOL.CommonInfo;
import NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieRecomListReq;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetLiveRoomListRequest extends QZoneRequest {
    private static final String CMD_STRING = "Liveshow.getKuolieRecomList";
    private long mStartTime;

    public QzoneGetLiveRoomListRequest(boolean z16, String str) {
        super(CMD_STRING);
        this.mStartTime = -1L;
        this.mStartTime = System.currentTimeMillis();
        CommonInfo commonInfo = new CommonInfo();
        commonInfo.cookie = "";
        commonInfo.hasMore = (byte) 0;
        commonInfo.isRefresh = convertBool2Byte(z16);
        GetKuolieRecomListReq getKuolieRecomListReq = new GetKuolieRecomListReq();
        getKuolieRecomListReq.commInfo = commonInfo;
        getKuolieRecomListReq.userId = str;
        this.req = getKuolieRecomListReq;
    }

    private byte convertBool2Byte(boolean z16) {
        return z16 ? (byte) 1 : (byte) 0;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getKuolieRecomList";
    }

    public QzoneGetLiveRoomListRequest(CommonInfo commonInfo, boolean z16, String str) {
        super(CMD_STRING);
        this.mStartTime = -1L;
        this.mStartTime = System.currentTimeMillis();
        if (commonInfo == null) {
            commonInfo = new CommonInfo();
            commonInfo.cookie = "";
            commonInfo.hasMore = (byte) 1;
        }
        commonInfo.isRefresh = convertBool2Byte(z16);
        GetKuolieRecomListReq getKuolieRecomListReq = new GetKuolieRecomListReq();
        getKuolieRecomListReq.commInfo = commonInfo;
        getKuolieRecomListReq.userId = str;
        this.req = getKuolieRecomListReq;
    }
}
