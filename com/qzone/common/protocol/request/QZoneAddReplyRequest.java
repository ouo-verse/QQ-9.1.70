package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_addreply_req;
import com.qzone.common.account.LoginData;
import com.qzone.util.u;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAddReplyRequest extends QZoneRequest {
    public static final int CMD_DEFAULT = 0;
    private static final String CMD_STRING = "addReply";

    private static String getCmdString(int i3) {
        return CMD_STRING;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getRequestType() {
        return com.qzone.app.a.b(((operation_addreply_req) this.req).appid);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneAddReplyRequest(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, int i17, Map<Integer, String> map, String str5, Map<String, String> map2) {
        super(getCmdString(i3), true);
        this.contentCacheUnikey = str4;
        operation_addreply_req operation_addreply_reqVar = new operation_addreply_req();
        operation_addreply_reqVar.appid = i16;
        operation_addreply_reqVar.uin = LoginData.getInstance().getUin();
        operation_addreply_reqVar.ownuin = j3;
        operation_addreply_reqVar.commentuin = j16;
        operation_addreply_reqVar.srcId = str;
        operation_addreply_reqVar.commentid = str2;
        operation_addreply_reqVar.content = u.c(str3);
        operation_addreply_reqVar.isverified = i17;
        operation_addreply_reqVar.busi_param = map;
        operation_addreply_reqVar.bypass_param = map2;
        if (str5 != null) {
            addParameter("refer", str5);
        }
        this.req = operation_addreply_reqVar;
    }
}
