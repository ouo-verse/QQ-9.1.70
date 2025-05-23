package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserInteractiveStorageRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserInteractiveStorageRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetUserInteractiveStorage";
    public static final String TAG = "GetUserInteractiveStorageRequest";
    private static final String unikey = "GetUserInteractiveStorageRequest";
    private CloudStorage$StGetUserInteractiveStorageReq req;

    public GetUserInteractiveStorageRequest(COMM.StCommonExt stCommonExt, String str, String[] strArr) {
        CloudStorage$StGetUserInteractiveStorageReq cloudStorage$StGetUserInteractiveStorageReq = new CloudStorage$StGetUserInteractiveStorageReq();
        this.req = cloudStorage$StGetUserInteractiveStorageReq;
        if (stCommonExt != null) {
            cloudStorage$StGetUserInteractiveStorageReq.ext.set(stCommonExt);
        }
        for (String str2 : strArr) {
            this.req.keyList.add(str2);
        }
        this.req.appid.set(str);
    }

    public static CloudStorage$StGetUserInteractiveStorageRsp onResponse(byte[] bArr) {
        CloudStorage$StGetUserInteractiveStorageRsp cloudStorage$StGetUserInteractiveStorageRsp = new CloudStorage$StGetUserInteractiveStorageRsp();
        try {
            cloudStorage$StGetUserInteractiveStorageRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return cloudStorage$StGetUserInteractiveStorageRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetUserInteractiveStorageRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
