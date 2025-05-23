package com.tencent.mobileqq.mini.server.request;

import com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest;
import com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service.SignToSReq;
import com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service.ToSInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/server/request/SignMiniGameUserAgreementRequest;", "Lcom/tencent/mobileqq/mini/server/BaseMiniAppSSORequest;", "appId", "", "versionNum", "isSigned", "", "isSubscribe", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCmd", "getRequestData", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SignMiniGameUserAgreementRequest implements BaseMiniAppSSORequest {
    private final String appId;
    private final boolean isSigned;
    private final boolean isSubscribe;
    private final String versionNum;

    public SignMiniGameUserAgreementRequest(String appId, String versionNum, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(versionNum, "versionNum");
        this.appId = appId;
        this.versionNum = versionNum;
        this.isSigned = z16;
        this.isSubscribe = z17;
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public String getCmd() {
        return "miniapp.trpc.minigame.terms_of_service.TermsOfService.SignToS";
    }

    @Override // com.tencent.mobileqq.mini.server.BaseMiniAppSSORequest
    public byte[] getRequestData() {
        SignToSReq signToSReq = new SignToSReq();
        ToSInfo toSInfo = new ToSInfo();
        toSInfo.appid.set(this.appId);
        toSInfo.version_num.set(this.versionNum);
        toSInfo.is_signed.set(this.isSigned);
        signToSReq.tos.set(toSInfo);
        signToSReq.is_subscribe.set(this.isSubscribe);
        byte[] byteArray = signToSReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
