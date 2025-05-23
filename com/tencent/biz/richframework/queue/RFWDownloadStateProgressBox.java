package com.tencent.biz.richframework.queue;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class RFWDownloadStateProgressBox {
    private final Map<String, List<RFWDownloadQueueResultListener>> mDownloadResultListenerMap = new HashMap();
    private final Handler mUIHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyTaskCallback$0(List list, RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RFWDownloadQueueResultListener rFWDownloadQueueResultListener = (RFWDownloadQueueResultListener) it.next();
                if (rFWDownloadQueueResultListener != null) {
                    rFWDownloadQueueResultListener.onStateChange(rFWDownloadTaskStateData);
                }
            }
        }
    }

    private RFWDownloadTaskStateData notifyTaskCallback(RFWDownloadTask rFWDownloadTask) {
        final RFWDownloadTaskStateData taskTransformStateData = RFWDownloadQueueUtils.taskTransformStateData(rFWDownloadTask);
        if (taskTransformStateData != null && !TextUtils.isEmpty(taskTransformStateData.getBusinessKey())) {
            final List<RFWDownloadQueueResultListener> list = this.mDownloadResultListenerMap.get(taskTransformStateData.getBusinessKey());
            this.mUIHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.queue.j
                @Override // java.lang.Runnable
                public final void run() {
                    RFWDownloadStateProgressBox.lambda$notifyTaskCallback$0(list, taskTransformStateData);
                }
            });
            return taskTransformStateData;
        }
        return null;
    }

    public void addDownloadListener(RFWDownloadQueueStrategy rFWDownloadQueueStrategy, RFWDownloadQueueResultListener rFWDownloadQueueResultListener) {
        if (rFWDownloadQueueStrategy != null && rFWDownloadQueueResultListener != null) {
            List<RFWDownloadQueueResultListener> list = this.mDownloadResultListenerMap.get(rFWDownloadQueueStrategy.getBusinessKey());
            if (list == null) {
                list = new ArrayList<>();
                this.mDownloadResultListenerMap.put(rFWDownloadQueueStrategy.getBusinessKey(), list);
            }
            Iterator<RFWDownloadQueueResultListener> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == rFWDownloadQueueResultListener) {
                    RFWLog.d("DQ-RFWDownloadStateProgressBox", RFWLog.USR, "[addDownloadListener]  has register | strategy.businessKey = " + rFWDownloadQueueStrategy.getBusinessKey() + " | listener = " + rFWDownloadQueueResultListener);
                    return;
                }
            }
            list.add(rFWDownloadQueueResultListener);
            RFWLog.d("DQ-RFWDownloadStateProgressBox", RFWLog.USR, "[addDownloadListener]  | strategy.businessKey = " + rFWDownloadQueueStrategy.getBusinessKey() + " | listener = " + rFWDownloadQueueResultListener + " | listenerList.size = " + list.size());
        }
    }

    public void deleteTaskEntry(RFWDownloadTask rFWDownloadTask) {
        RFWDownloadTaskStateData taskTransformStateData;
        if (rFWDownloadTask == null || rFWDownloadTask.getStrategy() == null || (taskTransformStateData = RFWDownloadQueueUtils.taskTransformStateData(rFWDownloadTask)) == null) {
            return;
        }
        RFWDownloadQueueLocalStorageHelper.deleteTaskEntry(taskTransformStateData, rFWDownloadTask.getStrategy().getTaskLocalStorageDelegate());
        RFWLog.d("DQ-RFWDownloadStateProgressBox", RFWLog.USR, "[deleteTaskEntry]  stateData = " + taskTransformStateData);
    }

    public void updateTaskEntry(RFWDownloadTask rFWDownloadTask) {
        RFWDownloadTaskStateData notifyTaskCallback;
        if (rFWDownloadTask == null || rFWDownloadTask.getStrategy() == null || (notifyTaskCallback = notifyTaskCallback(rFWDownloadTask)) == null) {
            return;
        }
        if (rFWDownloadTask.getState() != DownloadState.STATE_RUNNING) {
            RFWLog.d("DQ-RFWDownloadStateProgressBox", RFWLog.USR, "[updateTaskEntry]  stateData = " + notifyTaskCallback);
        }
        RFWDownloadQueueLocalStorageHelper.updateTaskEntry(notifyTaskCallback, rFWDownloadTask.getStrategy().getTaskLocalStorageDelegate());
    }
}
