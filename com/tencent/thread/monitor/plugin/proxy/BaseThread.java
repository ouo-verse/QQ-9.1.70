package com.tencent.thread.monitor.plugin.proxy;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.thread.monitor.plugin.api.IReporter;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\u0019\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\fB\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\rB#\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000eB+\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseThread;", "Ljava/lang/Thread;", "()V", "target", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", VipFunCallConstants.KEY_GROUP, "Ljava/lang/ThreadGroup;", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;)V", "name", "", "(Ljava/lang/String;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;)V", "stackSize", "", "(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V", TencentLocation.RUN_MODE, "", "start", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public class BaseThread extends Thread {
    static IPatchRedirector $redirector_;

    public BaseThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.run();
        if (ProxyController.INSTANCE.getEnabled()) {
            ProxyManager.removeThreadInfo(getId());
        }
    }

    @Override // java.lang.Thread
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            super.start();
        } catch (OutOfMemoryError e16) {
            if (ProxyController.INSTANCE.getEnableOptimized()) {
                ProxyController proxyController = ProxyController.INSTANCE;
                proxyController.trimThreads(true);
                super.start();
                IReporter iReporter = proxyController.getIReporter();
                if (iReporter != null) {
                    iReporter.reportFixOOM();
                }
            } else {
                throw e16;
            }
        }
        if (ProxyController.INSTANCE.getEnabled()) {
            ProxyManager.getOrPutThreadInfo(getId()).update(this);
        }
    }

    public BaseThread(@Nullable Runnable runnable) {
        super(runnable);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
    }

    public BaseThread(@Nullable ThreadGroup threadGroup, @Nullable Runnable runnable) {
        super(threadGroup, runnable);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) threadGroup, (Object) runnable);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThread(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) name);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThread(@Nullable ThreadGroup threadGroup, @NotNull String name) {
        super(threadGroup, name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) threadGroup, (Object) name);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThread(@Nullable Runnable runnable, @NotNull String name) {
        super(runnable, name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) runnable, (Object) name);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThread(@Nullable ThreadGroup threadGroup, @Nullable Runnable runnable, @NotNull String name) {
        super(threadGroup, runnable, name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, threadGroup, runnable, name);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThread(@Nullable ThreadGroup threadGroup, @Nullable Runnable runnable, @NotNull String name, long j3) {
        super(threadGroup, runnable, name, j3);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, this, threadGroup, runnable, name, Long.valueOf(j3));
    }
}
