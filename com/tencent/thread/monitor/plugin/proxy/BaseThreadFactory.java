package com.tencent.thread.monitor.plugin.proxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import com.tencent.thread.monitor.plugin.manager.ThreadInfo;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "poolName", "", "(Ljava/util/concurrent/ThreadFactory;Ljava/lang/String;)V", "getReal", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public class BaseThreadFactory implements ThreadFactory {
    static IPatchRedirector $redirector_;
    private final String poolName;
    private final ThreadFactory threadFactory;

    public BaseThreadFactory(@NotNull ThreadFactory threadFactory, @NotNull String poolName) {
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        Intrinsics.checkNotNullParameter(poolName, "poolName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) threadFactory, (Object) poolName);
        } else {
            this.threadFactory = threadFactory;
            this.poolName = poolName;
        }
    }

    @NotNull
    public final ThreadFactory getReal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ThreadFactory) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.threadFactory;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Thread) iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Thread newThread = this.threadFactory.newThread(runnable);
        if (ProxyController.INSTANCE.getEnabled()) {
            ThreadInfo orPutThreadInfo = ProxyManager.getOrPutThreadInfo(newThread.getId());
            Intrinsics.checkNotNullExpressionValue(newThread, "this");
            orPutThreadInfo.updateFromPoolCreateThread(newThread, this.poolName);
        }
        Intrinsics.checkNotNullExpressionValue(newThread, "threadFactory.newThread(\u2026this, poolName)\n        }");
        return newThread;
    }
}
