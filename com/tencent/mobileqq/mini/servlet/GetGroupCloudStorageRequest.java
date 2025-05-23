package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetGroupCloudStorageReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetGroupCloudStorageRequest extends ProtoBufRequest {
    private CloudStorage$StGetGroupCloudStorageReq req = new CloudStorage$StGetGroupCloudStorageReq();

    public GetGroupCloudStorageRequest(String[] strArr, String str, String str2) {
        for (String str3 : strArr) {
            this.req.keyList.add(str3);
        }
        this.req.appid.set(str2);
        this.req.shareTicket.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
