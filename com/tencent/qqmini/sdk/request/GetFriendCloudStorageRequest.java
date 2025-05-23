package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetFriendCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetFriendCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StUserGameData;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetFriendCloudStorageRequest extends ProtoBufRequest {
    private CloudStorage$StGetFriendCloudStorageReq req = new CloudStorage$StGetFriendCloudStorageReq();

    public GetFriendCloudStorageRequest(String[] strArr, String str) {
        for (String str2 : strArr) {
            this.req.keyList.add(str2);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetFriendCloudStorage";
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
        CloudStorage$StGetFriendCloudStorageRsp cloudStorage$StGetFriendCloudStorageRsp = new CloudStorage$StGetFriendCloudStorageRsp();
        try {
            cloudStorage$StGetFriendCloudStorageRsp.mergeFrom(bArr);
            List<CloudStorage$StUserGameData> list = cloudStorage$StGetFriendCloudStorageRsp.data.get();
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (CloudStorage$StUserGameData cloudStorage$StUserGameData : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PhotoCategorySummaryInfo.AVATAR_URL, cloudStorage$StUserGameData.avatarUrl.get());
                    jSONObject2.put("nickname", cloudStorage$StUserGameData.nickname.get());
                    jSONObject2.put("openid", cloudStorage$StUserGameData.openid.get());
                    PBRepeatMessageField<CloudStorage$StKVData> pBRepeatMessageField = cloudStorage$StUserGameData.KVDataList;
                    if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                        List<CloudStorage$StKVData> list2 = cloudStorage$StUserGameData.KVDataList.get();
                        JSONArray jSONArray2 = new JSONArray();
                        for (CloudStorage$StKVData cloudStorage$StKVData : list2) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("key", cloudStorage$StKVData.key.get());
                            jSONObject3.put("value", cloudStorage$StKVData.value.get());
                            jSONArray2.mo162put(jSONObject3);
                        }
                        jSONObject2.put("KVDataList", jSONArray2);
                    }
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
                return jSONObject;
            }
            return null;
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
