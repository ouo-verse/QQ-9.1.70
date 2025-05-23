package com.qzone.homepage.business.protocol;

import NS_MOBILE_FEEDS.mobile_applist_req;
import NS_MOBILE_FEEDS.mobile_applist_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.app.a;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.oskplayer.util.PlayerUtils;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneAppListRequest extends QZoneRequest {
    private static final String CMD_STRING = "getApplist";
    private static final String NEW_CMD_STRING = "applist";
    private mobile_applist_req request;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneAppListRequest(long j3, int i3, int i16, String str, int i17) {
        super(CMD_STRING);
        String str2 = CMD_STRING;
        this.request = new mobile_applist_req();
        String a16 = a.a(i3);
        if (!TextUtils.isEmpty(a16)) {
            str2 = "applist." + a16;
        }
        setCmdString(str2);
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneAppListRequest", 4, "QzoneAppListRequest cmd:" + getCmdString());
        }
        mobile_applist_req mobile_applist_reqVar = this.request;
        mobile_applist_reqVar.uin = j3;
        mobile_applist_reqVar.appid = i3;
        mobile_applist_reqVar.count = i16;
        mobile_applist_reqVar.attach_info = str == null ? "" : str;
        mobile_applist_reqVar.refresh_type = i17;
        if (mobile_applist_reqVar.mapEx == null) {
            mobile_applist_reqVar.mapEx = new HashMap();
        }
        this.request.mapEx.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        QZLog.i("h265debug mobile_applist_req", this.request.mapEx.get("mobile_detail_info"));
        this.req = this.request;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString() + a.b(((mobile_applist_req) this.req).appid);
    }

    public mobile_applist_rsp getResp() {
        JceStruct jceStruct = this.rsp;
        if (jceStruct instanceof mobile_applist_rsp) {
            return (mobile_applist_rsp) jceStruct;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L8;
     */
    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String uniKey() {
        String str;
        JceStruct jceStruct = this.req;
        if (jceStruct != null) {
            str = a.a(((mobile_applist_req) jceStruct).appid);
        }
        str = CMD_STRING;
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneAppListRequest", 4, "QzoneAppListRequest unikey:" + str);
        }
        return str;
    }
}
