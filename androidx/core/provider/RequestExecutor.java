package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class RequestExecutor {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        /* compiled from: P */
        /* loaded from: classes.dex */
        private static class ProcessPriorityThread extends BaseThread {
            private final int mPriority;

            ProcessPriorityThread(Runnable runnable, String str, int i3) {
                super(runnable, str);
                this.mPriority = i3;
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        DefaultThreadFactory(@NonNull String str, int i3) {
            this.mThreadName = str;
            this.mPriority = i3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        HandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ReplyRunnable<T> implements Runnable {

        @NonNull
        private Callable<T> mCallable;

        @NonNull
        private Consumer<T> mConsumer;

        @NonNull
        private Handler mHandler;

        ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
            this.mCallable = callable;
            this.mConsumer = consumer;
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T t16;
            try {
                t16 = this.mCallable.call();
            } catch (Exception unused) {
                t16 = null;
            }
            final Consumer<T> consumer = this.mConsumer;
            this.mHandler.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    consumer.accept(t16);
                }
            });
        }
    }

    RequestExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor createDefaultExecutor(@NonNull String str, int i3, @IntRange(from = 0) int i16) {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(0, 1, i16, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i3));
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return baseThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor createHandlerExecutor(@NonNull Handler handler) {
        return new HandlerExecutor(handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void execute(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.create(), callable, consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T submit(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, @IntRange(from = 0) int i3) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            throw e16;
        } catch (ExecutionException e17) {
            throw new RuntimeException(e17);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
