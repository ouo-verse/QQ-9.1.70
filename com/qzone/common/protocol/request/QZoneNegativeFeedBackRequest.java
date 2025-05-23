package com.qzone.common.protocol.request;

import NS_MOBILE_DROPLIST.mobile_video_nag_feedback_req;
import NS_MOBILE_DROPLIST.nagative_fb_info;
import com.qzone.common.account.LoginData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneNegativeFeedBackRequest extends QZoneRequest {
    private static final String CMD_STRING = "Operation.videoNagFeedback";

    public QZoneNegativeFeedBackRequest(long j3, ArrayList<nagative_fb_info> arrayList) {
        super(CMD_STRING, true);
        mobile_video_nag_feedback_req mobile_video_nag_feedback_reqVar = new mobile_video_nag_feedback_req();
        mobile_video_nag_feedback_reqVar.loginUin = LoginData.getInstance().getUin();
        mobile_video_nag_feedback_reqVar.feedsUin = j3;
        mobile_video_nag_feedback_reqVar.vecNagFbInfo = arrayList;
        this.req = mobile_video_nag_feedback_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "videoNagFeedback";
    }
}
