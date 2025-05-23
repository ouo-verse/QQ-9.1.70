package com.qzone.cover.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSetCoverRequest extends QZoneRequest {
    public static final String CMD_STRING = "setCover";

    public QZoneSetCoverRequest(long j3, String str, String str2, String str3, int i3, int i16, int i17, String str4) {
        this(j3, str, str2, str3, i3, i16, i17, str4, 0, "", 0, 0);
    }

    public static String getCmd() {
        return "setCover";
    }

    public mobile_sub_set_cover_req getJceRequest() {
        return (mobile_sub_set_cover_req) this.req;
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
        return "setCover";
    }

    public QZoneSetCoverRequest(long j3, String str, String str2, String str3, int i3, int i16, int i17, String str4, int i18, String str5, int i19, int i26) {
        super("setCover");
        mobile_sub_set_cover_req mobile_sub_set_cover_reqVar = new mobile_sub_set_cover_req();
        mobile_sub_set_cover_reqVar.uin = j3;
        mobile_sub_set_cover_reqVar.cover = str;
        mobile_sub_set_cover_reqVar.type = str2;
        mobile_sub_set_cover_reqVar.coverkey = str3;
        mobile_sub_set_cover_reqVar.syncflag = i3;
        mobile_sub_set_cover_reqVar.coverScene = i16 == 0 ? 1 : 2;
        mobile_sub_set_cover_reqVar.controlBits = i17;
        mobile_sub_set_cover_reqVar.trace = str4;
        mobile_sub_set_cover_reqVar.iTransparency = i18;
        mobile_sub_set_cover_reqVar.strVideoPlay = str5;
        mobile_sub_set_cover_reqVar.iVideoWidth = i19;
        mobile_sub_set_cover_reqVar.iVideoHeight = i26;
        this.req = mobile_sub_set_cover_reqVar;
    }

    public QZoneSetCoverRequest() {
    }
}
