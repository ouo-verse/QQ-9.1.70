package com.qzone.commoncode.module.videorecommend.model;

import NS_MOBILE_FEEDS.mobile_video_layer_adv_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneEncourageAdvRequest extends QZoneRequest {
    private static final String CMD = "getVideoLayerAdv";
    private static final String UNI_KEY = "getVideoLayerAdv";

    public QZoneEncourageAdvRequest(long j3, Map<String, String> map) {
        super("getVideoLayerAdv");
        mobile_video_layer_adv_req mobile_video_layer_adv_reqVar = new mobile_video_layer_adv_req();
        mobile_video_layer_adv_reqVar.uin = j3;
        mobile_video_layer_adv_reqVar.mapExt = map;
        mobile_video_layer_adv_reqVar.req_type = 3;
        this.req = mobile_video_layer_adv_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "getVideoLayerAdv";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getVideoLayerAdv";
    }
}
