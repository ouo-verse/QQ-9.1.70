package com.tencent.mobileqq.icgame.api.impl.room.module;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w22.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/module/SdkLoginStateModule;", "", "Lcom/tencent/mobileqq/icgame/api/IQQLiveSDK;", "liveSDK", "Lcom/tencent/mobileqq/icgame/api/impl/room/module/SdkLoginStateModule$CheckLoginStageCallback;", "callback", "", "checkLoginState", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "iAegisLogApi", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lw22/a;", "loginCallback", "Lw22/a;", "<init>", "()V", "Companion", "CheckLoginStageCallback", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class SdkLoginStateModule {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String TAG = "ICGameSdkLoginStateModule";

    @NotNull
    private final IAegisLogApi iAegisLogApi;

    @Nullable
    private a loginCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/module/SdkLoginStateModule$CheckLoginStageCallback;", "", "onCheckResult", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "", "errorMsg", "", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public interface CheckLoginStageCallback {
        void onCheckResult(boolean isLogin, @NotNull String errorMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/module/SdkLoginStateModule$Companion;", "", "()V", "TAG", "", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public SdkLoginStateModule() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.iAegisLogApi = (IAegisLogApi) api;
    }

    public final void checkLoginState(@Nullable final IQQLiveSDK liveSDK, @NotNull final CheckLoginStageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNull(liveSDK);
        final IQQLiveModuleLogin loginModule = liveSDK.getLoginModule();
        if (loginModule.getLoginStatus() != 3 && loginModule.getLoginStatus() != 0) {
            if (loginModule.getLoginStatus() == 2) {
                this.iAegisLogApi.i(TAG, 1, "waiting login");
                a aVar = this.loginCallback;
                if (aVar != null) {
                    loginModule.unregisterLoginStateCallback(aVar);
                }
                a aVar2 = new a() { // from class: com.tencent.mobileqq.icgame.api.impl.room.module.SdkLoginStateModule$checkLoginState$1
                    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
                    public void onFailed(int errorCode, @NotNull String errorMsg) {
                        IAegisLogApi iAegisLogApi;
                        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                        iAegisLogApi = SdkLoginStateModule.this.iAegisLogApi;
                        iAegisLogApi.e("ICGameSdkLoginStateModule", 1, "login failed");
                        loginModule.unregisterLoginStateCallback(this);
                        callback.onCheckResult(false, "login failed");
                    }

                    @Override // w22.a
                    public void onSuccess(@NotNull LoginInfo loginInfo) {
                        IAegisLogApi iAegisLogApi;
                        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
                        iAegisLogApi = SdkLoginStateModule.this.iAegisLogApi;
                        iAegisLogApi.i("ICGameSdkLoginStateModule", 1, "login success");
                        loginModule.unregisterLoginStateCallback(this);
                        liveSDK.getDataReportModule().setLoginInfo(loginInfo);
                        callback.onCheckResult(true, "");
                    }
                };
                this.loginCallback = aVar2;
                loginModule.registerLoginStateCallback(aVar2);
                return;
            }
            liveSDK.getDataReportModule().setLoginInfo(loginModule.getLoginInfo());
            callback.onCheckResult(true, "");
            return;
        }
        this.iAegisLogApi.e(TAG, 1, "loginStatus is " + loginModule.getLoginStatus());
        callback.onCheckResult(false, "login failed");
    }
}
