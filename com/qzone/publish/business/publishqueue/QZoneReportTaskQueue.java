package com.qzone.publish.business.publishqueue;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneReportTask;
import com.qzone.util.al;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.thread.BaseHandler;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneReportTaskQueue implements Handler.Callback, NetworkState.NetworkStateListener, b {
    private static boolean E = false;
    private static final al<QZoneReportTaskQueue, Void> F = new a();

    /* renamed from: h, reason: collision with root package name */
    public int f51099h;

    /* renamed from: i, reason: collision with root package name */
    public int f51100i;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f51101m;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<IQueueTask> f51096d = new CopyOnWriteArrayList<>();
    boolean C = false;
    private Runnable D = new Runnable() { // from class: com.qzone.publish.business.publishqueue.QZoneReportTaskQueue.2
        @Override // java.lang.Runnable
        public void run() {
            if (QZoneReportTaskQueue.this.f()) {
                QZoneReportTaskQueue qZoneReportTaskQueue = QZoneReportTaskQueue.this;
                qZoneReportTaskQueue.u(qZoneReportTaskQueue.f51096d);
            }
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private g f51097e = new g();

    /* renamed from: f, reason: collision with root package name */
    private Handler f51098f = new BaseHandler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper(), this);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QZoneReportTaskQueue, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneReportTaskQueue a(Void r16) {
            return new QZoneReportTaskQueue();
        }
    }

    QZoneReportTaskQueue() {
        this.f51099h = 1000;
        this.f51100i = 3;
        NetworkState.addListener(this);
        QZonePublishQueue.w().i(this);
        this.f51099h = QZoneConfigHelper.d0();
        this.f51100i = QZoneConfigHelper.Z();
        boolean d16 = QZoneConfigHelper.d();
        this.f51101m = d16;
        if (QZLog.isColorLevel()) {
            QZLog.d(QZLog.REPORT_QUEUE_TAG, 2, "maxPendingTaskNum:" + this.f51099h + ",maxPendingDay:" + this.f51100i + ",canRunAtFront:" + d16);
        }
    }

    private boolean e() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.f51096d;
        return (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty() || !w()) ? false : true;
    }

    public static QZoneReportTaskQueue h() {
        return F.get(null);
    }

    private int i() {
        int i3 = 0;
        for (IQueueTask iQueueTask : this.f51096d) {
            if (iQueueTask != null && (iQueueTask.getState() == 1 || iQueueTask.getState() == 4)) {
                if (System.currentTimeMillis() - iQueueTask.getTime() < 1800000) {
                    i3++;
                } else {
                    iQueueTask.setState(2);
                }
            }
        }
        return i3;
    }

    private void l(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        if (iQueueTask instanceof QZoneReportTask) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("QZoneReportTaskQueue.onAddTask path");
            QZoneReportTask qZoneReportTask = (QZoneReportTask) iQueueTask;
            sb5.append(qZoneReportTask.path);
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, sb5.toString());
            if (TextUtils.isEmpty(qZoneReportTask.path) || !new File(qZoneReportTask.path).exists()) {
                return;
            }
        }
        if (e()) {
            this.f51096d.add(iQueueTask);
            x();
        }
        if (!w()) {
            iQueueTask.setState(6);
        } else {
            v();
        }
        this.f51097e.d(iQueueTask);
    }

    private void m(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onCompleteTask type:" + iQueueTask.getExactType() + ",resultcode:" + iQueueTask.getResultCode());
        if (message.arg1 == 1) {
            iQueueTask.setState(3);
            r(iQueueTask);
        } else {
            iQueueTask.setState(2);
            if (!k(iQueueTask)) {
                r(iQueueTask);
                QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onCompleteTask  \u4efb\u52a1\u5931\u8d25\uff0c\u65e0\u9700\u91cd\u8bd5");
            } else {
                this.f51097e.e(iQueueTask);
                QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onCompleteTask  \u4efb\u52a1\u5931\u8d25\uff0c\u7a0d\u540e\u91cd\u8bd5");
            }
        }
        v();
    }

    private void q() {
        Iterator<IQueueTask> it = j().iterator();
        while (it.hasNext()) {
            IQueueTask next = it.next();
            if (next.getState() == 1 || next.getState() == 4) {
                if (next.cancel()) {
                    next.setState(0);
                }
            }
        }
    }

    private void s() {
        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.resetTaskList task size:" + this.f51096d.size());
        this.f51096d.clear();
        this.C = false;
    }

    private void t(int i3) {
        if (this.C) {
            return;
        }
        this.C = true;
        Message obtain = Message.obtain(this.f51098f, 5);
        obtain.arg1 = i3;
        obtain.sendToTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean v() {
        boolean z16 = false;
        if (!f()) {
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "runTask\uff08\uff09 \u5f53\u524d\u4e0d\u6267\u884c\u4efb\u52a1");
            return false;
        }
        if (!E) {
            E = true;
            UploadEnv uploadEnv = new UploadEnv();
            UploadServiceBuilder.getInstance().init(BaseApplication.getContext(), new r7.b(), new r7.d(), new r7.e(), uploadEnv, uploadEnv);
        }
        int i3 = i();
        if (QZonePublishQueue.w().F()) {
            return false;
        }
        if (i3 < 5) {
            Iterator<IQueueTask> it = this.f51096d.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != 0) {
                    if (next.getState() == 0 || next.getState() == 6) {
                        i3++;
                        next.setState(1);
                        QZoneBusinessLooper.getInstance().runTask((QZoneTask) next);
                        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "runTask\uff08\uff09 \u6267\u884c\u884c\u4efb\u52a1");
                        z16 = true;
                    }
                    if (i3 == 5) {
                        break;
                    }
                }
            }
        }
        return z16;
    }

    private boolean w() {
        return NetworkState.getNetworkType() == 2 ? (t8.a.f435590h & 2) != 0 : NetworkState.getNetworkType() == 3 ? (t8.a.f435590h & 4) != 0 : NetworkState.getNetworkType() == 4 ? (t8.a.f435590h & 8) != 0 : NetworkState.getNetworkType() == 5 ? (t8.a.f435590h & 32) != 0 : NetworkState.isWifiConn();
    }

    private void x() {
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.f51096d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<IQueueTask> it = this.f51096d.iterator();
        while (it.hasNext()) {
            IQueueTask next = it.next();
            if (next != null && (next instanceof QZoneReportTask)) {
                if (NetConnInfoCenter.getServerTime() - ((QZoneReportTask) next).createTime <= this.f51100i * 24 * 60 * 60) {
                    break;
                }
                next.setResultCode(-10000);
                r(next);
                if (QZLog.isColorLevel()) {
                    QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.trimTasks \u4efb\u52a1\u8fc7\u671f \u5220\u9664");
                }
            }
        }
        int size = this.f51096d.size() - this.f51099h;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                IQueueTask iQueueTask = this.f51096d.get(i3);
                if (iQueueTask != null) {
                    iQueueTask.setResultCode(-20000);
                    r(iQueueTask);
                    if (QZLog.isColorLevel()) {
                        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.trimTasks \u4efb\u52a1\u6ea2\u51fa \u5220\u9664");
                    }
                }
            } catch (Exception e16) {
                QZLog.w(e16);
                return;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            l(message);
            return false;
        }
        if (i3 == 4) {
            m(message);
            return false;
        }
        if (i3 != 5) {
            return false;
        }
        n(message);
        return false;
    }

    public CopyOnWriteArrayList<IQueueTask> j() {
        return this.f51096d;
    }

    public void o() {
        if (this.f51101m) {
            return;
        }
        t(0);
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (f()) {
            this.f51098f.removeCallbacks(this.D);
            this.f51098f.postDelayed(this.D, 90000L);
        } else {
            q();
        }
    }

    @Override // com.qzone.publish.business.publishqueue.b
    public void onQueueChanged() {
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.f51096d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        if (QZonePublishQueue.w().F()) {
            q();
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onQueneChanged \u53d1\u4ef6\u7bb1\u6dfb\u52a0\u4e86\u4efb\u52a1\uff0c\u6682\u505c\u5de5\u4f5c\u8fdb\u5165\u7761\u7720");
        } else {
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onQueneChanged \u53d1\u4ef6\u7bb1\u5b8c\u6210\u4e86\u4e0a\u4f20\uff0c\u8d77\u5e8a\u5de5\u4f5c\u4e86");
            v();
        }
    }

    public void p() {
        if (!this.f51101m) {
            q();
            s();
        } else {
            t(3000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<IQueueTask> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (IQueueTask iQueueTask : list) {
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onResumeTask type:" + iQueueTask.getExactType());
            if (k(iQueueTask)) {
                iQueueTask.increaseRetryNum();
                iQueueTask.resetDataSize();
                if (w()) {
                    iQueueTask.setState(0);
                } else {
                    iQueueTask.setState(6);
                }
                this.f51097e.e(iQueueTask);
            } else if (iQueueTask.getState() == 2) {
                r(iQueueTask);
            } else if (iQueueTask.getState() == 5) {
                iQueueTask.resetDataSize();
                if (w()) {
                    iQueueTask.setState(0);
                } else {
                    iQueueTask.setState(6);
                }
                this.f51097e.e(iQueueTask);
            }
        }
        v();
    }

    private void n(Message message) {
        if (message == null) {
            return;
        }
        ArrayList<IQueueTask> c16 = this.f51097e.c();
        if (c16 != null && !c16.isEmpty()) {
            this.f51096d.clear();
            this.f51096d.addAll(c16);
        }
        x();
        if (!this.f51096d.isEmpty()) {
            this.f51098f.removeCallbacks(this.D);
            this.f51098f.postDelayed(this.D, message.arg1);
        }
        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onRestore taskList size:" + this.f51096d.size());
    }

    private void r(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return;
        }
        QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue.onRemoveTask type:" + iQueueTask.getExactType());
        this.f51096d.remove(iQueueTask);
        iQueueTask.onRemove();
        this.f51097e.b(iQueueTask);
    }

    public void g(IQueueTask iQueueTask, boolean z16) {
        if (iQueueTask == null) {
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTaskQueue completeTask null");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.arg1 = z16 ? 1 : 0;
        obtain.obj = iQueueTask;
        this.f51098f.sendMessage(obtain);
    }

    private boolean k(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return false;
        }
        int resultCode = iQueueTask.getResultCode();
        if (iQueueTask.getState() == 2) {
            return (resultCode == 0 || resultCode == -3000 || resultCode == -5000 || resultCode == 35000 || resultCode == 301002 || resultCode == 301013 || resultCode == 1000004) && iQueueTask.getRetryNum() < 10;
        }
        return false;
    }

    public boolean d(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return false;
        }
        iQueueTask.setTime(System.currentTimeMillis());
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iQueueTask;
        this.f51098f.sendMessage(obtain);
        return true;
    }

    @Override // com.qzone.publish.business.publishqueue.b
    public void H(IQueueTask iQueueTask) {
    }
}
