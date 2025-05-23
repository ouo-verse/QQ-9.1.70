package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE$StReportExecuteRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ReportExecuteRequest extends ProtoBufRequest {
    public static final String TAG = "ReportExecuteRequest";
    private INTERFACE$StReportExecuteReq req;

    public ReportExecuteRequest(String str, int i3, String str2, String str3) {
        INTERFACE$StReportExecuteReq iNTERFACE$StReportExecuteReq = new INTERFACE$StReportExecuteReq();
        this.req = iNTERFACE$StReportExecuteReq;
        iNTERFACE$StReportExecuteReq.appid.set(str);
        this.req.execTime.set(i3);
        this.req.instrTraceId.set(str2);
        this.req.ruleName.set(str3);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "ReportExecute";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_growguard";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MessageMicro<INTERFACE$StReportExecuteRsp> messageMicro = new MessageMicro<INTERFACE$StReportExecuteRsp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StReportExecuteRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, INTERFACE$StReportExecuteRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
        };
        try {
            messageMicro.mergeFrom(bArr);
            jSONObject.put("response", messageMicro);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
