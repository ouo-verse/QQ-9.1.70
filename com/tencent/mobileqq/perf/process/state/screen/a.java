package com.tencent.mobileqq.perf.process.state.screen;

import android.app.Activity;
import android.os.Build;
import android.os.PowerManager;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/perf/process/state/screen/a;", "", "", "d", "c", "", "b", "a", "Z", "gotoBgByLocked", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257944a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean gotoBgByLocked;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33313);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f257944a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean d() {
        Display defaultDisplay;
        Integer num;
        Object systemService = BaseApplication.context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        boolean isInteractive = ((PowerManager) systemService).isInteractive();
        Activity topActivity = Foreground.getTopActivity();
        if (Build.VERSION.SDK_INT >= 30 && topActivity != null) {
            defaultDisplay = topActivity.getDisplay();
        } else {
            Object systemService2 = BaseApplication.context.getSystemService("window");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
            defaultDisplay = ((WindowManager) systemService2).getDefaultDisplay();
        }
        if (defaultDisplay != null) {
            num = Integer.valueOf(defaultDisplay.getState());
        } else {
            num = null;
        }
        QLog.e("ScreenLockHelper", 1, "printAppState, isInteractive:" + isInteractive + ", display State:" + num);
        if (!isInteractive && (num == null || num.intValue() != 2)) {
            return true;
        }
        return false;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            gotoBgByLocked = d();
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            gotoBgByLocked = false;
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return gotoBgByLocked;
    }
}
