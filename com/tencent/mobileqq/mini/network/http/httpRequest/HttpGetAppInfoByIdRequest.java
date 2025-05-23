package com.tencent.mobileqq.mini.network.http.httpRequest;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByIdRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.util.Log;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HttpGetAppInfoByIdRequest extends HttpProtoBufRequest {
    public static final String CMD_STRING = "GetAppInfoById";
    public static final String TAG = "GetAppInfoByIdRequest";
    private INTERFACE$StGetAppInfoByIdReq req;

    public HttpGetAppInfoByIdRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, String str2, String str3, String str4) {
        INTERFACE$StGetAppInfoByIdReq iNTERFACE$StGetAppInfoByIdReq = new INTERFACE$StGetAppInfoByIdReq();
        this.req = iNTERFACE$StGetAppInfoByIdReq;
        iNTERFACE$StGetAppInfoByIdReq.appid.set(str);
        this.req.needVersionInfo.set(i3);
        this.req.checkDevRight.set(i16);
        if (str2 != null) {
            this.req.firstPath.set(str2);
        }
        if (str3 != null) {
            this.req.envVersion.set(str3);
        }
        this.req.fromAppid.set(str4 == null ? "" : str4);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
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
        INTERFACE$StGetAppInfoByIdRsp iNTERFACE$StGetAppInfoByIdRsp = new INTERFACE$StGetAppInfoByIdRsp();
        try {
            stQWebRsp.mergeFrom(fh.a(bArr));
            iNTERFACE$StGetAppInfoByIdRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
            QLog.d("GetAppInfoByIdRequest", 1, "[miniapp-http].onResponse, retCode: " + stQWebRsp.retCode.get() + ", errMsg: " + stQWebRsp.errMsg.get().toStringUtf8());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mini_app_info_data", MiniAppInfo.from(iNTERFACE$StGetAppInfoByIdRsp.appInfo));
            jSONObject.put("mini_app_info_pb_data", iNTERFACE$StGetAppInfoByIdRsp.appInfo.toByteArray());
            jSONObject.put("retCode", stQWebRsp.retCode.get());
            jSONObject.put("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
            return jSONObject;
        } catch (Exception e16) {
            QLog.e("GetAppInfoByIdRequest", 1, "onResponse fail." + Log.getStackTraceString(e16));
            return null;
        }
    }
}
