package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StModifyFriendInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StModifyFriendInteractiveStorageRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ModifyFriendInteractiveStorageRequest extends ProtoBufRequest {
    private static final String TAG = "ModifyFriendInteractiveStorageRequest";
    private CloudStorage$StModifyFriendInteractiveStorageReq req;

    public ModifyFriendInteractiveStorageRequest(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3, String str4, HashMap<String, String> hashMap, boolean z16, CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate) {
        CloudStorage$StModifyFriendInteractiveStorageReq cloudStorage$StModifyFriendInteractiveStorageReq = new CloudStorage$StModifyFriendInteractiveStorageReq();
        this.req = cloudStorage$StModifyFriendInteractiveStorageReq;
        if (stCommonExt != null) {
            cloudStorage$StModifyFriendInteractiveStorageReq.ext.set(stCommonExt);
        }
        this.req.appid.set(str);
        this.req.toUser.set(str2);
        this.req.shareId.set(str3);
        this.req.opNum.set(i3);
        this.req.operation.set(str4);
        this.req.quiet.set(z16 ? 1 : 0);
        this.req.desc.set(cloudStorage$StInteractiveTemplate);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            CloudStorage$StKVData cloudStorage$StKVData = new CloudStorage$StKVData();
            cloudStorage$StKVData.key.set(entry.getKey());
            cloudStorage$StKVData.value.set(entry.getValue());
            this.req.KVDataList.add(cloudStorage$StKVData);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "ModifyFriendInteractiveStorage";
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
        CloudStorage$StModifyFriendInteractiveStorageRsp cloudStorage$StModifyFriendInteractiveStorageRsp = new CloudStorage$StModifyFriendInteractiveStorageRsp();
        try {
            cloudStorage$StModifyFriendInteractiveStorageRsp.mergeFrom(bArr);
            jSONObject.put("response", cloudStorage$StModifyFriendInteractiveStorageRsp);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
