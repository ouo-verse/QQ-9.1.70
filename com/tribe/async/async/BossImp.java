package com.tribe.async.async;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tribe.async.async.ExecutorConfig;
import com.tribe.async.async.FutureListener;
import com.tribe.async.async.JobController;
import com.tribe.async.async.MonitorThreadPoolExecutor;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public class BossImp implements Boss, MonitorThreadPoolExecutor.ThreadPoolMonitorListener {
    private static final String CPU_EXECUTOR_NAME = "cpu";
    private static final String DISK_READ_EXECUTOR_NAME = "disk_read";
    private static final String DISK_WRITE_EXECUTOR_NAME = "disk_write";
    private static final int EXECUTOR_SIZE = 4;
    private static final String NETWORK_EXECUTOR_NAME = "network";
    private static final String TAG = "async.boss.BossImp";
    private final Context mContext;
    private final ExecutorConfig mCpuConfig;
    private final MonitorThreadPoolExecutor mCpuExecutor;
    private final MonitorThreadPoolExecutor mDiskReadExecutor;
    private final MonitorThreadPoolExecutor mDiskWriteExecutor;
    private final MonitorThreadPoolExecutor[] mExecutors;
    private Handler mHandler;
    private final JobController mJobController;
    private final LightWeightExecutor mLightWeightExecutor;
    private Looper mLooper;
    private final ExecutorConfig mNetworkConfig;
    private final MonitorThreadPoolExecutor mNetworkExecutor;
    private final NetworkBroadcastReceiver mNetworkReceiver;
    private long mReportExceedSize;
    private long mReportExceedTime;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class AsyncThreadFactory implements ThreadFactory {
        private int index;
        private String type;

        public AsyncThreadFactory(String str) {
            this.type = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (runnable == null) {
                return new BaseThread("no_name");
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("type_");
            sb5.append(this.type);
            sb5.append("_index");
            int i3 = this.index;
            this.index = i3 + 1;
            sb5.append(i3);
            return new BaseThread(runnable, sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class NetworkBroadcastReceiver extends BroadcastReceiver {
        NetworkBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BossImp.this.mNetworkExecutor.setCorePoolSize(BossImp.this.mNetworkConfig.getCore());
            BossImp.this.mNetworkExecutor.setMaximumPoolSize(BossImp.this.mNetworkConfig.getMaximum());
            BossImp.this.mNetworkExecutor.setKeepAliveTime(BossImp.this.mNetworkConfig.getAliveTime(), BossImp.this.mNetworkConfig.getTimeUnit());
        }

        public void register(Context context) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this, intentFilter);
        }

        void unregister(Context context) {
            context.unregisterReceiver(this);
        }
    }

    public BossImp(Context context, Looper looper) {
        this.mExecutors = r2;
        ExecutorConfig.CpuExecutorConfig cpuExecutorConfig = new ExecutorConfig.CpuExecutorConfig();
        this.mCpuConfig = cpuExecutorConfig;
        this.mReportExceedTime = 0L;
        this.mReportExceedSize = 0L;
        this.mContext = context;
        this.mLooper = looper;
        MonitorThreadPoolExecutor monitorThreadPoolExecutor = new MonitorThreadPoolExecutor(cpuExecutorConfig.getCore(), cpuExecutorConfig.getMaximum(), cpuExecutorConfig.getAliveTime(), cpuExecutorConfig.getTimeUnit(), new LinkedBlockingQueue(), new AsyncThreadFactory(CPU_EXECUTOR_NAME));
        this.mCpuExecutor = monitorThreadPoolExecutor;
        monitorThreadPoolExecutor.setName(CPU_EXECUTOR_NAME);
        monitorThreadPoolExecutor.setMonitorListener(this);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        MonitorThreadPoolExecutor monitorThreadPoolExecutor2 = new MonitorThreadPoolExecutor(0, 1, 60L, timeUnit, linkedBlockingQueue, new AsyncThreadFactory(DISK_READ_EXECUTOR_NAME));
        this.mDiskReadExecutor = monitorThreadPoolExecutor2;
        monitorThreadPoolExecutor.setName(DISK_READ_EXECUTOR_NAME);
        monitorThreadPoolExecutor.setMonitorListener(this);
        MonitorThreadPoolExecutor monitorThreadPoolExecutor3 = new MonitorThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new AsyncThreadFactory(DISK_WRITE_EXECUTOR_NAME));
        this.mDiskWriteExecutor = monitorThreadPoolExecutor3;
        monitorThreadPoolExecutor.setName(DISK_WRITE_EXECUTOR_NAME);
        monitorThreadPoolExecutor.setMonitorListener(this);
        ExecutorConfig.NetworkExecutorConfig networkExecutorConfig = new ExecutorConfig.NetworkExecutorConfig(context);
        this.mNetworkConfig = networkExecutorConfig;
        MonitorThreadPoolExecutor monitorThreadPoolExecutor4 = new MonitorThreadPoolExecutor(networkExecutorConfig.getCore(), networkExecutorConfig.getMaximum(), networkExecutorConfig.getAliveTime(), networkExecutorConfig.getTimeUnit(), new LinkedBlockingQueue(), new AsyncThreadFactory("network"));
        this.mNetworkExecutor = monitorThreadPoolExecutor4;
        monitorThreadPoolExecutor.setName("network");
        monitorThreadPoolExecutor.setMonitorListener(this);
        MonitorThreadPoolExecutor[] monitorThreadPoolExecutorArr = {monitorThreadPoolExecutor, monitorThreadPoolExecutor2, monitorThreadPoolExecutor3, monitorThreadPoolExecutor4};
        NetworkBroadcastReceiver networkBroadcastReceiver = new NetworkBroadcastReceiver();
        this.mNetworkReceiver = networkBroadcastReceiver;
        networkBroadcastReceiver.register(context);
        LightWeightExecutor lightWeightExecutor = new LightWeightExecutor(this.mLooper, 100);
        this.mLightWeightExecutor = lightWeightExecutor;
        lightWeightExecutor.setMonitorListener(this);
        this.mHandler = new Handler(Dispatchers.get(this.mLooper).getDefaultLooper());
        JobController jobController = new JobController(this);
        this.mJobController = jobController;
        Dispatchers.get(this.mLooper).registerSubscriber(Dispatcher.ROOT_GROUP_NAME, jobController);
    }

    @NonNull
    private <Params, Progress, Result> Future<Result> scheduleJobDelayedInternal(Job<Params, Progress, Result> job, int i3, int i16, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        final Worker<Progress, Result> prepareWorker = prepareWorker(job, i16, futureListener, params);
        prepareWorker.addFutureListener(new FutureListener.SimpleFutureListener<Progress, Result>() { // from class: com.tribe.async.async.BossImp.1
            @Override // com.tribe.async.async.FutureListener.SimpleFutureListener, com.tribe.async.async.FutureListener
            public void onFutureDone(@Nullable Result result) {
                Dispatchers.get(BossImp.this.mLooper).dispatch(new JobController.DoneEvent(prepareWorker));
            }
        });
        if (i3 == 0) {
            Dispatchers.get(this.mLooper).dispatch(prepareWorker);
        } else {
            Dispatchers.get(this.mLooper).dispatchDelayed(prepareWorker, i3);
        }
        return prepareWorker;
    }

    @Override // com.tribe.async.async.Boss
    public <Result> void cancelJob(Future<Result> future, boolean z16) {
        if (future instanceof Worker) {
            Dispatchers.get(this.mLooper).cancelDispatch("", (Worker) future);
        }
        Dispatchers.get(this.mLooper).dispatch(new JobController.CancelCommand(future, z16));
    }

    public <Params, Progress, Result> Future<Result> executeJobInternal(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        Worker<Progress, Result> prepareWorker = prepareWorker(job, job.getJobType(), futureListener, params);
        this.mJobController.getDefaultHandler().handleExecute(this.mExecutors, prepareWorker);
        return prepareWorker;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public Executor getExecutor(int i3) {
        MonitorThreadPoolExecutor monitorThreadPoolExecutor = this.mCpuExecutor;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 8) {
                    if (i3 == 16) {
                        return this.mNetworkExecutor;
                    }
                    return monitorThreadPoolExecutor;
                }
                return this.mDiskWriteExecutor;
            }
            return this.mDiskReadExecutor;
        }
        return monitorThreadPoolExecutor;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public Executor[] getExecutors() {
        return this.mExecutors;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public JobController getJobController() {
        return this.mJobController;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public Executor getLightWeightExecutor() {
        return this.mLightWeightExecutor;
    }

    @Override // com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener
    public void onQueueExceedLimit(String str, int i3) {
        SLog.e(TAG, str + " onQueueExceedLimit, size = " + i3);
        if (SystemClock.uptimeMillis() - this.mReportExceedSize > 7200000) {
            this.mReportExceedSize = SystemClock.uptimeMillis();
        }
    }

    @Override // com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener
    public void onWorkerExceedTime(String str, List<Runnable> list, int i3) {
        for (Runnable runnable : list) {
            String simpleName = runnable.getClass().getSimpleName();
            if (runnable instanceof Worker) {
                simpleName = ((Worker) runnable).getJob().getClass().getSimpleName();
            }
            SLog.e(TAG, str + " onWorkerExceedTime, runnable = " + simpleName);
            if (SystemClock.uptimeMillis() - this.mReportExceedTime > 7200000) {
                this.mReportExceedTime = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job) {
        return executeJobInternal(job, null, null);
    }

    @Override // com.tribe.async.async.Boss
    public void postLightWeightJob(Runnable runnable, int i3) {
        if (i3 == 0) {
            this.mLightWeightExecutor.execute(runnable);
        } else {
            this.mHandler.postDelayed(runnable, i3);
        }
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Worker<Progress, Result> prepareWorker(Job<Params, Progress, Result> job, int i3, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        AssertUtils.checkNotNull(job);
        job.setJobType(i3);
        job.setParams(params);
        Worker<Progress, Result> worker = new Worker<>(job);
        if (futureListener != null) {
            worker.addFutureListener(futureListener);
        }
        job.onPost();
        return worker;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job) {
        return scheduleJobDelayedInternal(job, 0, job.getJobType(), null, null);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3) {
        return scheduleJobDelayedInternal(job, i3, job.getJobType(), null, null);
    }

    @Override // com.tribe.async.async.Boss
    public void shutdown() {
        this.mNetworkReceiver.unregister(this.mContext);
        for (MonitorThreadPoolExecutor monitorThreadPoolExecutor : this.mExecutors) {
            monitorThreadPoolExecutor.shutdown();
        }
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job, @Nullable Params params) {
        return executeJobInternal(job, null, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job, @Nullable Params params) {
        return scheduleJobDelayedInternal(job, 0, job.getJobType(), null, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3, @Nullable Params params) {
        return scheduleJobDelayedInternal(job, i3, job.getJobType(), null, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        return executeJobInternal(job, futureListener, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        return scheduleJobDelayedInternal(job, 0, job.getJobType(), futureListener, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        return scheduleJobDelayedInternal(job, i3, job.getJobType(), futureListener, params);
    }
}
