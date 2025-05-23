package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StCurrChannelInfo;
import NS_MINI_INTERFACE.INTERFACE$StUseUserAppReq;
import NS_MINI_INTERFACE.INTERFACE$StUseUserAppRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UseUserAppRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.UseUserApp";
    public static final String TAG = "UseUserAppRequest";
    private INTERFACE$StUseUserAppReq req;

    public UseUserAppRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, String str2, String str3) {
        INTERFACE$StUseUserAppReq iNTERFACE$StUseUserAppReq = new INTERFACE$StUseUserAppReq();
        this.req = iNTERFACE$StUseUserAppReq;
        iNTERFACE$StUseUserAppReq.appId.set(str);
        this.req.verType.set(i3);
        this.req.source.set(i16);
        INTERFACE$StCurrChannelInfo iNTERFACE$StCurrChannelInfo = new INTERFACE$StCurrChannelInfo();
        iNTERFACE$StCurrChannelInfo.refer.set(str2);
        iNTERFACE$StCurrChannelInfo.via.set(str3);
        this.req.channelInfo.set(iNTERFACE$StCurrChannelInfo);
        this.req.needRecommend.set(1);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StUseUserAppRsp onResponse(byte[] bArr) {
        INTERFACE$StUseUserAppRsp iNTERFACE$StUseUserAppRsp = new INTERFACE$StUseUserAppRsp();
        try {
            iNTERFACE$StUseUserAppRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StUseUserAppRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("UseUserAppRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
