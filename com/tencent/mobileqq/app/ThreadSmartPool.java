package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class ThreadSmartPool extends BaseThreadPoolExecutor {
    static IPatchRedirector $redirector_ = null;
    private static int BLOCKING_TIME_OUT = 0;
    private static int CHECK_PERIOD = 0;
    protected static final int CPU_COUNT;
    protected static final int KEEP_ALIVE_TIME = 15;
    private static final int MAX_Report_Size = 1;
    protected static final int maximumPoolSize;
    private Handler REJECTED_THREAD_HANDLER;
    private int blockingReportCount;
    private int initMaxPoolSize;
    protected long poolcheckTime;
    private boolean sAlreadyOutOfPool;
    private SmartRejectedExecutionHandler smartRejectedExecutionHandler;
    public com.tencent.mobileqq.app.monitor.f threadPoolMonitor;
    private final ThreadSmartPoolMonitorConfig threadSmartPoolMonitorConfig;

    /* loaded from: classes11.dex */
    private class SmartRejectedExecutionHandler implements RejectedExecutionHandler {
        static IPatchRedirector $redirector_;
        private int rejectReportCount;

        public SmartRejectedExecutionHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThreadSmartPool.this);
            } else {
                this.rejectReportCount = 0;
            }
        }

        private boolean needReportRejectedError() {
            if (this.rejectReportCount < 1 && ThreadLog.needRecordJob()) {
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ThreadSmartPool.this.sAlreadyOutOfPool = true;
                if (needReportRejectedError() && (threadPoolExecutor instanceof ThreadSmartPool)) {
                    String name = ((ThreadSmartPool) threadPoolExecutor).getName();
                    String str = name + "_RejectedExecution";
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\n revision:" + ThreadSetting.revision);
                    ThreadSmartPool.this.getRunningJob(str, sb5);
                    sb5.append("\n" + str + threadPoolExecutor.toString());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append(sb5.toString());
                    ThreadLog.printQLog(ThreadManagerV2.TAG, sb6.toString());
                    com.tencent.mobileqq.app.monitor.f fVar = ThreadSmartPool.this.threadPoolMonitor;
                    if (fVar != null) {
                        fVar.i();
                    }
                    ThreadWrapContext threadWrapContext = ThreadManagerV2.sThreadWrapContext;
                    if (threadWrapContext != null) {
                        threadWrapContext.reportRDMException(new TSPRejectedCatchedException(str), str, sb5.toString());
                        this.rejectReportCount++;
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("executor", name);
                        hashMap.put("process", String.valueOf(ThreadSetting.sProcessId));
                        ThreadManagerV2.sThreadWrapContext.reportDengTaException("", "sp_reject_exception_report", true, 0L, 0L, hashMap, "", false);
                    }
                }
                ThreadSmartPool.this.doJobOneByOne(runnable);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) threadPoolExecutor);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        maximumPoolSize = (availableProcessors * 2) + 1;
        BLOCKING_TIME_OUT = 9990000;
        CHECK_PERIOD = 9990000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadSmartPool(int i3, int i16, long j3, BlockingQueue<Runnable> blockingQueue, PriorityThreadFactory priorityThreadFactory) {
        super(i3, i16, j3, TimeUnit.SECONDS, blockingQueue, priorityThreadFactory);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), blockingQueue, priorityThreadFactory);
            return;
        }
        SmartRejectedExecutionHandler smartRejectedExecutionHandler = new SmartRejectedExecutionHandler();
        this.smartRejectedExecutionHandler = smartRejectedExecutionHandler;
        this.blockingReportCount = 0;
        this.sAlreadyOutOfPool = false;
        this.poolcheckTime = -1L;
        setRejectedExecutionHandler(smartRejectedExecutionHandler);
        this.initMaxPoolSize = i16;
        this.threadSmartPoolMonitorConfig = ThreadSmartPoolMonitorConfig.parse(getName());
    }

    private void checkBlockingState() {
        ThreadWrapContext threadWrapContext;
        if (!this.sAlreadyOutOfPool && ThreadLog.needReportRunOrBlocking()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.poolcheckTime > get_CHECK_PERIOD()) {
                this.poolcheckTime = uptimeMillis;
                ThreadLog.printQLog(ThreadManagerV2.TAG, getName() + "_checkBlockingState");
                Iterator<Runnable> it = getQueue().iterator();
                long uptimeMillis2 = SystemClock.uptimeMillis();
                while (it.hasNext()) {
                    Job job = (Job) it.next();
                    long j3 = uptimeMillis2 - job.addPoint;
                    job.blcokingCost = j3;
                    if (j3 >= get_BLOCKING_TIME_OUT()) {
                        String str = getName() + "_BlockingException";
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("\n revision:" + ThreadSetting.revision);
                        getRunningJob(str, sb5);
                        sb5.append("\nblocking JOB: " + job.toString());
                        sb5.append("\nblocking Executor:" + toString());
                        ThreadLog.printQLog(ThreadManagerV2.TAG, sb5.toString());
                        if (ThreadManagerV2.OPEN_RDM_REPORT && (threadWrapContext = ThreadManagerV2.sThreadWrapContext) != null && this.blockingReportCount < 1) {
                            threadWrapContext.reportRDMException(new TSPBlockingCatchedException(str), str, sb5.toString());
                            this.blockingReportCount++;
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJobOneByOne(Runnable runnable) {
        Handler rejectedHandler = getRejectedHandler();
        this.REJECTED_THREAD_HANDLER = rejectedHandler;
        if (rejectedHandler != null) {
            rejectedHandler.post(runnable);
        }
    }

    private Handler getRejectedHandler() {
        if (this.REJECTED_THREAD_HANDLER == null) {
            try {
                HandlerThread newFreeHandlerThread = ThreadExcutor.getInstance().newFreeHandlerThread(getName() + "_Rejected_Handler", 10);
                newFreeHandlerThread.start();
                Handler handler = new Handler(newFreeHandlerThread.getLooper());
                this.REJECTED_THREAD_HANDLER = handler;
                return handler;
            } catch (OutOfMemoryError e16) {
                ThreadLog.printQLog(ThreadManagerV2.TAG, getName() + "_getRejectedHandler:", e16);
            }
        }
        return this.REJECTED_THREAD_HANDLER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StringBuilder getRunningJob(String str, StringBuilder sb5) {
        ThreadLog.printQLog(ThreadManagerV2.TAG, "\ngetRunningJob from: " + str);
        ConcurrentLinkedQueue<String> runningJobCache = getRunningJobCache();
        if (runningJobCache != null) {
            Iterator<String> it = runningJobCache.iterator();
            while (it.hasNext()) {
                sb5.append("\n" + it.next());
            }
        }
        return sb5;
    }

    private static long get_BLOCKING_TIME_OUT() {
        if (!ThreadSetting.isPublicVersion) {
            BLOCKING_TIME_OUT = 30000;
        }
        return BLOCKING_TIME_OUT;
    }

    private static long get_CHECK_PERIOD() {
        if (!ThreadSetting.isPublicVersion) {
            CHECK_PERIOD = 30000;
        }
        return CHECK_PERIOD;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Job job;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        if (ThreadManagerV2.IsRunTimeShutDown) {
            ThreadLog.printQLog(ThreadManagerV2.TAG, "pool has shutdown:" + runnable.toString());
            return;
        }
        if (!(runnable instanceof Job)) {
            if (ThreadSetting.logcatBgTaskMonitor) {
                ThreadLog.printQLog(ThreadManagerV2.TAG, "command is not instanceof Job " + runnable.toString());
            }
            if (this instanceof ThreadAsyncTaskPool) {
                job = ThreadExcutor.buildJob(256, runnable, null, false);
                if (job != null) {
                    job.poolNum = 10;
                }
            } else {
                job = ThreadExcutor.buildJob(512, runnable, null, false);
                if (job != null) {
                    job.poolNum = 11;
                }
            }
            if (job == null) {
                ThreadLog.printQLog(ThreadManagerV2.TAG, "sp execute job == null ");
                doJobOneByOne(runnable);
                return;
            }
        } else {
            job = (Job) runnable;
        }
        try {
            if (this.threadSmartPoolMonitorConfig.getFeatureSwitchState()) {
                job.setMonitorConfig(this.threadSmartPoolMonitorConfig);
            }
            if (ThreadSetting.logcatBgTaskMonitor) {
                ThreadLog.printQLog(ThreadManagerV2.TAG, "tsp execute:" + job.toString());
            }
            checkBlockingState();
            super.execute(job);
        } catch (InternalError e16) {
            ThreadLog.printQLog(ThreadManagerV2.TAG, "java.lang.InternalError: Thread starting during runtime shutdown", e16);
        } catch (OutOfMemoryError e17) {
            ThreadLog.printQLog(ThreadManagerV2.TAG, "execute job OutOfMemoryError:" + job.toString(), e17);
            doJobOneByOne(job);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getInitMaxPoolSize() {
        return this.initMaxPoolSize;
    }

    protected String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ThreadOtherPool";
    }

    protected ConcurrentLinkedQueue<String> getRunningJobCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConcurrentLinkedQueue) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return Job.runningJmapInOther;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.terminated();
        }
    }
}
