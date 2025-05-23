package com.tencent.qqmini.sdk.request;

import NS_MINI_REALTIMELOG.REALTIMELOG$StLogItem;
import NS_MINI_REALTIMELOG.REALTIMELOG$StReportLogReq;
import NS_MINI_REALTIMELOG.REALTIMELOG$StReportLogRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RealTimeLogReportRequest extends ProtoBufRequest {
    private static final String unikey = "RealTimeLogReport";
    private REALTIMELOG$StReportLogReq req;

    public RealTimeLogReportRequest(String str, String str2, String str3, String[] strArr, List<RealTimeLogItem> list) {
        REALTIMELOG$StReportLogReq rEALTIMELOG$StReportLogReq = new REALTIMELOG$StReportLogReq();
        this.req = rEALTIMELOG$StReportLogReq;
        rEALTIMELOG$StReportLogReq.page.set(str);
        this.req.jslib_version.set(str2);
        for (String str4 : strArr) {
            this.req.filter_msgs.add(str4);
        }
        this.req.report_time.set(System.currentTimeMillis());
        this.req.appid.set(str3);
        for (RealTimeLogItem realTimeLogItem : list) {
            REALTIMELOG$StLogItem rEALTIMELOG$StLogItem = new REALTIMELOG$StLogItem();
            rEALTIMELOG$StLogItem.log_level.set(realTimeLogItem.level);
            rEALTIMELOG$StLogItem.log_time.set(realTimeLogItem.time);
            rEALTIMELOG$StLogItem.f24968msg.set(realTimeLogItem.f348089msg);
            this.req.logs.add(rEALTIMELOG$StLogItem);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return unikey;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        if (bArr == null) {
            return null;
        }
        try {
            new REALTIMELOG$StReportLogRsp().mergeFrom(decode(bArr));
            return new JSONObject();
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
