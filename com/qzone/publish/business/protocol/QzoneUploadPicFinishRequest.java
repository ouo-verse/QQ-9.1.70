package com.qzone.publish.business.protocol;

import NS_MOBILE_PHOTO.upload_finish_req;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QzoneUploadPicFinishRequest extends QZoneRequest {
    private static final String CMD_STRING = "rptUploadFinish";

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QzoneUploadPicFinishRequest(long j3, String str, int i3, int i16, int i17, String str2, int i18) {
        super(CMD_STRING);
        boolean isEmpty = TextUtils.isEmpty(str);
        upload_finish_req upload_finish_reqVar = new upload_finish_req(j3, !isEmpty ? 1 : 0, isEmpty ? 1L : 0L, str, i3, i16, null, i17, str2);
        if (upload_finish_reqVar.busi_param == null) {
            upload_finish_reqVar.busi_param = new HashMap();
        }
        upload_finish_reqVar.busi_param.put(25, LoginData.getInstance().getNickName(l.a(R.string.s_p)));
        upload_finish_reqVar.busi_param.put(41, "quickpic_use=" + i18);
        upload_finish_reqVar.busi_param.put(32, Integer.toString(LoginData.getInstance().getVipLevel()));
        upload_finish_reqVar.busi_param.put(33, Integer.toString(LoginData.getInstance().getUserType()));
        this.req = upload_finish_reqVar;
    }
}
