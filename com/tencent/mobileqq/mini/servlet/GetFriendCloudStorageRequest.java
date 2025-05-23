package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetFriendCloudStorageReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetFriendCloudStorageRequest extends ProtoBufRequest {
    private CloudStorage$StGetFriendCloudStorageReq req = new CloudStorage$StGetFriendCloudStorageReq();

    public GetFriendCloudStorageRequest(String[] strArr, String str) {
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
