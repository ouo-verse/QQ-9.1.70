package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StSetUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StSetUserCloudStorageRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SetCloudStorageRequest extends ProtoBufRequest {
    private static final String TAG = "SetCloudStorageRequest";
    private CloudStorage$StSetUserCloudStorageReq req = new CloudStorage$StSetUserCloudStorageReq();

    public SetCloudStorageRequest(HashMap<String, String> hashMap, String str) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            CloudStorage$StKVData cloudStorage$StKVData = new CloudStorage$StKVData();
            cloudStorage$StKVData.key.set(entry.getKey());
            cloudStorage$StKVData.value.set(entry.getValue());
            this.req.KVDataList.add(cloudStorage$StKVData);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "SetUserCloudStorage";
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
        try {
            new MessageMicro<CloudStorage$StSetUserCloudStorageRsp>() { // from class: NS_MINI_CLOUDSTORAGE.CloudStorage$StSetUserCloudStorageRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext"}, new Object[]{null}, CloudStorage$StSetUserCloudStorageRsp.class);
                public COMM.StCommonExt ext = new COMM.StCommonExt();
            }.mergeFrom(bArr);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
