package com.tencent.luggage.wxaapi;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum LaunchWxaAppResult {
    OK(0),
    FailNoAuth(10001),
    Fail(10002),
    Cancel(10003),
    FailUpdateContact(10004),
    FailWxaAppIdSync(10004),
    FailPubLibNotSupport(10005),
    FailForbidRunIn3rdApp(10006),
    FailWxaAppOffline(10007),
    FailWxaAppForbidden(10008),
    FailNotLoadDynamicPkg(30001),
    FailMiniGameNotSupported(30002),
    FailQRCodeInvalid(21002),
    FailQRCodeRespFullUrlInvalid(21003),
    FailQRCodeDevCodeExpired(21004),
    FailQRCodeDevCodeAccessDenied(21005);

    public final int code;

    LaunchWxaAppResult(int i3) {
        this.code = i3;
    }
}
