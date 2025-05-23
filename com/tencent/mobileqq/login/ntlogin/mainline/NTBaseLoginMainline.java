package com.tencent.mobileqq.login.ntlogin.mainline;

import android.os.Bundle;
import com.tencent.mobileqq.login.l;
import com.tencent.mobileqq.login.ntlogin.ag;
import com.tencent.mobileqq.login.ntlogin.y;
import com.tencent.mobileqq.msf.core.auth.NTAccountSigInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AppInfo;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 \u0019*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0015H\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline;", "Lcom/tencent/mobileqq/login/l;", "T", "Lcom/tencent/mobileqq/login/k;", "", "uin", "", "createNewRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;", "loginResult", "Lcom/tencent/mobileqq/login/ntlogin/mainline/i;", "", "commitMsfTicket", "(Lcom/tencent/qqnt/kernel/nativeinterface/LoginResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNickname", "nick", "Landroid/os/Bundle;", "bundle", "onNTLoginSuccess", "Lcom/tencent/qqnt/kernel/nativeinterface/AppInfo;", "getAppInfo", "", "needCreateNewRuntime", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class NTBaseLoginMainline<T extends com.tencent.mobileqq.login.l> extends com.tencent.mobileqq.login.k<T> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String LOGIN_APP_NAME = "com.tencent.mobileqq";

    @NotNull
    public static final String TAG = "NTLoginMainline";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline$a;", "", "", "LOGIN_APP_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.ntlogin.mainline.NTBaseLoginMainline$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/login/ntlogin/mainline/NTBaseLoginMainline$b", "Lcom/tencent/mobileqq/login/ntlogin/a;", "", "onSuccess", "", "retCode", "", "errMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.mobileqq.login.ntlogin.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<i<Object>> f242265a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super i<Object>> cancellableContinuation) {
            this.f242265a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.login.ntlogin.a
        public void onFail(int retCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, retCode, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e(NTBaseLoginMainline.TAG, 1, "commitLoginTicketToMsf onFail. retCode:" + retCode + ", errMsg:" + errMsg);
            CancellableContinuation<i<Object>> cancellableContinuation = this.f242265a;
            i iVar = new i(retCode, errMsg, null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "commit ticket to MSFsafeResume call failed ");
        }

        @Override // com.tencent.mobileqq.login.ntlogin.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(NTBaseLoginMainline.TAG, 1, "commitLoginTicketToMsf onSuccess");
            CancellableContinuation<i<Object>> cancellableContinuation = this.f242265a;
            i iVar = new i(0, null, null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(iVar));
                return;
            }
            QLog.e("NTLogin", 1, "commit ticket to MSFsafeResume call failed ");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21434);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTBaseLoginMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void createNewRuntime(String uin) {
        QLog.d(TAG, 2, "createNewRuntime ");
        SimpleAccount simpleAccount = new SimpleAccount();
        simpleAccount.setUin(uin);
        simpleAccount.setAttribute(SimpleAccount._ISLOGINED, "true");
        MobileQQ.sMobileQQ.createNewRuntime(simpleAccount, true, true, 3, null);
    }

    @Nullable
    public final Object commitMsfTicket(@NotNull LoginResult loginResult, @NotNull Continuation<? super i<Object>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            NTAccountSigInfo nTAccountSigInfo = new NTAccountSigInfo();
            nTAccountSigInfo.setUin(loginResult.getAccount().getUin());
            nTAccountSigInfo.setUid(loginResult.getAccount().getUid());
            if (loginResult.getTicket().appId == BaseConstants.OPEN_SDK_BUFLAG_B1) {
                nTAccountSigInfo.setUinType(6);
            } else {
                nTAccountSigInfo.setUinType(0);
            }
            nTAccountSigInfo.setA2(loginResult.getTicket().getA2());
            nTAccountSigInfo.setD2(loginResult.getTicket().getD2());
            nTAccountSigInfo.setD2key(loginResult.getTicket().getD2Key());
            QLog.d(TAG, 2, "set ticket uin : " + nTAccountSigInfo.getUin() + " ");
            y.f242393a.d(nTAccountSigInfo, new b(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginResult, (Object) continuation);
    }

    @NotNull
    public final AppInfo getAppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AppInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        AppInfo appInfo = new AppInfo();
        appInfo.appName = "com.tencent.mobileqq";
        appInfo.qua = BaseApplication.getContext().getQua();
        if (this.mLoginParams.f242203d) {
            appInfo.appId = BaseConstants.OPEN_SDK_BUFLAG_B1;
        } else {
            appInfo.appId = 16L;
        }
        return appInfo;
    }

    protected boolean needCreateNewRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNTLoginSuccess(@NotNull String uin, @Nullable String nick, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uin, nick, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        onLoginSuccess(uin, bundle);
        if (bundle.getBoolean("without_pwd", false)) {
            ag.f242225a.u(uin, true);
        }
        QLog.i(TAG, 1, "updateNickname uin:" + StringUtil.getSimpleUinForPrint(uin));
        if (!this.mLoginParams.f242203d) {
            MsfSdkUtils.addLoginSimpleAccount(uin, true);
            MobileQQ.sMobileQQ.refreAccountList();
        }
        if (nick != null) {
            MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.nickName.toString() + uin, nick);
        }
        if (needCreateNewRuntime()) {
            createNewRuntime(uin);
        }
    }

    @Override // com.tencent.mobileqq.login.k
    protected void updateNickname(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
        }
    }
}
