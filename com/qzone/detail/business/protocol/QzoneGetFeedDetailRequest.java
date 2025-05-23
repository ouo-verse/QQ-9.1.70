package com.qzone.detail.business.protocol;

import NS_MOBILE_FEEDS.mobile_detail_req;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.app.a;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.oskplayer.util.PlayerUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetFeedDetailRequest extends QZoneRequest {
    private static final String CMD_STRING = "getDetail";
    private static final String NEW_CMD_STRING = "detail";
    private static final int REQUST_COMMENT_COUNT = 29;

    public QzoneGetFeedDetailRequest() {
    }

    private void setAppId(mobile_detail_req mobile_detail_reqVar) {
        if (mobile_detail_reqVar.busi_param == null) {
            mobile_detail_reqVar.busi_param = new HashMap();
        }
        mobile_detail_reqVar.busi_param.put(182, "" + AppSetting.f());
    }

    protected String getCmdString(int i3) {
        String a16 = a.a(i3);
        if (TextUtils.isEmpty(a16)) {
            return CMD_STRING;
        }
        return "detail." + a16;
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
            str = a.a(((mobile_detail_req) jceStruct).appid);
        }
        str = CMD_STRING;
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneGetFeedDetailRequest", 4, "QzoneGetFeedDetailRequest unikey:" + str);
        }
        return str;
    }

    public QzoneGetFeedDetailRequest(long j3, int i3, String str, int i16) {
        super(CMD_STRING);
        setCmdString(getCmdString(i3));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneGetFeedDetailRequest", 4, "QzoneGetFeedDetailRequest cmd:" + getCmdString());
        }
        mobile_detail_req mobile_detail_reqVar = new mobile_detail_req();
        mobile_detail_reqVar.appid = i3;
        mobile_detail_reqVar.clientkey = str;
        mobile_detail_reqVar.refresh_type = 21;
        mobile_detail_reqVar.attach_info = "";
        mobile_detail_reqVar.attach_info_essence = "";
        mobile_detail_reqVar.count = 29;
        mobile_detail_reqVar.uin = j3;
        if (mobile_detail_reqVar.mapExt == null) {
            mobile_detail_reqVar.mapExt = new HashMap();
        }
        mobile_detail_reqVar.mapExt.put("retry_count", String.valueOf(i16));
        if (mobile_detail_reqVar.mapExt == null) {
            mobile_detail_reqVar.mapExt = new HashMap();
        }
        mobile_detail_reqVar.mapExt.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        QZLog.i("h265debug mobile_detail_req", mobile_detail_reqVar.mapExt.get("mobile_detail_info"));
        setAppId(mobile_detail_reqVar);
        this.req = mobile_detail_reqVar;
    }

    public QzoneGetFeedDetailRequest(long j3, int i3, String str, String str2, Map<Integer, String> map) {
        super(CMD_STRING);
        setCmdString(getCmdString(i3));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneGetFeedDetailRequest", 4, "QzoneGetFeedDetailRequest cmd:" + getCmdString());
        }
        mobile_detail_req mobile_detail_reqVar = new mobile_detail_req();
        mobile_detail_reqVar.appid = i3;
        mobile_detail_reqVar.cellid = str;
        mobile_detail_reqVar.subid = str2;
        mobile_detail_reqVar.refresh_type = 7;
        mobile_detail_reqVar.attach_info = "";
        mobile_detail_reqVar.attach_info_essence = "";
        mobile_detail_reqVar.count = 29;
        mobile_detail_reqVar.busi_param = map;
        mobile_detail_reqVar.uin = j3;
        if (mobile_detail_reqVar.mapExt == null) {
            mobile_detail_reqVar.mapExt = new HashMap();
        }
        mobile_detail_reqVar.mapExt.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        QZLog.i("h265debug mobile_detail_req", mobile_detail_reqVar.mapExt.get("mobile_detail_info"));
        setAppId(mobile_detail_reqVar);
        this.req = mobile_detail_reqVar;
    }

    public QzoneGetFeedDetailRequest(long j3, int i3, String str, String str2, Map<Integer, String> map, Map<String, String> map2, boolean z16, String str3) {
        super(CMD_STRING);
        setCmdString(getCmdString(i3));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneGetFeedDetailRequest", 4, "QzoneGetFeedDetailRequest cmd:" + getCmdString());
        }
        mobile_detail_req mobile_detail_reqVar = new mobile_detail_req();
        mobile_detail_reqVar.appid = i3;
        mobile_detail_reqVar.cellid = str;
        mobile_detail_reqVar.subid = str2;
        if (z16) {
            mobile_detail_reqVar.refresh_type = 71;
        } else {
            mobile_detail_reqVar.refresh_type = 7;
        }
        mobile_detail_reqVar.attach_info = "";
        mobile_detail_reqVar.attach_info_essence = "";
        mobile_detail_reqVar.count = 29;
        mobile_detail_reqVar.busi_param = map;
        mobile_detail_reqVar.uin = j3;
        if (mobile_detail_reqVar.mapExt == null) {
            mobile_detail_reqVar.mapExt = new HashMap();
        }
        mobile_detail_reqVar.mapExt.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        if (!TextUtils.isEmpty(str3)) {
            mobile_detail_reqVar.mapExt.put(QZoneHelper.CIPHERTEXT, str3);
        }
        QZLog.i("h265debug mobile_detail_req", mobile_detail_reqVar.mapExt.get("mobile_detail_info"));
        if (map2 != null) {
            for (String str4 : map2.keySet()) {
                if (!TextUtils.isEmpty(str4)) {
                    String str5 = map2.get(str4);
                    if (!TextUtils.isEmpty(str5)) {
                        mobile_detail_reqVar.mapExt.put(str4, str5);
                    }
                }
            }
        }
        setAppId(mobile_detail_reqVar);
        this.req = mobile_detail_reqVar;
    }

    public QzoneGetFeedDetailRequest(long j3, int i3, String str, String str2, int i16, String str3, int i17, Map<Integer, String> map) {
        super(CMD_STRING);
        setCmdString(getCmdString(i3));
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneGetFeedDetailRequest", 4, "QzoneGetFeedDetailRequest cmd:" + getCmdString());
        }
        mobile_detail_req mobile_detail_reqVar = new mobile_detail_req();
        mobile_detail_reqVar.appid = i3;
        mobile_detail_reqVar.cellid = str;
        mobile_detail_reqVar.subid = str2;
        mobile_detail_reqVar.refresh_type = i16;
        mobile_detail_reqVar.attach_info = str3;
        mobile_detail_reqVar.attach_info_essence = str3;
        mobile_detail_reqVar.count = i17;
        mobile_detail_reqVar.busi_param = map;
        mobile_detail_reqVar.uin = j3;
        if (mobile_detail_reqVar.mapExt == null) {
            mobile_detail_reqVar.mapExt = new HashMap();
        }
        mobile_detail_reqVar.mapExt.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        if (i3 == 406) {
            mobile_detail_reqVar.mapExt.put("fromComment", "1");
        }
        QZLog.i("h265debug mobile_detail_req", mobile_detail_reqVar.mapExt.get("mobile_detail_info"));
        setAppId(mobile_detail_reqVar);
        this.req = mobile_detail_reqVar;
    }
}
