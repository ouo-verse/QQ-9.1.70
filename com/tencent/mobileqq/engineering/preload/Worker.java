package com.tencent.mobileqq.engineering.preload;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.engineering.preload.inter.IWorker;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.richframework.thread.factory.RFWThreadFactory;
import com.tencent.richframework.thread.pool.RFWThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes12.dex */
public class Worker<T> implements Runnable, IWorker, OnPreLoadListener<T> {
    private static final String TAG = "RFWPreloadWorker";
    private static ExecutorService sDefaultThreadPoolExecutor;
    private static final ThreadFactory sFactory;
    private BasePreLoadTask<T> mPreLoadTask;
    private String mPreloadId;
    private T[] mResponse;
    private long mRspTimeStamp;
    private int mSeq;
    private volatile OnTaskListener<T> mTaskListener;
    private ExecutorService mThreadPoolExecutor;
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private volatile String mState = State.UnInited;

    static {
        RFWThreadFactory rFWThreadFactory = new RFWThreadFactory(TAG);
        sFactory = rFWThreadFactory;
        sDefaultThreadPoolExecutor = new RFWThreadPool(2, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), rFWThreadFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Worker(String str, BasePreLoadTask<T> basePreLoadTask, OnTaskListener<T> onTaskListener, int i3) {
        this.mTaskListener = null;
        this.mPreloadId = str;
        this.mSeq = i3;
        this.mPreLoadTask = basePreLoadTask;
        setState(State.Initialed);
        if (onTaskListener != null) {
            this.mTaskListener = onTaskListener;
        }
    }

    private boolean checkTaskIsExpired() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mPreLoadTask.mPreloadExpiredTime;
        if (j3 > 0 && currentTimeMillis - this.mRspTimeStamp > j3 * 1000) {
            return true;
        }
        return false;
    }

    private void doOnLoaded(final OnTaskListener<T> onTaskListener, final T... tArr) {
        try {
            boolean checkTaskIsExpired = checkTaskIsExpired();
            if (checkTaskIsExpired) {
                tArr = null;
            }
            PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", expiredTime=" + this.mPreLoadTask.mPreloadExpiredTime + ", isExpired=" + checkTaskIsExpired);
            boolean isMainThread = isMainThread();
            if (isMainThread()) {
                doTaskComplete(onTaskListener, tArr);
            } else {
                this.mMainThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.engineering.preload.Worker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Worker.this.doTaskComplete(onTaskListener, tArr);
                    }
                });
            }
            PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", isMainThread=" + isMainThread);
        } catch (Exception e16) {
            PreLoader.log(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doTaskComplete(OnTaskListener<T> onTaskListener, T[] tArr) {
        if (onTaskListener == null) {
            return;
        }
        onTaskListener.onComplete(tArr);
        if (this.mPreLoadTask.mIsOnlyRunOnce) {
            PreLoader.remove(this.mPreloadId);
        }
    }

    private boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setDefaultThreadPoolExecutor(ExecutorService executorService) {
        if (executorService != null) {
            sDefaultThreadPoolExecutor = executorService;
        }
    }

    private void setState(String str) {
        this.mState = str;
        PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", curState=" + str);
    }

    @Override // com.tencent.mobileqq.engineering.preload.inter.IWorker
    public void doPreLoad() {
        setState(State.Loading);
        ExecutorService executorService = this.mThreadPoolExecutor;
        if (executorService != null) {
            executorService.execute(this);
        } else {
            sDefaultThreadPoolExecutor.execute(this);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener
    public void onLoaded(T... tArr) {
        this.mResponse = tArr;
        this.mRspTimeStamp = System.currentTimeMillis();
        setState(State.Done);
        if (this.mTaskListener != null) {
            doOnLoaded(this.mTaskListener, tArr);
            return;
        }
        PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", done but listener is null");
    }

    @Override // com.tencent.mobileqq.engineering.preload.inter.IWorker
    public void onRemove() {
        try {
            PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", on remove worker");
            this.mPreLoadTask.onRemove();
        } catch (Exception e16) {
            PreLoader.log(e16);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.inter.IWorker
    public void removeListener(OnTaskListener onTaskListener) {
        PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", remove listener");
        this.mTaskListener = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mPreLoadTask.startLoadData(this);
        } catch (Exception e16) {
            PreLoader.log(e16);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.inter.IWorker
    public void setListener(OnTaskListener onTaskListener) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id=");
        sb5.append(this.mPreloadId);
        sb5.append(", seq=");
        sb5.append(this.mSeq);
        sb5.append(", listener is ");
        if (onTaskListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        PreLoader.log(sb5.toString());
        if (onTaskListener != null) {
            this.mTaskListener = onTaskListener;
            PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", curState=" + this.mState);
            if (State.Done.equals(this.mState)) {
                doOnLoaded(onTaskListener, this.mResponse);
            }
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.inter.IWorker
    public void setThreadPoolExecutor(ExecutorService executorService) {
        if (executorService != null) {
            this.mThreadPoolExecutor = executorService;
        }
    }
}
