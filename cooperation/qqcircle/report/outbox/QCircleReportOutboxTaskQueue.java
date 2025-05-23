package cooperation.qqcircle.report.outbox;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.outbox.QCircleNetDetectHelper;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportOutboxTaskQueue extends SimpleTaskQueue implements Handler.Callback, NetworkState.NetworkStateListener {
    private static int MAX_TASK_RETRY_COUNT = 3;
    private static final int MSG_ADD_TASK = 1;
    private static final int MSG_COMPLETE_TASK = 5;
    private static final int MSG_REMOVE_TASK = 3;
    private static final int MSG_RESET_TASK = 6;
    private static final int MSG_RESTORE_TASK = 4;
    private static final int MSG_RESUME_TASK = 2;
    private static final long ONE_DAY = 86400000;
    public static final String TAG = "QCircleReportOutboxTaskQueue";
    private static final long TIME_OFFSET = TimeZone.getTimeZone(DateUtil.TIME_ZONE_8).getRawOffset();
    private static volatile QCircleReportOutboxTaskQueue sInstance;
    private Runnable checkRetry = new Runnable() { // from class: cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.1
        @Override // java.lang.Runnable
        public void run() {
            if (!NetworkState.isNetSupport()) {
                return;
            }
            if (QCircleReportOutboxTaskQueue.this.getTaskCount() > 0) {
                QCircleNetDetectHelper.detectQCircleNetConnection(new QCircleNetDetectHelper.DetectListener() { // from class: cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.1.1
                    @Override // cooperation.qqcircle.report.outbox.QCircleNetDetectHelper.DetectListener
                    public void onDetectResult(boolean z16, long j3, String str) {
                        if (z16) {
                            QLog.d(QCircleReportOutboxTaskQueue.TAG, 1, "detectQCirclenNetConnection available,resumeOutboxTasks");
                            if (QCircleReportOutboxTaskQueue.this.mHandler != null) {
                                QCircleReportOutboxTaskQueue.this.mHandler.removeCallbacks(QCircleReportOutboxTaskQueue.this.excuteRetry);
                                QCircleReportOutboxTaskQueue.this.mHandler.post(QCircleReportOutboxTaskQueue.this.excuteRetry);
                                return;
                            }
                            return;
                        }
                        if (QCircleReportOutboxTaskQueue.this.mHandler != null) {
                            QCircleReportOutboxTaskQueue.this.mHandler.removeCallbacks(QCircleReportOutboxTaskQueue.this.checkRetry);
                            QCircleReportOutboxTaskQueue.this.mHandler.postDelayed(QCircleReportOutboxTaskQueue.this.checkRetry, 10000L);
                        }
                        QLog.d(QCircleReportOutboxTaskQueue.TAG, 1, "detectQCirclenNetConnection blocked,retry again!retCode:" + j3 + ",errMsg:" + str);
                    }
                });
            } else {
                QLog.d(QCircleReportOutboxTaskQueue.TAG, 1, "no outbox tasks left,direct return!");
            }
        }
    };
    private Runnable excuteRetry = new Runnable() { // from class: cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue.2
        @Override // java.lang.Runnable
        public void run() {
            QCircleReportOutboxTaskQueue.this.resumeOutboxTasks();
        }
    };
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    QCircleReportOutboxTaskQueue() {
        QLog.d(TAG, 1, "new instance");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("qqcircle_report_outbox", 10);
        this.mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        NetworkState.addListener(this);
    }

    private void addTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (qCircleReportOutboxTask != null && this.mHandler != null) {
            qCircleReportOutboxTask.setTime(System.currentTimeMillis());
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = qCircleReportOutboxTask;
            this.mHandler.sendMessage(obtain);
        }
    }

    public static SimpleTaskQueue getInstance() {
        if (c.a4()) {
            if (sInstance == null) {
                synchronized (QCircleReportOutboxTaskQueue.class) {
                    if (sInstance == null) {
                        sInstance = new QCircleReportOutboxTaskQueue();
                        sInstance.restore();
                    }
                }
            }
            return sInstance;
        }
        return new SimpleTaskQueue();
    }

    private int getRunningTaskCount() {
        return QCircleReportOutboxTaskManager.getInstance().getRunningTaskCount();
    }

    private boolean isTheSameDay(long j3) {
        if ((System.currentTimeMillis() + TIME_OFFSET) / 86400000 == j3 / 86400000) {
            return true;
        }
        return false;
    }

    private boolean needRetry(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (qCircleReportOutboxTask == null) {
            return false;
        }
        MAX_TASK_RETRY_COUNT = c.X0("qqcircle", "qqcircle_max_retry_count", Integer.valueOf(MAX_TASK_RETRY_COUNT)).intValue();
        if (qCircleReportOutboxTask.getState() != 2 || !resultCodeCanRetry(qCircleReportOutboxTask.getResultCode()) || qCircleReportOutboxTask.getRetryNum() >= MAX_TASK_RETRY_COUNT) {
            return false;
        }
        return true;
    }

    private void onAddTask(Message message) {
        QCircleReportOutboxTask qCircleReportOutboxTask = (QCircleReportOutboxTask) message.obj;
        if (qCircleReportOutboxTask == null) {
            return;
        }
        qCircleReportOutboxTask.printTaskInfo(TAG, "onAddTask");
        QCircleReportOutboxTaskManager.getInstance().addTask(qCircleReportOutboxTask);
        runTask();
    }

    private void onCompleteTask(Message message) {
        QCircleReportOutboxTask qCircleReportOutboxTask = (QCircleReportOutboxTask) message.obj;
        if (qCircleReportOutboxTask == null) {
            return;
        }
        qCircleReportOutboxTask.printTaskInfo(TAG, "onCompleteTask");
        QCircleReportOutboxTaskManager qCircleReportOutboxTaskManager = QCircleReportOutboxTaskManager.getInstance();
        boolean z16 = true;
        if (message.arg1 != 1) {
            z16 = false;
        }
        qCircleReportOutboxTaskManager.completeTask(qCircleReportOutboxTask, z16);
        runTask();
    }

    private void onRemoveTask(Message message) {
        QCircleReportOutboxTask qCircleReportOutboxTask = (QCircleReportOutboxTask) message.obj;
        if (qCircleReportOutboxTask == null) {
            return;
        }
        qCircleReportOutboxTask.printTaskInfo(TAG, "onRemoveTask", true);
        QCircleReportOutboxTaskManager.getInstance().removeTask(qCircleReportOutboxTask);
        runTask();
    }

    private void onResetTask() {
        QLog.i(TAG, 1, "onResetTask task size:" + getTaskCount());
        QCircleReportOutboxTaskManager.getInstance().reset();
        release();
    }

    private void onRestore() {
        if (QCircleReportOutboxTaskManager.getInstance().restore()) {
            Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.removeCallbacks(this.checkRetry);
            this.mHandler.postDelayed(this.checkRetry, 3000L);
        }
        QLog.i(TAG, 1, "onRestore taskList size:" + getTaskCount());
    }

    private void onResumeTask(Message message) {
        QCircleReportOutboxTask qCircleReportOutboxTask = (QCircleReportOutboxTask) message.obj;
        if (qCircleReportOutboxTask == null) {
            return;
        }
        qCircleReportOutboxTask.printTaskInfo(TAG, "onResumeTask");
        QCircleReportOutboxTaskManager.getInstance().resumeTask(qCircleReportOutboxTask);
        runTask();
    }

    private void release() {
        QLog.i(TAG, 1, "release uin:" + QCircleHostStubUtil.getCurrentAccount());
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
        this.mHandler = null;
        sInstance = null;
    }

    private void reportOutboxResendFinalFailed(QCircleReportOutboxTask qCircleReportOutboxTask) {
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_OUTBOX_TASK_RESEND_EVENT_FINAL, (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("ret_code", qCircleReportOutboxTask.getResultCode() + ""), QCircleReportHelper.newEntry("url", qCircleReportOutboxTask.getResultMsg()), QCircleReportHelper.newEntry("refer", qCircleReportOutboxTask.mCmdName + ""), QCircleReportHelper.newEntry("count", qCircleReportOutboxTask.getRetryNum() + ""), QCircleReportHelper.newEntry("attach_info", qCircleReportOutboxTask.getTaskId() + "_" + qCircleReportOutboxTask.getResultCode() + "_" + qCircleReportOutboxTask.getResultMsg() + "_state=" + qCircleReportOutboxTask.getState())));
    }

    private boolean resultCodeCanRetry(long j3) {
        if (j3 == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeOutboxTasks() {
        CopyOnWriteArrayList<QCircleReportOutboxTask> taskList = getTaskList();
        if (taskList != null) {
            int size = taskList.size();
            QLog.i(TAG, 1, "checkRetry taskList size:" + size);
            for (int i3 = 0; i3 < size; i3++) {
                QCircleReportOutboxTask qCircleReportOutboxTask = taskList.get(i3);
                qCircleReportOutboxTask.printTaskInfo(TAG, "checkRetry");
                if (qCircleReportOutboxTask.getState() != 1) {
                    if (needRetry(qCircleReportOutboxTask)) {
                        QLog.d(TAG, 1, "retryTask id:" + qCircleReportOutboxTask.getTaskId() + " ,state:" + qCircleReportOutboxTask.getState() + " ,cmd:" + qCircleReportOutboxTask.mCmdName + " ,curRetryNum:" + qCircleReportOutboxTask.getRetryNum());
                        resumeTask(qCircleReportOutboxTask);
                    } else {
                        reportOutboxResendFinalFailed(qCircleReportOutboxTask);
                        QLog.d(TAG, 1, "removeTask id:" + qCircleReportOutboxTask.getTaskId() + " ,state:" + qCircleReportOutboxTask.getState() + " ,cmd:" + qCircleReportOutboxTask.mCmdName + " ,curRetryNum:" + qCircleReportOutboxTask.getRetryNum() + " ,resultCode:" + qCircleReportOutboxTask.getResultCode());
                        removeTask(qCircleReportOutboxTask);
                    }
                }
            }
        }
    }

    private boolean runTask() {
        return QCircleReportOutboxTaskManager.getInstance().runTask();
    }

    @Override // cooperation.qqcircle.report.outbox.SimpleTaskQueue
    public void addPausedTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (qCircleReportOutboxTask == null) {
            return;
        }
        qCircleReportOutboxTask.setState(2);
        addTask(qCircleReportOutboxTask);
    }

    @Override // cooperation.qqcircle.report.outbox.SimpleTaskQueue
    public void completeTask(QCircleReportOutboxTask qCircleReportOutboxTask, boolean z16) {
        if (qCircleReportOutboxTask != null && this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.arg1 = z16 ? 1 : 0;
            obtain.obj = qCircleReportOutboxTask;
            this.mHandler.sendMessage(obtain);
            return;
        }
        QLog.i(TAG, 1, "completeTask null");
    }

    public boolean containTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        return QCircleReportOutboxTaskManager.getInstance().containTask(qCircleReportOutboxTask);
    }

    public CopyOnWriteArrayList<QCircleReportOutboxTask> getFailTaskList() {
        CopyOnWriteArrayList<QCircleReportOutboxTask> taskList = getTaskList();
        CopyOnWriteArrayList<QCircleReportOutboxTask> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<QCircleReportOutboxTask> it = taskList.iterator();
        while (it.hasNext()) {
            QCircleReportOutboxTask next = it.next();
            if (next != null && next.getState() == 2) {
                copyOnWriteArrayList.add(next);
            }
        }
        return copyOnWriteArrayList;
    }

    public QCircleReportOutboxTask getTaskByCacheKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return QCircleReportOutboxTaskManager.getInstance().getTaskByCacheKey(str);
    }

    public int getTaskCount() {
        return QCircleReportOutboxTaskManager.getInstance().getTaskCount();
    }

    public CopyOnWriteArrayList<QCircleReportOutboxTask> getTaskList() {
        long currentTimeMillis = System.currentTimeMillis();
        CopyOnWriteArrayList<QCircleReportOutboxTask> taskList = QCircleReportOutboxTaskManager.getInstance().getTaskList();
        QLog.d(TAG, 1, "getTaskList timeCost:" + (System.currentTimeMillis() - currentTimeMillis));
        return taskList;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                onAddTask(message);
                return false;
            case 2:
                onResumeTask(message);
                return false;
            case 3:
                onRemoveTask(message);
                return false;
            case 4:
                onRestore();
                return false;
            case 5:
                onCompleteTask(message);
                return false;
            case 6:
                onResetTask();
                return false;
            default:
                return false;
        }
    }

    public boolean hasRunningTask() {
        return QCircleReportOutboxTaskManager.getInstance().hasRunningTask();
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        Handler handler;
        if (z16 && (handler = this.mHandler) != null) {
            handler.removeCallbacks(this.checkRetry);
            this.mHandler.postDelayed(this.checkRetry, 10000L);
        }
    }

    public boolean removeTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        boolean z16 = false;
        if (qCircleReportOutboxTask != null && this.mHandler != null) {
            qCircleReportOutboxTask.printTaskInfo(TAG, "removeTask", true);
            if (containTask(qCircleReportOutboxTask)) {
                if (qCircleReportOutboxTask.getState() == 2) {
                    z16 = true;
                } else {
                    QLog.d(TAG, 1, "removeTask id:" + qCircleReportOutboxTask.getTaskId() + ",unexpect state:" + qCircleReportOutboxTask.getState());
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = qCircleReportOutboxTask;
            this.mHandler.sendMessage(obtain);
        }
        return z16;
    }

    @Override // cooperation.qqcircle.report.outbox.SimpleTaskQueue
    public void resetTaskList() {
        if (this.mHandler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 6;
        this.mHandler.sendMessage(obtain);
    }

    public void restore() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        handler.sendMessage(obtain);
    }

    public void resumeTask(QCircleReportOutboxTask qCircleReportOutboxTask) {
        if (qCircleReportOutboxTask != null && this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = qCircleReportOutboxTask;
            this.mHandler.sendMessage(obtain);
        }
    }
}
