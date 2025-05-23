package com.tencent.biz.richframework.queue;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.queue.RFWDownloadQueue;
import com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloadQueueDispatcher {
    private final Handler mQueueHandler;
    private final RFWDownloadStateProgressBox mStateProgressBox;
    private final Map<String, Map<String, RFWDownloadTask>> mTaskMap = new HashMap();
    private final Handler mUIHandler = new Handler(Looper.getMainLooper());

    public RFWDownloadQueueDispatcher(Handler handler, RFWDownloadStateProgressBox rFWDownloadStateProgressBox) {
        this.mQueueHandler = handler;
        this.mStateProgressBox = rFWDownloadStateProgressBox;
    }

    private void addNewTaskToMap(RFWDownloadTask rFWDownloadTask) {
        if (rFWDownloadTask != null && rFWDownloadTask.getStrategy() != null) {
            RFWDownloadTask task = getTask(rFWDownloadTask.getStrategy(), rFWDownloadTask.getUrl());
            if (task != null) {
                RFWLog.w("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[addNewTaskToMap] task already has , task = " + task);
                return;
            }
            Map<String, RFWDownloadTask> map = this.mTaskMap.get(rFWDownloadTask.getStrategy().getBusinessKey());
            if (map == null) {
                map = new HashMap<>();
                this.mTaskMap.put(rFWDownloadTask.getStrategy().getBusinessKey(), map);
            }
            map.put(rFWDownloadTask.getUrl(), rFWDownloadTask);
            RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[addNewTaskToMap]  newTask = " + rFWDownloadTask);
            RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
            if (rFWDownloadStateProgressBox != null) {
                rFWDownloadStateProgressBox.updateTaskEntry(rFWDownloadTask);
            }
        }
    }

    private RFWDownloadTask getTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str) {
        Map<String, RFWDownloadTask> map;
        if (rFWDownloadQueueStrategy == null || (map = this.mTaskMap.get(rFWDownloadQueueStrategy.getBusinessKey())) == null) {
            return null;
        }
        return map.get(str);
    }

    private List<RFWDownloadTask> getTaskList(String str) {
        Map<String, RFWDownloadTask> map;
        if (TextUtils.isEmpty(str) || (map = this.mTaskMap.get(str)) == null) {
            return null;
        }
        return new ArrayList(map.values());
    }

    private void handlePauseSingleTask(RFWDownloadTask rFWDownloadTask) {
        if (rFWDownloadTask == null) {
            return;
        }
        if (rFWDownloadTask.getState() == DownloadState.STATE_WAITING || rFWDownloadTask.getState() == DownloadState.STATE_START_RUN || rFWDownloadTask.getState() == DownloadState.STATE_RUNNING) {
            rFWDownloadTask.pauseTask();
            RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
            if (rFWDownloadStateProgressBox != null) {
                rFWDownloadStateProgressBox.updateTaskEntry(rFWDownloadTask);
            }
        }
    }

    private void handleQueryTaskStateListCallback(final RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback, final List<RFWDownloadTaskStateData> list) {
        this.mUIHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.queue.i
            @Override // java.lang.Runnable
            public final void run() {
                RFWDownloadQueueDispatcher.lambda$handleQueryTaskStateListCallback$2(RFWDownloadQueue.QueryBizTaskStateCallback.this, list);
            }
        });
    }

    private void handleTransformAddTask(List<RFWDownloadTaskStateData> list, RFWDownloadQueueStrategy rFWDownloadQueueStrategy) {
        if (list != null && !list.isEmpty() && rFWDownloadQueueStrategy != null) {
            ListIterator<RFWDownloadTaskStateData> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                RFWDownloadTaskStateData next = listIterator.next();
                if (rFWDownloadQueueStrategy.supportClearByTaskState(next.getState())) {
                    listIterator.remove();
                    RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[handleTransformAddTask] clear task cache, stateData = " + next);
                } else {
                    addNewTaskToMap(RFWDownloadQueueUtils.stateDataTransformTask(next, this.mQueueHandler, rFWDownloadQueueStrategy, this.mStateProgressBox));
                }
                if (rFWDownloadQueueStrategy.getTaskLocalStorageDelegate() != null && rFWDownloadQueueStrategy.getTaskLocalStorageDelegate().supportClearByTaskState(next.getState())) {
                    RFWDownloadQueueLocalStorageHelper.deleteTaskEntry(next, rFWDownloadQueueStrategy.getTaskLocalStorageDelegate());
                    RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[handleTransformAddTask] clear local storage, stateData = " + next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBizTaskStateList$0(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback, List list) {
        String str;
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getBizTaskStateList] fromDb | stateDataList = ");
        if (list != null) {
            str = Arrays.toString(list.toArray());
        } else {
            str = null;
        }
        sb5.append(str);
        RFWLog.i("DQ-RFWDownloadQueueDispatcher", i3, sb5.toString());
        handleTransformAddTask(list, rFWDownloadQueueStrategy);
        handleQueryTaskStateListCallback(queryBizTaskStateCallback, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleQueryTaskStateListCallback$2(RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback, List list) {
        if (queryBizTaskStateCallback != null) {
            queryBizTaskStateCallback.onTaskListRsp(list);
        }
    }

    private void sendMsgTriggerNextTaskRun(RFWDownloadQueueStrategy rFWDownloadQueueStrategy) {
        Message message = new Message();
        message.what = 1001;
        message.obj = rFWDownloadQueueStrategy;
        this.mQueueHandler.sendMessage(message);
    }

    private void startCreateNewTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo) {
        if (rFWDownloadQueueStrategy != null && rFWDownloadQueueTaskInfo != null) {
            RFWDownloadTask rFWDownloadTask = new RFWDownloadTask(rFWDownloadQueueStrategy, rFWDownloadQueueTaskInfo.getUrl(), this.mQueueHandler, this.mStateProgressBox);
            rFWDownloadTask.setExtMap(rFWDownloadQueueTaskInfo.getExtMap());
            rFWDownloadTask.waitTask();
            addNewTaskToMap(rFWDownloadTask);
            sendMsgTriggerNextTaskRun(rFWDownloadQueueStrategy);
        }
    }

    public void addTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo) {
        if (rFWDownloadQueueStrategy != null && rFWDownloadQueueTaskInfo != null) {
            RFWDownloadTask task = getTask(rFWDownloadQueueStrategy, rFWDownloadQueueTaskInfo.getUrl());
            if (task != null) {
                RFWLog.w("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[addTask] task already has task = " + task);
                if (task.getState() == DownloadState.STATE_ERROR || task.getState() == DownloadState.STATE_PAUSE) {
                    task.waitTask();
                }
                sendMsgTriggerNextTaskRun(rFWDownloadQueueStrategy);
                return;
            }
            startCreateNewTask(rFWDownloadQueueStrategy, rFWDownloadQueueTaskInfo);
            return;
        }
        RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[addTask]  params error | strategy = " + rFWDownloadQueueStrategy + " | taskInfo = " + rFWDownloadQueueTaskInfo);
    }

    public void cancelBizAllTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy) {
        if (rFWDownloadQueueStrategy == null) {
            RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[cancelBizAllTask]  strategy == null");
            return;
        }
        List<RFWDownloadTask> taskList = getTaskList(rFWDownloadQueueStrategy.getBusinessKey());
        if (taskList != null && taskList.size() != 0) {
            for (RFWDownloadTask rFWDownloadTask : taskList) {
                RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[cancelBizAllTask]  task = " + rFWDownloadTask);
                rFWDownloadTask.cancelTask();
                clearCurrentTask(rFWDownloadTask);
            }
            return;
        }
        RFWLog.w("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[cancelBizAllTask]  taskList == null");
    }

    public void cancelTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str) {
        if (rFWDownloadQueueStrategy != null && !TextUtils.isEmpty(str)) {
            RFWDownloadTask task = getTask(rFWDownloadQueueStrategy, str);
            if (task == null) {
                RFWLog.w("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[cancelTask]  task == null");
                return;
            }
            RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[cancelTask]  task = " + task);
            task.cancelTask();
            clearCurrentTask(task);
            return;
        }
        RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[cancelTask]  params error, strategy = " + rFWDownloadQueueStrategy + " , url = " + str);
    }

    public void clearCurrentTask(RFWDownloadTask rFWDownloadTask) {
        Map<String, RFWDownloadTask> map;
        if (rFWDownloadTask != null && rFWDownloadTask.getStrategy() != null) {
            if (rFWDownloadTask.getStrategy().supportClearByTaskState(rFWDownloadTask.getState()) && (map = this.mTaskMap.get(rFWDownloadTask.getStrategy().getBusinessKey())) != null) {
                map.remove(rFWDownloadTask.getUrl());
                RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[clearCurrentTask] clear task cache, task = " + rFWDownloadTask);
            }
            if (rFWDownloadTask.getStrategy().getTaskLocalStorageDelegate() != null && rFWDownloadTask.getStrategy().getTaskLocalStorageDelegate().supportClearByTaskState(rFWDownloadTask.getState()) && this.mStateProgressBox != null) {
                RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[clearCurrentTask] clear local storage, task = " + rFWDownloadTask);
                this.mStateProgressBox.deleteTaskEntry(rFWDownloadTask);
                return;
            }
            return;
        }
        RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[clearCurrentTask]  params error, task = " + rFWDownloadTask);
    }

    public void continueTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str) {
        if (rFWDownloadQueueStrategy != null && !TextUtils.isEmpty(str)) {
            RFWDownloadTask task = getTask(rFWDownloadQueueStrategy, str);
            RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[continueTask]  task = " + task);
            if (task == null) {
                RFWLog.w("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[continueTask]  task == null");
                return;
            }
            task.runTask();
            RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
            if (rFWDownloadStateProgressBox != null) {
                rFWDownloadStateProgressBox.updateTaskEntry(task);
                return;
            }
            return;
        }
        RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[continueTask]  params error, strategy = " + rFWDownloadQueueStrategy + " , url = " + str);
    }

    public void getBizTaskStateList(final RFWDownloadQueueStrategy rFWDownloadQueueStrategy, final RFWDownloadQueue.QueryBizTaskStateCallback queryBizTaskStateCallback) {
        if (rFWDownloadQueueStrategy == null) {
            RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[getBizTaskStateList]  params error, strategy = null");
            return;
        }
        List<RFWDownloadTaskStateData> taskListTransformStateDataList = RFWDownloadQueueUtils.taskListTransformStateDataList(getTaskList(rFWDownloadQueueStrategy.getBusinessKey()));
        if (taskListTransformStateDataList != null && taskListTransformStateDataList.size() != 0) {
            RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[getBizTaskStateList] fromMap | stateDataList = " + Arrays.toString(taskListTransformStateDataList.toArray()));
            handleQueryTaskStateListCallback(queryBizTaskStateCallback, taskListTransformStateDataList);
            return;
        }
        RFWDownloadQueueLocalStorageHelper.queryTaskEntryList(rFWDownloadQueueStrategy.getBusinessKey(), rFWDownloadQueueStrategy.getTaskLocalStorageDelegate(), new RFWDownloadTaskLocalStorageDelegate.OnQueryTaskListCallback() { // from class: com.tencent.biz.richframework.queue.h
            @Override // com.tencent.biz.richframework.queue.RFWDownloadTaskLocalStorageDelegate.OnQueryTaskListCallback
            public final void onResult(List list) {
                RFWDownloadQueueDispatcher.this.lambda$getBizTaskStateList$0(rFWDownloadQueueStrategy, queryBizTaskStateCallback, list);
            }
        });
    }

    public void pauseTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, String str) {
        if (rFWDownloadQueueStrategy != null && !TextUtils.isEmpty(str)) {
            RFWDownloadTask task = getTask(rFWDownloadQueueStrategy, str);
            if (task == null) {
                RFWLog.w("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[pauseTask]  task == null");
                return;
            }
            RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[pauseTask]  task = " + task);
            handlePauseSingleTask(task);
            sendMsgTriggerNextTaskRun(rFWDownloadQueueStrategy);
            return;
        }
        RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[pauseTask]  params error, strategy = " + rFWDownloadQueueStrategy + " , url = " + str);
    }

    public void triggerRunNextTask(RFWDownloadQueueStrategy rFWDownloadQueueStrategy) {
        int i3 = 0;
        if (rFWDownloadQueueStrategy == null) {
            RFWLog.e("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[triggerRunNextTask]  strategy == null");
            return;
        }
        List<RFWDownloadTask> taskList = getTaskList(rFWDownloadQueueStrategy.getBusinessKey());
        if (taskList != null && !taskList.isEmpty()) {
            RFWDownloadTask rFWDownloadTask = null;
            for (RFWDownloadTask rFWDownloadTask2 : taskList) {
                if (rFWDownloadTask2.getState() != DownloadState.STATE_RUNNING && rFWDownloadTask2.getState() != DownloadState.STATE_START_RUN) {
                    if (rFWDownloadTask == null && rFWDownloadTask2.getState() == DownloadState.STATE_WAITING) {
                        rFWDownloadTask = rFWDownloadTask2;
                    }
                } else {
                    i3++;
                }
            }
            if (i3 < rFWDownloadQueueStrategy.getRunMaxCount() && rFWDownloadTask != null) {
                rFWDownloadTask.runTask();
                RFWDownloadStateProgressBox rFWDownloadStateProgressBox = this.mStateProgressBox;
                if (rFWDownloadStateProgressBox != null) {
                    rFWDownloadStateProgressBox.updateTaskEntry(rFWDownloadTask);
                }
            }
            RFWLog.i("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[triggerRunNextTask]   | taskList.size = " + taskList.size() + " | runningCount = " + i3 + " | strategy.getRunMaxCount = " + rFWDownloadQueueStrategy.getRunMaxCount() + " | waitTopTask = " + rFWDownloadTask);
            return;
        }
        RFWLog.w("DQ-RFWDownloadQueueDispatcher", RFWLog.USR, "[triggerRunNextTask]  taskList == null");
    }
}
