package com.tencent.component.network.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.tencent.component.network.utils.thread.internel.ArrayDeque;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 1;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final FutureTask<Result> mFuture;
    private final WorkerRunnable<Params, Result> mWorker;
    private volatile Status mStatus = Status.PENDING;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.component.network.utils.thread.AsyncTask$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$component$network$utils$thread$AsyncTask$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$com$tencent$component$network$utils$thread$AsyncTask$Status = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$component$network$utils$thread$AsyncTask$Status[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class AsyncTaskResult<Data> {
        final Data[] mData;
        final AsyncTask mTask;

        AsyncTaskResult(AsyncTask asyncTask, Data... dataArr) {
            this.mTask = asyncTask;
            this.mData = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class HandlerHolder {
        static final InternalHandler Handler;

        static {
            Looper myLooper;
            if (Looper.getMainLooper() != null) {
                myLooper = Looper.getMainLooper();
            } else {
                myLooper = Looper.myLooper();
            }
            Handler = new InternalHandler(myLooper);
        }

        HandlerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class InternalHandler extends Handler {
        public InternalHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i3 = message.what;
            if (i3 == 1) {
                asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
            } else if (i3 == 2) {
                asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class SerialExecutor implements Executor {
        Runnable mActive;
        final ArrayDeque<Runnable> mTasks;

        SerialExecutor() {
            this.mTasks = new ArrayDeque<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() { // from class: com.tencent.component.network.utils.thread.AsyncTask.SerialExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        protected synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(poll);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
        }
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.tencent.component.network.utils.thread.AsyncTask.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new BaseThread(runnable, "AsyncTask :" + this.mCount.getAndIncrement());
            }
        };
        sThreadFactory = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        sPoolWorkQueue = linkedBlockingQueue;
        THREAD_POOL_EXECUTOR = new BaseThreadPoolExecutor(1, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        SerialExecutor serialExecutor = new SerialExecutor();
        SERIAL_EXECUTOR = serialExecutor;
        sDefaultExecutor = serialExecutor;
    }

    public AsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: com.tencent.component.network.utils.thread.AsyncTask.2
            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                AsyncTask.this.mTaskInvoked.set(true);
                Process.setThreadPriority(10);
                AsyncTask asyncTask = AsyncTask.this;
                return (Result) asyncTask.postResult(asyncTask.doInBackground(this.mParams));
            }
        };
        this.mWorker = workerRunnable;
        this.mFuture = new FutureTask<Result>(workerRunnable) { // from class: com.tencent.component.network.utils.thread.AsyncTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    AsyncTask.this.postResultIfNotInvoked(get());
                } catch (InterruptedException e16) {
                    Log.w(AsyncTask.LOG_TAG, e16);
                } catch (CancellationException unused) {
                    AsyncTask.this.postResultIfNotInvoked(null);
                } catch (ExecutionException e17) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e17.getCause());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = Status.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result postResult(Result result) {
        HandlerHolder.Handler.obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    public final boolean cancel(boolean z16) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z16);
    }

    protected abstract Result doInBackground(Params... paramsArr);

    public final AsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            int i3 = AnonymousClass4.$SwitchMap$com$tencent$component$network$utils$thread$AsyncTask$Status[this.mStatus.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
            } else {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            HandlerHolder.Handler.obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    public final Result get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j3, timeUnit);
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    protected void onPreExecute() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }
}
