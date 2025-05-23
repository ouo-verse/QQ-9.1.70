package com.tencent.mobileqq.wxmini.api.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b'\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wxmini/api/data/LaunchWxaErrorCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "Success", "FailParams", "FailDownloadSo", "FailNotSupport", "FailAppInfo", "FailRequestWxaInfo", "FailTeenager", "FailLoadDynamic", "FailBlackAppId", "FailAuthCommon", "FailLaunchCommon", "WechatTdi_Auth_Err_UserCanceled", "WechatTdi_Auth_Err_UserDenied", "WechatTdi_Auth_Err_System", "WechatTdi_Auth_Err_InvalidArgs", "WechatTdi_Auth_Err_NormalErr", "WechatTdi_Auth_Err_WechatNotInstalled", "WechatTdi_Auth_Err_WechatVersionTooLow", "WechatTdi_Auth_Err_ActiveDeviceFailed", "WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded", "FailNoAuth", "Fail", "Cancel", "FailUpdateContact", "FailWxaAppIdSync", "FailPubLibNotSupport", "FailForbidRunIn3rdApp", "FailWxaAppOffline", "FailWxaAppForbidden", "FailNotLoadDynamicPkg", "FailMiniGameNotSupported", "FailQRCodeInvalid", "FailQRCodeRespFullUrlInvalid", "FailQRCodeDevCodeExpired", "FailQRCodeDevCodeAccessDenied", "wxmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class LaunchWxaErrorCode {
    private static final /* synthetic */ LaunchWxaErrorCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LaunchWxaErrorCode Cancel;
    public static final LaunchWxaErrorCode Fail;
    public static final LaunchWxaErrorCode FailAppInfo;
    public static final LaunchWxaErrorCode FailAuthCommon;
    public static final LaunchWxaErrorCode FailBlackAppId;
    public static final LaunchWxaErrorCode FailDownloadSo;
    public static final LaunchWxaErrorCode FailForbidRunIn3rdApp;
    public static final LaunchWxaErrorCode FailLaunchCommon;
    public static final LaunchWxaErrorCode FailLoadDynamic;
    public static final LaunchWxaErrorCode FailMiniGameNotSupported;
    public static final LaunchWxaErrorCode FailNoAuth;
    public static final LaunchWxaErrorCode FailNotLoadDynamicPkg;
    public static final LaunchWxaErrorCode FailNotSupport;
    public static final LaunchWxaErrorCode FailParams;
    public static final LaunchWxaErrorCode FailPubLibNotSupport;
    public static final LaunchWxaErrorCode FailQRCodeDevCodeAccessDenied;
    public static final LaunchWxaErrorCode FailQRCodeDevCodeExpired;
    public static final LaunchWxaErrorCode FailQRCodeInvalid;
    public static final LaunchWxaErrorCode FailQRCodeRespFullUrlInvalid;
    public static final LaunchWxaErrorCode FailRequestWxaInfo;
    public static final LaunchWxaErrorCode FailTeenager;
    public static final LaunchWxaErrorCode FailUpdateContact;
    public static final LaunchWxaErrorCode FailWxaAppForbidden;
    public static final LaunchWxaErrorCode FailWxaAppIdSync;
    public static final LaunchWxaErrorCode FailWxaAppOffline;
    public static final LaunchWxaErrorCode Success;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_ActiveDeviceFailed;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_InvalidArgs;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_NormalErr;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_System;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_UserCanceled;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_UserDenied;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_WechatNotInstalled;
    public static final LaunchWxaErrorCode WechatTdi_Auth_Err_WechatVersionTooLow;
    private final int code;

    private static final /* synthetic */ LaunchWxaErrorCode[] $values() {
        return new LaunchWxaErrorCode[]{Success, FailParams, FailDownloadSo, FailNotSupport, FailAppInfo, FailRequestWxaInfo, FailTeenager, FailLoadDynamic, FailBlackAppId, FailAuthCommon, FailLaunchCommon, WechatTdi_Auth_Err_UserCanceled, WechatTdi_Auth_Err_UserDenied, WechatTdi_Auth_Err_System, WechatTdi_Auth_Err_InvalidArgs, WechatTdi_Auth_Err_NormalErr, WechatTdi_Auth_Err_WechatNotInstalled, WechatTdi_Auth_Err_WechatVersionTooLow, WechatTdi_Auth_Err_ActiveDeviceFailed, WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded, FailNoAuth, Fail, Cancel, FailUpdateContact, FailWxaAppIdSync, FailPubLibNotSupport, FailForbidRunIn3rdApp, FailWxaAppOffline, FailWxaAppForbidden, FailNotLoadDynamicPkg, FailMiniGameNotSupported, FailQRCodeInvalid, FailQRCodeRespFullUrlInvalid, FailQRCodeDevCodeExpired, FailQRCodeDevCodeAccessDenied};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        Success = new LaunchWxaErrorCode("Success", 0, 0);
        FailParams = new LaunchWxaErrorCode("FailParams", 1, -1);
        FailDownloadSo = new LaunchWxaErrorCode("FailDownloadSo", 2, -2);
        FailNotSupport = new LaunchWxaErrorCode("FailNotSupport", 3, -3);
        FailAppInfo = new LaunchWxaErrorCode("FailAppInfo", 4, -4);
        FailRequestWxaInfo = new LaunchWxaErrorCode("FailRequestWxaInfo", 5, -5);
        FailTeenager = new LaunchWxaErrorCode("FailTeenager", 6, -6);
        FailLoadDynamic = new LaunchWxaErrorCode("FailLoadDynamic", 7, -7);
        FailBlackAppId = new LaunchWxaErrorCode("FailBlackAppId", 8, -8);
        FailAuthCommon = new LaunchWxaErrorCode("FailAuthCommon", 9, -9);
        FailLaunchCommon = new LaunchWxaErrorCode("FailLaunchCommon", 10, -10);
        WechatTdi_Auth_Err_UserCanceled = new LaunchWxaErrorCode("WechatTdi_Auth_Err_UserCanceled", 11, 1);
        WechatTdi_Auth_Err_UserDenied = new LaunchWxaErrorCode("WechatTdi_Auth_Err_UserDenied", 12, 2);
        WechatTdi_Auth_Err_System = new LaunchWxaErrorCode("WechatTdi_Auth_Err_System", 13, 3);
        WechatTdi_Auth_Err_InvalidArgs = new LaunchWxaErrorCode("WechatTdi_Auth_Err_InvalidArgs", 14, 4);
        WechatTdi_Auth_Err_NormalErr = new LaunchWxaErrorCode("WechatTdi_Auth_Err_NormalErr", 15, 5);
        WechatTdi_Auth_Err_WechatNotInstalled = new LaunchWxaErrorCode("WechatTdi_Auth_Err_WechatNotInstalled", 16, 6);
        WechatTdi_Auth_Err_WechatVersionTooLow = new LaunchWxaErrorCode("WechatTdi_Auth_Err_WechatVersionTooLow", 17, 7);
        WechatTdi_Auth_Err_ActiveDeviceFailed = new LaunchWxaErrorCode("WechatTdi_Auth_Err_ActiveDeviceFailed", 18, 8);
        WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded = new LaunchWxaErrorCode("WechatTdi_Auth_Err_Dynamic_Pkg_Not_Loaded", 19, 9);
        FailNoAuth = new LaunchWxaErrorCode("FailNoAuth", 20, 10001);
        Fail = new LaunchWxaErrorCode("Fail", 21, 10002);
        Cancel = new LaunchWxaErrorCode("Cancel", 22, 10003);
        FailUpdateContact = new LaunchWxaErrorCode("FailUpdateContact", 23, 10004);
        FailWxaAppIdSync = new LaunchWxaErrorCode("FailWxaAppIdSync", 24, 10004);
        FailPubLibNotSupport = new LaunchWxaErrorCode("FailPubLibNotSupport", 25, 10005);
        FailForbidRunIn3rdApp = new LaunchWxaErrorCode("FailForbidRunIn3rdApp", 26, 10006);
        FailWxaAppOffline = new LaunchWxaErrorCode("FailWxaAppOffline", 27, 10007);
        FailWxaAppForbidden = new LaunchWxaErrorCode("FailWxaAppForbidden", 28, 10008);
        FailNotLoadDynamicPkg = new LaunchWxaErrorCode("FailNotLoadDynamicPkg", 29, 30001);
        FailMiniGameNotSupported = new LaunchWxaErrorCode("FailMiniGameNotSupported", 30, 30002);
        FailQRCodeInvalid = new LaunchWxaErrorCode("FailQRCodeInvalid", 31, 21002);
        FailQRCodeRespFullUrlInvalid = new LaunchWxaErrorCode("FailQRCodeRespFullUrlInvalid", 32, 21003);
        FailQRCodeDevCodeExpired = new LaunchWxaErrorCode("FailQRCodeDevCodeExpired", 33, 21004);
        FailQRCodeDevCodeAccessDenied = new LaunchWxaErrorCode("FailQRCodeDevCodeAccessDenied", 34, 21005);
        $VALUES = $values();
    }

    LaunchWxaErrorCode(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.code = i16;
        }
    }

    public static LaunchWxaErrorCode valueOf(String str) {
        return (LaunchWxaErrorCode) Enum.valueOf(LaunchWxaErrorCode.class, str);
    }

    public static LaunchWxaErrorCode[] values() {
        return (LaunchWxaErrorCode[]) $VALUES.clone();
    }

    public final int getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.code;
    }
}
