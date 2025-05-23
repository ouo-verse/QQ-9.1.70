package com.tencent.mobileqq.power;

import android.content.Context;
import com.tencent.mobileqq.power.api.IQQMonitorApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0004R\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/power/c;", "", "", "cpuUsage", "", "c", "", "b", "Landroid/content/Context;", "context", "e", "g", "d", "f", "a", "", "I", "getCount", "()I", "setCount", "(I)V", "count", "", "D", "getAllUsage", "()D", "setAllUsage", "(D)V", "allUsage", "<init>", "()V", "power_monitor_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f259407a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int count;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static double allUsage;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f259407a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        count = 0;
        allUsage = 0.0d;
    }

    private final boolean c(float cpuUsage) {
        com.tencent.mobileqq.power.config.a a16 = com.tencent.mobileqq.power.config.a.INSTANCE.a();
        if (!a16.c()) {
            return false;
        }
        com.tencent.mobileqq.perf.log.a.a("HP_CPU", "startCpuFrontMonitor cpuUsage:" + cpuUsage + ",count:" + count + ",allUsage:" + allUsage);
        double d16 = (double) cpuUsage;
        if (d16 < a16.b()) {
            b();
            return false;
        }
        if (count >= a16.a()) {
            return true;
        }
        count++;
        allUsage += d16;
        return false;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        String branchName = AppSetting.getBranchName();
        if (!AppSetting.isPublicVersion() && branchName.equals("master")) {
            return true;
        }
        return false;
    }

    public final void d(float cpuUsage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(cpuUsage));
        } else if (c(cpuUsage)) {
            double d16 = allUsage / count;
            b();
            ((IQQMonitorApi) QRoute.api(IQQMonitorApi.class)).startFrontCpuMonitor(d16);
        }
    }

    public final void e(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (com.tencent.mobileqq.power.config.a.INSTANCE.a().c()) {
            ((IQQMonitorApi) QRoute.api(IQQMonitorApi.class)).stopFrontCpuMonitor();
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
