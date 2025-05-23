package com.tencent.ams.dsdk.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WorkThreadManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WorkThreadManager";
    private Executor backgroundCachedThreadPool;
    private Executor cachedThreadPool;
    private DKScheduledExecutor dkScheduledExecutor;
    private Executor immediateThreadPool;
    private ScheduledThreadPoolExecutor scheduledThreadPool;
    private DKScheduledExecutor singleThreadDKScheduledPool;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class HighPriorityThreadPoolHolder {
        static IPatchRedirector $redirector_;
        private static final ThreadPoolExecutor INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19036);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(2, 4, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("AdCoreForegroundWorkThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
            INSTANCE = baseThreadPoolExecutor;
            baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
            DLog.d(WorkThreadManager.TAG, "HighPriorityThreadPool allowCoreThreadTimeOut");
        }

        HighPriorityThreadPoolHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ImmediateThreadPoolHolder {
        static IPatchRedirector $redirector_;
        private static final ThreadPoolExecutor INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19044);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(1, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("AdCoreFixedImmediateWorkThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
            INSTANCE = baseThreadPoolExecutor;
            baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
            DLog.d(WorkThreadManager.TAG, "ImmediateThreadPool allowCoreThreadTimeOut");
        }

        ImmediateThreadPoolHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class LowPriorityThreadPoolHolder {
        static IPatchRedirector $redirector_;
        private static final ThreadPoolExecutor INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19061);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, new PriorityBlockingQueue(100, new Comparator<Runnable>() { // from class: com.tencent.ams.dsdk.utils.WorkThreadManager.LowPriorityThreadPoolHolder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.util.Comparator
                public int compare(Runnable runnable, Runnable runnable2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) runnable2)).intValue();
                    }
                    if (runnable instanceof PriorityRunnable) {
                        if (runnable2 instanceof PriorityRunnable) {
                            return ((PriorityRunnable) runnable2).getPriority() - ((PriorityRunnable) runnable).getPriority();
                        }
                        return 0 - ((PriorityRunnable) runnable).getPriority();
                    }
                    if (runnable2 instanceof PriorityRunnable) {
                        return ((PriorityRunnable) runnable2).getPriority() - 0;
                    }
                    return 0;
                }
            }), new NamedThreadFactory("AdCoreBackgroundWorkThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
            INSTANCE = baseThreadPoolExecutor;
            baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
            DLog.d(WorkThreadManager.TAG, "LowPriorityThreadPool allowCoreThreadTimeOut");
        }

        LowPriorityThreadPoolHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class PriorityRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        protected int priority;

        protected PriorityRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public int getPriority() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.priority;
        }

        public PriorityRunnable(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.priority = i3;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ScheduledThreadPoolHolder {
        static IPatchRedirector $redirector_;
        private static final ScheduledThreadPoolExecutor INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19075);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BaseScheduledThreadPoolExecutor baseScheduledThreadPoolExecutor = new BaseScheduledThreadPoolExecutor(2, new NamedThreadFactory("AdCoreScheduledThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
            INSTANCE = baseScheduledThreadPoolExecutor;
            baseScheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
            baseScheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
            DLog.d(WorkThreadManager.TAG, "ScheduledThreadPool allowCoreThreadTimeOut");
        }

        ScheduledThreadPoolHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class SingleThreadScheduledPoolHolder {
        static IPatchRedirector $redirector_;
        private static final ScheduledThreadPoolExecutor INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19086);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BaseScheduledThreadPoolExecutor baseScheduledThreadPoolExecutor = new BaseScheduledThreadPoolExecutor(1, new NamedThreadFactory("AdCoreSingleThreadScheduledPool"));
            INSTANCE = baseScheduledThreadPoolExecutor;
            baseScheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
            DLog.d(WorkThreadManager.TAG, "SingleThreadScheduledPool allowCoreThreadTimeOut");
        }

        SingleThreadScheduledPoolHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class WorkThreadManagerHolder {
        static IPatchRedirector $redirector_;
        private static final WorkThreadManager INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19090);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new WorkThreadManager(null);
            }
        }

        WorkThreadManagerHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ WorkThreadManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) anonymousClass1);
    }

    public static final WorkThreadManager getInstance() {
        return WorkThreadManagerHolder.INSTANCE;
    }

    private ScheduledThreadPoolExecutor getScheduledThreadPool() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.scheduledThreadPool;
        if (scheduledThreadPoolExecutor == null) {
            return ScheduledThreadPoolHolder.INSTANCE;
        }
        return scheduledThreadPoolExecutor;
    }

    public Executor getBackgroundThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Executor) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Executor executor = this.backgroundCachedThreadPool;
        if (executor == null) {
            return LowPriorityThreadPoolHolder.INSTANCE;
        }
        return executor;
    }

    public Executor getCachedThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Executor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Executor executor = this.cachedThreadPool;
        if (executor == null) {
            return HighPriorityThreadPoolHolder.INSTANCE;
        }
        return executor;
    }

    public Executor getImmediateThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Executor) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Executor executor = this.immediateThreadPool;
        if (executor == null) {
            return ImmediateThreadPoolHolder.INSTANCE;
        }
        return executor;
    }

    public void schedule(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3));
            return;
        }
        DKScheduledExecutor dKScheduledExecutor = this.dkScheduledExecutor;
        if (dKScheduledExecutor != null) {
            dKScheduledExecutor.schedule(runnable, j3);
        } else {
            getScheduledThreadPool().schedule(runnable, j3, TimeUnit.MILLISECONDS);
        }
    }

    public void scheduleOnSingleThread(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, runnable, Long.valueOf(j3));
            return;
        }
        DKScheduledExecutor dKScheduledExecutor = this.singleThreadDKScheduledPool;
        if (dKScheduledExecutor != null) {
            dKScheduledExecutor.schedule(runnable, j3);
        } else {
            SingleThreadScheduledPoolHolder.INSTANCE.schedule(runnable, j3, TimeUnit.MILLISECONDS);
        }
    }

    public void setDkScheduledExecutor(DKScheduledExecutor dKScheduledExecutor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) dKScheduledExecutor);
        } else {
            this.dkScheduledExecutor = dKScheduledExecutor;
        }
    }

    public void setHighPriorityExecutor(Executor executor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) executor);
        } else {
            this.cachedThreadPool = executor;
        }
    }

    public void setImmediateExecutor(Executor executor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) executor);
        } else {
            this.immediateThreadPool = executor;
        }
    }

    public void setLowPriorityExecutor(Executor executor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) executor);
        } else {
            this.backgroundCachedThreadPool = executor;
        }
    }

    public void setSingleThreadDKScheduledPool(DKScheduledExecutor dKScheduledExecutor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dKScheduledExecutor);
        } else {
            this.singleThreadDKScheduledPool = dKScheduledExecutor;
        }
    }

    public void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    WorkThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
