package com.tencent.mobileqq.login.ntlogin.mainline;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.login.account.impl.LoginAccountInfoApiImpl;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.ntlogin.NTDevLockVerifyComponent;
import com.tencent.mobileqq.login.ntlogin.ah;
import com.tencent.mobileqq.login.remind.h;
import com.tencent.mobileqq.login.verify.MaskUinPwdVerifyFragment;
import com.tencent.mobileqq.login.verify.PuzzleVerifyComponent;
import com.tencent.mobileqq.loginregister.ILoginFailedCommonSceneHandlerApi;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.QuestionnaireForLoginManager;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.AccountType;
import com.tencent.qqnt.kernel.nativeinterface.ILoginCallback;
import com.tencent.qqnt.kernel.nativeinterface.Iframe;
import com.tencent.qqnt.kernel.nativeinterface.LoginProcessReqBody;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import com.tencent.qqnt.kernel.nativeinterface.LoginRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.PwdLoginInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserInfo;
import com.tencent.qqnt.kernel.nativeinterface.VerifySuccessSign;
import com.tencent.qqnt.kernel.nativeinterface.VerifyType;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b \u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\bJ3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J0\u0010&\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\u0003H\u0014J\b\u0010(\u001a\u00020\u001aH\u0014J\"\u0010,\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010+\u001a\u00020\u0011H\u0014J\b\u0010-\u001a\u00020\u0003H\u0014J\u0018\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000fJ\b\u00101\u001a\u00020\u000fH\u0014R\u0016\u00102\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00103R\u0016\u00105\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTAccountLoginMainline;", "Lcom/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline;", "Lcom/tencent/mobileqq/login/c;", "", "startLoginByCoroutine", "Lcom/tencent/qqnt/kernel/nativeinterface/PwdLoginInfo;", "pwdLoginInfo", "requestLoginByCoroutine", "(Lcom/tencent/qqnt/kernel/nativeinterface/PwdLoginInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginInfo", "Lcom/tencent/mobileqq/login/ntlogin/mainline/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "requestNTLogin", "", TangramHippyConstants.LOGIN_TYPE, "", "verifyUrl", "Landroid/os/Bundle;", "passThroughParams", "Lcom/tencent/qqnt/kernel/nativeinterface/VerifySuccessSign;", "requestPuzzleVerify", "(ILjava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRemindLogin", "reLogin", "onNtLoginFailed", "str", "", "isUinAccount", "isEmailAccount", "getPwLoginInfo", "getVerifyReportInfo", "getNotifyType", "getLoginDuration", "tValue", "result", "r2", "r3", "r4", "reportEvent", "startLogin", "needCreateNewRuntime", "uin", "nick", "bundle", "onNTLoginSuccess", "onLoginCancel", "urlString", "parameterName", "getParameterValue", "getReportUin", "mHasPuzzleVerify", "Z", "mHasDevLockVerify", "mIsReLogin", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NTAccountLoginMainline extends NTBaseLoginMainline<com.tencent.mobileqq.login.c> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NTLoginMainline_AccountLogin";
    private boolean mHasDevLockVerify;
    private boolean mHasPuzzleVerify;
    private boolean mIsReLogin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTAccountLoginMainline$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ntlogin.mainline.NTAccountLoginMainline$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTAccountLoginMainline$b", "Lcom/tencent/mobileqq/login/remind/h$b;", "", "a", "b", "", "url", "c", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements h.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginResult f242257b;

        b(LoginResult loginResult) {
            this.f242257b = loginResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTAccountLoginMainline.this, (Object) loginResult);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NTAccountLoginMainline.this.onLoginCancel();
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NTAccountLoginMainline.this.reLogin(this.f242257b);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.remind.h.b
        public void c(@NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.d(NTAccountLoginMainline.TAG, 1, "onJumpUrl :" + url);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "loginResultInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class c implements ILoginCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<LoginResult>> f242259b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super i<LoginResult>> cancellableContinuation) {
            this.f242259b = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTAccountLoginMainline.this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginCallback
        public final void onResult(int i3, String str, LoginResult loginResult) {
            int i16;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, loginResult);
                return;
            }
            NTAccountLoginMainline nTAccountLoginMainline = NTAccountLoginMainline.this;
            if (i3 == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            String valueOf = String.valueOf(i3);
            if (NTAccountLoginMainline.this.mIsReLogin) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            if (NTAccountLoginMainline.this.mHasPuzzleVerify) {
                str3 = "1";
            } else {
                str3 = "2";
            }
            nTAccountLoginMainline.reportEvent("0X800C49F", i16, valueOf, str2, str3);
            CancellableContinuation<i<LoginResult>> cancellableContinuation = this.f242259b;
            i iVar = new i(i3, str, loginResult);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "request loginsafeResume call failed ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTAccountLoginMainline$d", "Lcom/tencent/mobileqq/login/verify/PuzzleVerifyComponent$b;", "", "result", "", "ticket", "randStr", "appId", "", "b", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements PuzzleVerifyComponent.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f242261b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f242262c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f242263d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<VerifySuccessSign>> f242264e;

        d(long j3, Bundle bundle, String str, CancellableContinuation<? super i<VerifySuccessSign>> cancellableContinuation) {
            this.f242261b = j3;
            this.f242262c = bundle;
            this.f242263d = str;
            this.f242264e = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTAccountLoginMainline.this, Long.valueOf(j3), bundle, str, cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(NTAccountLoginMainline.TAG, 1, "PuzzleVerify cancel");
            NTAccountLoginMainline.this.reportEvent("0X800C27A", 2, String.valueOf(System.currentTimeMillis() - this.f242261b), "", "");
            CancellableContinuation<i<VerifySuccessSign>> cancellableContinuation = this.f242264e;
            i iVar = new i(-1, "puzzle verify cancel", null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "new puzzle verifysafeResume call failed ");
        }

        @Override // com.tencent.mobileqq.login.verify.PuzzleVerifyComponent.b
        public void b(boolean result, @Nullable String ticket, @Nullable String randStr, @Nullable String appId) {
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            Bundle bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), ticket, randStr, appId);
                return;
            }
            QLog.i(NTAccountLoginMainline.TAG, 1, "PuzzleVerify result=" + result);
            NTAccountLoginMainline.this.reportEvent("0X800C27A", 0, String.valueOf(System.currentTimeMillis() - this.f242261b), "", "");
            if (((com.tencent.mobileqq.login.c) ((com.tencent.mobileqq.login.k) NTAccountLoginMainline.this).mLoginParams).f242047k && ((com.tencent.mobileqq.login.c) ((com.tencent.mobileqq.login.k) NTAccountLoginMainline.this).mLoginParams).f242049m != null && (bundle = this.f242262c) != null) {
                Integer num = ((com.tencent.mobileqq.login.c) ((com.tencent.mobileqq.login.k) NTAccountLoginMainline.this).mLoginParams).f242049m;
                Intrinsics.checkNotNullExpressionValue(num, "mLoginParams.phoneBusinessType");
                bundle.putInt("businessType", num.intValue());
            }
            Iframe iframe = new Iframe();
            if (ticket != null) {
                bArr = ticket.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr = null;
            }
            iframe.iframeSig = bArr;
            if (randStr != null) {
                bArr2 = randStr.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr2 = null;
            }
            iframe.iframeRandstr = bArr2;
            String parameterValue = NTAccountLoginMainline.this.getParameterValue(this.f242263d, "sid");
            if (parameterValue != null) {
                bArr3 = parameterValue.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr3, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr3 = null;
            }
            iframe.iframeSid = bArr3;
            VerifySuccessSign verifySuccessSign = new VerifySuccessSign();
            verifySuccessSign.verifyType = VerifyType.VERIFY_TYPE_CAPTCHA;
            verifySuccessSign.iframe = iframe;
            CancellableContinuation<i<VerifySuccessSign>> cancellableContinuation = this.f242264e;
            i iVar = new i(0, null, verifySuccessSign);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "new puzzle verifysafeResume call failed ");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21415);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTAccountLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String getLoginDuration() {
        return String.valueOf(System.currentTimeMillis() - this.mLoginStartTime);
    }

    private final int getNotifyType(int loginType) {
        if (loginType != 1) {
            if (loginType != 2) {
                if (loginType != 3) {
                    return 0;
                }
                return 1100;
            }
            return 1035;
        }
        return 1001;
    }

    private final PwdLoginInfo getPwLoginInfo() {
        boolean z16;
        UserInfo userInfo = new UserInfo();
        userInfo.account = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f;
        PwdLoginInfo pwdLoginInfo = new PwdLoginInfo();
        pwdLoginInfo.userInfo = userInfo;
        String buf_to_string = util.buf_to_string(((com.tencent.mobileqq.login.c) this.mLoginParams).f242044h);
        pwdLoginInfo.passwordMd5 = buf_to_string;
        boolean z17 = false;
        if (TextUtils.isEmpty(buf_to_string)) {
            String str = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242043g;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                pwdLoginInfo.passwordMd5 = MD5.toMD5(((com.tencent.mobileqq.login.c) this.mLoginParams).f242043g);
            }
        }
        T t16 = this.mLoginParams;
        if (((com.tencent.mobileqq.login.c) t16).f242046j) {
            userInfo.accountType = AccountType.ACCOUNTTYPE_MASKUIN;
            userInfo.encryptUin = MaskUinPwdVerifyFragment.Dh(((com.tencent.mobileqq.login.c) t16).f242050n);
        } else {
            String str2 = ((com.tencent.mobileqq.login.c) t16).f242042f;
            Intrinsics.checkNotNullExpressionValue(str2, "mLoginParams.account");
            if (isUinAccount(str2)) {
                userInfo.accountType = AccountType.ACCOUNTTYPE_UIN;
            } else {
                String str3 = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f;
                Intrinsics.checkNotNullExpressionValue(str3, "mLoginParams.account");
                if (isEmailAccount(str3)) {
                    userInfo.accountType = AccountType.ACCOUNTTYPE_EMAIL;
                } else {
                    userInfo.accountType = AccountType.ACCOUNTTYPE_QID;
                }
            }
        }
        pwdLoginInfo.userInfo = userInfo;
        T t17 = this.mLoginParams;
        if (((com.tencent.mobileqq.login.c) t17).f242051o != null) {
            byte[] bArr = ((com.tencent.mobileqq.login.c) t17).f242051o;
            Intrinsics.checkNotNullExpressionValue(bArr, "mLoginParams.superSig");
            if (bArr.length == 0) {
                z17 = true;
            }
            if (!z17) {
                byte[] bArr2 = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242051o;
                Intrinsics.checkNotNullExpressionValue(bArr2, "mLoginParams.superSig");
                String str4 = new String(bArr2, Charsets.UTF_8);
                pwdLoginInfo.registerSucceedSig = str4;
                QLog.d(TAG, 2, "super key length: " + Integer.valueOf(str4.length()));
            }
        }
        pwdLoginInfo.appInfo = getAppInfo();
        LoginProcessReqBody loginProcessReqBody = new LoginProcessReqBody();
        loginProcessReqBody.needRemindCancellatedStatus = com.tencent.mobileqq.login.remind.n.f242580a.c(((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f);
        pwdLoginInfo.loginProcessReq = loginProcessReqBody;
        ah ahVar = ah.f242228a;
        String str5 = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f;
        Intrinsics.checkNotNullExpressionValue(str5, "mLoginParams.account");
        String a16 = ahVar.a(str5);
        if (a16 != null) {
            byte[] bytes = a16.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            pwdLoginInfo.longCookie = bytes;
        }
        return pwdLoginInfo;
    }

    private final String getVerifyReportInfo() {
        boolean z16 = this.mHasPuzzleVerify;
        if (z16 && this.mHasDevLockVerify) {
            return "1";
        }
        if (z16) {
            return "2";
        }
        if (this.mHasDevLockVerify) {
            return "3";
        }
        return "4";
    }

    private final void handleRemindLogin(final LoginResult loginInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ntlogin.mainline.a
            @Override // java.lang.Runnable
            public final void run() {
                NTAccountLoginMainline.handleRemindLogin$lambda$3(LoginResult.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleRemindLogin$lambda$3(LoginResult loginInfo, NTAccountLoginMainline this$0) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!new com.tencent.mobileqq.login.remind.m().e(QBaseActivity.sTopActivity, loginInfo, ((com.tencent.mobileqq.login.c) this$0.mLoginParams).f242042f, new b(loginInfo))) {
            this$0.reLogin(loginInfo);
        }
    }

    private final boolean isEmailAccount(String str) {
        return new Regex("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$").matches(str);
    }

    private final boolean isUinAccount(String str) {
        return new Regex("\\d+").matches(str);
    }

    private final void onNtLoginFailed(LoginResult loginInfo) {
        QLog.e(TAG, 1, "onNtLoginFailed ret = " + loginInfo.rspInfo.errCode);
        com.tencent.mobileqq.login.ntlogin.u uVar = com.tencent.mobileqq.login.ntlogin.u.f242388a;
        QBaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity()");
        T mLoginParams = this.mLoginParams;
        Intrinsics.checkNotNullExpressionValue(mLoginParams, "mLoginParams");
        uVar.y(activity, (com.tencent.mobileqq.login.c) mLoginParams, loginInfo);
        reportEvent("0X800C27C", 1, getLoginDuration(), getVerifyReportInfo(), String.valueOf(loginInfo.rspInfo.errCode));
        QuestionnaireForLoginManager.e();
        aj ajVar = new aj();
        LoginRspInfo loginRspInfo = loginInfo.rspInfo;
        ajVar.f241864a = loginRspInfo.errCode;
        ajVar.f241866c = loginRspInfo.errMsg;
        ajVar.f241871h = String.valueOf(loginInfo.account.uin);
        ErrMsg errMsg = new ErrMsg();
        ajVar.f241867d = errMsg;
        errMsg.setTitle(loginInfo.rspInfo.tipsTitle);
        ajVar.f241867d.setMessage(loginInfo.rspInfo.tipsContent);
        ajVar.f241868e = loginInfo.rspInfo.jumpUrl;
        onLoginFailed(ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reLogin(LoginResult loginInfo) {
        LoginProcessReqBody loginProcessReqBody = new LoginProcessReqBody();
        loginProcessReqBody.needRemindCancellatedStatus = com.tencent.mobileqq.login.remind.n.f242580a.c(((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f);
        PwdLoginInfo pwLoginInfo = getPwLoginInfo();
        pwLoginInfo.loginProcessReq = loginProcessReqBody;
        pwLoginInfo.loginContext = loginInfo.rspInfo.loginContext;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTAccountLoginMainline$reLogin$1(this, pwLoginInfo, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(String tValue, int result, String r26, String r36, String r46) {
        T t16 = this.mLoginParams;
        as.b("account_login_mainline", tValue, "", ((com.tencent.mobileqq.login.c) t16).f242201b, result, true, r26, r36, r46, ((com.tencent.mobileqq.login.c) t16).f242042f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestLoginByCoroutine(PwdLoginInfo pwdLoginInfo, Continuation<? super Unit> continuation) {
        NTAccountLoginMainline$requestLoginByCoroutine$1 nTAccountLoginMainline$requestLoginByCoroutine$1;
        Object coroutine_suspended;
        NTAccountLoginMainline nTAccountLoginMainline;
        i iVar;
        Integer num;
        NTAccountLoginMainline nTAccountLoginMainline2;
        i iVar2;
        NTAccountLoginMainline nTAccountLoginMainline3;
        PwdLoginInfo pwdLoginInfo2;
        i iVar3;
        String str;
        PwdLoginInfo pwdLoginInfo3;
        i iVar4;
        long j3;
        NTAccountLoginMainline nTAccountLoginMainline4;
        String str2;
        String g16;
        LoginRspInfo loginRspInfo;
        i iVar5;
        byte[] bArr;
        byte[] bArr2;
        i iVar6;
        byte[] bArr3;
        PwdLoginInfo pwdLoginInfo4 = pwdLoginInfo;
        if (continuation instanceof NTAccountLoginMainline$requestLoginByCoroutine$1) {
            nTAccountLoginMainline$requestLoginByCoroutine$1 = (NTAccountLoginMainline$requestLoginByCoroutine$1) continuation;
            int i3 = nTAccountLoginMainline$requestLoginByCoroutine$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                nTAccountLoginMainline$requestLoginByCoroutine$1.label = i3 - Integer.MIN_VALUE;
                Object obj = nTAccountLoginMainline$requestLoginByCoroutine$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (nTAccountLoginMainline$requestLoginByCoroutine$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        QLog.d(TAG, 1, "requestLoginByCoroutine");
                        nTAccountLoginMainline$requestLoginByCoroutine$1.L$0 = this;
                        nTAccountLoginMainline$requestLoginByCoroutine$1.L$1 = pwdLoginInfo4;
                        nTAccountLoginMainline$requestLoginByCoroutine$1.label = 1;
                        obj = requestNTLogin(pwdLoginInfo4, nTAccountLoginMainline$requestLoginByCoroutine$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        nTAccountLoginMainline = this;
                        iVar = (i) obj;
                        if (iVar.c() != 0 && iVar.b() != null) {
                            LoginResult loginResult = (LoginResult) iVar.b();
                            if (loginResult != null && (loginRspInfo = loginResult.rspInfo) != null) {
                                num = Boxing.boxInt(loginRspInfo.errCode);
                            } else {
                                num = null;
                            }
                            if (num != null && num.intValue() == 140022010) {
                                QLog.d(TAG, 1, "requestLoginByCoroutine need new device verify!");
                                nTAccountLoginMainline.mHasDevLockVerify = true;
                                Bundle bundle = new Bundle();
                                T t16 = nTAccountLoginMainline.mLoginParams;
                                if (((com.tencent.mobileqq.login.c) t16).f242201b == 16 && ((com.tencent.mobileqq.login.c) t16).f242204e && (g16 = com.tencent.mobileqq.accountbinding.d.f174609a.g()) != null) {
                                    bundle.putString("wechat_login_bind_uin", g16);
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                if (nTAccountLoginMainline.mHasPuzzleVerify) {
                                    str = "1";
                                } else {
                                    str = "2";
                                }
                                String str3 = str;
                                nTAccountLoginMainline.reportEvent("0X800C4AE", 0, "", str3, "");
                                NTDevLockVerifyComponent nTDevLockVerifyComponent = new NTDevLockVerifyComponent();
                                T t17 = nTAccountLoginMainline.mLoginParams;
                                int i16 = ((com.tencent.mobileqq.login.c) t17).f242200a;
                                String str4 = ((com.tencent.mobileqq.login.c) t17).f242042f;
                                Intrinsics.checkNotNullExpressionValue(str4, "mLoginParams.account");
                                LoginRspInfo loginRspInfo2 = ((LoginResult) iVar.b()).rspInfo;
                                Intrinsics.checkNotNullExpressionValue(loginRspInfo2, "loginResult.extraData.rspInfo");
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$0 = nTAccountLoginMainline;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$1 = pwdLoginInfo4;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$2 = iVar;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$3 = str3;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.J$0 = currentTimeMillis;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.label = 2;
                                Object f16 = nTDevLockVerifyComponent.f(i16, str4, loginRspInfo2, bundle, nTAccountLoginMainline$requestLoginByCoroutine$1);
                                if (f16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                pwdLoginInfo3 = pwdLoginInfo4;
                                iVar4 = iVar;
                                obj = f16;
                                j3 = currentTimeMillis;
                                nTAccountLoginMainline4 = nTAccountLoginMainline;
                                str2 = str3;
                                iVar5 = (i) obj;
                                if (iVar5.c() != 0) {
                                    QLog.d(TAG, 1, "requestLoginByCoroutine new device verify success!");
                                    nTAccountLoginMainline4.reportEvent("0X800C27B", 0, String.valueOf(System.currentTimeMillis() - j3), str2, "");
                                    VerifySuccessSign verifySuccessSign = new VerifySuccessSign();
                                    String str5 = (String) iVar5.b();
                                    if (str5 != null) {
                                        bArr = str5.getBytes(Charsets.UTF_8);
                                        Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                                    } else {
                                        bArr = null;
                                    }
                                    verifySuccessSign.deviceCheckSucceedSig = bArr;
                                    verifySuccessSign.verifyType = VerifyType.VERIFY_TYPE_NEW_DEVICE;
                                    pwdLoginInfo3.verifySign = verifySuccessSign;
                                    LoginRspInfo loginRspInfo3 = ((LoginResult) iVar4.b()).rspInfo;
                                    if (loginRspInfo3 != null) {
                                        bArr2 = loginRspInfo3.loginContext;
                                    } else {
                                        bArr2 = null;
                                    }
                                    pwdLoginInfo3.loginContext = bArr2;
                                    nTAccountLoginMainline4.mIsReLogin = true;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.L$0 = null;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.L$1 = null;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.L$2 = null;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.L$3 = null;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.label = 3;
                                    if (nTAccountLoginMainline4.requestLoginByCoroutine(pwdLoginInfo3, nTAccountLoginMainline$requestLoginByCoroutine$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    QLog.d(TAG, 1, "requestLoginByCoroutine new dev verify cancel!");
                                    nTAccountLoginMainline4.reportEvent("0X800C27B", 2, String.valueOf(System.currentTimeMillis() - j3), str2, "");
                                    nTAccountLoginMainline4.onLoginCancel();
                                }
                                return Unit.INSTANCE;
                            }
                            if (num != null && num.intValue() == 140022008) {
                                QLog.d(TAG, 1, "startLogin need new water wall verify!!!");
                                int i17 = ((com.tencent.mobileqq.login.c) nTAccountLoginMainline.mLoginParams).f242200a;
                                String jumpUrl = ((LoginResult) iVar.b()).rspInfo.getJumpUrl();
                                Intrinsics.checkNotNullExpressionValue(jumpUrl, "loginResult.extraData.rspInfo.getJumpUrl()");
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$0 = nTAccountLoginMainline;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$1 = pwdLoginInfo4;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$2 = iVar;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.label = 4;
                                Object requestPuzzleVerify = nTAccountLoginMainline.requestPuzzleVerify(i17, jumpUrl, null, nTAccountLoginMainline$requestLoginByCoroutine$1);
                                if (requestPuzzleVerify == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                nTAccountLoginMainline3 = nTAccountLoginMainline;
                                pwdLoginInfo2 = pwdLoginInfo4;
                                iVar3 = iVar;
                                obj = requestPuzzleVerify;
                                iVar6 = (i) obj;
                                if (iVar6.c() != 0) {
                                    QLog.d(TAG, 1, "requestLoginByCoroutine new water verify success!!!");
                                    pwdLoginInfo2.verifySign = (VerifySuccessSign) iVar6.b();
                                    LoginRspInfo loginRspInfo4 = ((LoginResult) iVar3.b()).rspInfo;
                                    if (loginRspInfo4 != null) {
                                        bArr3 = loginRspInfo4.loginContext;
                                    } else {
                                        bArr3 = null;
                                    }
                                    pwdLoginInfo2.loginContext = bArr3;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.L$0 = null;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.L$1 = null;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.L$2 = null;
                                    nTAccountLoginMainline$requestLoginByCoroutine$1.label = 5;
                                    if (nTAccountLoginMainline3.requestLoginByCoroutine(pwdLoginInfo2, nTAccountLoginMainline$requestLoginByCoroutine$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                QLog.d(TAG, 1, "requestLoginByCoroutine new water verify cancel");
                                nTAccountLoginMainline3.onLoginCancel();
                                return Unit.INSTANCE;
                            }
                            if (num != null && num.intValue() == 150022028) {
                                nTAccountLoginMainline.handleRemindLogin((LoginResult) iVar.b());
                                return Unit.INSTANCE;
                            }
                            if (num != null && num.intValue() == 0) {
                                QLog.d(TAG, 1, "requestLoginByCoroutine login success");
                                LoginResult loginResult2 = (LoginResult) iVar.b();
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$0 = nTAccountLoginMainline;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.L$1 = iVar;
                                nTAccountLoginMainline$requestLoginByCoroutine$1.label = 6;
                                Object commitMsfTicket = nTAccountLoginMainline.commitMsfTicket(loginResult2, nTAccountLoginMainline$requestLoginByCoroutine$1);
                                if (commitMsfTicket == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                nTAccountLoginMainline2 = nTAccountLoginMainline;
                                obj = commitMsfTicket;
                                iVar2 = iVar;
                                if (((i) obj).c() != 0) {
                                    String valueOf = String.valueOf(((LoginResult) iVar2.b()).getAccount().getUin());
                                    byte[] nick = ((LoginResult) iVar2.b()).getAccount().getUserProfile().getNickName();
                                    Intrinsics.checkNotNullExpressionValue(nick, "nick");
                                    nTAccountLoginMainline2.onNTLoginSuccess(valueOf, new String(nick, Charsets.UTF_8), new Bundle());
                                } else {
                                    QLog.d(TAG, 1, "requestLoginByCoroutine commit ticket failed!");
                                    nTAccountLoginMainline2.onNtLoginFailed((LoginResult) iVar2.b());
                                }
                                return Unit.INSTANCE;
                            }
                            QLog.d(TAG, 1, "requestLogin login failed retCode: " + num);
                            Object b16 = iVar.b();
                            Intrinsics.checkNotNull(b16);
                            nTAccountLoginMainline.onNtLoginFailed((LoginResult) b16);
                            return Unit.INSTANCE;
                        }
                        QLog.e(TAG, 1, "requestLogin local web error ret: " + iVar.c());
                        LoginResult loginResult3 = (LoginResult) iVar.b();
                        if (iVar.b() == null) {
                            loginResult3 = new LoginResult();
                            LoginRspInfo loginRspInfo5 = new LoginRspInfo();
                            loginRspInfo5.errCode = iVar.c();
                            loginRspInfo5.errMsg = BaseApplication.getContext().getString(R.string.c68);
                            loginResult3.rspInfo = loginRspInfo5;
                        }
                        Intrinsics.checkNotNull(loginResult3);
                        nTAccountLoginMainline.onNtLoginFailed(loginResult3);
                        return Unit.INSTANCE;
                    case 1:
                        pwdLoginInfo4 = (PwdLoginInfo) nTAccountLoginMainline$requestLoginByCoroutine$1.L$1;
                        NTAccountLoginMainline nTAccountLoginMainline5 = (NTAccountLoginMainline) nTAccountLoginMainline$requestLoginByCoroutine$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        nTAccountLoginMainline = nTAccountLoginMainline5;
                        iVar = (i) obj;
                        if (iVar.c() != 0) {
                            break;
                        }
                        QLog.e(TAG, 1, "requestLogin local web error ret: " + iVar.c());
                        LoginResult loginResult32 = (LoginResult) iVar.b();
                        if (iVar.b() == null) {
                        }
                        Intrinsics.checkNotNull(loginResult32);
                        nTAccountLoginMainline.onNtLoginFailed(loginResult32);
                        return Unit.INSTANCE;
                    case 2:
                        j3 = nTAccountLoginMainline$requestLoginByCoroutine$1.J$0;
                        String str6 = (String) nTAccountLoginMainline$requestLoginByCoroutine$1.L$3;
                        iVar4 = (i) nTAccountLoginMainline$requestLoginByCoroutine$1.L$2;
                        pwdLoginInfo3 = (PwdLoginInfo) nTAccountLoginMainline$requestLoginByCoroutine$1.L$1;
                        nTAccountLoginMainline4 = (NTAccountLoginMainline) nTAccountLoginMainline$requestLoginByCoroutine$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str2 = str6;
                        iVar5 = (i) obj;
                        if (iVar5.c() != 0) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 4:
                        iVar3 = (i) nTAccountLoginMainline$requestLoginByCoroutine$1.L$2;
                        pwdLoginInfo2 = (PwdLoginInfo) nTAccountLoginMainline$requestLoginByCoroutine$1.L$1;
                        nTAccountLoginMainline3 = (NTAccountLoginMainline) nTAccountLoginMainline$requestLoginByCoroutine$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        iVar6 = (i) obj;
                        if (iVar6.c() != 0) {
                        }
                        break;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 6:
                        iVar2 = (i) nTAccountLoginMainline$requestLoginByCoroutine$1.L$1;
                        nTAccountLoginMainline2 = (NTAccountLoginMainline) nTAccountLoginMainline$requestLoginByCoroutine$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((i) obj).c() != 0) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        nTAccountLoginMainline$requestLoginByCoroutine$1 = new NTAccountLoginMainline$requestLoginByCoroutine$1(this, continuation);
        Object obj2 = nTAccountLoginMainline$requestLoginByCoroutine$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nTAccountLoginMainline$requestLoginByCoroutine$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestNTLogin(PwdLoginInfo pwdLoginInfo, Continuation<? super i<LoginResult>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QLog.d(TAG, 1, "requestNTLogin uin: " + pwdLoginInfo.userInfo.account);
        ((ILoginService) QRoute.api(ILoginService.class)).passwordLogin(pwdLoginInfo, new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestPuzzleVerify(int i3, String str, Bundle bundle, Continuation<? super i<VerifySuccessSign>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.mHasPuzzleVerify = true;
        long currentTimeMillis = System.currentTimeMillis();
        reportEvent("0X800C4AD", 0, "", "", "");
        QLog.d(TAG, 1, "startPuzzleVerify url: " + str);
        new PuzzleVerifyComponent().d(i3, str, new d(currentTimeMillis, bundle, str, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void startLoginByCoroutine() {
        PwdLoginInfo pwLoginInfo = getPwLoginInfo();
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new NTAccountLoginMainline$startLoginByCoroutine$1(this, pwLoginInfo, null), 14, null);
        }
    }

    @Nullable
    public final String getParameterValue(@NotNull String urlString, @NotNull String parameterName) {
        List split$default;
        List split$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) urlString, (Object) parameterName);
        }
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        String query = new URL(urlString).getQuery();
        Intrinsics.checkNotNullExpressionValue(query, "query");
        split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
            if (split$default2.size() == 2 && Intrinsics.areEqual(split$default2.get(0), parameterName)) {
                return (String) split$default2.get(1);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.login.k
    @NotNull
    protected String getReportUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f;
        Intrinsics.checkNotNullExpressionValue(str, "mLoginParams.account");
        return str;
    }

    @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline
    protected boolean needCreateNewRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        T t16 = this.mLoginParams;
        if (!((com.tencent.mobileqq.login.c) t16).f242054r && !((com.tencent.mobileqq.login.c) t16).f242202c && !((com.tencent.mobileqq.login.c) t16).f242203d) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.k
    public void onLoginCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "onLoginCancel");
        reportEvent("0X800C27C", 2, getLoginDuration(), getVerifyReportInfo(), "");
        QuestionnaireForLoginManager.e();
        super.onLoginCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline
    public void onNTLoginSuccess(@NotNull String uin, @Nullable String nick, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uin, nick, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!checkBeforeLoginSuccess(uin, bundle)) {
            return;
        }
        QLog.i(TAG, 1, "onLoginSuccess uin=" + StringUtil.getSimpleUinForPrint(uin));
        LoginAccountInfoApiImpl.Companion companion = LoginAccountInfoApiImpl.INSTANCE;
        String str = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f;
        Intrinsics.checkNotNullExpressionValue(str, "mLoginParams.account");
        companion.b(str, uin, nick);
        ah ahVar = ah.f242228a;
        String str2 = ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f;
        Intrinsics.checkNotNullExpressionValue(str2, "mLoginParams.account");
        ahVar.c(str2);
        T t16 = this.mLoginParams;
        if (((com.tencent.mobileqq.login.c) t16).f242046j) {
            com.tencent.mobileqq.login.account.d.f241848a.b(uin, uin, ((com.tencent.mobileqq.login.c) t16).f242200a);
            if (!TextUtils.isEmpty(uin)) {
                MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + uin, uin);
            }
        } else {
            com.tencent.mobileqq.login.account.d.f241848a.b(uin, ((com.tencent.mobileqq.login.c) t16).f242042f, ((com.tencent.mobileqq.login.c) t16).f242200a);
            if (!TextUtils.isEmpty(uin) && !TextUtils.isEmpty(((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f)) {
                MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + uin, ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f);
            }
        }
        ((ILoginFailedCommonSceneHandlerApi) QRoute.api(ILoginFailedCommonSceneHandlerApi.class)).reportLoginSuccess(getAppRuntime(), Integer.valueOf(((com.tencent.mobileqq.login.c) this.mLoginParams).f242201b), uin);
        reportEvent("0X800C27C", 0, getLoginDuration(), getVerifyReportInfo(), "");
        super.onNTLoginSuccess(uin, nick, bundle);
    }

    @Override // com.tencent.mobileqq.login.k
    protected void startLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "startLogin uin: " + ((com.tencent.mobileqq.login.c) this.mLoginParams).f242042f);
        this.mHasPuzzleVerify = false;
        this.mHasDevLockVerify = false;
        this.mIsReLogin = false;
        reportEvent("0X800C279", 0, "", "", "");
        startLoginByCoroutine();
    }
}
