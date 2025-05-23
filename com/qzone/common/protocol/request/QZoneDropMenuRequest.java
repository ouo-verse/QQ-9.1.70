package com.qzone.common.protocol.request;

import NS_MOBILE_DROPLIST.mobile_droplist_operate_req;
import com.qzone.common.account.LoginData;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneDropMenuRequest extends QZoneRequest {
    private static final String CMD_STRING = "Operation.opDroplist";

    public QZoneDropMenuRequest(long j3, int i3, Map<Integer, String> map) {
        super(CMD_STRING, true);
        mobile_droplist_operate_req mobile_droplist_operate_reqVar = new mobile_droplist_operate_req();
        mobile_droplist_operate_reqVar.login_uin = LoginData.getInstance().getUin();
        mobile_droplist_operate_reqVar.owner_uin = j3;
        mobile_droplist_operate_reqVar.feedback_id = i3;
        mobile_droplist_operate_reqVar.busi_param = map;
        this.req = mobile_droplist_operate_reqVar;
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
        return "opDroplist";
    }
}
