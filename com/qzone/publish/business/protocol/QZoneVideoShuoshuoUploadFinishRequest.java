package com.qzone.publish.business.protocol;

import NS_MOBILE_EXTRA.mobile_video_shuoshuo_upload_finish_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneVideoShuoshuoUploadFinishRequest extends QZoneRequest {
    private static final String CMD_STRING = "rptVSUploadFinish";

    public QZoneVideoShuoshuoUploadFinishRequest(int i3, int i16, String str) {
        super(CMD_STRING);
        mobile_video_shuoshuo_upload_finish_req mobile_video_shuoshuo_upload_finish_reqVar = new mobile_video_shuoshuo_upload_finish_req();
        mobile_video_shuoshuo_upload_finish_reqVar.iSize = i3;
        mobile_video_shuoshuo_upload_finish_reqVar.iTimeLength = i16;
        this.req = mobile_video_shuoshuo_upload_finish_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
