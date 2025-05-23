package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByLinkRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HttpGetAppInfoByLinkRequest extends HttpProtoBufRequest {
    public static final String CMD_STRING = "GetAppInfoByLink";
    private static final String TAG = "HttpGetAppInfoByLinkRequest";
    private INTERFACE$StGetAppInfoByLinkReq req;

    public HttpGetAppInfoByLinkRequest(String str, int i3) {
        INTERFACE$StGetAppInfoByLinkReq iNTERFACE$StGetAppInfoByLinkReq = new INTERFACE$StGetAppInfoByLinkReq();
        this.req = iNTERFACE$StGetAppInfoByLinkReq;
        iNTERFACE$StGetAppInfoByLinkReq.link.set(str);
        this.req.linkType.set(i3);
    }

    @Override // com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
    public byte[] getBusiBuf() {
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

    @Override // com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
    public JSONObject onResponse(int i3, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        INTERFACE$StGetAppInfoByLinkRsp iNTERFACE$StGetAppInfoByLinkRsp = new INTERFACE$StGetAppInfoByLinkRsp();
        try {
            stQWebRsp.mergeFrom(fh.a(bArr));
            iNTERFACE$StGetAppInfoByLinkRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
            JSONObject jSONObject = new JSONObject();
            MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StGetAppInfoByLinkRsp.appInfo);
            String str = iNTERFACE$StGetAppInfoByLinkRsp.shareTicket.get();
            jSONObject.put("appInfo", from);
            jSONObject.put("appInfo_pd", iNTERFACE$StGetAppInfoByLinkRsp.appInfo);
            jSONObject.put("shareTicket", str);
            jSONObject.put("retCode", stQWebRsp.retCode.get());
            jSONObject.put("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
            QLog.d(TAG, 1, "[miniapp-http].onResponse, retCode: " + stQWebRsp.retCode.get() + ", errMsg: " + stQWebRsp.errMsg.get().toStringUtf8());
            return jSONObject;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "onResponse, exception: " + Log.getStackTraceString(e16));
            return null;
        }
    }
}
