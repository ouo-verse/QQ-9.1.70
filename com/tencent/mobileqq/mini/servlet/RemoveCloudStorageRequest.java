package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StRemoveUserCloudStorageReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RemoveCloudStorageRequest extends ProtoBufRequest {
    private CloudStorage$StRemoveUserCloudStorageReq req = new CloudStorage$StRemoveUserCloudStorageReq();

    public RemoveCloudStorageRequest(String[] strArr, String str) {
        for (String str2 : strArr) {
            this.req.keyList.add(str2);
        }
        this.req.appid.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
