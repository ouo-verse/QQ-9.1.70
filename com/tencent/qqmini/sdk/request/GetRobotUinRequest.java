package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetRobotUinReq;
import NS_MINI_INTERFACE.INTERFACE$StGetRobotUinRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetRobotUinRequest extends ProtoBufRequest {
    public static final String TAG = "GetRobotUinRequest";
    private INTERFACE$StGetRobotUinReq req;

    public GetRobotUinRequest(COMM.StCommonExt stCommonExt, String str) {
        INTERFACE$StGetRobotUinReq iNTERFACE$StGetRobotUinReq = new INTERFACE$StGetRobotUinReq();
        this.req = iNTERFACE$StGetRobotUinReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetRobotUinReq.extInfo.set(stCommonExt);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetRobotUin";
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
        INTERFACE$StGetRobotUinRsp iNTERFACE$StGetRobotUinRsp = new INTERFACE$StGetRobotUinRsp();
        try {
            iNTERFACE$StGetRobotUinRsp.mergeFrom(bArr);
            jSONObject.put("robotUin", iNTERFACE$StGetRobotUinRsp.uin.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetRobotUinRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
