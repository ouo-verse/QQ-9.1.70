package com.qzone.feed.business.protocol;

import NS_MOBILE_FEEDS.mobile_ranking_feeds_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetFrdVideoRecommRequest extends QZoneRequest {
    private static final String CMD_STRING = "Feeds.getOperaRankFeeds";
    public static String TAG = "com.qzone.feed.business.protocol.QZoneGetFrdVideoRecommRequest";
    private static final String UNIKEY = "getOperaRankFeeds";

    public QZoneGetFrdVideoRecommRequest(long j3, int i3, Map<String, String> map, Map<Integer, byte[]> map2) {
        super(CMD_STRING);
        this.req = new mobile_ranking_feeds_req(j3, i3, map, map2);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY;
    }
}
