package cooperation.qqcircle.report.outbox;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportOutboxTaskManager {
    private static int DEFAULT_MAX_PARALLEL_TASK_COUNT = 10;
    public static final String TAG = "QCircleReportOutboxTaskManager";
    private static volatile QCircleReportOutboxTaskManager sInstance;
    private QCircleReportOutboxTaskCacheManager mCacheManager;
    private CopyOnWriteArrayList<QCircleReportOutboxTask> mTaskList = new CopyOnWriteArrayList<>();
    private volatile boolean hasRunningTask = false;

    QCircleReportOutboxTaskManager() {
        QLog.d(TAG, 1, "new instance");
        this.mCacheManager = new QCircleReportOutboxTaskCacheManager("QCircleSendTaskManager_outbox_queue");
    }

    public static QCircleReportOutboxTaskManager getInstance() {
        if (sInstance == null) {
            synchronized (QCircleReportOutboxTaskManager.class) {
                if (sInstance == null) {
                    sInstance = new QCircleReportOutboxTaskManager();
                }
            }
        }
        return sInstance;
    }

    private void reportReportOutboxResendFinalSuccess(QCircleReportOutboxTask qCircleReportOutboxTask) {
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_OUTBOX_TASK_RESEND_EVENT_FINAL, (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("ret_code", qCircleReportOutboxTask.getResultCode() + ""), QCircleReportHelper.newEntry("url", qCircleReportOutboxTask.getResultMsg()), QCircleReportHelper.newEntry("refer", qCircleReportOutboxTask.mCmdName + ""), QCircleReportHelper.newEntry("count", qCircleReportOutboxTask.getRetryNum() + ""), QCircleReportHelper.newEntry("attach_info", qCircleReportOutboxTask.getTaskId() + "_" + qCircleReportOutboxTask.getResultCode() + "_" + qCircleReportOutboxTask.getResultMsg() + "_state=" + qCircleReportOutboxTask.getState())));
    }

    public boolean addTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (qCircleReportOutboxTask != null && !this.mTaskList.contains(qCircleReportOutboxTask)) {
            QLog.i(TAG, 1, "addTask id:" + qCircleReportOutboxTask.getTaskId());
            this.mTaskList.add(qCircleReportOutboxTask);
            this.mCacheManager.saveTask(qCircleReportOutboxTask);
            return true;
        }
        QLog.w(TAG, 1, "addTask error");
        return false;
    }

    public boolean completeTask(QCircleReportOutboxTask qCircleReportOutboxTask, boolean z16) {
        if (qCircleReportOutboxTask != null && this.mTaskList.contains(qCircleReportOutboxTask)) {
            if (z16) {
                qCircleReportOutboxTask.setState(3);
                this.mTaskList.remove(qCircleReportOutboxTask);
                this.mCacheManager.removeTask(qCircleReportOutboxTask);
                reportReportOutboxResendFinalSuccess(qCircleReportOutboxTask);
            } else {
                this.mTaskList.remove(qCircleReportOutboxTask);
                qCircleReportOutboxTask.setState(2);
                this.mCacheManager.updateTask(qCircleReportOutboxTask);
            }
            QLog.i(TAG, 1, "completeTask id:" + qCircleReportOutboxTask.getTaskId() + ", succeed:" + z16 + ", resultCode:" + qCircleReportOutboxTask.getResultCode() + ", resultMsg:" + qCircleReportOutboxTask.getResultMsg());
            return true;
        }
        QLog.w(TAG, 1, "completeTask error");
        return false;
    }

    public boolean containTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        return this.mTaskList.contains(qCircleReportOutboxTask);
    }

    public int getRunningTaskCount() {
        int i3 = 0;
        if (this.mTaskList.isEmpty()) {
            return 0;
        }
        Iterator<QCircleReportOutboxTask> it = this.mTaskList.iterator();
        while (it.hasNext()) {
            QCircleReportOutboxTask next = it.next();
            if (next != null && next.getState() == 1) {
                if (System.currentTimeMillis() - next.getTime() < 60000) {
                    i3++;
                } else {
                    next.setState(2);
                    next.printTaskInfo(TAG, "getRunningTaskCount resend timeout!", true);
                }
            }
        }
        return i3;
    }

    public QCircleReportOutboxTask getTaskByCacheKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (QCircleReportOutboxTask qCircleReportOutboxTask : this.mTaskList) {
            if (str.equals(qCircleReportOutboxTask.getCacheKey())) {
                return qCircleReportOutboxTask;
            }
        }
        return null;
    }

    public int getTaskCount() {
        return this.mTaskList.size();
    }

    public CopyOnWriteArrayList<QCircleReportOutboxTask> getTaskList() {
        return (CopyOnWriteArrayList) this.mTaskList.clone();
    }

    public boolean hasRunningTask() {
        return this.hasRunningTask;
    }

    public boolean removeTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (qCircleReportOutboxTask != null && this.mTaskList.contains(qCircleReportOutboxTask)) {
            qCircleReportOutboxTask.setState(4);
            qCircleReportOutboxTask.onRemove();
            this.mTaskList.remove(qCircleReportOutboxTask);
            this.mCacheManager.removeTask(qCircleReportOutboxTask);
            return true;
        }
        QLog.w(TAG, 1, "removeTask error");
        return false;
    }

    public void reset() {
        QLog.i(TAG, 1, "reset total size:" + this.mTaskList.size());
        if (this.mTaskList.size() > 0) {
            Iterator<QCircleReportOutboxTask> it = this.mTaskList.iterator();
            while (it.hasNext()) {
                QCircleReportOutboxTask next = it.next();
                if (next != null) {
                    next.clear();
                }
            }
        }
        this.mTaskList.clear();
        this.mCacheManager.release();
        sInstance = null;
    }

    public boolean restore() {
        if (!this.mTaskList.isEmpty()) {
            return false;
        }
        ArrayList<QCircleReportOutboxTask> restoreTasks = this.mCacheManager.restoreTasks();
        if (restoreTasks != null && !restoreTasks.isEmpty()) {
            Iterator<QCircleReportOutboxTask> it = restoreTasks.iterator();
            while (it.hasNext()) {
                QCircleReportOutboxTask next = it.next();
                next.printTaskInfo(TAG, CanvasView.ACTION_RESTORE);
                if (next.getState() != 1) {
                    next.onRestore();
                }
            }
            this.mTaskList.clear();
            this.mTaskList.addAll(restoreTasks);
        }
        QLog.i(TAG, 1, "restore total size:" + this.mTaskList.size());
        if (this.mTaskList.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean resumeTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (qCircleReportOutboxTask != null && this.mTaskList.contains(qCircleReportOutboxTask)) {
            QLog.i(TAG, 1, "resumeTask id:" + qCircleReportOutboxTask.getTaskId() + ", current state:" + qCircleReportOutboxTask.getState());
            qCircleReportOutboxTask.onResume();
            return true;
        }
        QLog.w(TAG, 1, "resumeTask error");
        return false;
    }

    public boolean runTask() {
        boolean z16;
        int runningTaskCount = getRunningTaskCount();
        boolean z17 = true;
        if (!AppNetConnInfo.isNetSupport()) {
            if (runningTaskCount <= 0) {
                z17 = false;
            }
            this.hasRunningTask = z17;
            return false;
        }
        int intValue = c.X0("qqcircle", "qqcircle_max_parallel_task_count", Integer.valueOf(DEFAULT_MAX_PARALLEL_TASK_COUNT)).intValue();
        if (runningTaskCount <= intValue) {
            Iterator<QCircleReportOutboxTask> it = this.mTaskList.iterator();
            z16 = false;
            while (it.hasNext()) {
                QCircleReportOutboxTask next = it.next();
                if (next != null) {
                    if (next.getState() == 2) {
                        QLog.i(TAG, 1, "runTask id:" + next.getTaskId());
                        runningTaskCount++;
                        next.setState(1);
                        next.resend();
                        z16 = true;
                    }
                    if (runningTaskCount == intValue) {
                        break;
                    }
                }
            }
        } else {
            z16 = false;
        }
        if (runningTaskCount <= 0) {
            z17 = false;
        }
        this.hasRunningTask = z17;
        return z16;
    }
}
