package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetReactiveFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetReactiveFriendListRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetReactiveFriendListRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.GetReactiveFriendList";
    public static final String TAG = "GetReactiveFriendListRequest";
    private static final String unikey = "GetReactiveFriendListRequest";
    private CloudStorage$StGetReactiveFriendListReq req;

    public GetReactiveFriendListRequest(COMM.StCommonExt stCommonExt, String str) {
        CloudStorage$StGetReactiveFriendListReq cloudStorage$StGetReactiveFriendListReq = new CloudStorage$StGetReactiveFriendListReq();
        this.req = cloudStorage$StGetReactiveFriendListReq;
        if (stCommonExt != null) {
            cloudStorage$StGetReactiveFriendListReq.ext.set(stCommonExt);
        }
        this.req.appid.set(str);
    }

    public static CloudStorage$StGetReactiveFriendListRsp onResponse(byte[] bArr) {
        CloudStorage$StGetReactiveFriendListRsp cloudStorage$StGetReactiveFriendListRsp = new CloudStorage$StGetReactiveFriendListRsp();
        try {
            cloudStorage$StGetReactiveFriendListRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return cloudStorage$StGetReactiveFriendListRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetReactiveFriendListRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
