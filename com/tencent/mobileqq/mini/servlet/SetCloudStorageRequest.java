package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StSetUserCloudStorageReq;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetCloudStorageRequest extends ProtoBufRequest {
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

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
