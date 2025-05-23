package com.qzone.photo.service.scan.task;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class SingleThreadTask<Params, Progress, Result> {

    /* renamed from: f, reason: collision with root package name */
    private static final int f49450f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f49451g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f49452h;

    /* renamed from: i, reason: collision with root package name */
    private static final ThreadFactory f49453i;

    /* renamed from: j, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f49454j;

    /* renamed from: k, reason: collision with root package name */
    public static final Executor f49455k;

    /* renamed from: l, reason: collision with root package name */
    public static final Executor f49456l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile Executor f49457m;

    /* renamed from: n, reason: collision with root package name */
    private static d f49458n;

    /* renamed from: a, reason: collision with root package name */
    private final e<Params, Result> f49459a;

    /* renamed from: b, reason: collision with root package name */
    private final FutureTask<Result> f49460b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Status f49461c = Status.PENDING;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f49462d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f49463e = new AtomicBoolean();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f49467d = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SingleThreadTask #" + this.f49467d.getAndIncrement());
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends e<Params, Result> {
        b() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            SingleThreadTask.this.f49463e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) SingleThreadTask.this.f(this.f49471d);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c<Data> {

        /* renamed from: a, reason: collision with root package name */
        final SingleThreadTask f49469a;

        /* renamed from: b, reason: collision with root package name */
        final Data[] f49470b;

        c(SingleThreadTask singleThreadTask, Data... dataArr) {
            this.f49469a = singleThreadTask;
            this.f49470b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d extends Handler {
        public d() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = (c) message.obj;
            int i3 = message.what;
            if (i3 == 1) {
                cVar.f49469a.g(cVar.f49470b[0]);
            } else {
                if (i3 != 2) {
                    return;
                }
                cVar.f49469a.m(cVar.f49470b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static abstract class e<Params, Result> implements Callable<Result> {

        /* renamed from: d, reason: collision with root package name */
        Params[] f49471d;

        e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f49450f = availableProcessors;
        f49451g = Math.max(2, Math.min(availableProcessors - 1, 4));
        f49452h = (availableProcessors * 2) + 1;
        f49453i = new a();
        f49454j = new LinkedBlockingQueue(128);
        f49455k = Executors.newSingleThreadExecutor();
        SerialExecutor serialExecutor = new SerialExecutor(null);
        f49456l = serialExecutor;
        f49457m = serialExecutor;
    }

    public SingleThreadTask() {
        b bVar = new b();
        this.f49459a = bVar;
        this.f49460b = new FutureTask<Result>(bVar) { // from class: com.qzone.photo.service.scan.task.SingleThreadTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    SingleThreadTask.this.o(get());
                } catch (InterruptedException e16) {
                    Log.w("AsyncTask", e16);
                } catch (CancellationException unused) {
                    SingleThreadTask.this.o(null);
                } catch (ExecutionException e17) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e17.getCause());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Result result) {
        if (i()) {
            k(result);
        } else {
            l(result);
        }
        this.f49461c = Status.FINISHED;
    }

    private static Handler h() {
        d dVar;
        synchronized (SingleThreadTask.class) {
            if (f49458n == null) {
                f49458n = new d();
            }
            dVar = f49458n;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result n(Result result) {
        h().obtainMessage(1, new c(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Result result) {
        if (this.f49463e.get()) {
            return;
        }
        n(result);
    }

    protected abstract Result f(Params... paramsArr);

    public final boolean i() {
        return this.f49462d.get();
    }

    protected void k(Result result) {
        j();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class SerialExecutor implements Executor {

        /* renamed from: d, reason: collision with root package name */
        final ArrayDeque<Runnable> f49464d;

        /* renamed from: e, reason: collision with root package name */
        Runnable f49465e;

        SerialExecutor() {
            this.f49464d = new ArrayDeque<>();
        }

        protected synchronized void a() {
            Runnable poll = this.f49464d.poll();
            this.f49465e = poll;
            if (poll != null) {
                SingleThreadTask.f49455k.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f49464d.offer(new Runnable() { // from class: com.qzone.photo.service.scan.task.SingleThreadTask.SerialExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.a();
                    }
                }
            });
            if (this.f49465e == null) {
                a();
            }
        }

        /* synthetic */ SerialExecutor(a aVar) {
            this();
        }
    }

    protected void j() {
    }

    protected void l(Result result) {
    }

    protected void m(Progress... progressArr) {
    }
}
