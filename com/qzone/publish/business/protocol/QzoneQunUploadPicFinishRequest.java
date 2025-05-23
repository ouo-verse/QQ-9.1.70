package com.qzone.publish.business.protocol;

import NS_MOBILE_QUN.qun_upload_finish_req;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QzoneQunUploadPicFinishRequest extends QZoneRequest {
    private static final String CMD_STRING = "qunUploadFinish";

    public QzoneQunUploadPicFinishRequest() {
        super(CMD_STRING);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QzoneQunUploadPicFinishRequest(String str, long j3, String str2, int i3, int i16, String str3, int i17, int i18) {
        super(CMD_STRING);
        qun_upload_finish_req qun_upload_finish_reqVar = new qun_upload_finish_req(str, str2, j3, i3, i16, str3, null, i17, i18);
        if (qun_upload_finish_reqVar.busi_param == null) {
            qun_upload_finish_reqVar.busi_param = new HashMap();
        }
        qun_upload_finish_reqVar.busi_param.put(25, LoginData.getInstance().getNickName(l.a(R.string.s79)));
        this.req = qun_upload_finish_reqVar;
    }
}
