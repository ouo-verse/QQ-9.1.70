package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetPotentialFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetPotentialFriendListRsp;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class GetPotentialFriendListRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetPotentialFriendList";
    public static final String TAG = "GetPotentialFriendListRequest";
    private static final String unikey = "GetPotentialFriendListRequest";
    private CloudStorage$StGetPotentialFriendListReq req;

    public GetPotentialFriendListRequest(COMM.StCommonExt stCommonExt, String str) {
        CloudStorage$StGetPotentialFriendListReq cloudStorage$StGetPotentialFriendListReq = new CloudStorage$StGetPotentialFriendListReq();
        this.req = cloudStorage$StGetPotentialFriendListReq;
        if (stCommonExt != null) {
            cloudStorage$StGetPotentialFriendListReq.ext.set(stCommonExt);
        }
        this.req.appid.set(str);
    }

    public static CloudStorage$StGetPotentialFriendListRsp onResponse(byte[] bArr) {
        CloudStorage$StGetPotentialFriendListRsp cloudStorage$StGetPotentialFriendListRsp = new CloudStorage$StGetPotentialFriendListRsp();
        try {
            cloudStorage$StGetPotentialFriendListRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return cloudStorage$StGetPotentialFriendListRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetPotentialFriendListRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
