package com.tencent.mobileqq.upgrade.activity;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\fH\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/upgrade/activity/q;", "", "Ljava/lang/Runnable;", "runnable", "", "g", "", "action", "a", "r4", "c", "subAction", "", "tipsType", "r5", "b", "actionName", "result", "d", "e", IProfileCardConst.KEY_FROM_TYPE, "f", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f306273a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63091);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f306273a = new q();
        }
    }

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", action, action, 0, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void b(@NotNull String subAction, int tipsType, @NotNull String r56) {
        Intrinsics.checkNotNullParameter(subAction, "subAction");
        Intrinsics.checkNotNullParameter(r56, "r5");
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", subAction, subAction, 0, 0, com.tencent.mobileqq.upgrade.g.a(), String.valueOf(tipsType), com.tencent.mobileqq.upgrade.k.g(), r56);
    }

    @JvmStatic
    public static final void c(@NotNull String action, @NotNull String r46) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(r46, "r4");
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", action, action, 0, 0, "", "", r46, "");
    }

    @JvmStatic
    public static final void d(@NotNull String subAction, @NotNull String actionName, int result) {
        Intrinsics.checkNotNullParameter(subAction, "subAction");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", subAction, actionName, 0, result, "", "", "", "");
    }

    @JvmStatic
    public static final void e(@NotNull String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", action, action, 0, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void f(@NotNull String action, int fromType) {
        Intrinsics.checkNotNullParameter(action, "action");
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", action, action, fromType, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void g(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }
}
