package com.tencent.videocut.utils.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/videocut/utils/thread/c;", "", "Ljava/lang/Runnable;", "r", "", "b", "runnable", "e", "c", "d", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/Thread;", "sMainThread", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "", "()Z", "isMainThread", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Thread sMainThread;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Handler mainHandler;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final c f384289c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f384289c = new c();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        sMainThread = mainLooper.getThread();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (sMainThread == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public final void b(@NotNull Runnable r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) r16);
        } else {
            Intrinsics.checkNotNullParameter(r16, "r");
            mainHandler.post(r16);
        }
    }

    public final void c(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        } else {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            a.a().execute(runnable);
        }
    }

    public final void d(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
        } else {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            a.b().execute(runnable);
        }
    }

    public final void e(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (a()) {
            runnable.run();
        } else {
            b(runnable);
        }
    }
}
