package com.tencent.qqmini.sdk.task;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TaskFlowEngine implements Handler.Callback {
    public static final int MSG_WHAT_BASE = 100;
    public static final int MSG_WHAT_TASK_DONE = 101;
    public static final int STATUS_DONE = 5;
    public static final int STATUS_INIT = 1;
    public static final int STATUS_PAUSE = 3;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_SLEEP = 4;
    public static final String TAG = "TaskFlow";
    private final WeakReference<BaseTask.Callback> callbackRef;
    protected TaskThreadPool mTaskThreadPool;
    protected BaseTask[] mTasks;
    private final List<DependFlow> mFlows = new ArrayList();
    protected List<BaseTask> mAllTasks = new ArrayList();
    private int mStatus = 1;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class DependFlow {
        List<BaseTask> mDependTasks;
        BaseTask mTask;

        DependFlow(BaseTask baseTask, List<BaseTask> list) {
            this.mTask = baseTask;
            this.mDependTasks = list;
        }

        public boolean isDepend(BaseTask baseTask) {
            List<BaseTask> list = this.mDependTasks;
            if (list != null && list.contains(baseTask)) {
                return true;
            }
            return false;
        }

        public void onDependCompleted() {
            boolean z16;
            List<BaseTask> list = this.mDependTasks;
            if (list != null) {
                Iterator<BaseTask> it = list.iterator();
                while (it.hasNext()) {
                    if (!it.next().isSucceed()) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                if (this.mTask.isDone() && this.mTask.isSucceed()) {
                    TaskFlowEngine.this.updateFlow(this.mTask);
                } else {
                    this.mTask.run();
                }
            }
        }
    }

    public TaskFlowEngine(BaseTask.Callback callback) {
        this.callbackRef = new WeakReference<>(callback);
        try {
            int config = DeviceInfoUtil.getPerfLevel() == 3 ? WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_LOW_LEVEL_DEVICE_THREAD_COUNT, 2) : DeviceInfoUtil.getNumberOfCPUCores();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("create thread pool, poolSize=");
            int i3 = config + 1;
            sb5.append(i3);
            QMLog.w(TAG, sb5.toString());
            if (config <= 0) {
                i3 = 2;
            }
            this.mTaskThreadPool = new TaskThreadPool("TaskFlowEngine", 2, i3);
        } catch (Exception e16) {
            QMLog.e(TAG, "create thread pool error!", e16);
        }
    }

    private void initCallback(BaseTask baseTask) {
        if (baseTask == null) {
            return;
        }
        BaseTask.Callback callback = this.callbackRef.get();
        if (callback != null) {
            baseTask.setCallback(callback);
        }
        if (!this.mAllTasks.contains(baseTask)) {
            this.mAllTasks.add(baseTask);
        }
        List<BaseTask> dependTasks = baseTask.getDependTasks();
        if (dependTasks != null && dependTasks.size() > 0) {
            Iterator<BaseTask> it = dependTasks.iterator();
            while (it.hasNext()) {
                initCallback(it.next());
            }
        }
    }

    public boolean checkAllTaskIsDone() {
        BaseTask[] baseTaskArr = this.mTasks;
        if (baseTaskArr == null) {
            return false;
        }
        for (BaseTask baseTask : baseTaskArr) {
            if (!baseTask.isDone()) {
                return false;
            }
        }
        return true;
    }

    public void executeTask(BaseTask baseTask) {
        boolean z16;
        if (baseTask == null) {
            return;
        }
        List<BaseTask> dependTasks = baseTask.getDependTasks();
        if (dependTasks != null && dependTasks.size() > 0) {
            synchronized (this.mFlows) {
                Iterator<DependFlow> it = this.mFlows.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().mTask == baseTask) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
            }
            if (!z16) {
                DependFlow dependFlow = new DependFlow(baseTask, dependTasks);
                synchronized (this.mFlows) {
                    this.mFlows.add(dependFlow);
                }
            }
            Iterator<BaseTask> it5 = dependTasks.iterator();
            while (it5.hasNext()) {
                executeTask(it5.next());
            }
            return;
        }
        baseTask.run();
    }

    public List<BaseTask> getAllTasks() {
        return this.mAllTasks;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public TaskThreadPool getTaskThreadPool() {
        return this.mTaskThreadPool;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public final void initTasks(BaseTask[] baseTaskArr) {
        this.mAllTasks.clear();
        this.mTasks = baseTaskArr;
        if (baseTaskArr == null) {
            return;
        }
        for (BaseTask baseTask : baseTaskArr) {
            initCallback(baseTask);
        }
    }

    public boolean isPause() {
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        if (this.mStatus == 2) {
            return true;
        }
        return false;
    }

    public void onTaskDone(final BaseTask baseTask) {
        if (!isPause() && baseTask.isSucceed()) {
            this.mTaskThreadPool.addExecuteTask(new Runnable() { // from class: com.tencent.qqmini.sdk.task.TaskFlowEngine.3
                @Override // java.lang.Runnable
                public void run() {
                    TaskFlowEngine.this.updateFlow(baseTask);
                }
            });
        }
    }

    public boolean onTaskEnd(BaseTask baseTask) {
        if (baseTask == null) {
            return false;
        }
        if (checkAllTaskIsDone()) {
            setStatus(5);
        }
        if (isPause()) {
            return false;
        }
        return true;
    }

    public void pause() {
        QMLog.i(TAG, "pause");
        setStatus(3);
    }

    public void resetTaskAndDepends(BaseTask baseTask) {
        if (baseTask == null) {
            return;
        }
        baseTask.reset();
        for (BaseTask baseTask2 : this.mAllTasks) {
            if (baseTask2.isDependTo(baseTask)) {
                baseTask2.reset();
            }
        }
    }

    public void resume() {
        QMLog.i(TAG, "resume");
        BaseTask[] baseTaskArr = this.mTasks;
        if (baseTaskArr != null && baseTaskArr.length > 0) {
            setStatus(2);
            this.mTaskThreadPool.addExecuteTask(new Runnable() { // from class: com.tencent.qqmini.sdk.task.TaskFlowEngine.2
                @Override // java.lang.Runnable
                public void run() {
                    for (BaseTask baseTask : TaskFlowEngine.this.mTasks) {
                        TaskFlowEngine.this.executeTask(baseTask);
                    }
                }
            });
        }
    }

    public synchronized void setStatus(int i3) {
        QMLog.i(TAG, "setStatus " + i3);
        this.mStatus = i3;
    }

    public void start() {
        BaseTask[] baseTaskArr = this.mTasks;
        if (baseTaskArr != null && baseTaskArr.length > 0) {
            setStatus(2);
            this.mTaskThreadPool.addExecuteTask(new Runnable() { // from class: com.tencent.qqmini.sdk.task.TaskFlowEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    for (BaseTask baseTask : TaskFlowEngine.this.mTasks) {
                        TaskFlowEngine.this.executeTask(baseTask);
                    }
                }
            });
        }
    }

    protected void updateFlow(BaseTask baseTask) {
        synchronized (this.mFlows) {
            for (DependFlow dependFlow : this.mFlows) {
                if (dependFlow.isDepend(baseTask)) {
                    dependFlow.onDependCompleted();
                }
            }
        }
    }
}
