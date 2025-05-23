package com.qzone.publish.business.protocol;

import NS_MOBILE_OPERATION.shuoshuo_video_right_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneVideoShuoShuoRightRequest extends QZoneRequest {
    private static final String FIELD_CMD = "shuoshuoVideo";

    public QZoneVideoShuoShuoRightRequest(long j3) {
        super(FIELD_CMD);
        shuoshuo_video_right_req shuoshuo_video_right_reqVar = new shuoshuo_video_right_req();
        shuoshuo_video_right_reqVar.uin = j3;
        this.req = shuoshuo_video_right_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return FIELD_CMD;
    }
}
