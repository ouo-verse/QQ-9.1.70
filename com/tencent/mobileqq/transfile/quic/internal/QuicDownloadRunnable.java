package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicDownloadRunnable extends AbTransportRunnable {
    static IPatchRedirector $redirector_ = null;
    private static final int INIT_TASK_ID = 65534;
    private static HashMap<String, Integer> allRunningTaskMap;
    private static AtomicInteger sUniqueID;
    private static ConcurrentHashMap<String, QuicDownloadTask> taskHashMap;
    protected QuicDownloadTask task;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        taskHashMap = new ConcurrentHashMap<>();
        allRunningTaskMap = new HashMap<>();
        sUniqueID = new AtomicInteger(65534);
    }

    public QuicDownloadRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void dataReceiving(Bundle bundle) {
        Iterator<Map.Entry<String, QuicDownloadTask>> it = taskHashMap.entrySet().iterator();
        while (it.hasNext()) {
            QuicDownloadTask quicDownloadTask = taskHashMap.get(it.next().getKey());
            if (quicDownloadTask != null && quicDownloadTask.running && quicDownloadTask.report.f293472id == bundle.getInt("ID", 0)) {
                quicDownloadTask.receiveResponse(bundle.getByteArray("DATA"), bundle.getInt("LEN", 0));
            }
        }
    }

    public static synchronized int getTaskID(String str) {
        int intValue;
        synchronized (QuicDownloadRunnable.class) {
            Integer num = allRunningTaskMap.get(str);
            if (num != null) {
                intValue = num.intValue();
            } else {
                throw new IllegalArgumentException("task id is null!!");
            }
        }
        return intValue;
    }

    public static synchronized boolean isExistTaskAddIfNeed(String str) {
        synchronized (QuicDownloadRunnable.class) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (allRunningTaskMap.containsKey(str)) {
                return true;
            }
            allRunningTaskMap.put(str, Integer.valueOf(sUniqueID.incrementAndGet()));
            return false;
        }
    }

    public static synchronized void removeRunningTask(String str) {
        synchronized (QuicDownloadRunnable.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Integer remove = allRunningTaskMap.remove(str);
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "removeTask: ", remove);
            }
            if (allRunningTaskMap.isEmpty()) {
                sUniqueID.set(65534);
            }
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "allTaskSize: ", Integer.valueOf(allRunningTaskMap.size()), " sUniqueID: " + sUniqueID);
            }
        }
    }

    private void serverClose(Bundle bundle) {
        Iterator<Map.Entry<String, QuicDownloadTask>> it = taskHashMap.entrySet().iterator();
        while (it.hasNext()) {
            QuicDownloadTask quicDownloadTask = taskHashMap.get(it.next().getKey());
            if (quicDownloadTask != null && quicDownloadTask.running && quicDownloadTask.report.f293472id == bundle.getInt("ID", 0)) {
                quicDownloadTask.connectionClose(bundle.getInt("CODE", 0), bundle.getString("DESC"));
            }
        }
    }

    private void taskConnected(Bundle bundle) {
        Iterator<Map.Entry<String, QuicDownloadTask>> it = taskHashMap.entrySet().iterator();
        while (it.hasNext()) {
            QuicDownloadTask quicDownloadTask = taskHashMap.get(it.next().getKey());
            if (quicDownloadTask != null && quicDownloadTask.running && quicDownloadTask.report.f293472id == bundle.getInt("ID", 0)) {
                quicDownloadTask.sendData();
            }
        }
    }

    private void taskFail(Message message) {
        T t16;
        Task task = (Task) message.obj;
        if (task != null && (t16 = task.netListener) != 0 && task.running && (t16 instanceof DownloadListener)) {
            QuicNetReport quicNetReport = task.report;
            ((DownloadListener) t16).onDownloadFailed(quicNetReport.url, quicNetReport);
        }
    }

    private void taskFinish(Message message) {
        QuicDownloadTask quicDownloadTask = (QuicDownloadTask) message.obj;
        this.task = quicDownloadTask;
        if (taskHashMap.containsValue(quicDownloadTask)) {
            taskHashMap.remove(this.task.report.tempPath);
        }
        removeRunningTask(this.task.report.tempPath);
        if (QLog.isColorLevel()) {
            QLog.d("quic", 4, "taskHashMap.size: ", Integer.valueOf(taskHashMap.size()));
        }
    }

    private void taskSuccess(Message message) {
        T t16;
        Task task = (Task) message.obj;
        if (task != null && (t16 = task.netListener) != 0 && task.running && (t16 instanceof DownloadListener)) {
            QuicNetReport quicNetReport = task.report;
            ((DownloadListener) t16).onDownloadSucceed(quicNetReport.url, quicNetReport);
        }
    }

    @Override // com.tencent.mobileqq.transfile.quic.internal.AbTransportRunnable
    public void enqueue(QuicDownloadTask quicDownloadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) quicDownloadTask);
            return;
        }
        Message message = this.message;
        message.what = 9;
        message.obj = quicDownloadTask;
        handleMessage(message);
    }

    @Override // com.tencent.mobileqq.transfile.quic.internal.AbTransportRunnable, com.tencent.mobileqq.transfile.quic.internal.ITaskHandler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        switch (message.what) {
            case 1:
                Bundle bundle = (Bundle) message.obj;
                if (bundle.getInt("ID", 0) != 0) {
                    taskConnected(bundle);
                    return;
                }
                return;
            case 2:
                Bundle bundle2 = (Bundle) message.obj;
                if (bundle2.getByteArray("DATA") != null) {
                    dataReceiving(bundle2);
                    return;
                }
                return;
            case 3:
            case 5:
            default:
                return;
            case 4:
                Bundle bundle3 = (Bundle) message.obj;
                if (bundle3.getInt("ID", 0) != 0) {
                    serverClose(bundle3);
                    return;
                }
                return;
            case 6:
                taskSuccess(message);
                return;
            case 7:
                taskFinish(message);
                return;
            case 8:
                taskFail(message);
                return;
            case 9:
                QuicDownloadTask quicDownloadTask = (QuicDownloadTask) message.obj;
                this.task = quicDownloadTask;
                taskHashMap.put(quicDownloadTask.report.tempPath, quicDownloadTask);
                this.task.prepare(this);
                this.task.startConnect();
                return;
        }
    }
}
