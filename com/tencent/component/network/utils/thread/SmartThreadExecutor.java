package com.tencent.component.network.utils.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.component.network.module.base.Config;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SmartThreadExecutor implements Executor, Handler.Callback {
    private static final long CHECK_PERIOD;
    private static final int FIRST_ANTI_JITTER_TEMP_WORKER_SIZE = 2;
    private static final long FIRST_CHECK_PERIOD;
    private static final AtomicInteger ID_GENERATOR;
    private static final int MAX_TEMP_THREAD_CNT = 2;
    private static final int MSG_WHAT_CHK_BASE = 7500;
    private static final String MTA_REPORT_EVENT = "qzone_downloader_smart_thread_event_temp_thread";
    private static final String MTA_REPORT_TYPE_START = "start";
    private static final String MTA_REPORT_TYPE_TOTAL = "total";
    private static final String MTA_REPORT_TYPE_VALID = "valid";
    private static final String TAG = "SmartThreadExecutor";
    private static final int TEMP_THREAD_VALID_REPORT_TIME_IN_SEC = 2;
    private static volatile int sAliveCnt;
    private static volatile HandlerThread sChkThread;
    private int antiJitterTempWorkerSize;
    private final Handler handler;

    /* renamed from: id, reason: collision with root package name */
    private final int f99907id;
    private volatile boolean isAlive;
    private String lastTaskId;
    private final int msgWhat;
    private final Executor normExecutor;
    private final LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final SmartThreadFactory factory = new SmartThreadFactory();
    private final List<TempTask> tempThreads = new LinkedList();
    private final AtomicBoolean isNeedTempWorker = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class IdTask implements Runnable, Comparable<IdTask> {

        /* renamed from: id, reason: collision with root package name */
        private final String f99908id;
        private final Runnable task;

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.task;
            if (runnable != null) {
                runnable.run();
            }
        }

        IdTask(Runnable runnable) {
            this.f99908id = UUID.randomUUID().toString();
            this.task = runnable;
        }

        @Override // java.lang.Comparable
        public int compareTo(IdTask idTask) {
            Runnable runnable = this.task;
            if (runnable == null) {
                return -1;
            }
            if (idTask.task == null) {
                return 1;
            }
            if (runnable.getClass() == idTask.task.getClass()) {
                Runnable runnable2 = this.task;
                if (runnable2 instanceof Comparable) {
                    return ((Comparable) runnable2).compareTo(idTask.task);
                }
            }
            return this.f99908id.compareTo(idTask.f99908id);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class SmartThreadFactory implements ThreadFactory {
        private static final AtomicInteger ID = new AtomicInteger();
        private static final String TAG = "SmartThreadFactory";

        SmartThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            BaseThread baseThread = new BaseThread("smart-" + ID.incrementAndGet()) { // from class: com.tencent.component.network.utils.thread.SmartThreadExecutor.SmartThreadFactory.1
                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    Log.i(SmartThreadFactory.TAG, "run: new thread start " + getName());
                    runnable.run();
                    Log.i(SmartThreadFactory.TAG, "run: new thread end " + getName());
                }
            };
            baseThread.setPriority(5);
            baseThread.setDaemon(false);
            return baseThread;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class TempTask implements Runnable {
        private static final String TAG = "TempTask";
        private volatile Thread currentThread;

        TempTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(TAG, "run: start");
            this.currentThread = Thread.currentThread();
            boolean z16 = true;
            while (true) {
                Runnable runnable = null;
                if (!SmartThreadExecutor.this.isAlive || !SmartThreadExecutor.this.isNeedTempWorker.get()) {
                    break;
                }
                try {
                    runnable = (Runnable) SmartThreadExecutor.this.taskQueue.take();
                } catch (InterruptedException e16) {
                    Log.i(TAG, "run: interrupted " + e16.getMessage());
                }
                if (runnable != null) {
                    Log.i(TAG, "run: execute task " + runnable.getClass().getSimpleName());
                    long nanoTime = System.nanoTime();
                    runnable.run();
                    long seconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - nanoTime);
                    Log.i(TAG, "run: execute task pass time " + seconds);
                    if (seconds <= 2) {
                        Properties properties = new Properties();
                        properties.put("total", 1);
                        if (z16) {
                            properties.put(SmartThreadExecutor.MTA_REPORT_TYPE_VALID, 1);
                        }
                        Config.reportToMta(SmartThreadExecutor.MTA_REPORT_EVENT, properties);
                    }
                    z16 = false;
                }
            }
            synchronized (SmartThreadExecutor.this.tempThreads) {
                SmartThreadExecutor.this.tempThreads.remove(this);
            }
            this.currentThread = null;
            Log.i(TAG, "run: end");
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CHECK_PERIOD = timeUnit.toMillis(30L);
        FIRST_CHECK_PERIOD = timeUnit.toMillis(2L);
        ID_GENERATOR = new AtomicInteger(0);
        sAliveCnt = 0;
    }

    public SmartThreadExecutor(Executor executor) {
        int andIncrement = ID_GENERATOR.getAndIncrement();
        this.f99907id = andIncrement;
        this.msgWhat = andIncrement + MSG_WHAT_CHK_BASE;
        this.isAlive = true;
        Log.i(TAG, "SmartThreadExecutor: " + andIncrement);
        this.normExecutor = executor;
        synchronized (SmartThreadExecutor.class) {
            if (sChkThread == null) {
                sChkThread = new BaseHandlerThread("smart-check-thread", 10);
                sChkThread.start();
            }
            sAliveCnt++;
        }
        while (true) {
            Looper looper = sChkThread.getLooper();
            if (looper == null) {
                Thread.yield();
            } else {
                Handler handler = new Handler(looper, this);
                this.handler = handler;
                handler.sendEmptyMessageDelayed(this.msgWhat, FIRST_CHECK_PERIOD);
                return;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (!this.isAlive) {
            return;
        }
        this.normExecutor.execute(new IdTask(runnable));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        boolean z16 = false;
        if (message.what != this.msgWhat) {
            return false;
        }
        if (!this.isAlive) {
            return true;
        }
        Log.i(TAG, "handleMessage: start check " + this.f99907id);
        Runnable peek = this.taskQueue.peek();
        if (peek instanceof IdTask) {
            str = ((IdTask) peek).f99908id;
        } else {
            str = null;
        }
        if (this.isAlive && str != null && str.equals(this.lastTaskId)) {
            this.isNeedTempWorker.set(true);
            this.antiJitterTempWorkerSize = 2;
            synchronized (this.tempThreads) {
                if (this.isAlive && this.tempThreads.size() < 2) {
                    Log.i(TAG, "handleMessage: start temp task " + this.f99907id);
                    TempTask tempTask = new TempTask();
                    this.factory.newThread(tempTask).start();
                    this.tempThreads.add(tempTask);
                    Properties properties = new Properties();
                    properties.put("start", 1);
                    Config.reportToMta(MTA_REPORT_EVENT, properties);
                }
            }
        } else {
            AtomicBoolean atomicBoolean = this.isNeedTempWorker;
            int i3 = this.antiJitterTempWorkerSize - 1;
            this.antiJitterTempWorkerSize = i3;
            if (i3 > 0) {
                z16 = true;
            }
            atomicBoolean.compareAndSet(true, z16);
        }
        Log.i(TAG, "handleMessage: check end " + this.f99907id + " " + this.antiJitterTempWorkerSize + " " + this.isNeedTempWorker.get());
        this.lastTaskId = str;
        if (this.isAlive) {
            this.handler.sendEmptyMessageDelayed(this.msgWhat, CHECK_PERIOD);
        }
        return true;
    }

    public void shutdown() {
        this.isAlive = false;
        Executor executor = this.normExecutor;
        if (executor instanceof ExecutorService) {
            ((ExecutorService) executor).shutdownNow();
        }
        this.handler.removeMessages(this.msgWhat);
        synchronized (this.tempThreads) {
            Iterator<TempTask> it = this.tempThreads.iterator();
            while (it.hasNext()) {
                Thread thread = it.next().currentThread;
                if (thread != null) {
                    thread.interrupt();
                }
            }
            this.tempThreads.clear();
        }
        synchronized (SmartThreadExecutor.class) {
            int i3 = sAliveCnt - 1;
            sAliveCnt = i3;
            if (i3 < 1) {
                sChkThread.quit();
            }
        }
    }
}
