package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetPotentialFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetPotentialFriendListRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class GetPotentialFriendListRequest extends ProtoBufRequest {
    private static final String TAG = "GetPotentialFriendListRequest";
    private CloudStorage$StGetPotentialFriendListReq req;

    public GetPotentialFriendListRequest(COMM.StCommonExt stCommonExt, String str) {
        CloudStorage$StGetPotentialFriendListReq cloudStorage$StGetPotentialFriendListReq = new CloudStorage$StGetPotentialFriendListReq();
        this.req = cloudStorage$StGetPotentialFriendListReq;
        if (stCommonExt != null) {
            cloudStorage$StGetPotentialFriendListReq.ext.set(stCommonExt);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetPotentialFriendList";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_cloudstorage";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        CloudStorage$StGetPotentialFriendListRsp cloudStorage$StGetPotentialFriendListRsp = new CloudStorage$StGetPotentialFriendListRsp();
        try {
            cloudStorage$StGetPotentialFriendListRsp.mergeFrom(bArr);
            jSONObject.put("response", cloudStorage$StGetPotentialFriendListRsp);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetPotentialFriendListRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
