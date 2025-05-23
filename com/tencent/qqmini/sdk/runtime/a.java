package com.tencent.qqmini.sdk.runtime;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.TaskFlowEngine;
import com.tencent.qqmini.sdk.task.TaskThreadPool;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class a extends BaseRuntimeLoader implements BaseTask.Callback {

    @NonNull
    private final TaskFlowEngine taskFlowEngine;

    public a(Context context) {
        super(context);
        this.taskFlowEngine = new TaskFlowEngine(this);
        initTask();
    }

    private final void initTask() {
        BaseTask[] createTasks = createTasks();
        this.taskFlowEngine.initTasks(createTasks);
        if (createTasks != null) {
            for (BaseTask baseTask : createTasks) {
                registTaskName(baseTask);
            }
        }
    }

    private void registTaskName(BaseTask baseTask) {
        if (baseTask == null) {
            return;
        }
        addTask(baseTask);
        List<BaseTask> dependTasks = baseTask.getDependTasks();
        if (dependTasks != null && dependTasks.size() > 0) {
            Iterator<BaseTask> it = dependTasks.iterator();
            while (it.hasNext()) {
                registTaskName(it.next());
            }
        }
    }

    private synchronized void restartFailTaskIfNeed() {
        if (!this.hasTaskFailed) {
            return;
        }
        this.hasTaskFailed = false;
        for (BaseTask baseTask : this.taskFlowEngine.getAllTasks()) {
            if (!baseTask.isSucceed()) {
                baseTask.reset();
                this.taskFlowEngine.executeTask(baseTask);
            }
        }
    }

    public boolean checkAllTaskIsDone() {
        return this.taskFlowEngine.checkAllTaskIsDone();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    protected BaseRuntime createRuntime(Context context) {
        return null;
    }

    public BaseTask[] createTasks() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public int getStatus() {
        return this.taskFlowEngine.getStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public TaskThreadPool getTaskThreadPool() {
        return this.taskFlowEngine.getTaskThreadPool();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public boolean isPause() {
        return this.taskFlowEngine.isPause();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public boolean isRunning() {
        return this.taskFlowEngine.isRunning();
    }

    public void onTaskDone(BaseTask baseTask) {
        if (baseTask == null) {
            return;
        }
        QMLog.d(BaseRuntimeLoader.TAG, toSimpleString() + " onTaskDone " + baseTask + " isSucc=" + baseTask.isSucceed());
        if (!baseTask.isSucceed()) {
            markHasTaskFailed(true);
        }
        this.taskFlowEngine.onTaskDone(baseTask);
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask.Callback
    public void onTaskEnd(BaseTask baseTask) {
        if (!this.taskFlowEngine.onTaskEnd(baseTask)) {
            return;
        }
        onTaskDone(baseTask);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void pause() {
        super.start();
        this.taskFlowEngine.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetTaskAndDepends(BaseTask baseTask) {
        this.taskFlowEngine.resetTaskAndDepends(baseTask);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void resume() {
        this.taskFlowEngine.resume();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        super.setMiniAppInfo(miniAppInfo);
        restartFailTaskIfNeed();
    }

    public synchronized void setStatus(int i3) {
        this.taskFlowEngine.setStatus(i3);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void start() {
        super.start();
        this.taskFlowEngine.start();
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask.Callback
    public void onTaskBegin(BaseTask baseTask) {
    }
}
