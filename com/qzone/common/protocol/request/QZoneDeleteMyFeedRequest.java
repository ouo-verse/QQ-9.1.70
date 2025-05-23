package com.qzone.common.protocol.request;

import NS_MOBILE_FEEDS.operation_del_icfeed_req;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneDeleteMyFeedRequest extends QZoneRequest {
    private static final String CMD_STRING = "delICFeeds";

    public QZoneDeleteMyFeedRequest(int i3, long j3, int i16, String str, long j16, Map<Integer, String> map) {
        super(CMD_STRING);
        operation_del_icfeed_req operation_del_icfeed_reqVar = new operation_del_icfeed_req();
        operation_del_icfeed_reqVar.uin = LoginData.getInstance().getUin();
        if (map != null && !TextUtils.isEmpty(map.get(28))) {
            operation_del_icfeed_reqVar.typeId = Integer.valueOf(map.get(28)).intValue();
        } else {
            operation_del_icfeed_reqVar.typeId = 0;
        }
        if (map != null && !TextUtils.isEmpty(map.get(40))) {
            operation_del_icfeed_reqVar.appid = Integer.valueOf(map.get(40)).intValue();
        } else {
            operation_del_icfeed_reqVar.appid = 0;
        }
        if (map != null && !TextUtils.isEmpty(map.get(42))) {
            operation_del_icfeed_reqVar.time = Long.valueOf(map.get(42)).longValue();
        } else {
            operation_del_icfeed_reqVar.time = 0L;
        }
        if (map != null && !TextUtils.isEmpty(map.get(26))) {
            operation_del_icfeed_reqVar.skey = map.get(26);
        } else {
            operation_del_icfeed_reqVar.skey = "";
        }
        if (map != null && !TextUtils.isEmpty(map.get(58))) {
            operation_del_icfeed_reqVar.uflag = Long.valueOf(map.get(58)).longValue();
        } else {
            operation_del_icfeed_reqVar.uflag = 0L;
        }
        this.req = operation_del_icfeed_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "QzoneNewService.delICFeeds";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneDeleteMyFeedRequest(int i3, long j3, int i16, String str, long j16, Map<Integer, String> map, String str2) {
        this(i3, j3, i16, str, j16, map);
        if (!(this.req instanceof operation_del_icfeed_req) || TextUtils.isEmpty(str2)) {
            return;
        }
        ((operation_del_icfeed_req) this.req).clientkey = str2;
    }
}
