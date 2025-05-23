package com.tencent.qqmini.sdk.request;

import NS_MINI_AD.MiniAppAd$StGetSdkAdInfoReq;
import NS_MINI_AD.MiniAppAd$StGetSdkAdInfoRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetAdInfoRequest extends ProtoBufRequest {
    public static final String CATEGORY = "category";
    public static final String POSID = "posId";
    public static final String SOURCE_FROM = "sourceFrom";
    private static final String TAG = "GetAdRequest";
    private MiniAppAd$StGetSdkAdInfoReq req;

    public GetAdInfoRequest(String str, int i3, String str2) {
        MiniAppAd$StGetSdkAdInfoReq miniAppAd$StGetSdkAdInfoReq = new MiniAppAd$StGetSdkAdInfoReq();
        this.req = miniAppAd$StGetSdkAdInfoReq;
        miniAppAd$StGetSdkAdInfoReq.strAppid.set(str);
        this.req.iAdType.set(i3);
        this.req.strSubPosId.set(str2);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetSdkAdInfo";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_ad";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MiniAppAd$StGetSdkAdInfoRsp miniAppAd$StGetSdkAdInfoRsp = new MiniAppAd$StGetSdkAdInfoRsp();
        try {
            miniAppAd$StGetSdkAdInfoRsp.mergeFrom(bArr);
            jSONObject.put(SOURCE_FROM, miniAppAd$StGetSdkAdInfoRsp.strSourceFrom.get());
            jSONObject.put("category", miniAppAd$StGetSdkAdInfoRsp.strMiniCategory.get());
            jSONObject.put("posId", miniAppAd$StGetSdkAdInfoRsp.strPosId.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
