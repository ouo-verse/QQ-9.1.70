package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadExcutor {
    static IPatchRedirector $redirector_ = null;
    private static volatile Handler DISPATCHER_HANDLER = null;
    public static final int IS_ASYNC_POOL = 10;
    public static final int IS_DB_POOL = 7;
    public static final int IS_DOWNLOAD_POOL = 5;
    public static final int IS_FILE_POOL = 8;
    public static final int IS_HEAVY_POOL = 2;
    public static final int IS_LIGHT_POOL = 1;
    public static final int IS_NET_POOL = 9;
    public static final int IS_NOMAL_POOL = 6;
    public static final int IS_OTHER_POOL = 11;
    public static final int IS_SUB = 99;
    private static final ThreadExcutor sExcutors;
    private ThreadSmartPool mAIODownloadThreadPool;
    private ThreadSmartPool mDBPool;
    private ThreadSmartPool mFilePool;
    private ThreadSmartPool mHeavyThreadPool;
    private ThreadSmartPool mLightThreadPool;
    private ThreadSmartPool mNetPool;
    private ThreadSmartPool mNormalPool;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface IThreadListener {
        void onAdded();

        void onPostRun();

        void onPreRun();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41010);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sExcutors = new ThreadExcutor();
        }
    }

    ThreadExcutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ThreadManagerV2.IsRunTimeShutDown = false;
        ThreadLog.printQLog(ThreadManagerV2.TAG, "ThreadExcutor singleton construct");
        initThreadPools();
        initDispatcherHandler();
    }

    public static Job buildJob(int i3, Runnable runnable, IThreadListener iThreadListener, boolean z16) {
        Object obj;
        Object obj2;
        Field declaredField;
        Class<?> cls = runnable.getClass();
        String name = cls.getName();
        if (z16) {
            try {
                declaredField = cls.getDeclaredField("this$0");
                declaredField.setAccessible(true);
                obj = declaredField.get(runnable);
            } catch (IllegalAccessException unused) {
                obj = null;
            } catch (IllegalArgumentException unused2) {
                obj = null;
            } catch (NoSuchFieldException unused3) {
                obj = null;
            }
            try {
                declaredField.set(runnable, null);
            } catch (IllegalAccessException unused4) {
                if (ThreadSetting.logcatBgTaskMonitor) {
                    ThreadLog.printQLog(ThreadManagerV2.TAG, "buildJob IllegalAccessException");
                }
                obj2 = obj;
                return new Job(obj2, name, i3, runnable, iThreadListener, z16);
            } catch (IllegalArgumentException unused5) {
                if (ThreadSetting.logcatBgTaskMonitor) {
                    ThreadLog.printQLog(ThreadManagerV2.TAG, "buildJob IllegalArgumentException");
                }
                obj2 = obj;
                return new Job(obj2, name, i3, runnable, iThreadListener, z16);
            } catch (NoSuchFieldException unused6) {
                if (ThreadSetting.logcatBgTaskMonitor) {
                    ThreadLog.printQLog(ThreadManagerV2.TAG, "buildJob NoSuchFieldException");
                }
                obj2 = obj;
                return new Job(obj2, name, i3, runnable, iThreadListener, z16);
            }
            obj2 = obj;
        } else {
            obj2 = null;
        }
        try {
            return new Job(obj2, name, i3, runnable, iThreadListener, z16);
        } catch (OutOfMemoryError e16) {
            ThreadLog.printQLog(ThreadManagerV2.TAG, "buildJob IllegalAccessException", e16);
            return null;
        }
    }

    public static void doRdmReport(String str, String str2) {
        if (ThreadSetting.isPublicVersion) {
            ThreadWrapContext threadWrapContext = ThreadManagerV2.sThreadWrapContext;
            if (threadWrapContext != null) {
                threadWrapContext.reportRDMException(new TSPInvalidArgsCatchedException(str), str, str2);
                return;
            }
            return;
        }
        throw new TSPInvalidArgsCatchedException(str + "|" + str2);
    }

    private StringBuilder getAllPoolRunningJob(String str) {
        ThreadLog.printQLog(ThreadManagerV2.TAG, "\ngetAllPoolRunningJob from: " + str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nInLight");
        getPoolRunningJob(sb5, Job.runningJmapInLight);
        sb5.append("\nInHeavy");
        getPoolRunningJob(sb5, Job.runningJmapInHeavy);
        sb5.append("\nInDownload");
        getPoolRunningJob(sb5, Job.runningJmapInDownload);
        sb5.append("\nInNormal");
        getPoolRunningJob(sb5, Job.runningJmapInNormal);
        sb5.append("\nInDB");
        getPoolRunningJob(sb5, Job.runningJmapInDB);
        sb5.append("\nInFile");
        getPoolRunningJob(sb5, Job.runningJmapInFile);
        sb5.append("\nInNet");
        getPoolRunningJob(sb5, Job.runningJmapInNet);
        sb5.append("\nInAync");
        getPoolRunningJob(sb5, Job.runningJmapInAync);
        sb5.append("\nInOther");
        getPoolRunningJob(sb5, Job.runningJmapInOther);
        return sb5;
    }

    public static synchronized ThreadExcutor getInstance() {
        ThreadExcutor threadExcutor;
        synchronized (ThreadExcutor.class) {
            threadExcutor = sExcutors;
        }
        return threadExcutor;
    }

    private StringBuilder getPoolRunningJob(StringBuilder sb5, ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
        if (concurrentLinkedQueue != null && sb5 != null) {
            Iterator<String> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                sb5.append("\nRunning_Job: " + it.next());
            }
        }
        return sb5;
    }

    private String getStackTrace() {
        if (ThreadSmartPoolMonitorConfig.getMonitorFeatureSwitchState()) {
            StringBuilder sb5 = new StringBuilder();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                if (stackTrace.length > 3) {
                    for (int i3 = 3; i3 < stackTrace.length; i3++) {
                        sb5.append(stackTrace[i3].toString());
                        sb5.append("\n");
                    }
                    if (sb5.length() > 1000) {
                        return sb5.substring(0, 1000);
                    }
                    return "";
                }
            }
            return sb5.toString();
        }
        return "";
    }

    private Handler initDispatcherHandler() {
        if (DISPATCHER_HANDLER == null) {
            HandlerThread newFreeHandlerThread = newFreeHandlerThread("QQ_DISPATCHER", 0);
            newFreeHandlerThread.start();
            DISPATCHER_HANDLER = new Handler(newFreeHandlerThread.getLooper());
            if (ThreadSetting.logcatBgTaskMonitor) {
                DISPATCHER_HANDLER.getLooper().setMessageLogging(new ThreadLooperPrinter2(1, "QQ_DISPATCHER"));
            }
        }
        return DISPATCHER_HANDLER;
    }

    @TargetApi(9)
    private void initThreadPools() {
        if (this.mLightThreadPool == null) {
            ThreadSmartPool createThreadPool = ThreadLightPool.createThreadPool();
            this.mLightThreadPool = createThreadPool;
            createThreadPool.allowCoreThreadTimeOut(true);
        }
        if (this.mHeavyThreadPool == null) {
            ThreadSmartPool createThreadPool2 = ThreadHeavyPool.createThreadPool();
            this.mHeavyThreadPool = createThreadPool2;
            createThreadPool2.allowCoreThreadTimeOut(true);
        }
        if (this.mNormalPool == null) {
            ThreadSmartPool createThreadPool3 = ThreadNormalPool.createThreadPool();
            this.mNormalPool = createThreadPool3;
            createThreadPool3.allowCoreThreadTimeOut(true);
        }
        if (this.mDBPool == null) {
            ThreadSmartPool createThreadPool4 = ThreadDBPool.createThreadPool();
            this.mDBPool = createThreadPool4;
            createThreadPool4.allowCoreThreadTimeOut(true);
        }
        if (this.mFilePool == null) {
            ThreadSmartPool createThreadPool5 = ThreadFilePool.createThreadPool();
            this.mFilePool = createThreadPool5;
            createThreadPool5.allowCoreThreadTimeOut(true);
        }
        if (this.mNetPool == null) {
            ThreadSmartPool createThreadPool6 = ThreadNetWorkPool.createThreadPool();
            this.mNetPool = createThreadPool6;
            createThreadPool6.allowCoreThreadTimeOut(true);
        }
        if (this.mAIODownloadThreadPool == null) {
            ThreadSmartPool createThreadPool7 = ThreadAioDownloadPool.createThreadPool();
            this.mAIODownloadThreadPool = createThreadPool7;
            createThreadPool7.allowCoreThreadTimeOut(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Runnable excute(Runnable runnable, int i3, IThreadListener iThreadListener, boolean z16, long j3) {
        if (runnable != null) {
            WrapperRunnable wrapperRunnable = new WrapperRunnable(runnable, i3, runnable, iThreadListener, z16, getStackTrace()) { // from class: com.tencent.mobileqq.app.ThreadExcutor.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$canAutoRetrieve;
                final /* synthetic */ Runnable val$job;
                final /* synthetic */ IThreadListener val$listener;
                final /* synthetic */ String val$trace;
                final /* synthetic */ int val$type;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(runnable);
                    this.val$type = i3;
                    this.val$job = runnable;
                    this.val$listener = iThreadListener;
                    this.val$canAutoRetrieve = z16;
                    this.val$trace = r11;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ThreadExcutor.this, runnable, Integer.valueOf(i3), runnable, iThreadListener, Boolean.valueOf(z16), r11);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ThreadSmartPool threadSmartPool;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Job buildJob = ThreadExcutor.buildJob(this.val$type, this.val$job, this.val$listener, this.val$canAutoRetrieve);
                    if (buildJob == null) {
                        ThreadExcutor.doRdmReport("ThreadManagerV2_excute_Job_NULL", "w_NONE_job" + this.val$job.getClass().getName());
                        return;
                    }
                    buildJob.setStacktrace(this.val$trace);
                    int i16 = this.val$type;
                    if ((i16 & 128) != 0) {
                        buildJob.poolNum = 9;
                        threadSmartPool = ThreadExcutor.this.mNetPool;
                    } else if ((i16 & 64) != 0) {
                        buildJob.poolNum = 8;
                        threadSmartPool = ThreadExcutor.this.mFilePool;
                    } else if ((i16 & 32) != 0) {
                        buildJob.poolNum = 7;
                        threadSmartPool = ThreadExcutor.this.mDBPool;
                    } else if ((i16 & 16) != 0) {
                        buildJob.poolNum = 6;
                        buildJob.setThreadPoolMonitor(ThreadExcutor.this.mNormalPool.threadPoolMonitor);
                        threadSmartPool = ThreadExcutor.this.mNormalPool;
                    } else {
                        return;
                    }
                    threadSmartPool.execute(buildJob);
                }
            };
            if (j3 > 0) {
                DISPATCHER_HANDLER.postDelayed(wrapperRunnable, j3);
            } else {
                DISPATCHER_HANDLER.postAtFrontOfQueue(wrapperRunnable);
            }
            return wrapperRunnable;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerThread newFreeHandlerThread(String str, int i3) {
        return new BaseHandlerThread(str, i3) { // from class: com.tencent.mobileqq.app.ThreadExcutor.4
            static IPatchRedirector $redirector_;

            {
                super(str, i3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ThreadExcutor.this, str, Integer.valueOf(i3));
                }
            }

            private void checkQQGlobalThread() {
                if (!ThreadSetting.isPublicVersion) {
                    String name = getName();
                    if (name.equals("QQ_FILE_RW") || name.equals("QQ_SUB") || name.equals("Recent_Handler")) {
                        throw new RuntimeException(name + " can't quit Global Thread ");
                    }
                }
            }

            @Override // android.os.HandlerThread
            public boolean quit() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                checkQQGlobalThread();
                return super.quit();
            }

            @Override // android.os.HandlerThread
            public boolean quitSafely() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                checkQQGlobalThread();
                return super.quitSafely();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Thread newFreeThread(Runnable runnable, String str, int i3) {
        BaseThread baseThread = new BaseThread(runnable, str);
        baseThread.setPriority(i3);
        return baseThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    public Executor newFreeThreadPool(ThreadPoolParams threadPoolParams) {
        if (threadPoolParams == null) {
            threadPoolParams = new ThreadPoolParams();
        }
        ThreadSmartPool threadSmartPool = new ThreadSmartPool(threadPoolParams.corePoolsize, threadPoolParams.maxPooolSize, threadPoolParams.keepAliveTime, threadPoolParams.queue, new PriorityThreadFactory(threadPoolParams.poolThreadName, threadPoolParams.priority));
        threadSmartPool.allowCoreThreadTimeOut(true);
        ThreadLog.printQLog(ThreadManagerV2.TAG, "newFreeThreadPool " + threadPoolParams.poolThreadName);
        return threadSmartPool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void post(int i3, Runnable runnable, IThreadListener iThreadListener, boolean z16) {
        if (runnable != null) {
            DISPATCHER_HANDLER.postAtFrontOfQueue(new Runnable(i3, runnable, iThreadListener, z16, getStackTrace()) { // from class: com.tencent.mobileqq.app.ThreadExcutor.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$canAutoRetrieve;
                final /* synthetic */ Runnable val$job;
                final /* synthetic */ IThreadListener val$listener;
                final /* synthetic */ int val$priority;
                final /* synthetic */ String val$trace;

                {
                    this.val$priority = i3;
                    this.val$job = runnable;
                    this.val$listener = iThreadListener;
                    this.val$canAutoRetrieve = z16;
                    this.val$trace = r10;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ThreadExcutor.this, Integer.valueOf(i3), runnable, iThreadListener, Boolean.valueOf(z16), r10);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Job buildJob = ThreadExcutor.buildJob(this.val$priority, this.val$job, this.val$listener, this.val$canAutoRetrieve);
                    if (buildJob == null) {
                        ThreadLog.printQLog(ThreadManagerV2.TAG, "post 3:w == null" + this.val$job);
                        return;
                    }
                    buildJob.setStacktrace(this.val$trace);
                    if (this.val$priority >= 8) {
                        buildJob.poolNum = 1;
                        ThreadExcutor.this.mLightThreadPool.execute(buildJob);
                    } else {
                        buildJob.poolNum = 2;
                        ThreadExcutor.this.mHeavyThreadPool.execute(buildJob);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("ThreadManager job == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postDownLoadTask(int i3, Runnable runnable, IThreadListener iThreadListener, boolean z16) {
        if (runnable != null) {
            DISPATCHER_HANDLER.postAtFrontOfQueue(new Runnable(i3, runnable, iThreadListener, z16, getStackTrace()) { // from class: com.tencent.mobileqq.app.ThreadExcutor.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$canAutoRetrieve;
                final /* synthetic */ Runnable val$job;
                final /* synthetic */ IThreadListener val$listener;
                final /* synthetic */ int val$priority;
                final /* synthetic */ String val$trace;

                {
                    this.val$priority = i3;
                    this.val$job = runnable;
                    this.val$listener = iThreadListener;
                    this.val$canAutoRetrieve = z16;
                    this.val$trace = r10;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ThreadExcutor.this, Integer.valueOf(i3), runnable, iThreadListener, Boolean.valueOf(z16), r10);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Job buildJob = ThreadExcutor.buildJob(this.val$priority, this.val$job, this.val$listener, this.val$canAutoRetrieve);
                    if (buildJob == null) {
                        ThreadLog.printQLog(ThreadManagerV2.TAG, "postDownLoadTask -1:w == null" + this.val$job);
                        return;
                    }
                    buildJob.setStacktrace(this.val$trace);
                    buildJob.poolNum = 5;
                    ThreadExcutor.this.mAIODownloadThreadPool.execute(buildJob);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postImmediately(Runnable runnable, IThreadListener iThreadListener, boolean z16) {
        post(10, runnable, iThreadListener, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String printCurrentState() {
        StringBuilder allPoolRunningJob = getAllPoolRunningJob("CRASH");
        allPoolRunningJob.append("\n");
        allPoolRunningJob.append(this.mHeavyThreadPool.toString());
        allPoolRunningJob.append("\n");
        allPoolRunningJob.append(this.mLightThreadPool.toString());
        allPoolRunningJob.append("\n");
        allPoolRunningJob.append(this.mAIODownloadThreadPool.toString());
        allPoolRunningJob.append("\n");
        allPoolRunningJob.append(this.mNormalPool.toString());
        allPoolRunningJob.append("\n");
        allPoolRunningJob.append(this.mDBPool.toString());
        allPoolRunningJob.append("\n");
        allPoolRunningJob.append(this.mFilePool.toString());
        allPoolRunningJob.append("\n");
        allPoolRunningJob.append(this.mNetPool.toString());
        return allPoolRunningJob.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeJob(Runnable runnable, int i3) {
        if (runnable instanceof WrapperRunnable) {
            WrapperRunnable wrapperRunnable = (WrapperRunnable) runnable;
            DISPATCHER_HANDLER.removeCallbacks(wrapperRunnable);
            removeJobFromThreadPool(wrapperRunnable.innerRunnable.get(), i3);
            return;
        }
        removeJobFromThreadPool(runnable, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeJobFromThreadPool(Runnable runnable, int i3) {
        ThreadSmartPool threadSmartPool;
        try {
            if (runnable == null) {
                doRdmReport("removeJobFromThreadPool_Err", "job_NONE_type" + i3);
                return false;
            }
            Job buildJob = buildJob(i3, runnable, null, false);
            if (buildJob == null) {
                doRdmReport("removeJobFromThreadPool_Err", "work_NONE_type" + i3);
                return false;
            }
            if ((i3 & 128) != 0) {
                threadSmartPool = this.mNetPool;
            } else if ((i3 & 64) != 0) {
                threadSmartPool = this.mFilePool;
            } else if ((i3 & 32) != 0) {
                threadSmartPool = this.mDBPool;
            } else if ((i3 & 16) != 0) {
                threadSmartPool = this.mNormalPool;
            } else {
                doRdmReport("removeJobFromThreadPool_Err", "type_NONE_" + runnable);
                return false;
            }
            return threadSmartPool.remove(buildJob);
        } catch (Exception unused) {
            doRdmReport("removeJobFromThreadPool_Err", "name_" + runnable + "_Type_" + i3);
            return false;
        }
    }

    public void setThreadPoolMonitorConfig(Map<Integer, JSONObject> map) {
        com.tencent.mobileqq.app.monitor.f fVar;
        ThreadSmartPool threadSmartPool;
        com.tencent.mobileqq.app.monitor.f fVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            return;
        }
        if (map == null) {
            return;
        }
        if (!ThreadSetting.isPublicVersion && (threadSmartPool = this.mNormalPool) != null && (fVar2 = threadSmartPool.threadPoolMonitor) != null) {
            fVar2.k();
        }
        if (map.containsKey(16)) {
            JSONObject jSONObject = map.get(16);
            ThreadSmartPool threadSmartPool2 = this.mNormalPool;
            if (threadSmartPool2 != null && (fVar = threadSmartPool2.threadPoolMonitor) != null) {
                fVar.j(jSONObject);
            }
        }
    }

    public void shrinkMaxPoolSize(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        if (z16) {
            ThreadSmartPool threadSmartPool = this.mHeavyThreadPool;
            threadSmartPool.setMaximumPoolSize(Math.max(threadSmartPool.getActiveCount(), this.mHeavyThreadPool.getCorePoolSize()));
            ThreadSmartPool threadSmartPool2 = this.mAIODownloadThreadPool;
            threadSmartPool2.setMaximumPoolSize(Math.max(threadSmartPool2.getActiveCount(), this.mAIODownloadThreadPool.getCorePoolSize()));
            return;
        }
        ThreadSmartPool threadSmartPool3 = this.mHeavyThreadPool;
        threadSmartPool3.setMaximumPoolSize(threadSmartPool3.getInitMaxPoolSize());
        ThreadSmartPool threadSmartPool4 = this.mAIODownloadThreadPool;
        threadSmartPool4.setMaximumPoolSize(threadSmartPool4.getInitMaxPoolSize());
    }
}
