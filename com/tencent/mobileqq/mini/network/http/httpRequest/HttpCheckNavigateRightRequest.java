package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE$StCheckNavigateRightReq;
import NS_MINI_INTERFACE.INTERFACE$StCheckNavigateRightRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.util.Log;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HttpCheckNavigateRightRequest extends HttpProtoBufRequest {
    public static final String CMD_STRING = "CheckNavigateRight";
    public static final String TAG = "HttpCheckNavigateRightRequest";
    private INTERFACE$StCheckNavigateRightReq req;

    public HttpCheckNavigateRightRequest(String str, String str2) {
        INTERFACE$StCheckNavigateRightReq iNTERFACE$StCheckNavigateRightReq = new INTERFACE$StCheckNavigateRightReq();
        this.req = iNTERFACE$StCheckNavigateRightReq;
        iNTERFACE$StCheckNavigateRightReq.appId.set(str);
        this.req.targetAppId.set(str2);
    }

    @Override // com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
    protected String getCmdName() {
        return CMD_STRING;
    }

    @Override // com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
    protected String getModule() {
        return "mini_app_info";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
    public JSONObject onResponse(int i3, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        INTERFACE$StCheckNavigateRightRsp iNTERFACE$StCheckNavigateRightRsp = new INTERFACE$StCheckNavigateRightRsp();
        try {
            stQWebRsp.mergeFrom(fh.a(bArr));
            iNTERFACE$StCheckNavigateRightRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
            QLog.d(TAG, 1, "[miniapp-http].onResponse, retCode: " + stQWebRsp.retCode.get() + ", errMsg: " + stQWebRsp.errMsg.get().toStringUtf8());
            JSONObject jSONObject = new JSONObject();
            int i16 = iNTERFACE$StCheckNavigateRightRsp.actionCode.get();
            jSONObject.put("action_code", i16);
            jSONObject.put("skip_local_check", iNTERFACE$StCheckNavigateRightRsp.skipLocalCheck.get());
            if (i16 == 0) {
                jSONObject.put("reason", iNTERFACE$StCheckNavigateRightRsp.wording.get());
            } else {
                jSONObject.put("wording", iNTERFACE$StCheckNavigateRightRsp.wording.get());
            }
            return jSONObject;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onResponse fail." + Log.getStackTraceString(e16));
            return null;
        }
    }
}
