package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DefaultTaskExecutor extends TaskExecutor {

    @Nullable
    private volatile Handler mMainHandler;
    private final Object mLock = new Object();
    private final ExecutorService mDiskIO = ProxyExecutors.newFixedThreadPool(4, new ThreadFactory() { // from class: androidx.arch.core.executor.DefaultTaskExecutor.1
        private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setName(String.format(THREAD_NAME_STEM, Integer.valueOf(this.mThreadId.getAndIncrement())));
            return baseThread;
        }
    });

    private static Handler createAsync(@NonNull Looper looper) {
        Handler createAsync;
        if (Build.VERSION.SDK_INT >= 28) {
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = createAsync(Looper.getMainLooper());
                }
            }
        }
        this.mMainHandler.post(runnable);
    }
}
