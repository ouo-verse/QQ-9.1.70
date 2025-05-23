package com.tencent.biz.qqstory.base;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tribe.async.async.Boss;
import com.tribe.async.async.FutureListener;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobController;
import com.tribe.async.async.LightWeightExecutor;
import com.tribe.async.async.MonitorThreadPoolExecutor;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StoryBoss implements Boss, MonitorThreadPoolExecutor.ThreadPoolMonitorListener {

    /* renamed from: j, reason: collision with root package name */
    private static final int f93965j = Runtime.getRuntime().availableProcessors();

    /* renamed from: k, reason: collision with root package name */
    private static final int f93966k = Runtime.getRuntime().availableProcessors();

    /* renamed from: l, reason: collision with root package name */
    private static final int f93967l = Runtime.getRuntime().availableProcessors();

    /* renamed from: a, reason: collision with root package name */
    private final Executor f93968a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f93969b;

    /* renamed from: c, reason: collision with root package name */
    private final Executor f93970c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor[] f93971d;

    /* renamed from: e, reason: collision with root package name */
    private final JobController f93972e;

    /* renamed from: f, reason: collision with root package name */
    private final LightWeightExecutor f93973f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f93974g;

    /* renamed from: h, reason: collision with root package name */
    private long f93975h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f93976i = 0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    private @interface StoryThreadType {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [Progress, Result] */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a<Progress, Result> extends FutureListener.SimpleFutureListener<Progress, Result> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Worker f93977d;

        a(Worker worker) {
            this.f93977d = worker;
        }

        @Override // com.tribe.async.async.FutureListener.SimpleFutureListener, com.tribe.async.async.FutureListener
        public void onFutureDone(@Nullable Result result) {
            c.a().dispatch(new JobController.DoneEvent(this.f93977d));
        }
    }

    public StoryBoss(Context context) {
        this.f93971d = r7;
        b bVar = new b("StoryBoss.CpuExecutor", 16, f93965j);
        this.f93969b = bVar;
        b bVar2 = new b("StoryBoss.NetworkExecutor", 128, f93967l);
        this.f93968a = bVar2;
        b bVar3 = new b("StoryBoss.FileExecutor", 64, f93966k);
        this.f93970c = bVar3;
        Executor[] executorArr = {bVar2, bVar, bVar3};
        LightWeightExecutor lightWeightExecutor = new LightWeightExecutor(c.a().getDefaultLooper(), 100);
        this.f93973f = lightWeightExecutor;
        lightWeightExecutor.setMonitorListener(this);
        this.f93974g = new Handler(c.a().getDefaultLooper());
        JobController jobController = new JobController(this);
        this.f93972e = jobController;
        c.a().registerSubscriber(Dispatcher.ROOT_GROUP_NAME, jobController);
    }

    @NonNull
    private <Params, Progress, Result> Future<Result> b(Job<Params, Progress, Result> job, int i3, int i16, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        Worker<Progress, Result> prepareWorker = prepareWorker(job, i16, futureListener, params);
        prepareWorker.addFutureListener(new a(prepareWorker));
        if (i3 == 0) {
            c.a().dispatch(prepareWorker);
        } else {
            c.a().dispatchDelayed(prepareWorker, i3);
        }
        return prepareWorker;
    }

    public <Params, Progress, Result> Future<Result> a(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        Worker<Progress, Result> prepareWorker = prepareWorker(job, job.getJobType(), futureListener, params);
        this.f93972e.getDefaultHandler().handleExecute(this.f93971d, prepareWorker);
        if (prepareWorker != null) {
            hd0.c.a("StoryBoss", "work hash code:" + prepareWorker.hashCode());
        }
        return prepareWorker;
    }

    @Override // com.tribe.async.async.Boss
    public <Result> void cancelJob(Future<Result> future, boolean z16) {
        if (future instanceof Worker) {
            c.a().cancelDispatch("", (Worker) future);
        }
        c.a().dispatch(new JobController.CancelCommand(future, z16));
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public Executor getExecutor(int i3) {
        Executor executor = this.f93969b;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 8) {
                    if (i3 == 16) {
                        return this.f93968a;
                    }
                    return executor;
                }
                return this.f93970c;
            }
            return this.f93970c;
        }
        return executor;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public Executor[] getExecutors() {
        return this.f93971d;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public JobController getJobController() {
        return this.f93972e;
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public Executor getLightWeightExecutor() {
        return this.f93973f;
    }

    @Override // com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener
    public void onQueueExceedLimit(String str, int i3) {
        hd0.c.g("StoryBoss", str + " onQueueExceedLimit, size = " + i3);
        if (SystemClock.uptimeMillis() - this.f93976i > 7200000) {
            this.f93976i = SystemClock.uptimeMillis();
        }
    }

    @Override // com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener
    public void onWorkerExceedTime(String str, List<Runnable> list, int i3) {
        for (Runnable runnable : list) {
            String simpleName = runnable.getClass().getSimpleName();
            if (runnable instanceof Worker) {
                simpleName = ((Worker) runnable).getJob().getClass().getSimpleName();
            }
            hd0.c.g("StoryBoss", str + " onWorkerExceedTime, runnable = " + simpleName);
            if (SystemClock.uptimeMillis() - this.f93975h > 7200000) {
                this.f93975h = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job) {
        return a(job, null, null);
    }

    @Override // com.tribe.async.async.Boss
    public void postLightWeightJob(Runnable runnable, int i3) {
        if (i3 == 0) {
            this.f93973f.execute(runnable);
        } else {
            this.f93974g.postDelayed(runnable, i3);
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
        return b(job, 0, job.getJobType(), null, null);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3) {
        return b(job, i3, job.getJobType(), null, null);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job, @Nullable Params params) {
        return a(job, null, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job, @Nullable Params params) {
        return b(job, 0, job.getJobType(), null, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3, @Nullable Params params) {
        return b(job, i3, job.getJobType(), null, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        return a(job, futureListener, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> job, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        return b(job, 0, job.getJobType(), futureListener, params);
    }

    @Override // com.tribe.async.async.Boss
    @NonNull
    public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> job, int i3, @Nullable FutureListener<Progress, Result> futureListener, @Nullable Params params) {
        return b(job, i3, job.getJobType(), futureListener, params);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class b implements Executor {

        /* renamed from: d, reason: collision with root package name */
        private final Queue<Runnable> f93979d = new ConcurrentLinkedQueue();

        /* renamed from: e, reason: collision with root package name */
        private final AtomicInteger f93980e = new AtomicInteger(0);

        /* renamed from: f, reason: collision with root package name */
        private int f93981f;

        /* renamed from: h, reason: collision with root package name */
        private final String f93982h;

        /* renamed from: i, reason: collision with root package name */
        private int f93983i;

        b(@NonNull String str, int i3, @IntRange(from = 0) int i16) {
            this.f93982h = str;
            this.f93983i = i3;
            this.f93981f = i16;
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f93979d.offer(runnable);
            int size = this.f93979d.size();
            if (size > Runtime.getRuntime().availableProcessors()) {
                hd0.c.a(this.f93982h, "too many runnable remained in the queue, size " + size);
            }
            if (this.f93980e.get() <= this.f93981f) {
                hd0.c.a(this.f93982h, "current number of task threshold is " + this.f93980e.get());
                while (!this.f93979d.isEmpty()) {
                    Runnable poll = this.f93979d.poll();
                    if (poll != null) {
                        ThreadManagerV2.excute(poll, this.f93983i, new a(poll), false);
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements ThreadExcutor.IThreadListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f93984d;

            a(Runnable runnable) {
                this.f93984d = runnable;
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPostRun() {
                b.this.f93980e.decrementAndGet();
                hd0.c.a(b.this.f93982h, "threshold after running current task is " + b.this.f93980e.get());
                if (this.f93984d != null) {
                    hd0.c.a(b.this.f93982h, "threshold after running current task is:" + this.f93984d.hashCode());
                }
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPreRun() {
                b.this.f93980e.incrementAndGet();
                hd0.c.b(b.this.f93982h, "execute %s", this.f93984d);
                if (this.f93984d != null) {
                    hd0.c.a(b.this.f93982h, "execute hashcode:" + this.f93984d.hashCode());
                }
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onAdded() {
            }
        }
    }

    @Override // com.tribe.async.async.Boss
    public void shutdown() {
    }
}
