package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE$StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE$StGetCodeRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.util.Log;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HttpGetCodeRequest extends HttpProtoBufRequest {
    public static final String CMD_STRING = "GetCode";
    private static final String TAG = "HttpGetCodeRequest";
    private INTERFACE$StGetCodeReq req;

    public HttpGetCodeRequest(String str) {
        INTERFACE$StGetCodeReq iNTERFACE$StGetCodeReq = new INTERFACE$StGetCodeReq();
        this.req = iNTERFACE$StGetCodeReq;
        iNTERFACE$StGetCodeReq.appid.set(str);
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
        return "mini_program_auth";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
    public JSONObject onResponse(int i3, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        INTERFACE$StGetCodeRsp iNTERFACE$StGetCodeRsp = new INTERFACE$StGetCodeRsp();
        try {
            stQWebRsp.mergeFrom(fh.a(bArr));
            iNTERFACE$StGetCodeRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
            QLog.d(TAG, 1, "[miniapp-http].onResponse, retCode: " + stQWebRsp.retCode.get() + ", errMsg: " + stQWebRsp.errMsg.get().toStringUtf8());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", iNTERFACE$StGetCodeRsp.code.get());
            return jSONObject;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onResponse, exception: " + Log.getStackTraceString(e16));
            return null;
        }
    }
}
