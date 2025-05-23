package com.tencent.mobileqq.mini.server.request;

import com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.trpcprotocol.minigame.authorization.app_auth.appAuth$SetAppAuthReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/MiniGameWifiAutoDownloadRequest;", "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "appId", "", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, "", "(Ljava/lang/String;Z)V", "getCmd", "getRequestData", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameWifiAutoDownloadRequest implements BaseMiniAppSSORequest {
    private static final String CMD = "miniapp.trpc.minigame.authorization.AppAuth.SetAppAuth";
    private static final String TAG = "MiniGameWifiAutoDownloadRequest";
    private final String appId;
    private final boolean auth;

    public MiniGameWifiAutoDownloadRequest(String appId, boolean z16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.appId = appId;
        this.auth = z16;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public String getCmd() {
        return CMD;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public byte[] getRequestData() {
        appAuth$SetAppAuthReq appauth_setappauthreq = new appAuth$SetAppAuthReq();
        appauth_setappauthreq.appid.set(this.appId);
        appauth_setappauthreq.type.set(2);
        appauth_setappauthreq.state.set(this.auth ? 1 : 0);
        byte[] byteArray = appauth_setappauthreq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
