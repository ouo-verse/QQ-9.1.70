package com.tencent.qqmini.sdk.request;

import NS_MINI_REPORT.REPORT$StDcReportRsp;
import NS_MINI_REPORT.REPORT$StGameDcReportRsp;
import NS_MINI_REPORT.REPORT$StThirdDcReportRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DcReportRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "DcReport";
    public static final String CMD_STRING_GAME_CP_REPORT = "GameDcReport";
    public static final String CMD_STRING_THIRD_PARTY_REPORT = "ThirdDcReport";
    public static final String MODULE_APIREPORT = "mini_app_apireport";
    public static final String MODULE_DCREPORT = "mini_app_dcreport";
    private String cmdName;
    private byte[] datas;
    private String module;

    public DcReportRequest(byte[] bArr, String str, String str2) {
        this.datas = bArr;
        this.module = str;
        this.cmdName = str2;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.datas;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        String str = this.cmdName;
        if (str != null) {
            return str;
        }
        return "DcReport";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        String str = this.module;
        if (str != null) {
            return str;
        }
        return "mini_app_dcreport";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        int i3;
        if (bArr == null) {
            return null;
        }
        try {
            if ("ThirdDcReport".equals(this.cmdName)) {
                REPORT$StThirdDcReportRsp rEPORT$StThirdDcReportRsp = new REPORT$StThirdDcReportRsp();
                rEPORT$StThirdDcReportRsp.mergeFrom(bArr);
                i3 = rEPORT$StThirdDcReportRsp.ret.get();
            } else if ("GameDcReport".equals(this.cmdName)) {
                REPORT$StGameDcReportRsp rEPORT$StGameDcReportRsp = new REPORT$StGameDcReportRsp();
                rEPORT$StGameDcReportRsp.mergeFrom(bArr);
                i3 = rEPORT$StGameDcReportRsp.ret.get();
            } else {
                REPORT$StDcReportRsp rEPORT$StDcReportRsp = new REPORT$StDcReportRsp();
                rEPORT$StDcReportRsp.mergeFrom(bArr);
                i3 = rEPORT$StDcReportRsp.ret.get();
            }
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
