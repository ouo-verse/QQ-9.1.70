package com.qzone.homepage.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_pwdright_req;
import NS_MOBILE_MAIN_PAGE.mobile_sub_pwdright_rsp;
import NS_MOBILE_MAIN_PAGE.s_pwdright;
import NS_MOBILE_MAIN_PAGE.s_user;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAnswerQuestionRequest extends QZoneRequest {
    private static final String CMD_STRING = "verifyPwdRight";

    public QZoneAnswerQuestionRequest(long j3, long j16, String str, String str2) {
        super(CMD_STRING);
        mobile_sub_pwdright_req mobile_sub_pwdright_reqVar = new mobile_sub_pwdright_req();
        mobile_sub_pwdright_reqVar.uin = j16;
        s_user s_userVar = new s_user();
        s_userVar.uin = j3;
        s_userVar.question = str;
        s_userVar.answer = str2;
        mobile_sub_pwdright_reqVar.pwdright = new s_pwdright(s_userVar);
        this.req = mobile_sub_pwdright_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public mobile_sub_pwdright_rsp getResponse() {
        return (mobile_sub_pwdright_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
