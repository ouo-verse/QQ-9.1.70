package com.tencent.mobileqq.login;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.login.restart.LoginProcessRestartMonitor;
import com.tencent.mobileqq.login.restart.Scene;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/login/LogoutHelper;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "restartProcess", "", "c", "f", "Lkotlin/Function0;", "block", "d", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LogoutHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LogoutHelper f241796a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f241796a = new LogoutHelper();
        }
    }

    LogoutHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void c(@Nullable final Activity activity, boolean restartProcess) {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("LogoutHelper", 1, "logout appRuntime is null");
            return;
        }
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        if (activity == null) {
            QLog.e("LogoutHelper", 1, "logout activity is null");
            return;
        }
        if (restartProcess && com.tencent.mobileqq.login.restart.c.d(Scene.LOGOUT)) {
            z16 = true;
        } else {
            z16 = false;
        }
        LoginProcessRestartMonitor.E(Scene.LOGOUT, peekAppRuntime.getCurrentAccountUin(), z16);
        if (z16) {
            QLog.i("LogoutHelper", 1, "logout with restart process");
            peekAppRuntime.logoutByRestartProcess();
            new com.tencent.mobileqq.loginregister.w().e(activity, peekAppRuntime);
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount != null && firstSimpleAccount.getUin() != null) {
                String uin = firstSimpleAccount.getUin();
                Intrinsics.checkNotNullExpressionValue(uin, "simpleAccount.uin");
                AutoLoginUtil.setAutoLogin(uin, false);
            }
            com.tencent.mobileqq.login.relogin.vm.j.b();
            f241796a.d(new Function0<Unit>(activity) { // from class: com.tencent.mobileqq.login.LogoutHelper$logout$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $act;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$act = activity;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    String string = this.$act.getString(R.string.f200904td);
                    Intrinsics.checkNotNullExpressionValue(string, "act.getString(R.string.q\u2026n_waiting_logout_account)");
                    Activity activity2 = this.$act;
                    com.tencent.mobileqq.login.restart.k.f(activity2, string, new Function1<Boolean, Unit>(activity2) { // from class: com.tencent.mobileqq.login.LogoutHelper$logout$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Activity $act;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$act = activity2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) activity2);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, z17);
                                return;
                            }
                            if (z17) {
                                return;
                            }
                            QLog.e("LogoutHelper", 1, "restart process fail");
                            LogoutHelper logoutHelper = LogoutHelper.f241796a;
                            Activity act = this.$act;
                            Intrinsics.checkNotNullExpressionValue(act, "act");
                            logoutHelper.f(act);
                        }
                    });
                }
            });
            return;
        }
        QLog.i("LogoutHelper", 1, "logout with start login");
        peekAppRuntime.logout(true);
        new com.tencent.mobileqq.loginregister.w().e(activity, peekAppRuntime);
        f241796a.f(activity);
    }

    private final void d(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.ap
                @Override // java.lang.Runnable
                public final void run() {
                    LogoutHelper.e(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Activity activity) {
        QRoute.createNavigator(activity, RouterConstants.UI_ROUTER_LOGIN).withInt("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a).withBoolean("logout_intent", true).requestWithReturn();
        activity.finish();
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154550b4);
    }
}
