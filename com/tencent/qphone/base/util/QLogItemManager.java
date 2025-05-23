package com.tencent.qphone.base.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.exp.QLogItemCircularQueuePool;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QLogItemManager {
    private static final long LOG_ITEM_CACHE_TIME = 150;
    public static final String TAG = "QLogManager";
    private Handler mainHandler;
    private WriteHandler writeHandler;
    private final LogWriterManager writerManager;

    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat logTimeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
    private final List<QLogItem> cachedLogItems = new ArrayList();
    private final BlockingQueue<QLogItem> logItems = new LinkedBlockingQueue();
    private final Runnable deleteExpireLogFileTask = new Runnable() { // from class: com.tencent.qphone.base.util.QLogItemManager.1
        @Override // java.lang.Runnable
        public void run() {
            QLogItemManager.this.writerManager.deleteExpireLogFile();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class MainHandler extends Handler {
        public static final int MSG_TRANSFER = 0;

        public MainHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                ArrayList arrayList = new ArrayList(QLogItemManager.this.cachedLogItems);
                QLogItemManager.this.cachedLogItems.clear();
                Message.obtain(QLogItemManager.this.writeHandler, 5, arrayList).sendToTarget();
                QLogItemManager.this.mainHandler.removeMessages(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class WriteHandler extends Handler {
        private static final int MSG_ADD_LOG_ITEM = 4;
        private static final int MSG_ADD_LOG_LIST = 5;
        private static final int MSG_CLEAR = 3;
        private static final int MSG_INIT_WRITER = 1;
        private static final int MSG_WRITE = 2;
        private static final long ONE_MINUTE = 60000;
        private final int[] intervalRetryInit;
        private int retryTimes;

        public WriteHandler(Looper looper) {
            super(looper);
            this.intervalRetryInit = new int[]{1, 1, 1, 2, 2, 4, 4, 8, 16, 29};
        }

        private void tryInit() {
            long j3;
            try {
                Log.d(QLogItemManager.TAG, "QLog init");
                QLogItemManager.this.writerManager.initialize();
                this.retryTimes = 0;
                removeMessages(2);
                sendEmptyMessage(2);
            } catch (Throwable unused) {
                Log.d(QLogItemManager.TAG, "QLog init" + this.retryTimes + ", " + this.intervalRetryInit[this.retryTimes]);
                removeMessages(1);
                sendEmptyMessageDelayed(1, ((long) this.intervalRetryInit[this.retryTimes]) * 60000);
                removeMessages(3);
                if (this.retryTimes == 0) {
                    j3 = 62000;
                } else {
                    j3 = 15000;
                }
                sendEmptyMessageDelayed(3, j3);
                int i3 = this.retryTimes + 1;
                this.retryTimes = i3;
                if (i3 >= this.intervalRetryInit.length) {
                    this.retryTimes = 1;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            List list;
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5 && (list = (List) message.obj) != null && !list.isEmpty()) {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    list.removeIf(new Predicate() { // from class: com.tencent.qphone.base.util.r
                                        @Override // java.util.function.Predicate
                                        public final boolean test(Object obj) {
                                            return q.a((QLogItem) obj);
                                        }
                                    });
                                } else {
                                    list.removeAll(Collections.singleton(null));
                                }
                                QLogItemManager.this.logItems.addAll(list);
                                return;
                            }
                            return;
                        }
                        QLogItemManager.this.logItems.offer((QLogItem) message.obj);
                        return;
                    }
                    if (this.retryTimes > 0) {
                        Log.d(QLogItemManager.TAG, "QLog clear logs");
                        QLogItemManager.this.logItems.clear();
                        removeMessages(3);
                        sendEmptyMessageDelayed(3, 15000L);
                        return;
                    }
                    return;
                }
                if (QLogItemManager.this.writeLogItems()) {
                    removeMessages(1);
                    sendEmptyMessageDelayed(1, 1000L);
                    return;
                } else {
                    removeMessages(2);
                    sendEmptyMessageDelayed(2, 1000L);
                    return;
                }
            }
            tryInit();
        }
    }

    public QLogItemManager(Context context, String str, String str2, String str3, boolean z16) {
        this.writerManager = new LogWriterManager(context, str, str2, str3, z16);
    }

    private void addLogItem(QLogItem qLogItem) {
        if (qLogItem == null) {
            return;
        }
        if (this.writeHandler == null) {
            this.logItems.offer(qLogItem);
        } else {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (!this.mainHandler.hasMessages(0)) {
                    this.mainHandler.sendEmptyMessageDelayed(0, LOG_ITEM_CACHE_TIME);
                }
                this.cachedLogItems.add(qLogItem);
                return;
            }
            Message.obtain(this.writeHandler, 4, qLogItem).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeLogItems() {
        if (QLog.isUseNewQLog()) {
            return this.writerManager.writeNewQLogItems();
        }
        ArrayList arrayList = new ArrayList();
        this.logItems.drainTo(arrayList);
        return this.writerManager.writeLogItems(arrayList);
    }

    public void addLog(byte b16, long j3, int i3, String str, String str2, Throwable th5) {
        if (str2.length() > 1024 && b16 < 4 && !TextUtils.equals(str, "QQCrashReportManager")) {
            str2 = str2.substring(0, 1024) + " \u65e5\u5fd7\u8d851024\u4e2a\u5b57\u7b26\uff0c\u540e\u9762\u4e0d\u6253\u5370\u4e86\uff01\uff01\uff01";
        }
        if (QLog.isUseNewQLog()) {
            QLogItemCircularQueuePool.obtain(b16, j3, (byte) i3, str, str2, th5);
        } else {
            addLogItem(QLogItem.obtain(b16, j3, (byte) i3, str, str2, th5));
        }
        QLogHelper.reportToGoogleFirebase(j3, b16, str, str2, th5);
    }

    public void deleteExpireLogFile() {
        WriteHandler writeHandler = this.writeHandler;
        if (writeHandler == null) {
            QLog.e(TAG, 1, "delExpireFileActively, sWriteHandler == null");
        } else {
            writeHandler.post(this.deleteExpireLogFileTask);
        }
    }

    public void flushLog() {
        flushLog(false);
    }

    public String getDeleteExpireLogRecordFilePath() {
        return this.writerManager.getDeleteRecordFileName();
    }

    public SimpleDateFormat getLogFileFormatter() {
        return this.writerManager.getLogFileFormatter();
    }

    Collection<QLogItem> getLogItems() {
        return this.logItems;
    }

    public String getLogPath() {
        LogWriterManager logWriterManager = this.writerManager;
        if (logWriterManager != null && !TextUtils.isEmpty(logWriterManager.getLogPath())) {
            return this.writerManager.getLogPath();
        }
        return "";
    }

    public List<File> getOutOfCurHourLogs() {
        return this.writerManager.getOutOfCurHourLogs();
    }

    public void init(long j3) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("logWriteThread");
        baseHandlerThread.start();
        WriteHandler writeHandler = new WriteHandler(baseHandlerThread.getLooper());
        this.writeHandler = writeHandler;
        writeHandler.sendEmptyMessageDelayed(1, j3);
        this.mainHandler = new MainHandler(Looper.getMainLooper());
    }

    public boolean isEncrypted() {
        return this.writerManager.isEncrypted();
    }

    public void setFullEncryptedLogMode(boolean z16) {
        this.writerManager.setFullEncryptedLogMode(z16);
    }

    public void flushLog(boolean z16) {
        if (z16) {
            writeLogItems();
            return;
        }
        this.writeHandler.sendEmptyMessage(2);
        this.writeHandler.sendEmptyMessageDelayed(2, 20L);
        this.writeHandler.sendEmptyMessageDelayed(2, 80L);
        this.writeHandler.sendEmptyMessageDelayed(2, 160L);
        this.writeHandler.sendEmptyMessageDelayed(2, 3200L);
    }
}
