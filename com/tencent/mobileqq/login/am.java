package com.tencent.mobileqq.login;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.login.fragment.BaseLoginFragment;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001!\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/login/am;", "", "", "c", "Lcom/tencent/mobileqq/login/l;", "params", "", "uin", "Landroid/os/Bundle;", "bundle", "i", "", "e", "Lcom/tencent/mobileqq/login/ao;", "d", "savedState", "f", tl.h.F, "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "fragment", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "", "J", "lastLoginSuccessTime", "Lcom/tencent/mobileqq/login/ao;", "currSavedState", "Lmqq/app/IAccountCallback;", "Lmqq/app/IAccountCallback;", "accountCallback", "com/tencent/mobileqq/login/am$b", "Lcom/tencent/mobileqq/login/am$b;", "loginSuccessListener", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class am {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final am f241878a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean hasInit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastLoginSuccessTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ao currSavedState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAccountCallback accountCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b loginSuccessListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/login/am$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements IAccountCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) newRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(@Nullable AppRuntime newRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newRuntime);
            } else {
                am.f241878a.h();
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(@Nullable Constants.LogoutReason reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/login/am$b", "Lcom/tencent/mobileqq/login/aq;", "Lcom/tencent/mobileqq/login/l;", "params", "", "uin", "Landroid/os/Bundle;", "data", "", "onLoginSuccess", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements aq {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.login.aq
        public void onLoginSuccess(@NotNull l params, @NotNull String uin, @Nullable Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, params, uin, data);
                return;
            }
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(uin, "uin");
            am amVar = am.f241878a;
            am.lastLoginSuccessTime = System.currentTimeMillis();
            if (params.f242202c || params.f242203d) {
                am.f241878a.i(params, uin, data);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f241878a = new am();
        hasInit = new AtomicBoolean(false);
        accountCallback = new a();
        loginSuccessListener = new b();
    }

    am() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void c() {
        if (hasInit.getAndSet(true)) {
            return;
        }
        MobileQQ.sMobileQQ.registerAccountCallback(accountCallback);
        an.f241884a.b(loginSuccessListener);
    }

    @JvmStatic
    @Nullable
    public static final ao d() {
        ao aoVar = currSavedState;
        if (aoVar == null || f241878a.f(aoVar)) {
            return null;
        }
        return aoVar;
    }

    private final boolean e() {
        if (((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).isLoggingIn()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = lastLoginSuccessTime;
        if (currentTimeMillis >= j3 && currentTimeMillis - j3 < 2000) {
            return true;
        }
        return false;
    }

    private final boolean f(ao savedState) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= savedState.c() && currentTimeMillis - savedState.c() < 2000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(l params, String uin, Bundle bundle) {
        if (!LoginActivity.isLoginActivityDestroyed()) {
            return;
        }
        QLog.i("LoginRestoreUtils", 1, "savedState when onOtherLoginSuccess");
        currSavedState = new ao(uin, bundle, params, System.currentTimeMillis());
        com.tencent.mobileqq.login.fragment.l.f242160a.b(false);
    }

    public final boolean g(@NotNull BaseLoginFragment fragment) {
        ao aoVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || (activity instanceof LoginActivity) || (aoVar = currSavedState) == null) {
            return false;
        }
        boolean z16 = !f(aoVar);
        if (z16) {
            QLog.i("LoginRestoreUtils", 1, "needFinishWhenRestore " + fragment.getClass().getName());
        }
        return z16;
    }

    public final void h() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!LoginActivity.isLoginActivityDestroyed() || !e()) {
            return;
        }
        QLog.i("LoginRestoreUtils", 1, "savedState when onAccountChanged");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        currSavedState = new ao(str, null, null, System.currentTimeMillis(), 6, null);
        com.tencent.mobileqq.login.fragment.l.f242160a.b(false);
    }
}
