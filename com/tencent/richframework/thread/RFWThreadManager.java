package com.tencent.richframework.thread;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.pool.RFWAsyncDisplayPool;
import com.tencent.richframework.thread.pool.RFWFileThreadPool;
import com.tencent.richframework.thread.pool.RFWNetThreadPool;
import com.tencent.richframework.thread.pool.RFWSubThreadPool;
import com.tencent.richframework.thread.pool.RFWThreadPool;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWThreadManager {
    public static final String TAG = "RFWThreadManager";
    private static final String THIS_OBJ_NAME = "this$0";
    protected static final String THREAD_NAME_PREFIX = "rfw_thread_";
    protected static final String THREAD_NAME_VIDEO = "rfw_thread_video";
    protected static final int THREAD_TYPE_ASYNC_DISPLAY = 4;
    protected static final int THREAD_TYPE_FILE = 2;
    protected static final int THREAD_TYPE_NET = 1;
    protected static final int THREAD_TYPE_NORMAL_SUB = 3;
    protected static final int THREAD_TYPE_NOT_FOUND = -1;
    protected static final int THREAD_TYPE_NUMBER_END = 4;
    protected static final int THREAD_TYPE_NUMBER_START = 1;
    protected static volatile RFWThreadLooperDelegate sErrorLooperDelegate;
    private static RFWThreadPoolExecuteListener sExecuteListener;
    private static volatile RFWThreadManager sInstance;
    protected static final Handler sUIHandler = new Handler(Looper.getMainLooper());
    protected volatile RFWThreadPool mAsyncDisplay;
    protected final Map<Integer, DelayRunnable> mDelayRunnables = new ConcurrentHashMap();
    protected volatile RFWThreadPool mFilePool;
    protected volatile RFWThreadPool mNetPool;
    protected volatile Handler mSerialThreadHandler;
    protected volatile RFWThreadPool mSubPool;
    protected volatile Handler mVideoHandler;
    protected volatile Handler mWinkHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class DelayRunnable implements Runnable {
        private final Runnable mDelegateRunnable;
        private final int mThreadType;

        DelayRunnable(Runnable runnable, int i3) {
            this.mDelegateRunnable = runnable;
            this.mThreadType = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            RFWThreadManager.this.getExecuteThreadPool(this.mThreadType).execute(this.mDelegateRunnable);
            RFWThreadManager.this.mDelayRunnables.remove(Integer.valueOf(this.mDelegateRunnable.hashCode()));
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface ThreadPoolType {
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class WeakAsyncTask extends WeakReference<Object> implements Runnable {
        private static final String TAG = "MainPostDelayedTask";
        private boolean isAutoRetrieve;
        private boolean mHashKey;
        private final Runnable mJob;
        private final String mThreadName;

        public WeakAsyncTask(Object obj, String str, Runnable runnable, boolean z16) {
            super(obj);
            this.mHashKey = false;
            this.mJob = runnable;
            this.isAutoRetrieve = z16;
            this.mThreadName = str;
            if (obj != null) {
                this.mHashKey = true;
            }
        }

        private boolean isShouldExecute() {
            if (!this.isAutoRetrieve) {
                return true;
            }
            Object obj = get();
            if (obj != null) {
                try {
                    Field declaredField = this.mJob.getClass().getDeclaredField(RFWThreadManager.THIS_OBJ_NAME);
                    declaredField.setAccessible(true);
                    declaredField.set(this.mJob, obj);
                    return true;
                } catch (Throwable th5) {
                    RFWLog.e(TAG, RFWLog.USR, "[isShouldExecute] thread name: " + this.mThreadName + " | error: ", th5);
                    return false;
                }
            }
            RFWLog.e(TAG, RFWLog.USR, "[isShouldExecute] never run, becuse outer object is retrieve already. thrad name: " + this.mThreadName);
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isShouldExecute()) {
                return;
            }
            if (!this.mHashKey) {
                RFWLog.e(TAG, RFWLog.USR, "[run] current hash key is false, flow end. thread name: " + this.mThreadName);
                return;
            }
            Runnable runnable = this.mJob;
            if (runnable != null) {
                runnable.run();
                return;
            }
            RFWLog.e(TAG, RFWLog.USR, "[run] main post delayed task job should not be null. thread name: " + this.mThreadName);
        }
    }

    RFWThreadManager() {
    }

    private WeakAsyncTask buildAsyncTask(@NonNull Runnable runnable, boolean z16) {
        Object obj;
        Class<?> cls = runnable.getClass();
        String name = cls.getName();
        try {
            Field declaredField = cls.getDeclaredField(THIS_OBJ_NAME);
            declaredField.setAccessible(true);
            obj = declaredField.get(runnable);
            declaredField.set(runnable, null);
        } catch (Throwable unused) {
        }
        try {
            return new WeakAsyncTask(obj, name, runnable, z16);
        } catch (Throwable th5) {
            RFWLog.e(TAG, RFWLog.USR, "[buildAsyncTask] create async task error: ", th5);
            return null;
        }
    }

    public static Handler createNewThreadHandler(String str, int i3) {
        return createNewThreadHandler(str, i3, null);
    }

    private void executeOnThread(@NonNull Runnable runnable, int i3) {
        executeOnThread(runnable, i3, 0L);
    }

    private RFWThreadPool getAsyncDisplayThreadPool() {
        if (this.mAsyncDisplay == null) {
            synchronized (RFWAsyncDisplayPool.class) {
                if (this.mAsyncDisplay == null) {
                    this.mAsyncDisplay = new RFWAsyncDisplayPool();
                    this.mAsyncDisplay.setExecuteListener(sExecuteListener);
                }
            }
        }
        return this.mAsyncDisplay;
    }

    private static Looper getErrorLooper() {
        if (sErrorLooperDelegate != null) {
            return sErrorLooperDelegate.getErrorLooper();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RFWThreadPool getExecuteThreadPool(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return getSubThreadPool();
                }
                return getAsyncDisplayThreadPool();
            }
            return getFileThreadPool();
        }
        return getNetThreadPool();
    }

    private RFWThreadPool getFileThreadPool() {
        if (this.mFilePool == null) {
            synchronized (RFWFileThreadPool.class) {
                if (this.mFilePool == null) {
                    this.mFilePool = new RFWFileThreadPool();
                    this.mFilePool.setExecuteListener(sExecuteListener);
                }
            }
        }
        return this.mFilePool;
    }

    public static RFWThreadManager getInstance() {
        if (sInstance == null) {
            synchronized (RFWThreadManager.class) {
                if (sInstance == null) {
                    sInstance = new RFWThreadManager();
                }
            }
        }
        return sInstance;
    }

    private RFWThreadPool getNetThreadPool() {
        if (this.mNetPool == null) {
            synchronized (RFWNetThreadPool.class) {
                if (this.mNetPool == null) {
                    this.mNetPool = new RFWNetThreadPool();
                    this.mNetPool.setExecuteListener(sExecuteListener);
                }
            }
        }
        return this.mNetPool;
    }

    private RFWThreadPool getSubThreadPool() {
        if (this.mSubPool == null) {
            synchronized (RFWSubThreadPool.class) {
                if (this.mSubPool == null) {
                    this.mSubPool = new RFWSubThreadPool();
                    this.mSubPool.setExecuteListener(sExecuteListener);
                }
            }
        }
        return this.mSubPool;
    }

    public static Handler getUIHandler() {
        return sUIHandler;
    }

    private int getVideoThreadPriority() {
        if (Build.VERSION.SDK_INT >= 28) {
            return -10;
        }
        return -2;
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static void setErrorLooperDelegate(RFWThreadLooperDelegate rFWThreadLooperDelegate) {
        sErrorLooperDelegate = rFWThreadLooperDelegate;
    }

    public static void setExecuteListener(RFWThreadPoolExecuteListener rFWThreadPoolExecuteListener) {
        sExecuteListener = rFWThreadPoolExecuteListener;
    }

    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5L, timeUnit)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5L, timeUnit)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e16) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e16);
        }
    }

    public void execOnAsyncDisplayThread(@NonNull Runnable runnable) {
        executeOnThread(runnable, 4);
    }

    public void execOnFileThread(@NonNull Runnable runnable) {
        executeOnThread(runnable, 2);
    }

    public void execOnNetThread(@NonNull Runnable runnable) {
        executeOnThread(runnable, 1);
    }

    public void execOnSubThread(@NonNull Runnable runnable) {
        executeOnThread(runnable, 3);
    }

    public Handler getSerialThreadHandler() {
        if (this.mSerialThreadHandler == null) {
            synchronized (RFWThreadManager.class) {
                if (this.mSerialThreadHandler == null) {
                    this.mSerialThreadHandler = createNewThreadHandler("RFSerialThread", 0);
                }
            }
        }
        return this.mSerialThreadHandler;
    }

    public Handler getVideoHandler() {
        if (this.mVideoHandler == null) {
            synchronized (RFWThreadManager.class) {
                if (this.mVideoHandler == null) {
                    this.mVideoHandler = createNewThreadHandler(THREAD_NAME_VIDEO, getVideoThreadPriority());
                }
            }
        }
        return this.mVideoHandler;
    }

    public Handler getWinkHandler() {
        if (this.mWinkHandler == null) {
            synchronized (RFWThreadManager.class) {
                if (this.mWinkHandler == null) {
                    this.mWinkHandler = createNewThreadHandler("RFWinkThread", 0);
                }
            }
        }
        return this.mWinkHandler;
    }

    public void postMainDelay(Runnable runnable, long j3, boolean z16) {
        if (runnable == null) {
            RFWLog.d(TAG, RFWLog.USR, "[postMainDelay] job should not be null.");
            return;
        }
        if (!z16) {
            getUIHandler().postDelayed(runnable, j3);
            return;
        }
        WeakAsyncTask buildAsyncTask = buildAsyncTask(runnable, true);
        if (buildAsyncTask == null) {
            getUIHandler().postDelayed(runnable, j3);
        } else {
            getUIHandler().postDelayed(buildAsyncTask, j3);
        }
    }

    public void releaseHandler(Handler handler) {
        handler.removeCallbacksAndMessages(null);
        if (handler.getLooper() != getErrorLooper()) {
            handler.getLooper().quit();
        }
    }

    public void remove(Runnable runnable) {
        DelayRunnable delayRunnable = this.mDelayRunnables.get(Integer.valueOf(runnable.hashCode()));
        if (delayRunnable != null) {
            getUIHandler().removeCallbacks(delayRunnable);
            return;
        }
        for (int i3 = 1; i3 <= 4; i3++) {
            RFWThreadPool executeThreadPool = getExecuteThreadPool(i3);
            if (executeThreadPool != null && executeThreadPool.remove(runnable)) {
                return;
            }
        }
    }

    public void runOnUiThread(@NonNull Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static Handler createNewThreadHandler(String str, int i3, Handler.Callback callback) {
        try {
            RFWHandlerThread rFWHandlerThread = new RFWHandlerThread(str, i3);
            rFWHandlerThread.start();
            RFWLog.d(TAG, RFWLog.USR, "createNewThreadHandler success name:" + str + " priority:" + i3);
            return new Handler(rFWHandlerThread.getLooper(), callback);
        } catch (OutOfMemoryError e16) {
            RFWLog.e(TAG, RFWLog.USR, "createNewThreadHandler failed with OOM name:" + str + " priority:" + i3);
            Looper errorLooper = getErrorLooper();
            if (errorLooper != null) {
                return new Handler(errorLooper, callback);
            }
            throw e16;
        }
    }

    private void executeOnThread(@NonNull Runnable runnable, int i3, long j3) {
        if (j3 > 0) {
            DelayRunnable delayRunnable = new DelayRunnable(runnable, i3);
            this.mDelayRunnables.put(Integer.valueOf(runnable.hashCode()), delayRunnable);
            getUIHandler().postDelayed(delayRunnable, j3);
            return;
        }
        getExecuteThreadPool(i3).execute(runnable);
    }

    public void execOnAsyncDisplayThread(@NonNull Runnable runnable, long j3) {
        executeOnThread(runnable, 4, j3);
    }

    public void execOnFileThread(@NonNull Runnable runnable, long j3) {
        executeOnThread(runnable, 2, j3);
    }

    public void execOnNetThread(@NonNull Runnable runnable, long j3) {
        executeOnThread(runnable, 1, j3);
    }

    public void execOnSubThread(@NonNull Runnable runnable, long j3) {
        executeOnThread(runnable, 3, j3);
    }

    public void runOnUiThread(@NonNull Runnable runnable, long j3) {
        if (isMainThread() && j3 <= 0) {
            runnable.run();
        } else {
            getUIHandler().postDelayed(runnable, j3);
        }
    }

    public void postMainDelay(Runnable runnable, long j3) {
        postMainDelay(runnable, j3, false);
    }
}
