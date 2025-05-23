package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StCheckBindingStateReq;
import NS_MINI_INTERFACE.INTERFACE$StCheckBindingStateRsp;
import com.tencent.mobileqq.mini.servlet.CheckBindingStateServlet;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CheckBindingStateRequest extends ProtoBufRequest {
    private static final String TAG = "CheckBindingStateRequest";
    private INTERFACE$StCheckBindingStateReq req;

    public CheckBindingStateRequest(String str, String str2, int i3) {
        INTERFACE$StCheckBindingStateReq iNTERFACE$StCheckBindingStateReq = new INTERFACE$StCheckBindingStateReq();
        this.req = iNTERFACE$StCheckBindingStateReq;
        iNTERFACE$StCheckBindingStateReq.appId.set(str);
        this.req.uid.set(str2);
        this.req.bindType.set(i3);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "CheckBindingState";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_native_page";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StCheckBindingStateRsp iNTERFACE$StCheckBindingStateRsp = new INTERFACE$StCheckBindingStateRsp();
        try {
            iNTERFACE$StCheckBindingStateRsp.mergeFrom(bArr);
            jSONObject.put(CheckBindingStateServlet.KEY_CHECK_STATE, iNTERFACE$StCheckBindingStateRsp.bindingState.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
