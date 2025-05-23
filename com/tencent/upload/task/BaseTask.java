package com.tencent.upload.task;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.UploadThreadManager;
import com.tencent.upload.utils.watcher.UploadFlowTracker;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class BaseTask implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseTask";
    protected volatile boolean mCanceled;
    protected StringBuffer mFlowRecoder;
    protected Future<?> mFuture;
    protected int mRetCode;
    protected String mRetMsg;
    private volatile TaskState mState;
    protected volatile boolean mSuspended;
    protected int mTaskId;
    protected ThreadPoolExecutor mThreadPool;

    public BaseTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mState = TaskState.WAITING;
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SUCCEED;
        this.mRetCode = uploadRetCode.getCode();
        this.mRetMsg = uploadRetCode.getDesc();
        this.mFuture = null;
        this.mCanceled = false;
        this.mSuspended = false;
        this.mFlowRecoder = new StringBuffer();
        this.mTaskId = UUID.randomUUID().hashCode();
    }

    private boolean terminateJob(Future<?> future) {
        if (future.cancel(true) && future.isCancelled()) {
            TaskState taskState = getTaskState();
            UploadLog.i(TAG, "terminateJob | task is canceled. task id=" + getTaskId() + " , lastState:" + taskState);
            if (taskState == TaskState.WAITING) {
                if (this.mCanceled) {
                    setState(TaskState.CANCEL);
                } else {
                    setState(TaskState.PAUSE);
                }
            }
            return true;
        }
        UploadLog.w(TAG, "task can not be canceled. task id=" + getTaskId());
        return false;
    }

    public void bindThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) threadPoolExecutor);
        } else {
            this.mThreadPool = threadPoolExecutor;
        }
    }

    public boolean cancel() {
        Future<?> future;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        synchronized (this) {
            future = this.mFuture;
        }
        if (future == null) {
            UploadLog.e(TAG, "task is not started. task id=" + getTaskId());
            this.mCanceled = true;
            setState(TaskState.CANCEL);
            return true;
        }
        if (future.isDone()) {
            UploadLog.i(TAG, "task is done. task id=" + getTaskId());
            synchronized (this) {
                this.mFuture = null;
            }
            return true;
        }
        try {
            this.mCanceled = true;
            boolean terminateJob = terminateJob(future);
            synchronized (this) {
                this.mFuture = null;
            }
            return terminateJob;
        } catch (Throwable th5) {
            synchronized (this) {
                this.mFuture = null;
                throw th5;
            }
        }
    }

    public abstract Const.FileType getFileType();

    public int getRetCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mRetCode;
    }

    public String getRetMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mRetMsg;
    }

    protected TaskState getState() {
        TaskState taskState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TaskState) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        synchronized (this) {
            taskState = this.mState;
        }
        return taskState;
    }

    public int getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mTaskId;
    }

    public TaskState getTaskState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TaskState) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mState;
    }

    public boolean isAlive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (!this.mCanceled && !this.mSuspended) {
            return true;
        }
        return false;
    }

    public abstract void onError(int i3, String str);

    protected abstract boolean onRun();

    public boolean pause() {
        Future<?> future;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        synchronized (this) {
            future = this.mFuture;
        }
        if (future == null) {
            UploadLog.e(TAG, "task is not started. task id=" + getTaskId());
            this.mSuspended = true;
            setState(TaskState.PAUSE);
            return true;
        }
        if (future.isDone()) {
            UploadLog.i(TAG, "task is done. task id=" + getTaskId());
            synchronized (this) {
                this.mFuture = null;
            }
            return true;
        }
        try {
            this.mSuspended = true;
            boolean terminateJob = terminateJob(future);
            synchronized (this) {
                this.mFuture = null;
            }
            return terminateJob;
        } catch (Throwable th5) {
            synchronized (this) {
                this.mFuture = null;
                throw th5;
            }
        }
    }

    protected abstract void report(int i3, String str);

    public synchronized void resetWaitState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        UploadLog.d(TAG, "resetWaitState task id:" + getTaskId());
        setState(TaskState.PAUSE);
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            if (!onRun()) {
                if (!Thread.interrupted() && isAlive()) {
                    setState(TaskState.FAILED);
                }
                UploadLog.d(TAG, "task id:" + getTaskId() + " Thread.interrupted():" + Thread.interrupted() + " mCanceled:" + this.mCanceled + " mSuspended:" + this.mSuspended);
                if (this.mCanceled) {
                    setState(TaskState.CANCEL);
                } else {
                    setState(TaskState.PAUSE);
                }
            }
        } catch (Throwable th5) {
            UploadLog.e(TAG, "taskId:" + getTaskId() + " onRun has Exception:" + th5.getMessage());
            if (this.mRetCode == 0) {
                this.mRetCode = Const.UploadRetCode.UNKNOWN_EXCEPTION.getCode();
            }
            int i3 = this.mRetCode;
            onError(i3, Const.getRetCode(i3).getDesc());
            setState(TaskState.FAILED);
            UploadFlowTracker.trackException(this, th5);
        }
        synchronized (this) {
            this.mFuture = null;
            notifyAll();
        }
    }

    public void setRetCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mRetCode = i3;
        }
    }

    public void setRetMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mRetMsg = str;
        }
    }

    public synchronized void setState(TaskState taskState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) taskState);
            return;
        }
        UploadLog.d(TAG, "taskid:" + this.mTaskId + " setState: " + this.mState + " ---> " + taskState);
        this.mState = taskState;
    }

    public void setTaskId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mTaskId = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setTaskStatus(TaskState taskState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) taskState)).booleanValue();
        }
        UploadLog.i(TAG, "setTaskStatus " + this.mState + " --> " + taskState);
        if (this.mState == taskState) {
            return false;
        }
        this.mState = taskState;
        return true;
    }

    public synchronized boolean start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.mThreadPool == null) {
            UploadLog.e(TAG, "thread pool is null!");
            return false;
        }
        if (this.mFuture != null) {
            try {
                UploadLog.d(TAG, "start wait ...");
                LockMethodProxy.wait(this);
            } catch (Throwable th5) {
                UploadLog.e(TAG, "thread exception !", th5);
                return false;
            }
        }
        try {
            try {
                this.mCanceled = false;
                this.mSuspended = false;
                setState(TaskState.WAITING);
                Future<?> submit = submit(this.mThreadPool);
                if (submit == null) {
                    UploadLog.w(TAG, "submit task failed! task id=" + getTaskId());
                    return false;
                }
                if (!submit.isDone()) {
                    this.mFuture = submit;
                }
                UploadLog.i(TAG, "submit task ok. task id=" + getTaskId() + " thread pool:" + UploadThreadManager.getInstance().toString());
                return true;
            } catch (OutOfMemoryError e16) {
                UploadLog.w(TAG, "submit task failed!", e16);
                return false;
            }
        } catch (Exception e17) {
            UploadLog.w(TAG, "submit task failed!", e17);
            return false;
        }
    }

    protected Future<?> submit(ThreadPoolExecutor threadPoolExecutor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Future) iPatchRedirector.redirect((short) 18, (Object) this, (Object) threadPoolExecutor);
        }
        return threadPoolExecutor.submit(this);
    }
}
