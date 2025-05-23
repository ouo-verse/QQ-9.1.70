package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_APP_MISC.MISC$StGetFriendPlayListV2Req;
import NS_MINI_APP_MISC.MISC$StGetFriendPlayListV2Rsp;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class GetFriendPlayListV2Request extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetFriendPlayListV2Request";
    private MISC$StGetFriendPlayListV2Req req;

    public GetFriendPlayListV2Request(COMM.StCommonExt stCommonExt, String str, int i3) {
        MISC$StGetFriendPlayListV2Req mISC$StGetFriendPlayListV2Req = new MISC$StGetFriendPlayListV2Req();
        this.req = mISC$StGetFriendPlayListV2Req;
        mISC$StGetFriendPlayListV2Req.friendUin.set(str);
        this.req.pageSize.set(i3);
        if (stCommonExt != null) {
            this.req.ext.set(stCommonExt);
        }
        QLog.d("ProtoBufRequest", 1, "MiniAppSummaryCard GetFriendPlayListV2Request friendUin:", str, " pageSize:", Integer.valueOf(i3));
    }

    public static MISC$StGetFriendPlayListV2Rsp onResponse(byte[] bArr) {
        MISC$StGetFriendPlayListV2Rsp mISC$StGetFriendPlayListV2Rsp = new MISC$StGetFriendPlayListV2Rsp();
        try {
            mISC$StGetFriendPlayListV2Rsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return mISC$StGetFriendPlayListV2Rsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
