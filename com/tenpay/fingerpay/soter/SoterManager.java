package com.tenpay.fingerpay.soter;

import android.content.Context;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.core.model.SoterSignatureResult;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricCanceller;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessAuthenticationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessKeyPreparationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessNoExtResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_task.AuthenticationParam;
import com.tencent.soter.wrapper.wrap_task.InitializeParam;
import com.tenpay.api.QFuncProxy;
import com.tenpay.compat.SoterBiometricStateCallbackCompat;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.FingerNet.PrepareASkData;
import com.tenpay.sdk.FingerNet.UploadPayAuthKeyNet;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.QwLog4Soter;
import com.tenpay.util.MD5;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0018J&\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tenpay/fingerpay/soter/SoterManager;", "", "()V", "authKeyModel", "Lcom/tencent/soter/core/model/SoterPubKeyModel;", "fingerAuthenResult", "Lcom/tencent/soter/core/model/SoterSignatureResult;", "soterBiometricCanceller", "Lcom/tencent/soter/wrapper/wrap_biometric/SoterBiometricCanceller;", "createAuthenticationParam", "Lcom/tencent/soter/wrapper/wrap_task/AuthenticationParam;", "context", "Landroid/content/Context;", "intentBusType", "", "uin", "", "callback", "Lcom/tenpay/fingerpay/soter/SoterManagerCallback;", "generateChallenge", "getASKModel", "getAuthKeyModel", "getFingerAuthenResult", "initSoter", "", "initCallback", "Lcom/tenpay/fingerpay/soter/SoterInitCallback;", "prepareAuthKey", "soterCallback", "Lcom/tenpay/fingerpay/soter/SoterPrepareCallback;", "releaseFp", "requestSoterAuthorize", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class SoterManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "SoterManager";

    @Nullable
    private SoterPubKeyModel authKeyModel;

    @Nullable
    private SoterSignatureResult fingerAuthenResult;

    @Nullable
    private SoterBiometricCanceller soterBiometricCanceller;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/fingerpay/soter/SoterManager$Companion;", "", "()V", "TAG", "", "isSupportSoter", "", "removeAuthKeyByScene", "", "scene", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isSupportSoter() {
            return SoterWrapperApi.isSupportSoter();
        }

        public final void removeAuthKeyByScene(int scene) {
            SoterWrapperApi.removeAuthKeyByScene(scene);
        }

        Companion() {
        }
    }

    private final AuthenticationParam createAuthenticationParam(Context context, int intentBusType, String uin, final SoterManagerCallback callback) {
        if (this.soterBiometricCanceller != null) {
            QLog.i(TAG, 1, "last canceller is not null. should not happen because we will set it to null every time we finished the process");
        }
        this.soterBiometricCanceller = new SoterBiometricCanceller();
        AuthenticationParam build = new AuthenticationParam.AuthenticationParamBuilder().setScene(Cgi.scene_FingerPay).setBiometricType(QWSoterConstans.getBiometricType(intentBusType)).setContext(context).setSoterBiometricCanceller(this.soterBiometricCanceller).setPrefilledChallenge(generateChallenge(context, uin)).setSoterBiometricStateCallback(new SoterBiometricStateCallbackCompat() { // from class: com.tenpay.fingerpay.soter.SoterManager$createAuthenticationParam$1
            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationCancelled() {
                this.soterBiometricCanceller = null;
                SoterManagerCallback.this.onAuthenticationCancelled();
            }

            @Override // com.tenpay.compat.SoterBiometricStateCallbackCompat
            public void onAuthenticationErrorCompat(int errCode, @Nullable CharSequence errMsg) {
                QLog.i(SoterManager.TAG, 1, "onAuthenticationError:" + errCode + ",CharSequence:" + ((Object) errMsg));
                this.soterBiometricCanceller = null;
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationFailed() {
                SoterManagerCallback.this.onAuthenticationFailed();
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationHelp(int helpCode, @NotNull CharSequence helpString) {
                Intrinsics.checkNotNullParameter(helpString, "helpString");
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationSucceed() {
                QLog.i(SoterManager.TAG, 1, "onAuthenticationSucceed()");
                SoterManagerCallback.this.onAuthenticationSucceed();
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onStartAuthentication() {
                SoterManagerCallback.this.onStartAuthentication();
            }
        }).build();
        Intrinsics.checkNotNullExpressionValue(build, "private fun createAuthen\u2026         }).build()\n    }");
        return build;
    }

    private final String generateChallenge(Context context, String uin) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("device_id=");
        stringBuffer.append(QFuncProxy.getDeviceId(context));
        stringBuffer.append("&is_root=");
        stringBuffer.append(NetUtil.isPhoneRooted(context) ? 1 : 0);
        stringBuffer.append("&uin=");
        stringBuffer.append(uin);
        String hexdigest = MD5.hexdigest(stringBuffer.toString());
        Intrinsics.checkNotNullExpressionValue(hexdigest, "hexdigest(sb.toString())");
        return hexdigest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSoter$lambda$0(SoterInitCallback initCallback, SoterProcessNoExtResult result) {
        Intrinsics.checkNotNullParameter(initCallback, "$initCallback");
        Intrinsics.checkNotNullParameter(result, "result");
        VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "fingerprint.get.support", null, null, result.errCode, result.errMsg);
        QLog.i(TAG, 1, "get is support soter done. result: " + result + ",isSupportSoter:" + SoterWrapperApi.isSupportSoter());
        if ((result.isSuccess() || result.errCode == 1028) && SoterWrapperApi.isSupportSoter()) {
            initCallback.onSuccess();
        } else {
            initCallback.onFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareAuthKey$lambda$1(SoterManager this$0, SoterPrepareCallback soterCallback, SoterProcessKeyPreparationResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(soterCallback, "$soterCallback");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i(TAG, 1, "\u751f\u6210AuthKey\u7ed3\u679c\uff1a" + result);
        VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "fingerprint.get.authkey", null, null, result.errCode, result.errMsg);
        if (result.isSuccess()) {
            SoterPubKeyModel extData = result.getExtData();
            if (extData != null) {
                this$0.authKeyModel = extData;
                soterCallback.onSuccess();
                return;
            }
            return;
        }
        soterCallback.onFailed(result.getErrCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestSoterAuthorize$lambda$2(SoterManager this$0, SoterManagerCallback soterCallback, SoterProcessAuthenticationResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(soterCallback, "$soterCallback");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i(TAG, 1, "requestAuthorizeAndSign result\uff1a" + result);
        int i3 = result.errCode;
        if (i3 != 0) {
            if (i3 != 3) {
                if (i3 != 1021) {
                    if (i3 != 1005) {
                        if (i3 != 1006) {
                            soterCallback.onSoterProcessFailed();
                            return;
                        }
                    } else {
                        INSTANCE.removeAuthKeyByScene(Cgi.scene_FingerPay);
                        soterCallback.onSoterProcessRetry();
                        return;
                    }
                } else {
                    soterCallback.onSoterFingerLocked();
                    return;
                }
            }
            soterCallback.onSoterProcessRetry();
            return;
        }
        this$0.fingerAuthenResult = result.getExtData();
        soterCallback.onSoterProcessSucceed();
    }

    @Nullable
    public final SoterPubKeyModel getASKModel() {
        return SoterCore.getAppGlobalSecureKeyModel();
    }

    @Nullable
    public final SoterPubKeyModel getAuthKeyModel() {
        return this.authKeyModel;
    }

    @Nullable
    public final SoterSignatureResult getFingerAuthenResult() {
        return this.fingerAuthenResult;
    }

    public final void initSoter(@NotNull String uin, @NotNull Context context, @NotNull final SoterInitCallback initCallback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initCallback, "initCallback");
        if (SoterWrapperApi.isInitialized()) {
            if (SoterWrapperApi.isSupportSoter()) {
                initCallback.onSuccess();
                return;
            } else {
                initCallback.onFailed();
                return;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", uin);
        try {
            SoterWrapperApi.init(context, new SoterProcessCallback() { // from class: com.tenpay.fingerpay.soter.c
                @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
                public final void onResult(SoterProcessResultBase soterProcessResultBase) {
                    SoterManager.initSoter$lambda$0(SoterInitCallback.this, (SoterProcessNoExtResult) soterProcessResultBase);
                }
            }, new InitializeParam.InitializeParamBuilder().setGetSupportNetWrapper(new GetSupportSoterNet(context, hashMap)).setScenes(Cgi.scene_FingerPay).setDistinguishSalt(uin).setSoterLogger(QwLog4Soter.getInstance()).build());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            initCallback.onFailed();
        } catch (OutOfMemoryError e17) {
            QLog.e(TAG, 1, "", e17);
            initCallback.onFailed();
        }
    }

    public final void prepareAuthKey(@NotNull final SoterPrepareCallback soterCallback) {
        Intrinsics.checkNotNullParameter(soterCallback, "soterCallback");
        SoterWrapperApi.prepareAuthKey(new SoterProcessCallback() { // from class: com.tenpay.fingerpay.soter.b
            @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
            public final void onResult(SoterProcessResultBase soterProcessResultBase) {
                SoterManager.prepareAuthKey$lambda$1(SoterManager.this, soterCallback, (SoterProcessKeyPreparationResult) soterProcessResultBase);
            }
        }, false, true, Cgi.scene_FingerPay, new UploadPayAuthKeyNet(), new PrepareASkData());
    }

    public final void releaseFp() {
        if (SoterWrapperApi.isSupportSoter()) {
            SoterBiometricCanceller soterBiometricCanceller = this.soterBiometricCanceller;
            if (soterBiometricCanceller != null) {
                soterBiometricCanceller.asyncCancelBiometricAuthentication();
            }
            this.soterBiometricCanceller = null;
        }
    }

    public final void requestSoterAuthorize(@NotNull Context context, int intentBusType, @NotNull String uin, @NotNull final SoterManagerCallback soterCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(soterCallback, "soterCallback");
        SoterWrapperApi.requestAuthorizeAndSign(new SoterProcessCallback() { // from class: com.tenpay.fingerpay.soter.a
            @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
            public final void onResult(SoterProcessResultBase soterProcessResultBase) {
                SoterManager.requestSoterAuthorize$lambda$2(SoterManager.this, soterCallback, (SoterProcessAuthenticationResult) soterProcessResultBase);
            }
        }, createAuthenticationParam(context, intentBusType, uin, soterCallback));
    }
}
