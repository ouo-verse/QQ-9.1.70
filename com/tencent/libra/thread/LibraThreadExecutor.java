package com.tencent.libra.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.task.ILibraTask;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.richframework.thread.factory.RFWThreadFactory;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraThreadExecutor {
    public static final int DEFAULT_COMPARE_VALUE = 0;
    private static volatile LibraThreadExecutor sInstance;
    private volatile ThreadPoolExecutor mDecodeExecutor;
    private volatile ThreadPoolExecutor mDownloadExecutor;
    private ITaskExecutor mInjectTaskExecutor;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraThreadExecutor");
    public static final int PROCESSORS_COUNT = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements Comparator<Runnable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Runnable runnable, Runnable runnable2) {
            if ((runnable instanceof ILibraTask) && (runnable2 instanceof ILibraTask)) {
                return ((ILibraTask) runnable).getOption().getPriority() - ((ILibraTask) runnable2).getOption().getPriority();
            }
            return 0;
        }
    }

    LibraThreadExecutor() {
    }

    public static Handler createNewThreadHandler(String str, int i3, Handler.Callback callback) {
        try {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, i3);
            baseHandlerThread.start();
            RFWLog.i(TAG, RFWLog.USR, "createNewThreadHandler success name:" + str + " priority:" + i3);
            return new Handler(baseHandlerThread.getLooper(), callback);
        } catch (OutOfMemoryError e16) {
            String str2 = TAG;
            RFWLog.i(str2, RFWLog.USR, "createNewThreadHandler failed with OOM name:" + str + " priority:" + i3);
            Looper globalErrorLooper = getGlobalErrorLooper();
            if (globalErrorLooper != null) {
                return new Handler(globalErrorLooper, callback);
            }
            RFWLog.e(str2, RFWLog.USR, "createNewThreadHandler failed with OOM and mErrorLooper is null");
            throw e16;
        }
    }

    public static ThreadPoolExecutor createPool(int i3, int i16) {
        return new LibraThreadPool(i3, i16, 120L, TimeUnit.SECONDS, new PriorityBlockingQueue(200, new a()), new RFWThreadFactory(TAG));
    }

    public static LibraThreadExecutor g() {
        if (sInstance == null) {
            synchronized (LibraThreadExecutor.class) {
                if (sInstance == null) {
                    sInstance = new LibraThreadExecutor();
                }
            }
        }
        return sInstance;
    }

    private ThreadPoolExecutor getDecodeExecutor() {
        if (this.mDecodeExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (this.mDecodeExecutor == null) {
                    int i3 = PROCESSORS_COUNT;
                    this.mDecodeExecutor = createPool(i3 + 1, ((i3 * 2) + 1) * 2);
                }
            }
        }
        return this.mDecodeExecutor;
    }

    private ThreadPoolExecutor getDownloadExecutor() {
        if (this.mDownloadExecutor == null) {
            synchronized (ThreadPoolExecutor.class) {
                if (this.mDownloadExecutor == null) {
                    int i3 = PROCESSORS_COUNT;
                    this.mDownloadExecutor = createPool(i3 + 1, (i3 * 2) + 1);
                }
            }
        }
        return this.mDownloadExecutor;
    }

    private static Looper getGlobalErrorLooper() {
        if (LibraPicLoaderFactory.getGlobalPicLoadStrategy() != null) {
            return LibraPicLoaderFactory.getGlobalPicLoadStrategy().getErrorLooper();
        }
        return null;
    }

    public void execDecodeTask(Runnable runnable) {
        ITaskExecutor iTaskExecutor = this.mInjectTaskExecutor;
        if (iTaskExecutor != null) {
            iTaskExecutor.execDecodeTask(runnable);
        } else {
            getDecodeExecutor().execute(runnable);
        }
    }

    public void execDownloadTask(Runnable runnable) {
        ITaskExecutor iTaskExecutor = this.mInjectTaskExecutor;
        if (iTaskExecutor != null) {
            iTaskExecutor.execDownloadTask(runnable);
        } else {
            getDownloadExecutor().execute(runnable);
        }
    }

    public void removeDecodeTask(Runnable runnable) {
        ITaskExecutor iTaskExecutor = this.mInjectTaskExecutor;
        if (iTaskExecutor != null) {
            iTaskExecutor.removeDecodeTask(runnable);
        } else {
            getDecodeExecutor().remove(runnable);
        }
    }

    public void removeDownloadTask(Runnable runnable) {
        ITaskExecutor iTaskExecutor = this.mInjectTaskExecutor;
        if (iTaskExecutor != null) {
            iTaskExecutor.removeDownloadTask(runnable);
        } else {
            getDownloadExecutor().remove(runnable);
        }
    }

    public void setTaskExecutorAndLooper(ITaskExecutor iTaskExecutor) {
        this.mInjectTaskExecutor = iTaskExecutor;
    }
}
