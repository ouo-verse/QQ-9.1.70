package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_SHARE.MiniProgramShare$StGetGroupShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare$StGetGroupShareInfoRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppGetGroupShareInfoRequest extends ProtoBufRequest {
    private static final String TAG = "MiniAppGetGroupShareInfoRequest";
    private MiniProgramShare$StGetGroupShareInfoReq req;

    public MiniAppGetGroupShareInfoRequest(COMM.StCommonExt stCommonExt, String str, String str2) {
        MiniProgramShare$StGetGroupShareInfoReq miniProgramShare$StGetGroupShareInfoReq = new MiniProgramShare$StGetGroupShareInfoReq();
        this.req = miniProgramShare$StGetGroupShareInfoReq;
        if (stCommonExt != null) {
            miniProgramShare$StGetGroupShareInfoReq.extInfo.set(stCommonExt);
        }
        this.req.appid.set(str);
        this.req.shareTicket.set(str2);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetGroupShareInfo";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_share";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MiniProgramShare$StGetGroupShareInfoRsp miniProgramShare$StGetGroupShareInfoRsp = new MiniProgramShare$StGetGroupShareInfoRsp();
        try {
            miniProgramShare$StGetGroupShareInfoRsp.mergeFrom(bArr);
            jSONObject.put("response", miniProgramShare$StGetGroupShareInfoRsp);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, jSONObject.get("retCode"));
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("MiniAppGetGroupShareInfoRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
