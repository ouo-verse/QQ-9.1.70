package com.tencent.aio.base.thread;

import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import tl.h;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0017J\b\u0010\t\u001a\u00020\u0007H\u0017J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0097\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/aio/base/thread/DifferListDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lzs/a;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "block", "", "dispatch", "close", "runnable", "Lkotlinx/coroutines/CoroutineScope;", "scope", h.F, "", "g", "", "d", "I", "threadIndex", "Ljava/util/concurrent/Executor;", "e", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class DifferListDispatcher extends ExecutorCoroutineDispatcher implements zs.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int threadIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    private static final Executor executor;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final DifferListDispatcher f69210f;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "it", "Ljava/lang/Runnable;", "newThread"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    static final class a implements ThreadFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public static final a f69211d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30552);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f69211d = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (Thread) iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Displaydiffer-");
            int a16 = DifferListDispatcher.a(DifferListDispatcher.f69210f);
            DifferListDispatcher.threadIndex = a16 + 1;
            sb5.append(a16);
            return new DisplayOperationThread(it, sb5.toString());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f69210f = new DifferListDispatcher();
        ScheduledExecutorService newScheduledThreadPool = ProxyExecutors.newScheduledThreadPool(3, a.f69211d);
        Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "Executors.newScheduledTh\u2026${threadIndex ++}\")\n    }");
        executor = newScheduledThreadPool;
    }

    DifferListDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public static final /* synthetic */ int a(DifferListDispatcher differListDispatcher) {
        return threadIndex;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Executor executor2 = getExecutor();
        if (!(executor2 instanceof ScheduledExecutorService)) {
            executor2 = null;
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor2;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: dispatch */
    public void mo2047dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        getExecutor().execute(block);
    }

    @Override // zs.a
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return a.C11711a.a(this);
    }

    @Override // zs.a
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        com.tencent.aio.base.thread.a aVar = com.tencent.aio.base.thread.a.f69217b;
        return Intrinsics.areEqual(aVar.a(), aVar);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Executor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return executor;
    }

    @Override // zs.a
    public void h(@NotNull Runnable runnable, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable, (Object) scope);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Intrinsics.checkNotNullParameter(scope, "scope");
        BuildersKt__Builders_commonKt.launch$default(scope, this, null, new DifferListDispatcher$post$1(runnable, null), 2, null);
    }
}
