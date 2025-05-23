package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadManagerV2 {
    static IPatchRedirector $redirector_ = null;
    public static final String AUTO_MONITOR_TAG = "AutoMonitor";
    protected static HandlerThread FILE_THREAD = null;
    protected static volatile Handler FILE_THREAD_HANDLER = null;
    public static volatile boolean IsRunTimeShutDown = false;
    protected static HandlerThread MSF_COMMON_PRIORITY_THREAD = null;
    protected static HandlerThread MSF_HIGH_PRIORITY_THREAD = null;
    private static final String NAME_COMMON_PRIORITY_THREAD = "MSF_Common_Priority_Thread";
    private static final String NAME_HIGH_PRIORITY_THREAD = "MSF_High_Priority_Thread";
    public static final boolean OLD_BUSINESS_AUTO_RETRIEVE = false;
    public static boolean OPEN_RDM_REPORT = false;
    protected static HandlerThread QQ_COMMON_THREAD = null;
    protected static volatile Handler QQ_COMMON_THREAD_HANDLER = null;
    protected static HandlerThread RECENT_THREAD = null;
    protected static Handler RECENT_THREAD_HANDLER = null;
    private static final String REPORT_AP_REJECTION_EXCEPTION = "ap_reject_exception_report";
    protected static final String REPORT_SP_REJECTION_EXCEPTION = "sp_reject_exception_report";
    protected static Handler SERVICE_CONTENT_HANDLER = null;
    protected static HandlerThread SERVICE_CONTENT_THREAD = null;
    protected static HandlerThread SUB_THREAD = null;
    protected static volatile Handler SUB_THREAD_HANDLER = null;
    public static final String TAG = "ThreadManager";
    private static Timer TIMER;
    protected static volatile Handler UI_HANDLER;
    private static Executor mNetExcutorPool;
    public static ThreadWrapContext sThreadWrapContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        OPEN_RDM_REPORT = true;
        IsRunTimeShutDown = false;
        initRuntimShutDownHook();
        reflectAsyncTaskPool();
        mNetExcutorPool = new BaseThreadPoolExecutor(5, 9, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new ThreadFactory() { // from class: com.tencent.mobileqq.app.ThreadManagerV2.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
                }
                ThreadLog.printQLog(ThreadManagerV2.TAG, "new NetExcutor5Thread");
                return new BaseThread(runnable, "NetExcutor5Thread");
            }
        });
    }

    public ThreadManagerV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkAndRunOnUIThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            getUIHandlerV2().post(runnable);
        }
    }

    public static void excute(Runnable runnable, int i3, ThreadExcutor.IThreadListener iThreadListener, boolean z16) {
        executeDelay(runnable, i3, iThreadListener, z16, 0L);
    }

    public static Runnable executeDelay(Runnable runnable, int i3, ThreadExcutor.IThreadListener iThreadListener, boolean z16, long j3) {
        if ((i3 & 240) == 0) {
            if (!ThreadSetting.isPublicVersion) {
                ThreadLog.trackException(TAG, "ThreadManager.excute type is not valid");
            } else {
                ThreadWrapContext threadWrapContext = sThreadWrapContext;
                if (threadWrapContext != null) {
                    threadWrapContext.reportRDMException(new TSPInvalidArgsCatchedException("ThreadManager_excute_Type_NONE"), "ThreadManager_excute_Type_NONE", runnable.getClass().getName());
                    return null;
                }
                return null;
            }
        }
        return ThreadExcutor.getInstance().excute(runnable, i3, iThreadListener, z16, j3);
    }

    public static void executeOnFileThread(Runnable runnable) {
        getFileThreadHandlerV2().post(runnable);
    }

    public static void executeOnNetWorkThread(Runnable runnable) {
        excute(runnable, 128, null, false);
    }

    public static void executeOnSubThread(Runnable runnable) {
        if (ThreadMonitor.INSTANCE.getEnable()) {
            getSubThreadHandlerV2().post(new Runnable(runnable) { // from class: com.tencent.mobileqq.app.ThreadManagerV2.2
                static IPatchRedirector $redirector_;
                public final long addPoint;
                public long cost;
                final /* synthetic */ Runnable val$run;
                public long wait;

                {
                    this.val$run = runnable;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
                        return;
                    }
                    this.addPoint = SystemClock.uptimeMillis();
                    this.cost = -1L;
                    this.wait = -1L;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    this.wait = SystemClock.uptimeMillis() - this.addPoint;
                    this.val$run.run();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    long j3 = this.wait;
                    long j16 = uptimeMillis - (this.addPoint + j3);
                    this.cost = j16;
                    ThreadMonitor.INSTANCE.upDataTask(99, j3, j16);
                }
            });
        } else {
            getSubThreadHandlerV2().post(runnable);
        }
    }

    public static Thread getFileThread() {
        if (FILE_THREAD == null) {
            getFileThreadHandlerV2();
        }
        return FILE_THREAD;
    }

    private static Handler getFileThreadHandlerV2() {
        if (FILE_THREAD_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (FILE_THREAD_HANDLER == null) {
                    HandlerThread newFreeHandlerThread = newFreeHandlerThread("QQ_FILE_RW", 0);
                    FILE_THREAD = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                    FILE_THREAD_HANDLER = new Handler(FILE_THREAD.getLooper());
                }
            }
        }
        return FILE_THREAD_HANDLER;
    }

    public static Looper getFileThreadLooper() {
        return getFileThreadHandlerV2().getLooper();
    }

    public static HandlerThread getMSFCommonPriorityThread() {
        if (MSF_COMMON_PRIORITY_THREAD == null) {
            synchronized (ThreadManagerV2.class) {
                if (MSF_COMMON_PRIORITY_THREAD == null) {
                    HandlerThread newFreeHandlerThread = newFreeHandlerThread(NAME_COMMON_PRIORITY_THREAD, 0);
                    MSF_COMMON_PRIORITY_THREAD = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                }
            }
        }
        return MSF_COMMON_PRIORITY_THREAD;
    }

    public static HandlerThread getMSFHighPriorityThread() {
        if (MSF_HIGH_PRIORITY_THREAD == null) {
            synchronized (ThreadManagerV2.class) {
                if (MSF_HIGH_PRIORITY_THREAD == null) {
                    HandlerThread newFreeHandlerThread = newFreeHandlerThread(NAME_HIGH_PRIORITY_THREAD, 0);
                    MSF_HIGH_PRIORITY_THREAD = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                }
            }
        }
        return MSF_HIGH_PRIORITY_THREAD;
    }

    public static Executor getNetExcutor() {
        return mNetExcutorPool;
    }

    public static Thread getQQCommonThread() {
        if (QQ_COMMON_THREAD == null) {
            getQQCommonThreadHandlerV2();
        }
        return QQ_COMMON_THREAD;
    }

    private static Handler getQQCommonThreadHandlerV2() {
        if (QQ_COMMON_THREAD_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (QQ_COMMON_THREAD_HANDLER == null) {
                    HandlerThread newFreeHandlerThread = newFreeHandlerThread("QQ_COMMON", 0);
                    QQ_COMMON_THREAD = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                    QQ_COMMON_THREAD_HANDLER = new Handler(QQ_COMMON_THREAD.getLooper());
                }
            }
        }
        return QQ_COMMON_THREAD_HANDLER;
    }

    public static Looper getQQCommonThreadLooper() {
        return getQQCommonThreadHandlerV2().getLooper();
    }

    public static Thread getRecentThread() {
        if (RECENT_THREAD == null) {
            getRecentThreadLooper();
        }
        return RECENT_THREAD;
    }

    public static Looper getRecentThreadLooper() {
        if (RECENT_THREAD_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (RECENT_THREAD_HANDLER == null) {
                    HandlerThread newFreeHandlerThread = newFreeHandlerThread("Recent_Handler", 0);
                    RECENT_THREAD = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                    RECENT_THREAD_HANDLER = new Handler(RECENT_THREAD.getLooper());
                }
            }
        }
        return RECENT_THREAD_HANDLER.getLooper();
    }

    public static Handler getServiceContentHandler() {
        if (SERVICE_CONTENT_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (SERVICE_CONTENT_HANDLER == null) {
                    HandlerThread newFreeHandlerThread = newFreeHandlerThread("ServiceContent", 0);
                    SERVICE_CONTENT_THREAD = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                    SERVICE_CONTENT_HANDLER = new Handler(SERVICE_CONTENT_THREAD.getLooper());
                }
            }
        }
        return SERVICE_CONTENT_HANDLER;
    }

    public static Thread getServiceContentThread() {
        if (SERVICE_CONTENT_THREAD == null) {
            getServiceContentHandler();
        }
        return SERVICE_CONTENT_THREAD;
    }

    public static Thread getSubThread() {
        if (SUB_THREAD == null) {
            getSubThreadHandlerV2();
        }
        return SUB_THREAD;
    }

    private static Handler getSubThreadHandlerV2() {
        if (SUB_THREAD_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (SUB_THREAD_HANDLER == null) {
                    HandlerThread newFreeHandlerThread = newFreeHandlerThread("QQ_SUB", 0);
                    SUB_THREAD = newFreeHandlerThread;
                    newFreeHandlerThread.start();
                    SUB_THREAD_HANDLER = new Handler(SUB_THREAD.getLooper());
                }
            }
        }
        return SUB_THREAD_HANDLER;
    }

    public static Looper getSubThreadLooper() {
        return getSubThreadHandlerV2().getLooper();
    }

    public static Timer getTimer() {
        if (TIMER == null) {
            synchronized (ThreadManagerV2.class) {
                TIMER = new BaseTimer("QQ_Timer") { // from class: com.tencent.mobileqq.app.ThreadManagerV2.5
                    static IPatchRedirector $redirector_;

                    {
                        super(r4);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                        }
                    }

                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseTimer, java.util.Timer
                    public void cancel() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        ThreadLog.printQLog(ThreadManagerV2.TAG, "Can't cancel Global Timer");
                        if (ThreadSetting.isPublicVersion) {
                        } else {
                            throw new RuntimeException("Can't cancel Global Timer");
                        }
                    }

                    @Override // java.util.Timer
                    public void schedule(TimerTask timerTask, long j3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, this, timerTask, Long.valueOf(j3));
                            return;
                        }
                        try {
                            super.schedule(timerTask, j3);
                        } catch (Exception e16) {
                            ThreadLog.printQLog(ThreadManagerV2.TAG, "timer schedule err", e16);
                        }
                    }

                    @Override // java.util.Timer
                    public void schedule(TimerTask timerTask, long j3, long j16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, this, timerTask, Long.valueOf(j3), Long.valueOf(j16));
                            return;
                        }
                        try {
                            super.schedule(timerTask, j3, j16);
                        } catch (Exception e16) {
                            ThreadLog.printQLog(ThreadManagerV2.TAG, "timer schedule2 err", e16);
                        }
                    }
                };
            }
        }
        return TIMER;
    }

    public static Handler getUIHandlerV2() {
        if (UI_HANDLER == null) {
            synchronized (ThreadManagerV2.class) {
                if (UI_HANDLER == null) {
                    UI_HANDLER = new Handler(Looper.getMainLooper());
                }
            }
        }
        return UI_HANDLER;
    }

    public static void init() {
        ThreadLog.printQLog(TAG, "ThreadManager init");
        ThreadExcutor.getInstance();
    }

    private static void initRuntimShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new BaseThread() { // from class: com.tencent.mobileqq.app.ThreadManagerV2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ThreadManagerV2.IsRunTimeShutDown = true;
                    ThreadLog.printQLog(ThreadManagerV2.TAG, "QQ Runtime ShutDown");
                }
            }
        });
    }

    public static HandlerThread newFreeHandlerThread(String str, int i3) {
        HandlerThread newFreeHandlerThread = ThreadExcutor.getInstance().newFreeHandlerThread(str, i3);
        ThreadLog.printQLog(TAG, newFreeHandlerThread.getId() + "-" + str);
        return newFreeHandlerThread;
    }

    public static Thread newFreeThread(Runnable runnable, String str, int i3) {
        Thread newFreeThread = ThreadExcutor.getInstance().newFreeThread(runnable, str, i3);
        ThreadLog.printQLog(TAG, newFreeThread.getId() + "|" + str);
        return newFreeThread;
    }

    public static Executor newFreeThreadPool(ThreadPoolParams threadPoolParams) {
        if (!ThreadSetting.isPublicVersion && (threadPoolParams == null || TextUtils.isEmpty(threadPoolParams.poolThreadName) || ThreadPoolParams.DEFAULT_THREAD_NAME.equals(threadPoolParams.poolThreadName))) {
            throw new RuntimeException("newFreeThreadPool exception");
        }
        return ThreadExcutor.getInstance().newFreeThreadPool(threadPoolParams);
    }

    public static bd newHandlerRecycleThread(String str, int i3) {
        return new HandlerRecycleThreadPoolExecutor(str, i3);
    }

    public static Executor newSerialExecutor() {
        return ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.mobileqq.app.ThreadManagerV2.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
                }
                ThreadLog.printQLog(ThreadManagerV2.TAG, "serialExecutor_thread");
                return new BaseThread(runnable, "serialExecutor_thread");
            }
        });
    }

    @Deprecated
    public static void post(Runnable runnable, int i3, ThreadExcutor.IThreadListener iThreadListener, boolean z16) {
        ThreadExcutor.getInstance().post(i3, runnable, iThreadListener, z16);
    }

    @Deprecated
    public static void postDownLoadTask(Runnable runnable, int i3, ThreadExcutor.IThreadListener iThreadListener, boolean z16) {
        ThreadExcutor.getInstance().postDownLoadTask(i3, runnable, iThreadListener, z16);
    }

    @Deprecated
    public static void postImmediately(Runnable runnable, ThreadExcutor.IThreadListener iThreadListener, boolean z16) {
        ThreadExcutor.getInstance().postImmediately(runnable, iThreadListener, z16);
    }

    @TargetApi(11)
    private static void reflectAsyncTaskPool() {
        try {
            ThreadSmartPool createThreadPool = ThreadAsyncTaskPool.createThreadPool();
            createThreadPool.allowCoreThreadTimeOut(true);
            ThreadLog.printQLog(TAG, "reflectAsyncTaskPool before:" + AsyncTask.THREAD_POOL_EXECUTOR);
            Field declaredField = AsyncTask.class.getDeclaredField("THREAD_POOL_EXECUTOR");
            declaredField.setAccessible(true);
            declaredField.set(null, createThreadPool);
            ThreadLog.printQLog(TAG, "reflectAsyncTaskPool after:" + AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (Throwable th5) {
            ThreadLog.printQLog(TAG, "reflectAsyncTaskPool", th5);
        }
    }

    @Deprecated
    public static boolean remove(Runnable runnable) {
        ThreadLog.printQLog(TAG, "Remove_Use_Deprecated_Method " + runnable.getClass().getName());
        return false;
    }

    public static void removeJob(Runnable runnable, int i3) {
        ThreadExcutor.getInstance().removeJob(runnable, i3);
    }

    public static boolean removeJobFromThreadPool(Runnable runnable, int i3) {
        return ThreadExcutor.getInstance().removeJobFromThreadPool(runnable, i3);
    }

    public static String reportCurrentState() {
        return ThreadExcutor.getInstance().printCurrentState();
    }

    @Deprecated
    public static void executeOnSubThread(Runnable runnable, boolean z16) {
        getSubThreadHandlerV2().post(runnable);
    }
}
