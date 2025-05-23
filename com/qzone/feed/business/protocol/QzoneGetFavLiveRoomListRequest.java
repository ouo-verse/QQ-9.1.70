package com.qzone.feed.business.protocol;

import NS_QQRADIO_KUOLIE_PROTOCOL.CommonInfo;
import NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieFavListReq;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetFavLiveRoomListRequest extends QZoneRequest {
    private static final String CMD_STRING = "Liveshow.getKuolieFavList";
    private long mStartTime;

    public QzoneGetFavLiveRoomListRequest(boolean z16, String str) {
        super(CMD_STRING);
        this.mStartTime = -1L;
        this.mStartTime = System.currentTimeMillis();
        CommonInfo commonInfo = new CommonInfo();
        commonInfo.cookie = "";
        commonInfo.hasMore = (byte) 0;
        commonInfo.isRefresh = convertBool2Byte(z16);
        GetKuolieFavListReq getKuolieFavListReq = new GetKuolieFavListReq();
        getKuolieFavListReq.commInfo = commonInfo;
        getKuolieFavListReq.userId = str;
        this.req = getKuolieFavListReq;
    }

    private static byte convertBool2Byte(boolean z16) {
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
        return "getKuolieFavList";
    }

    public QzoneGetFavLiveRoomListRequest(CommonInfo commonInfo, boolean z16, String str) {
        super(CMD_STRING);
        this.mStartTime = -1L;
        this.mStartTime = System.currentTimeMillis();
        if (commonInfo == null) {
            commonInfo = new CommonInfo();
            commonInfo.cookie = "";
            commonInfo.hasMore = (byte) 1;
        }
        commonInfo.isRefresh = convertBool2Byte(z16);
        GetKuolieFavListReq getKuolieFavListReq = new GetKuolieFavListReq();
        getKuolieFavListReq.commInfo = commonInfo;
        getKuolieFavListReq.userId = str;
        this.req = getKuolieFavListReq;
    }
}
