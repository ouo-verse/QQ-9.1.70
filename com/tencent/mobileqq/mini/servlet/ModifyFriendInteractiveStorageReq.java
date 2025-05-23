package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StModifyFriendInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StModifyFriendInteractiveStorageRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ModifyFriendInteractiveStorageReq extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.ModifyFriendInteractiveStorage";
    public static final String TAG = "ModifyFriendInteractiveStorageReq";
    private static final String unikey = "ModifyFriendInteractiveStorageReq";
    private CloudStorage$StModifyFriendInteractiveStorageReq req;

    public ModifyFriendInteractiveStorageReq(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3, String str4, HashMap<String, String> hashMap, boolean z16, CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate) {
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
        if (cloudStorage$StInteractiveTemplate != null) {
            this.req.desc.set(cloudStorage$StInteractiveTemplate);
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            CloudStorage$StKVData cloudStorage$StKVData = new CloudStorage$StKVData();
            cloudStorage$StKVData.key.set(entry.getKey());
            cloudStorage$StKVData.value.set(entry.getValue());
            this.req.KVDataList.add(cloudStorage$StKVData);
        }
    }

    public static CloudStorage$StModifyFriendInteractiveStorageRsp onResponse(byte[] bArr) {
        CloudStorage$StModifyFriendInteractiveStorageRsp cloudStorage$StModifyFriendInteractiveStorageRsp = new CloudStorage$StModifyFriendInteractiveStorageRsp();
        try {
            cloudStorage$StModifyFriendInteractiveStorageRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return cloudStorage$StModifyFriendInteractiveStorageRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ModifyFriendInteractiveStorageReq", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
