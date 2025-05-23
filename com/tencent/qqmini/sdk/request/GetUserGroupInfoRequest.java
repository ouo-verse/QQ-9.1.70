package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserGroupInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserGroupInfoRsp;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserGroupInfoServlet;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetUserGroupInfoRequest extends ProtoBufRequest {
    public static final String TAG = "GetUserGroupInfoRequest";
    private INTERFACE$StGetUserGroupInfoReq req;

    public GetUserGroupInfoRequest(String str, String str2, long j3, COMM.StCommonExt stCommonExt) {
        INTERFACE$StGetUserGroupInfoReq iNTERFACE$StGetUserGroupInfoReq = new INTERFACE$StGetUserGroupInfoReq();
        this.req = iNTERFACE$StGetUserGroupInfoReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetUserGroupInfoReq.extInfo.set(stCommonExt);
        }
        if (str != null) {
            this.req.appid.set(str);
        }
        if (str2 != null) {
            this.req.groupId.set(str2);
        }
        this.req.groupClass.set(j3);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetUserHealthData";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetUserGroupInfoRsp iNTERFACE$StGetUserGroupInfoRsp = new INTERFACE$StGetUserGroupInfoRsp();
        try {
            iNTERFACE$StGetUserGroupInfoRsp.mergeFrom(decode(bArr));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniAppGetUserGroupInfoServlet.KEY_EXTRA_JSON_DATA, iNTERFACE$StGetUserGroupInfoRsp.userGroupInfo.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetUserGroupInfoRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
