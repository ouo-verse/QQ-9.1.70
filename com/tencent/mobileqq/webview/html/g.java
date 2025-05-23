package com.tencent.mobileqq.webview.html;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/webview/html/g;", "", "Ljava/lang/Runnable;", "task", "", "a", "Ljava/util/concurrent/ThreadPoolExecutor;", "b", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f313896a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ThreadPoolExecutor executor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/webview/html/g$a;", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", "r", "Ljava/lang/Thread;", "newThread", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNumber", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    private static final class a implements ThreadFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicInteger threadNumber;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.threadNumber = new AtomicInteger(1);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable r16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r16);
            }
            Intrinsics.checkNotNullParameter(r16, "r");
            BaseThread baseThread = new BaseThread(r16, "htmlsession_" + this.threadNumber.getAndIncrement());
            if (baseThread.getPriority() != 10) {
                baseThread.setPriority(10);
            }
            return baseThread;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f313896a = new g();
        executor = new BaseThreadPoolExecutor(1, 6, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new a());
        executor.allowCoreThreadTimeOut(true);
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull Runnable task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) task)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            executor.execute(task);
            return true;
        } catch (Throwable th5) {
            c.g(c.f313882a, "htmlAgent_HtmlSessionThreadPool", 6, "execute task error:" + th5.getMessage(), null, 8, null);
            return false;
        }
    }
}
