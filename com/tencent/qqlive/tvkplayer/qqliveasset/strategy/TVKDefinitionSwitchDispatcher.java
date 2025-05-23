package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDefinitionSwitchDispatcher extends TVKSwitchDispatcherBase {
    private static final String MODULE_NAME = "TVKDefinitionSwitchDispatcher";
    private static final AtomicInteger sTaskIdBase = new AtomicInteger(10000);

    public TVKDefinitionSwitchDispatcher(@NonNull TVKContext tVKContext) {
        super(tVKContext, MODULE_NAME);
    }

    private boolean hasUserSwitchDefnTask() {
        for (int i3 = 0; i3 < this.mTasks.size(); i3++) {
            if (this.mTasks.valueAt(i3).info.getDefnSwitchType() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public ITVKSwitchDispatcher.Ret addTask(@NonNull ITVKSwitchDispatcher.SwitchInfo switchInfo) {
        ITVKSwitchDispatcher.Task findTaskBySwitchInfo = findTaskBySwitchInfo(switchInfo);
        if (!isNeedAddTask(findTaskBySwitchInfo)) {
            ITVKSwitchDispatcher.Ret createRet = createRet(findTaskBySwitchInfo, 1);
            findTaskBySwitchInfo.timeMs = SystemClock.elapsedRealtime();
            printForDuplicationTask(switchInfo.getDefinition(), findTaskBySwitchInfo);
            return createRet;
        }
        ITVKSwitchDispatcher.Task task = new ITVKSwitchDispatcher.Task();
        task.type = 0;
        task.taskId = sTaskIdBase.incrementAndGet();
        task.state = 1;
        task.info = switchInfo;
        task.timeMs = SystemClock.elapsedRealtime();
        this.mTasks.put((int) task.taskId, task);
        ITVKSwitchDispatcher.Ret createRet2 = createRet(task, 0);
        if (findTaskBySwitchInfo != null) {
            printForDupTaskAndAddNewTask(task.taskId, findTaskBySwitchInfo.taskId, switchInfo.getDefinition());
        } else {
            printForNoDuplicationTask(task.taskId, switchInfo.getDefinition());
        }
        return createRet2;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public ITVKSwitchDispatcher.Ret driveTaskWhenCGIFailed(long j3) {
        ITVKSwitchDispatcher.Task taskByTaskId = getTaskByTaskId(j3);
        if (taskByTaskId == null) {
            ITVKSwitchDispatcher.Ret createNonExistRet = createNonExistRet();
            printForVideoInfoFailed(j3, 2, "");
            return createNonExistRet;
        }
        if (!isLatestTask(taskByTaskId)) {
            ITVKSwitchDispatcher.Ret createRet = createRet(taskByTaskId, 3);
            taskByTaskId.state = 3;
            printForVideoInfoFailed(j3, 3, taskByTaskId.info.getDefinition());
            return createRet;
        }
        taskByTaskId.state = 3;
        printForVideoInfoFailed(j3, 0, taskByTaskId.info.getDefinition());
        ITVKSwitchDispatcher.Ret createRet2 = createRet(taskByTaskId, 0);
        clear();
        return createRet2;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public ITVKSwitchDispatcher.Ret driveTaskWhenCGISuccess(long j3) {
        ITVKSwitchDispatcher.Task taskByTaskId = getTaskByTaskId(j3);
        if (taskByTaskId == null) {
            ITVKSwitchDispatcher.Ret createNonExistRet = createNonExistRet();
            printForVideoInfoSuccess(j3, 2, "");
            return createNonExistRet;
        }
        if (!isLatestTask(taskByTaskId)) {
            ITVKSwitchDispatcher.Ret createRet = createRet(taskByTaskId, 3);
            taskByTaskId.state = 3;
            printForVideoInfoSuccess(j3, 3, taskByTaskId.info.getDefinition());
            return createRet;
        }
        ITVKSwitchDispatcher.Ret createRet2 = createRet(taskByTaskId, 0);
        taskByTaskId.state = 2;
        printForVideoInfoSuccess(j3, 0, taskByTaskId.info.getDefinition());
        return createRet2;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public ITVKSwitchDispatcher.Ret driveTaskWhenPlayerFailed(long j3) {
        ITVKSwitchDispatcher.Task taskByTaskId = getTaskByTaskId(j3);
        if (taskByTaskId == null) {
            ITVKSwitchDispatcher.Ret createNonExistRet = createNonExistRet();
            printForPlayerSwitchFailed(j3, 2, "");
            return createNonExistRet;
        }
        if (!isLatestTask(taskByTaskId)) {
            ITVKSwitchDispatcher.Ret createRet = createRet(taskByTaskId, 3);
            taskByTaskId.state = 3;
            printForPlayerSwitchFailed(taskByTaskId.taskId, 3, taskByTaskId.info.getDefinition());
            return createRet;
        }
        taskByTaskId.state = 3;
        printForPlayerSwitchFailed(j3, 0, taskByTaskId.info.getDefinition());
        ITVKSwitchDispatcher.Ret createRet2 = createRet(taskByTaskId, 0);
        clear();
        return createRet2;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public ITVKSwitchDispatcher.Ret driveTaskWhenPlayerSuccess(long j3) {
        ITVKSwitchDispatcher.Task taskByTaskId = getTaskByTaskId(j3);
        if (taskByTaskId == null) {
            ITVKSwitchDispatcher.Ret createNonExistRet = createNonExistRet();
            printForPlayerSwitchSuccess(j3, 2, "");
            return createNonExistRet;
        }
        if (!isLatestTask(taskByTaskId)) {
            ITVKSwitchDispatcher.Ret createRet = createRet(taskByTaskId, 3);
            taskByTaskId.state = 3;
            printForPlayerSwitchSuccess(j3, 3, taskByTaskId.info.getDefinition());
            return createRet;
        }
        taskByTaskId.state = 3;
        printForPlayerSwitchSuccess(j3, 0, taskByTaskId.info.getDefinition());
        ITVKSwitchDispatcher.Ret createRet2 = createRet(taskByTaskId, 0);
        clear();
        return createRet2;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKSwitchDispatcherBase
    protected boolean isDuplicateTask(@NonNull ITVKSwitchDispatcher.Task task, @NonNull ITVKSwitchDispatcher.SwitchInfo switchInfo) {
        ITVKSwitchDispatcher.SwitchInfo switchInfo2;
        if (task.type != 0 || (switchInfo2 = task.info) == null || TextUtils.isEmpty(switchInfo2.getTaskName()) || TextUtils.isEmpty(switchInfo.getTaskName()) || task.info.getDefnSwitchType() != switchInfo.getDefnSwitchType() || !task.info.getTaskName().equals(switchInfo.getTaskName())) {
            return false;
        }
        return true;
    }
}
