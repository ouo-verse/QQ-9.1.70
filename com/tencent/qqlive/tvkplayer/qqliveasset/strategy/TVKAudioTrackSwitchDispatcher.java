package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAudioTrackSwitchDispatcher extends TVKSwitchDispatcherBase {
    private static final String MODULE_NAME = "TVKAudioTrackSwitchDispatcher";
    private static AtomicInteger sTaskIdBase = new AtomicInteger(100000);

    public TVKAudioTrackSwitchDispatcher(@NonNull TVKContext tVKContext) {
        super(tVKContext, MODULE_NAME);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public ITVKSwitchDispatcher.Ret addTask(@NonNull ITVKSwitchDispatcher.SwitchInfo switchInfo) {
        ITVKSwitchDispatcher.Task findTaskBySwitchInfo = findTaskBySwitchInfo(switchInfo);
        if (!isNeedAddTask(findTaskBySwitchInfo)) {
            ITVKSwitchDispatcher.Ret createRet = createRet(findTaskBySwitchInfo, 1);
            findTaskBySwitchInfo.timeMs = SystemClock.elapsedRealtime();
            printForDuplicationTask(switchInfo.getAudioTrack(), findTaskBySwitchInfo);
            return createRet;
        }
        ITVKSwitchDispatcher.Task task = new ITVKSwitchDispatcher.Task();
        task.type = 1;
        task.taskId = sTaskIdBase.incrementAndGet();
        task.state = 1;
        task.info = switchInfo;
        task.timeMs = SystemClock.elapsedRealtime();
        this.mTasks.put((int) task.taskId, task);
        ITVKSwitchDispatcher.Ret createRet2 = createRet(task, 0);
        if (findTaskBySwitchInfo != null) {
            printForDupTaskAndAddNewTask(task.taskId, findTaskBySwitchInfo.taskId, switchInfo.getAudioTrack());
        } else {
            printForNoDuplicationTask(task.taskId, switchInfo.getAudioTrack());
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
            printForVideoInfoFailed(j3, 3, taskByTaskId.info.getAudioTrack());
            return createRet;
        }
        taskByTaskId.state = 3;
        printForVideoInfoFailed(j3, 0, taskByTaskId.info.getAudioTrack());
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
            printForVideoInfoSuccess(j3, 3, taskByTaskId.info.getAudioTrack());
            return createRet;
        }
        ITVKSwitchDispatcher.Ret createRet2 = createRet(taskByTaskId, 0);
        taskByTaskId.state = 2;
        printForVideoInfoSuccess(j3, 0, taskByTaskId.info.getAudioTrack());
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
            printForPlayerSwitchFailed(j3, 3, taskByTaskId.info.getAudioTrack());
            return createRet;
        }
        taskByTaskId.state = 3;
        printForPlayerSwitchFailed(j3, 0, taskByTaskId.info.getAudioTrack());
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
            printForPlayerSwitchSuccess(j3, 3, taskByTaskId.info.getAudioTrack());
            return createRet;
        }
        taskByTaskId.state = 3;
        printForPlayerSwitchSuccess(j3, 0, taskByTaskId.info.getAudioTrack());
        ITVKSwitchDispatcher.Ret createRet2 = createRet(taskByTaskId, 0);
        clear();
        return createRet2;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKSwitchDispatcherBase
    protected boolean isDuplicateTask(@NonNull ITVKSwitchDispatcher.Task task, @NonNull ITVKSwitchDispatcher.SwitchInfo switchInfo) {
        ITVKSwitchDispatcher.SwitchInfo switchInfo2;
        if (task.type != 1 || (switchInfo2 = task.info) == null) {
            return false;
        }
        if (!TextUtils.isEmpty(switchInfo2.getAudioTrack()) && !TextUtils.isEmpty(switchInfo.getAudioTrack()) && !task.info.getTaskName().equals(switchInfo.getTaskName())) {
            return false;
        }
        return true;
    }
}
