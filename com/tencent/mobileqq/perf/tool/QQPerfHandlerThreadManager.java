package com.tencent.mobileqq.perf.tool;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/QQPerfHandlerThreadManager;", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQPerfHandlerThreadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<HandlerThread> f258188b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<Handler> f258189c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0015\u001a\u00020\u000f8FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/perf/tool/QQPerfHandlerThreadManager$a;", "", "Ljava/lang/Runnable;", "task", "", "a", "", "delayTimeMs", "b", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "c", "()Landroid/os/Handler;", "handler", "Landroid/os/HandlerThread;", "handlerThread$delegate", "d", "()Landroid/os/HandlerThread;", "getHandlerThread$annotations", "()V", "handlerThread", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        private final Handler c() {
            return (Handler) QQPerfHandlerThreadManager.f258189c.getValue();
        }

        @JvmStatic
        public final void a(@NotNull Runnable task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task);
            } else {
                Intrinsics.checkNotNullParameter(task, "task");
                c().post(task);
            }
        }

        @JvmStatic
        public final void b(@NotNull Runnable task, long delayTimeMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, task, Long.valueOf(delayTimeMs));
            } else {
                Intrinsics.checkNotNullParameter(task, "task");
                c().postDelayed(task, delayTimeMs);
            }
        }

        @NotNull
        public final HandlerThread d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HandlerThread) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (HandlerThread) QQPerfHandlerThreadManager.f258188b.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<HandlerThread> lazy;
        Lazy<Handler> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) QQPerfHandlerThreadManager$Companion$handlerThread$2.INSTANCE);
        f258188b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) QQPerfHandlerThreadManager$Companion$handler$2.INSTANCE);
        f258189c = lazy2;
    }

    @NotNull
    public static final HandlerThread c() {
        return INSTANCE.d();
    }
}
