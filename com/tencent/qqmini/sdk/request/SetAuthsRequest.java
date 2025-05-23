package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetAuthsReq;
import NS_MINI_INTERFACE.INTERFACE$StUserAuthInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SetAuthsRequest extends ProtoBufRequest {
    private static final String TAG = "SetAuthsRequest";
    private INTERFACE$StSetAuthsReq req;

    public SetAuthsRequest(COMM.StCommonExt stCommonExt, String str, INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo) {
        INTERFACE$StSetAuthsReq iNTERFACE$StSetAuthsReq = new INTERFACE$StSetAuthsReq();
        this.req = iNTERFACE$StSetAuthsReq;
        iNTERFACE$StSetAuthsReq.appid.set(str);
        if (iNTERFACE$StUserAuthInfo != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iNTERFACE$StUserAuthInfo);
            this.req.auths.set(arrayList);
        }
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
        return "SetAuths";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr != null) {
            return jSONObject;
        }
        try {
            QMLog.d(TAG, "onResponse fail.rsp = null");
            return null;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
