package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaseTask implements Handler.Callback {
    public static final int STATUS_DONE = 3;
    public static final int STATUS_RESET = 4;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_WAIT = 1;
    private static final String TAG = "minisdk-start_BaseTask";
    public static final int THREAD_TYPE_ASYNC = 2;
    public static final int THREAD_TYPE_MAIN = 3;
    public static final int THREAD_TYPE_SYNC = 1;
    private Callback mCallback;
    protected String mClassTag;
    protected Context mContext;
    private List<BaseTask> mDependTask;
    protected String mDescStr;
    private boolean mIsCached;
    private boolean mIsSucc;
    protected long mRunDurationMs;
    private int mSatus;
    private long mTaskStartTime;
    private int mThreadType;
    private long mTotalRunDurationMs;
    protected Handler mainHander;

    /* renamed from: msg, reason: collision with root package name */
    public String f348348msg;
    public int retCode;
    private BaseRuntimeLoader runtimeLoader;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Callback {
        void onTaskBegin(BaseTask baseTask);

        void onTaskEnd(BaseTask baseTask);
    }

    public BaseTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        this(context, 1, baseRuntimeLoader);
    }

    private void doReset() {
        QMLog.i(TAG, "Task Reset: " + getDescStr());
        this.mSatus = 4;
        this.mIsSucc = false;
    }

    private String getDescStr() {
        if (TextUtils.isEmpty(this.mDescStr)) {
            this.mDescStr = this.mClassTag;
            if (this.runtimeLoader != null) {
                this.mDescStr += "{" + this.runtimeLoader.getClass().getSimpleName() + "@" + this.runtimeLoader.hashCode() + "}";
            }
        }
        return this.mDescStr;
    }

    public BaseTask addDependTask(BaseTask baseTask) {
        if (!this.mDependTask.contains(baseTask)) {
            this.mDependTask.add(baseTask);
        }
        return this;
    }

    protected abstract void execute();

    public List<BaseTask> getAllDependTask() {
        ArrayList arrayList = new ArrayList();
        if (this.mDependTask.size() <= 0) {
            return null;
        }
        for (BaseTask baseTask : this.mDependTask) {
            List<BaseTask> allDependTask = baseTask.getAllDependTask();
            arrayList.add(baseTask);
            if (allDependTask != null) {
                arrayList.addAll(allDependTask);
            }
        }
        return arrayList;
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<BaseTask> getDependTasks() {
        return this.mDependTask;
    }

    @NonNull
    public TaskExecutionStatics getExecutionStatics() {
        List<TaskExecutionStatics> subTaskExecutionStatics = getSubTaskExecutionStatics();
        TaskExecutionStatics.Status status = TaskExecutionStatics.Status.SUCCESS;
        int i3 = this.mSatus;
        if (i3 == 1) {
            status = TaskExecutionStatics.Status.WAIT;
        } else if (i3 == 2) {
            status = TaskExecutionStatics.Status.RUNNING;
        } else if (isDone()) {
            if (!isSucceed()) {
                status = TaskExecutionStatics.Status.FAIL;
            } else if (this.mIsCached) {
                status = TaskExecutionStatics.Status.CACHED;
            }
        }
        TaskExecutionStatics.Status status2 = status;
        String name = getName();
        long runDurationMs = getRunDurationMs();
        long totalRunDurationMs = getTotalRunDurationMs();
        String str = this.f348348msg;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (subTaskExecutionStatics == null) {
            subTaskExecutionStatics = Collections.emptyList();
        }
        return new TaskExecutionStatics(name, runDurationMs, totalRunDurationMs, status2, str2, subTaskExecutionStatics);
    }

    @NonNull
    public String getName() {
        String str = this.mClassTag;
        if (str != null) {
            return str;
        }
        return getClass().getSimpleName();
    }

    public long getRunDurationMs() {
        if (this.mSatus == 2) {
            return SystemClock.uptimeMillis() - this.mTaskStartTime;
        }
        return this.mRunDurationMs;
    }

    public BaseRuntimeLoader getRuntimeLoader() {
        return this.runtimeLoader;
    }

    public int getStatus() {
        return this.mSatus;
    }

    @Nullable
    protected List<TaskExecutionStatics> getSubTaskExecutionStatics() {
        ArrayList arrayList = new ArrayList(getDependTasks().size());
        Iterator<BaseTask> it = getDependTasks().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getExecutionStatics());
        }
        return arrayList;
    }

    public long getTotalRunDurationMs() {
        if (this.mTotalRunDurationMs == -1) {
            this.mTotalRunDurationMs = this.mRunDurationMs;
            List<TaskExecutionStatics> subTaskExecutionStatics = getSubTaskExecutionStatics();
            if (subTaskExecutionStatics != null) {
                for (TaskExecutionStatics taskExecutionStatics : subTaskExecutionStatics) {
                    if (taskExecutionStatics.getStatus() != TaskExecutionStatics.Status.CACHED) {
                        this.mTotalRunDurationMs += taskExecutionStatics.getTotalRunDurationMs();
                    }
                }
            }
        }
        return this.mTotalRunDurationMs;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public boolean isDependTo(BaseTask baseTask) {
        List<BaseTask> list;
        if (baseTask != null && (list = this.mDependTask) != null && list.size() > 0) {
            if (this.mDependTask.contains(baseTask)) {
                return true;
            }
            Iterator<BaseTask> it = this.mDependTask.iterator();
            while (it.hasNext()) {
                boolean isDependTo = it.next().isDependTo(baseTask);
                if (isDependTo) {
                    return isDependTo;
                }
            }
        }
        return false;
    }

    public boolean isDone() {
        if (this.mSatus == 3) {
            return true;
        }
        return false;
    }

    public boolean isSucceed() {
        return this.mIsSucc;
    }

    public void onTaskFailed() {
        this.mRunDurationMs = SystemClock.uptimeMillis() - this.mTaskStartTime;
        onTaskFailed(-1, "");
    }

    protected final void onTaskStart() {
        this.mTaskStartTime = SystemClock.uptimeMillis();
    }

    public void onTaskSucceed() {
        String str;
        this.mRunDurationMs = SystemClock.uptimeMillis() - this.mTaskStartTime;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Task end: ");
        sb5.append(getDescStr());
        sb5.append(" succ=");
        sb5.append(true);
        if (getStatus() == 4) {
            str = " Reseted";
        } else {
            str = "";
        }
        sb5.append(str);
        QMLog.i(TAG, sb5.toString());
        if (getStatus() == 4) {
            return;
        }
        setStatus(3);
        this.mIsSucc = true;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTaskEnd(this);
        }
    }

    public void onTaskSucceedWithCache() {
        this.mIsCached = true;
        onTaskSucceed();
    }

    public void reset() {
        if (getStatus() == 4) {
            return;
        }
        doReset();
    }

    public void run() {
        int i3 = this.mSatus;
        if (i3 == 2) {
            return;
        }
        if (i3 == 3) {
            this.mIsCached = true;
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onTaskEnd(this);
                return;
            }
            return;
        }
        setStatus(2);
        Callback callback2 = this.mCallback;
        if (callback2 != null) {
            callback2.onTaskBegin(this);
        }
        QMLog.i(TAG, "Task begin: " + getDescStr());
        try {
            onTaskStart();
            execute();
        } catch (Throwable th5) {
            QMLog.e(TAG, "task exception!", th5);
            onTaskFailed();
        }
    }

    public BaseTask setCallback(Callback callback) {
        this.mCallback = callback;
        return this;
    }

    public synchronized void setStatus(int i3) {
        this.mSatus = i3;
    }

    public String toString() {
        return getDescStr();
    }

    public BaseTask(Context context, int i3, BaseRuntimeLoader baseRuntimeLoader) {
        this.retCode = -1;
        this.f348348msg = "";
        this.mainHander = new Handler(Looper.getMainLooper());
        this.mRunDurationMs = 0L;
        this.mClassTag = getClass().getSimpleName();
        this.mDependTask = new ArrayList();
        this.mSatus = 1;
        this.mIsSucc = false;
        this.mIsCached = false;
        this.mTaskStartTime = 0L;
        this.mTotalRunDurationMs = -1L;
        this.mContext = context;
        this.mThreadType = i3;
        this.runtimeLoader = baseRuntimeLoader;
        ClassTag classTag = (ClassTag) getClass().getAnnotation(ClassTag.class);
        if (classTag != null) {
            String tag = classTag.tag();
            if (TextUtils.isEmpty(tag)) {
                return;
            }
            this.mClassTag = tag;
        }
    }

    public void onTaskFailed(int i3, String str) {
        this.mRunDurationMs = SystemClock.uptimeMillis() - this.mTaskStartTime;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Task end: ");
        sb5.append(getDescStr());
        sb5.append(" retCode=");
        sb5.append(i3);
        sb5.append(" msg=");
        sb5.append(str);
        sb5.append(getStatus() == 4 ? " Reseted" : "");
        QMLog.i(TAG, sb5.toString());
        if (getStatus() == 4) {
            return;
        }
        setStatus(3);
        this.mIsSucc = false;
        this.retCode = i3;
        this.f348348msg = str;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTaskEnd(this);
        }
    }
}
