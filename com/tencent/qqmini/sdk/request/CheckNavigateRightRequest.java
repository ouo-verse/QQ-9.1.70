package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StCheckNavigateRightReq;
import NS_MINI_INTERFACE.INTERFACE$StCheckNavigateRightRsp;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpCheckNavigateRightRequest;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CheckNavigateRightRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.CheckNavigateRight";
    private static final String TAG = "GetNewBaseLibRequest";
    private INTERFACE$StCheckNavigateRightReq req;

    public CheckNavigateRightRequest(String str, String str2) {
        INTERFACE$StCheckNavigateRightReq iNTERFACE$StCheckNavigateRightReq = new INTERFACE$StCheckNavigateRightReq();
        this.req = iNTERFACE$StCheckNavigateRightReq;
        iNTERFACE$StCheckNavigateRightReq.appId.set(str);
        this.req.targetAppId.set(str2);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return HttpCheckNavigateRightRequest.CMD_STRING;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StCheckNavigateRightRsp iNTERFACE$StCheckNavigateRightRsp = new INTERFACE$StCheckNavigateRightRsp();
        try {
            iNTERFACE$StCheckNavigateRightRsp.mergeFrom(bArr);
            int i3 = iNTERFACE$StCheckNavigateRightRsp.actionCode.get();
            jSONObject.put("action_code", i3);
            jSONObject.put("skip_local_check", iNTERFACE$StCheckNavigateRightRsp.skipLocalCheck.get());
            if (i3 == 0) {
                jSONObject.put("reason", iNTERFACE$StCheckNavigateRightRsp.wording.get());
            } else {
                jSONObject.put("wording", iNTERFACE$StCheckNavigateRightRsp.wording.get());
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
