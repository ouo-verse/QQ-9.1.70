package com.tencent.upload.impl;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.network.session.cache.CacheUtil;
import com.tencent.upload.task.BaseTask;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.task.TaskStateListener;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.BatchControlTask;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.PriorityThreadPoolExecutor;
import com.tencent.upload.utils.pool.ThreadPool;
import com.tencent.upload.utils.pool.UploadThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadTaskManager implements TaskStateListener, SessionPool.PoolStateListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UploadTaskManager";
    private boolean bStopAllLogTask;
    private long last;
    private Handler mHandler;
    private long mMaxDispatchNum;
    private LinkedBlockingQueue<AbstractUploadTask> mRunningList;
    private final Map<String, SessionPool> mSessionPools;
    private LinkedBlockingQueue<AbstractUploadTask> mTaskList;
    private ThreadPool mThreadPool;

    public UploadTaskManager(ThreadPool threadPool, int i3) {
        this(threadPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mMaxDispatchNum = i3;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) threadPool, i3);
        }
    }

    private boolean checkCondition(AbstractUploadTask abstractUploadTask) {
        boolean z16;
        Object obj;
        Object obj2;
        boolean onVerifyUploadFile = abstractUploadTask.onVerifyUploadFile();
        ServerRouteTable serverRouteTable = getServerRouteTable(abstractUploadTask);
        SessionPool sessionPool = this.mSessionPools.get(serverRouteTable.getSessionPoolKey());
        if (sessionPool != null && UploadGlobalConfig.getConfig().checkApnChangeForInit()) {
            z16 = sessionPool.getmRouteStrategy().isApnChanged();
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getSessionPool tableKey:");
        sb5.append(serverRouteTable.getSessionPoolKey());
        sb5.append(" pool:");
        if (sessionPool != null) {
            obj = Integer.valueOf(sessionPool.hashCode());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        sb5.append(" isCheck:");
        sb5.append(z16);
        sb5.append(" ret:");
        sb5.append(onVerifyUploadFile);
        sb5.append(" pool is ready:");
        if (sessionPool != null) {
            obj2 = Boolean.valueOf(sessionPool.isReady());
        } else {
            obj2 = "false";
        }
        sb5.append(obj2);
        UploadLog.d(TAG, sb5.toString());
        if (sessionPool != null && !z16) {
            if (!onVerifyUploadFile || !sessionPool.isReady()) {
                return false;
            }
            return true;
        }
        if (sessionPool != null) {
            UploadLog.d(TAG, "queue:" + sessionPool.getSessionQueueSize() + " detect:" + sessionPool.getDetectingSessionSize() + " id:" + sessionPool.getTag());
        }
        SessionPool sessionPool2 = new SessionPool(serverRouteTable);
        sessionPool2.registerListener(this);
        sessionPool2.init();
        this.mSessionPools.put(serverRouteTable.getSessionPoolKey(), sessionPool2);
        return false;
    }

    private boolean checkEmpty() {
        if (this.mTaskList.size() == 0 && this.mRunningList.size() == 0) {
            UploadLog.d(TAG, "uploadTaskManager checkEmpty empty == true");
            for (SessionPool sessionPool : this.mSessionPools.values()) {
                if (sessionPool != null) {
                    sessionPool.setCloseTimer();
                }
            }
            return true;
        }
        return false;
    }

    private void cleanSessionPools() {
        for (SessionPool sessionPool : this.mSessionPools.values()) {
            if (sessionPool != null) {
                sessionPool.cleanSessions();
            }
        }
        if (UploadGlobalConfig.getConfig().isNeedReleasePool()) {
            UploadLog.d(TAG, "cleanSessionPools...");
            this.mSessionPools.clear();
        }
    }

    private void clearAllLogTask() {
        UploadLog.d(TAG, "clearAllLogTask !");
        synchronized (this.mTaskList) {
            Iterator<AbstractUploadTask> it = this.mTaskList.iterator();
            while (it.hasNext()) {
                AbstractUploadTask next = it.next();
                if (next.getFileType() == Const.FileType.Log) {
                    this.mTaskList.remove(next);
                }
            }
        }
        synchronized (this.mRunningList) {
            Iterator<AbstractUploadTask> it5 = this.mRunningList.iterator();
            while (it5.hasNext()) {
                AbstractUploadTask next2 = it5.next();
                if (next2.getFileType() == Const.FileType.Log) {
                    Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SERVER_DISCONNECT;
                    next2.onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
                }
            }
        }
    }

    private void dumpAllTasksState() {
        StringBuilder sb5 = new StringBuilder("pending:");
        sb5.append(this.mTaskList.size());
        Iterator<AbstractUploadTask> it = this.mTaskList.iterator();
        while (it.hasNext()) {
            AbstractUploadTask next = it.next();
            sb5.append(" [" + next.flowId + " state:" + next.getTaskState() + "]");
        }
        sb5.append(" running:");
        sb5.append(this.mRunningList.size());
        Iterator<AbstractUploadTask> it5 = this.mRunningList.iterator();
        while (it5.hasNext()) {
            AbstractUploadTask next2 = it5.next();
            sb5.append(" [" + next2.flowId + " state:" + next2.getTaskState() + "]");
        }
        UploadLog.d(TAG, sb5.toString());
    }

    public static Const.FileType getFileType(AbstractUploadTask abstractUploadTask) {
        return abstractUploadTask.getUploadTaskType().serverRouteTable.supportFileType;
    }

    public static ServerRouteTable getServerRouteTable(AbstractUploadTask abstractUploadTask) {
        return abstractUploadTask.getUploadTaskType().serverRouteTable;
    }

    public static String getSessionPoolKey(AbstractUploadTask abstractUploadTask) {
        return abstractUploadTask.getUploadTaskType().serverRouteTable.getSessionPoolKey();
    }

    private AbstractUploadTask getTask() {
        String str;
        AbstractUploadTask abstractUploadTask = null;
        if (this.mTaskList.size() <= 0) {
            return null;
        }
        synchronized (this.mTaskList) {
            Iterator<AbstractUploadTask> it = this.mTaskList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractUploadTask next = it.next();
                if (next.getTaskState() == TaskState.WAITING) {
                    this.mTaskList.remove(next);
                    abstractUploadTask = next;
                    break;
                }
            }
        }
        if (abstractUploadTask != null) {
            synchronized (this.mRunningList) {
                this.mRunningList.add(abstractUploadTask);
                abstractUploadTask.bindHandler(this.mHandler);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getTask, move task from pending to running, taskId:");
        if (abstractUploadTask != null) {
            str = abstractUploadTask.getTaskId() + " taskType:" + abstractUploadTask.getClass().getSimpleName();
        } else {
            str = "";
        }
        sb5.append(str);
        UploadLog.d(TAG, sb5.toString());
        return abstractUploadTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (!UploadConfiguration.isNetworkAvailable()) {
            cancelAllTasks();
            return;
        }
        if (this.mRunningList.size() >= this.mMaxDispatchNum) {
            UploadLog.d(TAG, "channel is full now! mMaxDispatchNum:" + this.mMaxDispatchNum + " thread pool:" + UploadThreadManager.getInstance().toString());
            return;
        }
        AbstractUploadTask task = getTask();
        if (task != null && checkCondition(task)) {
            runTask(task);
            return;
        }
        if (task == null) {
            UploadLog.d(TAG, "getTask return null!");
        } else {
            task.setState(TaskState.PAUSE);
            SessionPool sessionPool = this.mSessionPools.get(getSessionPoolKey(task));
            if (sessionPool != null && !sessionPool.isReady()) {
                UploadLog.d(TAG, "getSessionPool: " + sessionPool.hashCode() + " is not ready");
                if (UploadGlobalConfig.getConfig().isSwitchOn(Const.SwitchConfigKey.QQCIRCLE_ENABLE_RESET)) {
                    sessionPool.reset();
                }
            }
        }
        dumpAllTasksState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recovery(String str) {
        UploadLog.d(TAG, "recovery -- mRunningList:" + this.mRunningList.size());
        if (this.mRunningList.size() > 0) {
            Iterator<AbstractUploadTask> it = this.mRunningList.iterator();
            while (it.hasNext()) {
                AbstractUploadTask next = it.next();
                if (getSessionPoolKey(next).equals(str) && (next.getTaskState() == TaskState.FAILED || next.getTaskState() == TaskState.CONNECTING || next.getTaskState() == TaskState.PAUSE)) {
                    UploadLog.d(TAG, "recovery taskId:" + next.getTaskId() + " state:" + next.getTaskState() + ", path:" + next.getFilePath());
                    next.resetTask();
                    runTask(next);
                }
            }
            return;
        }
        next();
    }

    private void runTask(AbstractUploadTask abstractUploadTask) {
        UploadLog.d(TAG, "runTask -- [" + abstractUploadTask.getClass().getSimpleName() + "], flowId:" + abstractUploadTask.flowId + ", path:" + abstractUploadTask.getFilePath());
        CacheUtil.setCachedSessionId(abstractUploadTask);
        PriorityThreadPoolExecutor executor = this.mThreadPool.getExecutor();
        SessionPool sessionPool = getSessionPool(abstractUploadTask);
        if (sessionPool != null) {
            sessionPool.removeCloseTimer();
        }
        abstractUploadTask.bindThreadPool(executor);
        abstractUploadTask.bindSessionPool(sessionPool);
        abstractUploadTask.setTaskId(abstractUploadTask.flowId);
        abstractUploadTask.start();
    }

    @Override // com.tencent.upload.network.session.SessionPool.PoolStateListener
    public void allIpFailed(SessionPool sessionPool, Const.UploadRetCode uploadRetCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) sessionPool, (Object) uploadRetCode);
            return;
        }
        if (sessionPool == null) {
            return;
        }
        if (sessionPool.getPoolType() == Const.FileType.Log) {
            this.bStopAllLogTask = true;
            clearAllLogTask();
            return;
        }
        Iterator<AbstractUploadTask> it = this.mRunningList.iterator();
        while (it.hasNext()) {
            AbstractUploadTask next = it.next();
            UploadLog.d(TAG, "allIpFailed  pool.getTableKey():" + sessionPool.getTableKey() + " task.getTableKey():" + next.getTableKey());
            if (getSessionPoolKey(next).equals(sessionPool.getTableKey()) || (next instanceof BatchControlTask)) {
                if (uploadRetCode != null) {
                    next.onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
                } else {
                    Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.ALL_IP_FAILED;
                    next.onError(uploadRetCode2.getCode(), uploadRetCode2.getDesc());
                }
            }
        }
    }

    public void cancelAllTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            UploadLog.d(TAG, "cancelAllTasks --- ");
            this.mHandler.post(new Runnable() { // from class: com.tencent.upload.impl.UploadTaskManager.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadTaskManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        synchronized (UploadTaskManager.this.mTaskList) {
                            UploadTaskManager.this.mTaskList.clear();
                        }
                        synchronized (UploadTaskManager.this.mRunningList) {
                            Iterator it = UploadTaskManager.this.mRunningList.iterator();
                            while (it.hasNext()) {
                                ((AbstractUploadTask) it.next()).cancel();
                            }
                            UploadTaskManager.this.mRunningList.clear();
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    public void cancelTask(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) abstractUploadTask);
        } else {
            this.mHandler.post(new Runnable(abstractUploadTask) { // from class: com.tencent.upload.impl.UploadTaskManager.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ AbstractUploadTask val$out;

                {
                    this.val$out = abstractUploadTask;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadTaskManager.this, (Object) abstractUploadTask);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractUploadTask abstractUploadTask2;
                    AbstractUploadTask abstractUploadTask3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.val$out == null) {
                        return;
                    }
                    UploadLog.d(UploadTaskManager.TAG, "remove task, flowId: " + this.val$out.flowId + ", path:" + this.val$out.uploadFilePath);
                    synchronized (UploadTaskManager.this.mTaskList) {
                        Iterator it = UploadTaskManager.this.mTaskList.iterator();
                        while (true) {
                            abstractUploadTask2 = null;
                            if (it.hasNext()) {
                                abstractUploadTask3 = (AbstractUploadTask) it.next();
                                if (abstractUploadTask3.flowId == this.val$out.flowId) {
                                    break;
                                }
                            } else {
                                abstractUploadTask3 = null;
                                break;
                            }
                        }
                        if (abstractUploadTask3 == null) {
                            synchronized (UploadTaskManager.this.mRunningList) {
                                Iterator it5 = UploadTaskManager.this.mRunningList.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    }
                                    AbstractUploadTask abstractUploadTask4 = (AbstractUploadTask) it5.next();
                                    if (abstractUploadTask4.flowId == this.val$out.flowId) {
                                        abstractUploadTask2 = abstractUploadTask4;
                                        break;
                                    }
                                }
                                if (abstractUploadTask2 != null) {
                                    UploadTaskManager.this.mRunningList.remove(abstractUploadTask2);
                                    abstractUploadTask2.cancel();
                                }
                            }
                            UploadTaskManager.this.next();
                            return;
                        }
                        UploadTaskManager.this.mTaskList.remove(abstractUploadTask3);
                    }
                }
            });
        }
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        UploadLog.d(TAG, "uploadTaskManger is close... clear list !!!");
        this.mTaskList.clear();
        this.mRunningList.clear();
        cleanSessionPools();
    }

    public int getRemainTaskSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        dumpAllTasksState();
        LinkedBlockingQueue<AbstractUploadTask> linkedBlockingQueue = this.mTaskList;
        int i3 = 0;
        if (linkedBlockingQueue != null && this.mRunningList != null) {
            Iterator<AbstractUploadTask> it = linkedBlockingQueue.iterator();
            while (it.hasNext()) {
                AbstractUploadTask next = it.next();
                if (next.getTaskState().getCode() != TaskState.CANCEL.getCode() && next.getTaskState().getCode() != TaskState.FAILED.getCode() && next.getTaskState().getCode() != TaskState.SUCCEED.getCode()) {
                    i3++;
                }
            }
            Iterator<AbstractUploadTask> it5 = this.mRunningList.iterator();
            while (it5.hasNext()) {
                AbstractUploadTask next2 = it5.next();
                if (next2.getTaskState().getCode() != TaskState.CANCEL.getCode() && next2.getTaskState().getCode() != TaskState.FAILED.getCode() && next2.getTaskState().getCode() != TaskState.SUCCEED.getCode()) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public SessionPool getSessionPool(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SessionPool) iPatchRedirector.redirect((short) 7, (Object) this, (Object) abstractUploadTask);
        }
        return this.mSessionPools.get(getSessionPoolKey(abstractUploadTask));
    }

    @Override // com.tencent.upload.network.session.SessionPool.PoolStateListener
    public boolean hasRemainTasks(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).booleanValue();
        }
        Iterator<AbstractUploadTask> it = this.mTaskList.iterator();
        while (it.hasNext()) {
            if (getSessionPoolKey(it.next()).equals(str)) {
                return true;
            }
        }
        Iterator<AbstractUploadTask> it5 = this.mRunningList.iterator();
        while (it5.hasNext()) {
            if (getSessionPoolKey(it5.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.upload.network.session.SessionPool.PoolStateListener
    public void onNetWorkConnectFail(SessionPool sessionPool, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, sessionPool, Integer.valueOf(i3), str);
            return;
        }
        UploadLog.d(TAG, "onNetWorkConnectFail:" + i3 + " mTaskList:" + this.mTaskList.size() + " mRunningList:" + this.mRunningList.size());
        if (sessionPool.getPoolType() == Const.FileType.Log) {
            this.bStopAllLogTask = true;
            clearAllLogTask();
            return;
        }
        Iterator<AbstractUploadTask> it = this.mTaskList.iterator();
        while (it.hasNext()) {
            AbstractUploadTask next = it.next();
            UploadLog.d(TAG, "mTaskList onNetWorkConnectFail  pool.getTableKey():" + sessionPool.getTableKey() + " task.getTableKey():" + next.getTableKey());
            if (getSessionPoolKey(next).equals(sessionPool.getTableKey()) || (next instanceof BatchControlTask)) {
                next.onError(i3, str);
            }
        }
        Iterator<AbstractUploadTask> it5 = this.mRunningList.iterator();
        while (it5.hasNext()) {
            AbstractUploadTask next2 = it5.next();
            UploadLog.d(TAG, "mRunningList onNetWorkConnectFail  pool.getTableKey():" + sessionPool.getTableKey() + " task.getTableKey():" + next2.getTableKey());
            if (getSessionPoolKey(next2).equals(sessionPool.getTableKey()) || (next2 instanceof BatchControlTask)) {
                next2.onError(i3, str);
            }
        }
        cancelAllTasks();
    }

    @Override // com.tencent.upload.network.session.SessionPool.PoolStateListener
    public void onSessionPoolError(SessionPool sessionPool, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) sessionPool, i3);
            return;
        }
        UploadLog.d(TAG, sessionPool.getTag() + " no available sessions !");
        if (hasRemainTasks(sessionPool.getTableKey())) {
            UploadLog.d(TAG, "hasRemainTask == true;");
            if (System.currentTimeMillis() - this.last > 1000) {
                sessionPool.rebuildSessions();
                this.last = System.currentTimeMillis();
                UploadLog.d(TAG, "rebuildSessions;");
            }
        }
    }

    @Override // com.tencent.upload.network.session.SessionPool.PoolStateListener
    public void onSessionPoolRestore(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        UploadLog.w(TAG, "onSessionPoolRestore sessionPoolKey: " + str);
        this.mHandler.postDelayed(new Runnable(str) { // from class: com.tencent.upload.impl.UploadTaskManager.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$sessionPoolKey;

            {
                this.val$sessionPoolKey = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadTaskManager.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    UploadTaskManager.this.recovery(this.val$sessionPoolKey);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 500L);
    }

    @Override // com.tencent.upload.task.TaskStateListener
    public void onTaskFinished(BaseTask baseTask, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, baseTask, Integer.valueOf(i3), str);
            return;
        }
        if (baseTask instanceof AbstractUploadTask) {
            UploadLog.d(TAG, "taskId:" + baseTask.getTaskId() + " onTaskFinished state: " + baseTask.getTaskState() + " ret:" + i3 + " msg:" + str);
            if (baseTask.getTaskState() == TaskState.SUCCEED) {
                synchronized (this.mRunningList) {
                    this.mRunningList.remove(baseTask);
                    UploadLog.d(TAG, "remove -- flowid:" + ((AbstractUploadTask) baseTask).flowId);
                }
                if (!checkEmpty()) {
                    next();
                    return;
                }
                return;
            }
            if (baseTask.getTaskState() == TaskState.FAILED || baseTask.getTaskState() == TaskState.CANCEL) {
                synchronized (this.mRunningList) {
                    this.mRunningList.remove(baseTask);
                    UploadLog.d(TAG, "remove -- flowid:" + ((AbstractUploadTask) baseTask).flowId);
                }
                if (baseTask.getFileType() == Const.FileType.Log && i3 == Const.UploadRetCode.SERVER_DISCONNECT.getCode()) {
                    this.bStopAllLogTask = true;
                    clearAllLogTask();
                }
            }
        }
        if (i3 == Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode()) {
            UploadLog.w(TAG, "taskId:" + baseTask.getTaskId() + " post next() delay 500ms");
            this.mHandler.postAtTime(new Runnable() { // from class: com.tencent.upload.impl.UploadTaskManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadTaskManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        UploadTaskManager.this.next();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 500L);
            return;
        }
        next();
    }

    @Override // com.tencent.upload.task.TaskStateListener
    public void onTaskInfoChanged(BaseTask baseTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) baseTask);
        }
    }

    public void prepare(ServerRouteTable serverRouteTable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serverRouteTable);
            return;
        }
        if (this.mSessionPools.get(serverRouteTable.getSessionPoolKey()) == null) {
            UploadLog.d(TAG, "prepare pool == null need create new, key:" + serverRouteTable.getSessionPoolKey());
            SessionPool sessionPool = new SessionPool(serverRouteTable);
            sessionPool.registerListener(this);
            sessionPool.init();
            this.mSessionPools.put(serverRouteTable.getSessionPoolKey(), sessionPool);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        for (SessionPool sessionPool : this.mSessionPools.values()) {
            if (sessionPool != null) {
                sessionPool.reset();
            }
        }
    }

    public boolean sendAsync(AbstractUploadTask abstractUploadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        if (abstractUploadTask == null) {
            return false;
        }
        if (this.bStopAllLogTask && abstractUploadTask.getFileType() == Const.FileType.Log) {
            UploadLog.d(TAG, "bStopAllLogTask now ! ");
            return false;
        }
        if (abstractUploadTask.getTaskState() != TaskState.WAITING) {
            abstractUploadTask.resetWaitState();
        }
        synchronized (this.mTaskList) {
            this.mTaskList.add(abstractUploadTask);
            abstractUploadTask.setTaskStateListener(this);
        }
        if (!UploadConfiguration.isNetworkAvailable()) {
            UploadLog.w(TAG, "sendAsync network is not available");
            prepare(getServerRouteTable(abstractUploadTask));
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
            abstractUploadTask.onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
            return false;
        }
        return this.mHandler.post(new Runnable() { // from class: com.tencent.upload.impl.UploadTaskManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadTaskManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    UploadTaskManager.this.next();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    public UploadTaskManager(ThreadPool threadPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) threadPool);
            return;
        }
        this.mMaxDispatchNum = 1L;
        this.mThreadPool = threadPool;
        this.mSessionPools = new HashMap();
        this.mTaskList = new LinkedBlockingQueue<>();
        this.mRunningList = new LinkedBlockingQueue<>();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Dispatcher");
        baseHandlerThread.start();
        this.mHandler = new Handler(baseHandlerThread.getLooper());
    }

    public AbstractUploadTask getTask(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AbstractUploadTask) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        for (AbstractUploadTask abstractUploadTask : new ArrayList(this.mTaskList)) {
            if (i3 == abstractUploadTask.getTaskId()) {
                return abstractUploadTask;
            }
        }
        return null;
    }
}
