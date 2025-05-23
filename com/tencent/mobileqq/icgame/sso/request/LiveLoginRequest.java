package com.tencent.mobileqq.icgame.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.util.QQDeviceInfo;
import dz0.d;
import dz0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u001aB7\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J!\u0010\f\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/icgame/sso/request/LiveLoginRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "needLogin", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "openId", "Ljava/lang/String;", CommonConstant.KEY_ACCESS_TOKEN, "authAppId", "loginExtData", "", "liveClientType", "I", "wantAppId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "a", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveLoginRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    public static final String LOG_TAG = "ICGameLogin|ICGameLiveLoginRequest";

    @NotNull
    private final String accessToken;

    @NotNull
    private final String authAppId;
    private final int liveClientType;

    @NotNull
    private final String loginExtData;

    @NotNull
    private final String openId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLoginRequest(@NotNull String wantAppId, @NotNull String openId, @NotNull String accessToken, @NotNull String authAppId, @NotNull String loginExtData, int i3) {
        super(wantAppId);
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(authAppId, "authAppId");
        Intrinsics.checkNotNullParameter(loginExtData, "loginExtData");
        this.openId = openId;
        this.accessToken = accessToken;
        this.authAppId = authAppId;
        this.loginExtData = loginExtData;
        this.liveClientType = i3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) d.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            a.INSTANCE.i(LOG_TAG, "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.icggame.login_svr.LoginSvr";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        e eVar = new e();
        eVar.f395256d = this.openId;
        eVar.f395257e = this.accessToken;
        eVar.f395255c = QQDeviceInfo.getQIMEI();
        eVar.f395258f = this.authAppId;
        eVar.f395259g = this.loginExtData;
        eVar.f395253a = this.liveClientType;
        return eVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return AegisLogger.LOGIN;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    public boolean needLogin() {
        return false;
    }
}
