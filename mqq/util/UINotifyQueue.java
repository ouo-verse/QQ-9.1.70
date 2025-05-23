package mqq.util;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UINotifyQueue implements Runnable {
    public static final String TAG = "UINotifyQueue";
    private final long aggregateTime;
    private boolean enable;
    private boolean isDebug;
    private final Runnable monitorRunnable;
    private final Handler uiHandler;
    private long execLimitTime = 100;
    private final Queue<Task> taskQueue = new ConcurrentLinkedQueue();
    private final Object lock = new Object();
    private volatile boolean isRunning = false;
    private volatile boolean hasCallbackUnProcess = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Task {
        Runnable curTask;
        long startTime;
        String tag;

        Task(Runnable runnable, String str, long j3) {
            this.curTask = runnable;
            this.tag = str;
            this.startTime = j3;
        }
    }

    public UINotifyQueue(Handler handler, long j3, boolean z16, boolean z17) {
        this.enable = false;
        this.isDebug = true;
        Runnable runnable = new Runnable() { // from class: mqq.util.UINotifyQueue.1
            @Override // java.lang.Runnable
            public void run() {
                Task task;
                if (!UINotifyQueue.this.taskQueue.isEmpty() && (task = (Task) UINotifyQueue.this.taskQueue.peek()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j16 = task.startTime;
                    long j17 = currentTimeMillis - j16;
                    if (j17 > 1000) {
                        QLog.d(UINotifyQueue.TAG, 1, "task maybe miss: ", task.tag, " startTime: ", Long.valueOf(j16), " wait: ", Long.valueOf(j17));
                    }
                }
                ThreadManagerV2.executeDelay(UINotifyQueue.this.monitorRunnable, 16, null, true, 1000L);
            }
        };
        this.monitorRunnable = runnable;
        this.uiHandler = handler;
        this.aggregateTime = j3;
        this.enable = z16;
        this.isDebug = z17;
        if (z17) {
            ThreadManagerV2.executeDelay(runnable, 16, null, true, 1000L);
        }
    }

    private void execTask() {
        QLog.i(TAG, 4, "execTask");
        long j3 = 0;
        while (j3 < this.execLimitTime && !this.taskQueue.isEmpty()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            Task poll = this.taskQueue.poll();
            if (poll == null) {
                return;
            }
            poll.curTask.run();
            j3 += SystemClock.uptimeMillis() - uptimeMillis;
        }
    }

    private void setUpRunTask() {
        synchronized (this.lock) {
            if (!this.taskQueue.isEmpty() && !this.isRunning && !this.hasCallbackUnProcess) {
                this.uiHandler.postDelayed(this, this.aggregateTime);
                this.hasCallbackUnProcess = true;
            }
        }
    }

    public void postTask(String str, Runnable runnable) {
        if (!this.enable) {
            this.uiHandler.post(runnable);
            return;
        }
        synchronized (this.lock) {
            if (this.isDebug) {
                str = str + "-" + runnable.hashCode();
                QLog.i(TAG, 4, "add Runnable: " + str);
            }
            this.taskQueue.add(new Task(runnable, str, System.currentTimeMillis()));
            setUpRunTask();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.isRunning = true;
        execTask();
        this.isRunning = false;
        this.hasCallbackUnProcess = false;
        setUpRunTask();
    }

    public void setEnable(boolean z16) {
        this.enable = z16;
    }
}
