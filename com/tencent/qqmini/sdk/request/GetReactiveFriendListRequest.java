package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage$FriendInfo;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetReactiveFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetReactiveFriendListRsp;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetReactiveFriendListRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetReactiveFriendList";
    public static final String KEY_RESULT_DATA = "key_result_data";
    public static final String TAG = "GetReactiveFriendListRequest";
    private CloudStorage$StGetReactiveFriendListReq req;

    public GetReactiveFriendListRequest(String str) {
        CloudStorage$StGetReactiveFriendListReq cloudStorage$StGetReactiveFriendListReq = new CloudStorage$StGetReactiveFriendListReq();
        this.req = cloudStorage$StGetReactiveFriendListReq;
        cloudStorage$StGetReactiveFriendListReq.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetReactiveFriendList";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public String getCmdString() {
        return "LightAppSvc.mini_app_cloudstorage.GetReactiveFriendList";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_cloudstorage";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        if (bArr == null) {
            return null;
        }
        try {
            CloudStorage$StGetReactiveFriendListRsp cloudStorage$StGetReactiveFriendListRsp = new CloudStorage$StGetReactiveFriendListRsp();
            cloudStorage$StGetReactiveFriendListRsp.mergeFrom(bArr);
            List<CloudStorage$FriendInfo> list = cloudStorage$StGetReactiveFriendListRsp.list.get();
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt(PhotoCategorySummaryInfo.AVATAR_URL, list.get(i3).avatarUrl.get());
                        jSONObject2.putOpt("nickname", list.get(i3).nickname.get());
                        jSONObject2.putOpt("openid", list.get(i3).openid.get());
                        jSONArray.mo162put(jSONObject2);
                    } catch (Throwable th5) {
                        QMLog.i("GetReactiveFriendListRequest", "", th5);
                    }
                }
                jSONObject.putOpt("key_result_data", jSONArray);
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("GetReactiveFriendListRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
