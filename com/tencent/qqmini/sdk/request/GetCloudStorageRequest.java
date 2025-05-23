package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StKVData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetCloudStorageRequest extends ProtoBufRequest {
    private static final String TAG = "GetCloudStorageRequest";
    private CloudStorage$StGetUserCloudStorageReq req = new CloudStorage$StGetUserCloudStorageReq();

    public GetCloudStorageRequest(String[] strArr, String str) {
        for (String str2 : strArr) {
            this.req.keyList.add(str2);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetUserCloudStorage";
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
        CloudStorage$StGetUserCloudStorageRsp cloudStorage$StGetUserCloudStorageRsp = new CloudStorage$StGetUserCloudStorageRsp();
        try {
            cloudStorage$StGetUserCloudStorageRsp.mergeFrom(bArr);
            PBRepeatMessageField<CloudStorage$StKVData> pBRepeatMessageField = cloudStorage$StGetUserCloudStorageRsp.KVDataList;
            if (pBRepeatMessageField != null) {
                List<CloudStorage$StKVData> list = pBRepeatMessageField.get();
                JSONArray jSONArray = new JSONArray();
                for (CloudStorage$StKVData cloudStorage$StKVData : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", cloudStorage$StKVData.key.get());
                    jSONObject2.put("value", cloudStorage$StKVData.value.get());
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put("KVDataList", jSONArray);
                return jSONObject;
            }
            QMLog.d(TAG, "onResponse fail.rsp = null");
            return null;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
