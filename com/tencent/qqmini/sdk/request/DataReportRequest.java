package com.tencent.qqmini.sdk.request;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DataReportRequest extends ProtoBufRequest {
    private static final String CMD_STRING = "LightAppSvc.mini_app_report_transfer.DataReport";
    private byte[] datas;

    public DataReportRequest(byte[] bArr) {
        this.datas = bArr;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.datas;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "DataReport";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public String getCmdString() {
        return "LightAppSvc.mini_app_report_transfer.DataReport";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_report_transfer";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        try {
            APP_REPORT_TRANSFER.StDataReportRsp stDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
            stDataReportRsp.mergeFrom(bArr);
            int i3 = stDataReportRsp.ret.get();
            if (i3 == 0) {
                return jSONObject;
            }
            QMLog.d("ProtoBufRequest", "onResponse fail.retCode = " + i3);
            return null;
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
