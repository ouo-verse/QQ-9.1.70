package com.qzone.detail.business.protocol;

import NS_MOBILE_FEEDS.mobile_detail_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetADFeedDetailRequest extends QZoneRequest {
    private static final String CMD_STRING = "getAdvDetail";
    private static final int REQUST_COMMENT_COUNT = 29;

    public QZoneGetADFeedDetailRequest(long j3, int i3, String str, String str2, Map<Integer, String> map) {
        super(CMD_STRING);
        mobile_detail_req mobile_detail_reqVar = new mobile_detail_req();
        mobile_detail_reqVar.appid = i3;
        mobile_detail_reqVar.cellid = str;
        mobile_detail_reqVar.subid = str2;
        mobile_detail_reqVar.refresh_type = 7;
        mobile_detail_reqVar.attach_info = "";
        mobile_detail_reqVar.count = 29;
        mobile_detail_reqVar.busi_param = map;
        mobile_detail_reqVar.uin = j3;
        this.req = mobile_detail_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        String cmdString = getCmdString();
        int i3 = ((mobile_detail_req) this.req).refresh_type;
        if (i3 != 2 && i3 != 6) {
            return cmdString;
        }
        return cmdString + "MoreComment";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneGetADFeedDetailRequest(long j3, int i3, String str, String str2, int i16, String str3, int i17, Map<Integer, String> map) {
        super(CMD_STRING);
        mobile_detail_req mobile_detail_reqVar = new mobile_detail_req();
        mobile_detail_reqVar.appid = i3;
        mobile_detail_reqVar.cellid = str;
        mobile_detail_reqVar.subid = str2;
        mobile_detail_reqVar.refresh_type = i16;
        mobile_detail_reqVar.attach_info = str3;
        mobile_detail_reqVar.count = i17;
        mobile_detail_reqVar.busi_param = map;
        mobile_detail_reqVar.uin = j3;
        this.req = mobile_detail_reqVar;
    }
}
