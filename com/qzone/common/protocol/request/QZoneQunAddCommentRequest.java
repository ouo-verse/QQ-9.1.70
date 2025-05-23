package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.operation_addcomment_req;
import NS_MOBILE_QUN.qun_add_comment_req;
import NS_MOBILE_QUN.qun_add_comment_rsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.common.account.LoginData;
import com.qzone.util.u;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQunAddCommentRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "qunAddComment";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {
    }

    public QZoneQunAddCommentRequest() {
        super(CMD_STRING, true);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getRequestType() {
        return com.qzone.app.a.b(((operation_addcomment_req) this.req).appid);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneQunAddCommentRequest(String str, long j3, String str2, String str3, Map<Integer, String> map, String str4) {
        super(CMD_STRING, true);
        this.contentCacheUnikey = this.contentCacheUnikey;
        qun_add_comment_req qun_add_comment_reqVar = new qun_add_comment_req();
        qun_add_comment_reqVar.uin = LoginData.getInstance().getUin();
        qun_add_comment_reqVar.albumId = str2;
        qun_add_comment_reqVar.qunid = str;
        qun_add_comment_reqVar.ownuin = j3;
        qun_add_comment_reqVar.content = u.c(str3);
        qun_add_comment_reqVar.busi_param = map;
        this.req = qun_add_comment_reqVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof qun_add_comment_rsp)) {
            return null;
        }
        new a();
        return null;
    }

    public QZoneQunAddCommentRequest(int i3, long j3, String str, String str2, String str3, int i16, Map<Integer, String> map, String str4, boolean z16, MediaInfo mediaInfo, Map<String, String> map2) {
        super(CMD_STRING, true);
        this.contentCacheUnikey = str3;
        qun_add_comment_req qun_add_comment_reqVar = new qun_add_comment_req();
        qun_add_comment_reqVar.uin = LoginData.getInstance().getUin();
        qun_add_comment_reqVar.ownuin = j3;
        qun_add_comment_reqVar.content = u.c(str2);
        qun_add_comment_reqVar.busi_param = map;
        if (str4 != null) {
            addParameter("refer", str4);
        }
        this.req = qun_add_comment_reqVar;
    }
}
