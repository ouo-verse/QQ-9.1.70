package com.tencent.mobileqq.qqlive.api.impl.room.module;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.room.module.SdkLoginStateModule;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/module/SdkLoginStateModule;", "", "()V", "iAegisLogApi", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "loginCallback", "Lcom/tencent/mobileqq/qqlive/callback/login/IQQLiveLoginCallback;", "checkLoginState", "", "liveSDK", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "callback", "Lcom/tencent/mobileqq/qqlive/api/impl/room/module/SdkLoginStateModule$CheckLoginStageCallback;", "CheckLoginStageCallback", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class SdkLoginStateModule {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    @NotNull
    private static final String TAG = "SdkLoginStateModule";

    @NotNull
    private final IAegisLogApi iAegisLogApi;

    @Nullable
    private IQQLiveLoginCallback loginCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/module/SdkLoginStateModule$CheckLoginStageCallback;", "", "onCheckResult", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "", "errorMsg", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public interface CheckLoginStageCallback {
        void onCheckResult(boolean isLogin, @NotNull String errorMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/module/SdkLoginStateModule$Companion;", "", "()V", "TAG", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    private static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            Companion = new Companion(null);
        }
    }

    public SdkLoginStateModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.iAegisLogApi = (IAegisLogApi) api;
    }

    public final void checkLoginState(@Nullable final IQQLiveSDK liveSDK, @NotNull final CheckLoginStageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) liveSDK, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNull(liveSDK);
        final IQQLiveModuleLogin loginModule = liveSDK.getLoginModule();
        if (loginModule.getLoginStatus() != 3 && loginModule.getLoginStatus() != 0) {
            if (loginModule.getLoginStatus() == 2) {
                this.iAegisLogApi.i(TAG, 1, "waiting login");
                IQQLiveLoginCallback iQQLiveLoginCallback = this.loginCallback;
                if (iQQLiveLoginCallback != null) {
                    loginModule.unregisterLoginStateCallback(iQQLiveLoginCallback);
                }
                IQQLiveLoginCallback iQQLiveLoginCallback2 = new IQQLiveLoginCallback(loginModule, liveSDK, callback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.SdkLoginStateModule$checkLoginState$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ SdkLoginStateModule.CheckLoginStageCallback $callback;
                    final /* synthetic */ IQQLiveSDK $liveSDK;
                    final /* synthetic */ IQQLiveModuleLogin $loginModule;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$loginModule = loginModule;
                        this.$liveSDK = liveSDK;
                        this.$callback = callback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, SdkLoginStateModule.this, loginModule, liveSDK, callback);
                        }
                    }

                    @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
                    public void onFailed(int errorCode, @NotNull String errorMsg) {
                        IAegisLogApi iAegisLogApi;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                        iAegisLogApi = SdkLoginStateModule.this.iAegisLogApi;
                        iAegisLogApi.e("SdkLoginStateModule", 1, "login failed");
                        this.$loginModule.unregisterLoginStateCallback(this);
                        this.$callback.onCheckResult(false, "login failed");
                    }

                    @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
                    public void onSuccess(@NotNull LoginInfo loginInfo) {
                        IAegisLogApi iAegisLogApi;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) loginInfo);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
                        iAegisLogApi = SdkLoginStateModule.this.iAegisLogApi;
                        iAegisLogApi.i("SdkLoginStateModule", 1, "login success");
                        this.$loginModule.unregisterLoginStateCallback(this);
                        this.$liveSDK.getDataReportModule().setLoginInfo(loginInfo);
                        this.$callback.onCheckResult(true, "");
                    }
                };
                this.loginCallback = iQQLiveLoginCallback2;
                loginModule.registerLoginStateCallback(iQQLiveLoginCallback2);
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
