package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_AD.MiniAppAd$ContextInfo;
import NS_MINI_AD.MiniAppAd$DebugInfo;
import NS_MINI_AD.MiniAppAd$DeviceInfo;
import NS_MINI_AD.MiniAppAd$PositionInfo;
import NS_MINI_AD.MiniAppAd$StGetAdReq;
import NS_MINI_AD.MiniAppAd$StGetAdRsp;
import NS_MINI_AD.MiniAppAd$UserInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetAdRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_ad.GetAd";
    public static final String TAG = "MiniAppGetAdRequest";
    private static final String unikey = "MiniAppGetAdRequest";
    private MiniAppAd$StGetAdReq req;

    public MiniAppGetAdRequest(COMM.StCommonExt stCommonExt, MiniAppAd$UserInfo miniAppAd$UserInfo, MiniAppAd$PositionInfo miniAppAd$PositionInfo, MiniAppAd$DeviceInfo miniAppAd$DeviceInfo, MiniAppAd$ContextInfo miniAppAd$ContextInfo, MiniAppAd$DebugInfo miniAppAd$DebugInfo, String str, boolean z16, String str2, String str3, int i3) {
        MiniAppAd$StGetAdReq miniAppAd$StGetAdReq = new MiniAppAd$StGetAdReq();
        this.req = miniAppAd$StGetAdReq;
        if (stCommonExt != null) {
            miniAppAd$StGetAdReq.extInfo.set(stCommonExt);
        }
        if (miniAppAd$UserInfo != null) {
            this.req.user_info.set(miniAppAd$UserInfo);
        }
        if (miniAppAd$PositionInfo != null) {
            this.req.position_info.add(miniAppAd$PositionInfo);
        }
        if (miniAppAd$DeviceInfo != null) {
            this.req.device_info.set(miniAppAd$DeviceInfo);
        }
        if (miniAppAd$ContextInfo != null) {
            this.req.context_info.set(miniAppAd$ContextInfo);
        }
        if (miniAppAd$DebugInfo != null) {
            this.req.debug_info.set(miniAppAd$DebugInfo);
        }
        this.req.gdt_cookie.set(str);
        this.req.support_https.set(z16);
        this.req.busi_cookie.set(str2);
        this.req.appid.set(str3);
        this.req.ad_type.set(i3);
    }

    public static MiniAppAd$StGetAdRsp onResponse(byte[] bArr) {
        MiniAppAd$StGetAdRsp miniAppAd$StGetAdRsp = new MiniAppAd$StGetAdRsp();
        try {
            miniAppAd$StGetAdRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppAd$StGetAdRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("MiniAppGetAdRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
