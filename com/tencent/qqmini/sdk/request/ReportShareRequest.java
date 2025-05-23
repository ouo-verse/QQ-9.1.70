package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StReportShareReq;
import NS_MINI_INTERFACE.INTERFACE$StReportShareRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ReportShareRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_usr_time.ReportShare";
    public static final String TAG = "ReportShareRequest";
    private INTERFACE$StReportShareReq req;

    public ReportShareRequest(long j3, String str, int i3, int i16, int i17, int i18, String str2) {
        INTERFACE$StReportShareReq iNTERFACE$StReportShareReq = new INTERFACE$StReportShareReq();
        this.req = iNTERFACE$StReportShareReq;
        iNTERFACE$StReportShareReq.reportTime.set(j3);
        this.req.appid.set(str);
        this.req.appType.set(i3);
        this.req.shareScene.set(i16);
        this.req.shareType.set(i17);
        this.req.destType.set(i18);
        this.req.destId.set(str2);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "ReportShare";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_usr_time";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        try {
            new INTERFACE$StReportShareRsp().mergeFrom(bArr);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("ReportShareRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
