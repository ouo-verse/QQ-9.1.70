package com.tencent.qqmini.sdk.request;

import NS_STORE_APP_CLIENT.MiniAppStore$StGetFirstPageByTypeReq;
import NS_STORE_APP_CLIENT.MiniAppStore$StGetFirstPageByTypeRsp;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JSONConverter;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class GetFirstPageByTypeRequest extends ProtoBufRequest {
    private static final String TAG = "GetFirstPageByTypeRequest";
    private MiniAppStore$StGetFirstPageByTypeReq req;

    public GetFirstPageByTypeRequest(int i3) {
        MiniAppStore$StGetFirstPageByTypeReq miniAppStore$StGetFirstPageByTypeReq = new MiniAppStore$StGetFirstPageByTypeReq();
        this.req = miniAppStore$StGetFirstPageByTypeReq;
        miniAppStore$StGetFirstPageByTypeReq.uiPageType.set(i3);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetFirstPageByType";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "store_app_client";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MiniAppStore$StGetFirstPageByTypeRsp miniAppStore$StGetFirstPageByTypeRsp = new MiniAppStore$StGetFirstPageByTypeRsp();
        try {
            miniAppStore$StGetFirstPageByTypeRsp.mergeFrom(bArr);
            jSONObject.put("data", JSONConverter.convert2JSONArray(miniAppStore$StGetFirstPageByTypeRsp.vecAppInfo.get()).toString());
            jSONObject.put("dataType", HippyControllerProps.STRING);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
