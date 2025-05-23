package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Loader implements LoaderErrorThrower {
    public static final int DONT_RETRY = 2;
    public static final int DONT_RETRY_FATAL = 3;
    public static final int RETRY = 0;
    public static final int RETRY_RESET_ERROR_COUNT = 1;
    private LoadTask<? extends Loadable> currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t16, long j3, long j16, boolean z16);

        void onLoadCompleted(T t16, long j3, long j16);

        int onLoadError(T t16, long j3, long j16, IOException iOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final int MSG_CANCEL = 1;
        private static final int MSG_END_OF_SOURCE = 2;
        private static final int MSG_FATAL_ERROR = 4;
        private static final int MSG_IO_EXCEPTION = 3;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";
        private final Callback<T> callback;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t16, Callback<T> callback, int i3, long j3) {
            super(looper);
            this.loadable = t16;
            this.callback = callback;
            this.defaultMinRetryCount = i3;
            this.startTimeMs = j3;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute(Loader.this.currentTask);
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }

        public void cancel(boolean z16) {
            this.released = z16;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z16) {
                    sendEmptyMessage(1);
                }
            } else {
                this.loadable.cancelLoad();
                if (this.executorThread != null) {
                    this.executorThread.interrupt();
                }
            }
            if (z16) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.callback.onLoadCanceled(this.loadable, elapsedRealtime, elapsedRealtime - this.startTimeMs, true);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.released) {
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                execute();
                return;
            }
            if (i3 != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = elapsedRealtime - this.startTimeMs;
                if (this.loadable.isLoadCanceled()) {
                    this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j3, false);
                    return;
                }
                int i16 = message.what;
                int i17 = 1;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            IOException iOException = (IOException) message.obj;
                            this.currentError = iOException;
                            int onLoadError = this.callback.onLoadError(this.loadable, elapsedRealtime, j3, iOException);
                            if (onLoadError == 3) {
                                Loader.this.fatalError = this.currentError;
                                return;
                            } else {
                                if (onLoadError != 2) {
                                    if (onLoadError != 1) {
                                        i17 = 1 + this.errorCount;
                                    }
                                    this.errorCount = i17;
                                    start(getRetryDelayMillis());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        this.callback.onLoadCompleted(this.loadable, elapsedRealtime, j3);
                        return;
                    } catch (RuntimeException e16) {
                        Log.e(TAG, "Unexpected exception handling load completed", e16);
                        Loader.this.fatalError = new UnexpectedLoaderException(e16);
                        return;
                    }
                }
                this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j3, false);
                return;
            }
            throw ((Error) message.obj);
        }

        public void maybeThrowError(int i3) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > i3) {
                throw iOException;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.executorThread = Thread.currentThread();
                if (!this.loadable.isLoadCanceled()) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        TraceUtil.endSection();
                    } catch (Throwable th5) {
                        TraceUtil.endSection();
                        throw th5;
                    }
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e16) {
                if (!this.released) {
                    obtainMessage(3, e16).sendToTarget();
                }
            } catch (InterruptedException unused) {
                Assertions.checkState(this.loadable.isLoadCanceled());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e17) {
                Log.e(TAG, "Unexpected exception loading stream", e17);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e17)).sendToTarget();
                }
            } catch (OutOfMemoryError e18) {
                Log.e(TAG, "OutOfMemory error loading stream", e18);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e18)).sendToTarget();
                }
            } catch (Error e19) {
                Log.e(TAG, "Unexpected error loading stream", e19);
                if (!this.released) {
                    obtainMessage(4, e19).sendToTarget();
                }
                throw e19;
            }
        }

        public void start(long j3) {
            boolean z16;
            if (Loader.this.currentTask == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkState(z16);
            Loader.this.currentTask = this;
            if (j3 > 0) {
                sendEmptyMessageDelayed(0, j3);
            } else {
                execute();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Loadable {
        void cancelLoad();

        boolean isLoadCanceled();

        void load() throws IOException, InterruptedException;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.callback.onLoaderReleased();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th5) {
            super("Unexpected " + th5.getClass().getSimpleName() + MsgSummary.STR_COLON + th5.getMessage(), th5);
        }
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(str);
    }

    public void cancelLoading() {
        this.currentTask.cancel(false);
    }

    public boolean isLoading() {
        if (this.currentTask != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void release() {
        release(null);
    }

    public <T extends Loadable> long startLoading(T t16, Callback<T> callback, int i3) {
        boolean z16;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(myLooper, t16, callback, i3, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i3) throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            LoadTask<? extends Loadable> loadTask = this.currentTask;
            if (loadTask != null) {
                if (i3 == Integer.MIN_VALUE) {
                    i3 = loadTask.defaultMinRetryCount;
                }
                loadTask.maybeThrowError(i3);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void release(@Nullable ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (releaseCallback != null) {
            this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
        }
        this.downloadExecutorService.shutdown();
    }
}
