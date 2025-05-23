package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetNAppForJumpReq;
import NS_MINI_INTERFACE.INTERFACE$StGetNAppForJumpRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetNativeAppInfoRequest extends ProtoBufRequest {
    private static final String TAG = "GetAppInfoByIdRequest";
    private INTERFACE$StGetNAppForJumpReq req;

    public GetNativeAppInfoRequest(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3) {
        INTERFACE$StGetNAppForJumpReq iNTERFACE$StGetNAppForJumpReq = new INTERFACE$StGetNAppForJumpReq();
        this.req = iNTERFACE$StGetNAppForJumpReq;
        iNTERFACE$StGetNAppForJumpReq.android_pkg_name.set(str3);
        this.req.mini_appid.set(str);
        this.req.native_appid.set(str2);
        this.req.scene.set(i3);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetNAppForJump";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetNAppForJumpRsp iNTERFACE$StGetNAppForJumpRsp = new INTERFACE$StGetNAppForJumpRsp();
        try {
            iNTERFACE$StGetNAppForJumpRsp.mergeFrom(bArr);
            jSONObject.put("packageName", iNTERFACE$StGetNAppForJumpRsp.android_pkg.get());
            jSONObject.put("nativeAppId", iNTERFACE$StGetNAppForJumpRsp.native_appid.get());
            jSONObject.put("downloadUrl", iNTERFACE$StGetNAppForJumpRsp.android_donwload_url.get());
            jSONObject.put("appName", iNTERFACE$StGetNAppForJumpRsp.appName.get());
            jSONObject.put("onlyOpen", iNTERFACE$StGetNAppForJumpRsp.onlyOpen.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetAppInfoByIdRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
