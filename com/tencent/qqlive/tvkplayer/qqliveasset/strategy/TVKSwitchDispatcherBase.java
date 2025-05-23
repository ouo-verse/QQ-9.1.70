package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKSwitchDispatcherBase implements ITVKSwitchDispatcher {

    @NonNull
    protected final ITVKLogger mLogger;
    protected SparseArray<ITVKSwitchDispatcher.Task> mTasks = new SparseArray<>();

    public TVKSwitchDispatcherBase(@NonNull TVKContext tVKContext, String str) {
        this.mLogger = new TVKLogger(tVKContext, str);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public void clear() {
        this.mTasks.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ITVKSwitchDispatcher.Ret createNonExistRet() {
        ITVKSwitchDispatcher.Ret ret = new ITVKSwitchDispatcher.Ret();
        ret.taskId = -1L;
        ret.retCode = 2;
        return ret;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ITVKSwitchDispatcher.Ret createRet(@NonNull ITVKSwitchDispatcher.Task task, int i3) {
        ITVKSwitchDispatcher.Ret ret = new ITVKSwitchDispatcher.Ret();
        ret.taskId = task.taskId;
        ret.info = task.info;
        ret.type = task.type;
        ret.retCode = i3;
        return ret;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ITVKSwitchDispatcher.Task findTaskBySwitchInfo(@NonNull ITVKSwitchDispatcher.SwitchInfo switchInfo) {
        for (int i3 = 0; i3 < this.mTasks.size(); i3++) {
            ITVKSwitchDispatcher.Task valueAt = this.mTasks.valueAt(i3);
            if (isDuplicateTask(valueAt, switchInfo)) {
                return valueAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public ITVKSwitchDispatcher.Task getTaskByTaskId(long j3) {
        return this.mTasks.get((int) j3);
    }

    protected abstract boolean isDuplicateTask(@NonNull ITVKSwitchDispatcher.Task task, @NonNull ITVKSwitchDispatcher.SwitchInfo switchInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLatestTask(ITVKSwitchDispatcher.Task task) {
        for (int i3 = 0; i3 < this.mTasks.size(); i3++) {
            if (task != this.mTasks.valueAt(i3) && task.type == this.mTasks.valueAt(i3).type && task.timeMs < this.mTasks.valueAt(i3).timeMs) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedAddTask(@Nullable ITVKSwitchDispatcher.Task task) {
        if (task == null) {
            return true;
        }
        this.mLogger.info("isNeedAddTask, duplicateTask taskId:" + task.taskId + ", state:" + task.state + ", isLatestTask:" + isLatestTask(task), new Object[0]);
        if (!isLatestTask(task)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printForDupTaskAndAddNewTask(long j3, long j16, String str) {
        this.mLogger.info("**************************************", new Object[0]);
        this.mLogger.info("add new task , duplicate task ", new Object[0]);
        this.mLogger.info("duplicate task switch defn/track : " + str, new Object[0]);
        this.mLogger.info("duplicate task state : player switching", new Object[0]);
        this.mLogger.info("duplicate task id : " + j16, new Object[0]);
        this.mLogger.info("duplicate task action : add new one", new Object[0]);
        this.mLogger.info("new task switch defn/track : " + str, new Object[0]);
        this.mLogger.info("new task id : " + j3, new Object[0]);
        this.mLogger.info("**************************************", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printForDuplicationTask(String str, @NonNull ITVKSwitchDispatcher.Task task) {
        String str2;
        int i3 = task.state;
        if (i3 == 2) {
            str2 = "switching";
        } else if (i3 == 1) {
            str2 = "video info";
        } else {
            return;
        }
        this.mLogger.warn("**************************************", new Object[0]);
        this.mLogger.warn("add new task , duplicate task ", new Object[0]);
        this.mLogger.warn("duplicate task switch defn/track : " + str, new Object[0]);
        this.mLogger.warn("duplicate task state : " + str2, new Object[0]);
        this.mLogger.warn("duplicate task id : " + task.taskId, new Object[0]);
        this.mLogger.warn("duplicate task action : don't add new", new Object[0]);
        this.mLogger.warn("**************************************", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printForNoDuplicationTask(long j3, String str) {
        this.mLogger.info("**************************************", new Object[0]);
        this.mLogger.info("add new task , no duplicate task", new Object[0]);
        this.mLogger.info("new task switch defn/track : " + str, new Object[0]);
        this.mLogger.info("new task id : " + j3, new Object[0]);
        this.mLogger.info("**************************************", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printForPlayerSwitchFailed(long j3, int i3, String str) {
        if (i3 == 2) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("player switch failed : task id :" + j3, new Object[0]);
            this.mLogger.warn("player switch failed : task not exist", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 3) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("player switch failed : task id :" + j3, new Object[0]);
            this.mLogger.warn("player switch failed : task switch defn/track :" + str, new Object[0]);
            this.mLogger.warn("player switch failed : task not latest", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 0) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("player switch failed : task id :" + j3, new Object[0]);
            this.mLogger.warn("player switch failed : task switch defn/track :" + str, new Object[0]);
            this.mLogger.warn("player switch failed : task is latest", new Object[0]);
            this.mLogger.warn("player switch failed : task complete", new Object[0]);
            this.mLogger.warn("player switch failed : task complete , clear tasks", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printForPlayerSwitchSuccess(long j3, int i3, String str) {
        if (i3 == 2) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("player switch success : task id :" + j3, new Object[0]);
            this.mLogger.warn("player switch success : task not exist", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 3) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("player switch success : task id :" + j3, new Object[0]);
            this.mLogger.warn("player switch success : task switch defn/track :" + str, new Object[0]);
            this.mLogger.warn("player switch success : task not latest", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 0) {
            this.mLogger.info("**************************************", new Object[0]);
            this.mLogger.info("player switch success : task id :" + j3, new Object[0]);
            this.mLogger.info("player switch success : task switch defn/track :" + str, new Object[0]);
            this.mLogger.info("player switch success : task is latest", new Object[0]);
            this.mLogger.info("player switch success : task complete", new Object[0]);
            this.mLogger.info("player switch success : task complete , clear tasks", new Object[0]);
            this.mLogger.info("**************************************", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printForVideoInfoFailed(long j3, int i3, String str) {
        if (i3 == 2) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("video info failed : task id :" + j3, new Object[0]);
            this.mLogger.warn("video info failed : task not exist", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 3) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("video info failed : task id :" + j3, new Object[0]);
            this.mLogger.warn("video info failed : task switch defn/track :" + str, new Object[0]);
            this.mLogger.warn("video info failed : task not latest", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 0) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("video info failed : task id :" + j3, new Object[0]);
            this.mLogger.warn("video info failed : task switch defn/track :" + str, new Object[0]);
            this.mLogger.warn("video info failed : task is latest", new Object[0]);
            this.mLogger.warn("video info failed : task complete", new Object[0]);
            this.mLogger.warn("video info failed : task complete , clear tasks", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printForVideoInfoSuccess(long j3, int i3, String str) {
        if (i3 == 2) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("video info success : task id :" + j3, new Object[0]);
            this.mLogger.warn("video info success : task not exist", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 3) {
            this.mLogger.warn("**************************************", new Object[0]);
            this.mLogger.warn("video info success : task id :" + j3, new Object[0]);
            this.mLogger.warn("video info success : task switch defn/track :" + str, new Object[0]);
            this.mLogger.warn("video info success : task not latest", new Object[0]);
            this.mLogger.warn("**************************************", new Object[0]);
            return;
        }
        if (i3 == 0) {
            this.mLogger.info("**************************************", new Object[0]);
            this.mLogger.info("video info success : task id :" + j3, new Object[0]);
            this.mLogger.info("video info success : task switch defn/track :" + str, new Object[0]);
            this.mLogger.info("video info success : mark to switching", new Object[0]);
            this.mLogger.info("**************************************", new Object[0]);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher
    public ITVKSwitchDispatcher.Ret queryTaskByTaskId(long j3) {
        ITVKSwitchDispatcher.Task taskByTaskId = getTaskByTaskId(j3);
        if (taskByTaskId == null) {
            return createNonExistRet();
        }
        return createRet(taskByTaskId, 0);
    }
}
