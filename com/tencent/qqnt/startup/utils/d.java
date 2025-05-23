package com.tencent.qqnt.startup.utils;

import android.os.Build;
import android.os.Trace;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/startup/utils/d;", "", "", "section", "", "b", "d", "", "cookies", "a", "c", "", "Z", "getTRACE_ENABLE", "()Z", "e", "(Z)V", "TRACE_ENABLE", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "sAsyncTraceBegin", "sAsyncTraceEnd", "<init>", "()V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f362285a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean TRACE_ENABLE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Method sAsyncTraceBegin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Method sAsyncTraceEnd;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f362285a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String section, int cookies) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) section, cookies);
            return;
        }
        Intrinsics.checkNotNullParameter(section, "section");
        if (!TRACE_ENABLE) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            a.a("TraceUtils", "beginAsyncSection: " + section + ", " + cookies);
            Trace.beginAsyncSection(section, cookies);
            return;
        }
        if (sAsyncTraceBegin == null) {
            try {
                sAsyncTraceBegin = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                a.a("TraceUtils", "beginAsyncSection: " + section + ", " + cookies);
            } catch (Throwable th5) {
                a.c("TraceUtils", "Unable to reflect asyncTraceBegin method", th5);
            }
        }
        try {
            Method method = sAsyncTraceBegin;
            if (method != null) {
                method.invoke(null, 4096L, section, Integer.valueOf(cookies));
            }
        } catch (Throwable th6) {
            a.c("TraceUtils", "Unable to invoke asyncTraceBegin method", th6);
        }
    }

    public final void b(@NotNull String section) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) section);
            return;
        }
        Intrinsics.checkNotNullParameter(section, "section");
        if (TRACE_ENABLE) {
            a.a("TraceUtils", "beginSection: " + section);
            Trace.beginSection(section);
        }
    }

    public final void c(@NotNull String section, int cookies) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) section, cookies);
            return;
        }
        Intrinsics.checkNotNullParameter(section, "section");
        if (!TRACE_ENABLE) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.endAsyncSection(section, cookies);
            a.a("TraceUtils", "endAsyncSection: " + section + ", " + cookies);
            return;
        }
        if (sAsyncTraceEnd == null) {
            try {
                sAsyncTraceEnd = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                a.a("TraceUtils", "endAsyncSection: " + section + ", " + cookies);
            } catch (Throwable th5) {
                a.c("TraceUtils", "Unable to reflect asyncTraceEnd method", th5);
            }
        }
        try {
            Method method = sAsyncTraceEnd;
            if (method != null) {
                method.invoke(null, 4096L, section, Integer.valueOf(cookies));
            }
        } catch (Throwable th6) {
            a.c("TraceUtils", "Unable to invoke asyncTraceEnd method", th6);
        }
    }

    public final void d(@NotNull String section) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) section);
            return;
        }
        Intrinsics.checkNotNullParameter(section, "section");
        if (TRACE_ENABLE) {
            Trace.endSection();
            a.a("TraceUtils", "endSection: " + section);
        }
    }

    public final void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            TRACE_ENABLE = z16;
        }
    }
}
