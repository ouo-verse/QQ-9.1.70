package com.qzone.homepage.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_main_page_req;
import NS_MOBILE_MAIN_PAGE.mobile_main_page_rsp;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetUserInfoRequest extends QZoneRequest {
    public static final String CMD_STRING = "getMainPage";

    public QZoneGetUserInfoRequest(long j3, long j16) {
        this(j3, j16, null);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public mobile_main_page_rsp getResponse() {
        return (mobile_main_page_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getMainPage";
    }

    public QZoneGetUserInfoRequest(long j3, long j16, Map<Integer, Long> map) {
        super("getMainPage");
        mobile_main_page_req mobile_main_page_reqVar = new mobile_main_page_req();
        mobile_main_page_reqVar.visituin = j3;
        mobile_main_page_reqVar.uin = j16;
        mobile_main_page_reqVar.mapTimeStamp = map;
        this.req = mobile_main_page_reqVar;
    }
}
