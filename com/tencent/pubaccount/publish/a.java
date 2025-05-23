package com.tencent.pubaccount.publish;

import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.publishqueue.e;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.util.al;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static int f342313d = 5;

    /* renamed from: e, reason: collision with root package name */
    private static final al<a, Void> f342314e = new C9291a();

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<IQueueTask> f342315a = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f342317c = false;

    /* renamed from: b, reason: collision with root package name */
    private e f342316b = new e("certified_account_publish_queue");

    /* compiled from: P */
    /* renamed from: com.tencent.pubaccount.publish.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    class C9291a extends al<a, Void> {
        C9291a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    a() {
    }

    public static a d() {
        return f342314e.get(null);
    }

    public boolean a(IQueueTask iQueueTask) {
        if (iQueueTask != null && !this.f342315a.contains(iQueueTask)) {
            QZLog.i("[upload_PubAccountTaskManager]", "addTask id:" + iQueueTask.getTaskId());
            this.f342315a.add(iQueueTask);
            this.f342316b.f(iQueueTask);
            return true;
        }
        QZLog.w("[upload_PubAccountTaskManager]", "addTask error");
        return false;
    }

    public boolean b(IQueueTask iQueueTask, boolean z16) {
        if (iQueueTask != null && this.f342315a.contains(iQueueTask)) {
            QZLog.i("[upload_PubAccountTaskManager]", "completeTask id:" + iQueueTask.getTaskId() + ", succeed:" + z16);
            if (z16) {
                iQueueTask.setState(3);
                this.f342315a.remove(iQueueTask);
                this.f342316b.d(iQueueTask);
                return true;
            }
            iQueueTask.setState(2);
            this.f342316b.g(iQueueTask);
            return true;
        }
        QZLog.w("[upload_PubAccountTaskManager]", "completeTask error");
        return false;
    }

    public boolean c(IQueueTask iQueueTask) {
        return this.f342315a.contains(iQueueTask);
    }

    public long e() {
        Iterator<IQueueTask> it = this.f342315a.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            IQueueTask next = it.next();
            if (next != null && next.getState() != 3) {
                long leaveSize = next.getLeaveSize();
                if (leaveSize > 0) {
                    j3 += leaveSize;
                }
            }
        }
        QZLog.i("[upload_PubAccountTaskManager]", 2, "getLeaveSize, the size of all task is:" + j3);
        return j3;
    }

    public int f() {
        int i3 = 0;
        if (this.f342315a.isEmpty()) {
            return 0;
        }
        Iterator<IQueueTask> it = this.f342315a.iterator();
        while (it.hasNext()) {
            IQueueTask next = it.next();
            if (next != null && (next.getState() == 1 || next.getState() == 4)) {
                if (System.currentTimeMillis() - next.getTime() < 1800000) {
                    i3++;
                } else {
                    next.setState(2);
                }
            }
        }
        return i3;
    }

    public int g() {
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.f342315a;
        int i3 = 0;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IQueueTask> it = this.f342315a.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != null && next.isVideoTask() && (next.getState() == 1 || next.getState() == 4)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public int h() {
        return this.f342315a.size();
    }

    public CopyOnWriteArrayList<IQueueTask> i() {
        return (CopyOnWriteArrayList) this.f342315a.clone();
    }

    public boolean k() {
        return this.f342317c;
    }

    public void l() {
        if (this.f342315a.isEmpty()) {
            return;
        }
        QZLog.i("[upload_PubAccountTaskManager]", "pauseAllTasks");
        Iterator<IQueueTask> it = this.f342315a.iterator();
        while (it.hasNext()) {
            m(it.next());
        }
    }

    public boolean m(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f342315a.contains(iQueueTask)) {
            QZLog.i("[upload_PubAccountTaskManager]", "pauseTask id:" + iQueueTask.getTaskId());
            iQueueTask.cancel();
            iQueueTask.setState(2);
            s(iQueueTask);
            return true;
        }
        QZLog.w("[upload_PubAccountTaskManager]", "pauseTask error");
        return false;
    }

    public boolean n(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f342315a.contains(iQueueTask)) {
            QZLog.i("[upload_PubAccountTaskManager]", "removeTask id:" + iQueueTask.getTaskId());
            iQueueTask.setState(5);
            iQueueTask.onRemove();
            this.f342315a.remove(iQueueTask);
            this.f342316b.d(iQueueTask);
            return true;
        }
        QZLog.w("[upload_PubAccountTaskManager]", "removeTask error");
        return false;
    }

    public void o() {
        QZLog.i("[upload_PubAccountTaskManager]", "reset total size:" + this.f342315a.size());
        if (this.f342315a.size() > 0) {
            Iterator<IQueueTask> it = this.f342315a.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != null && !next.cancel()) {
                    next.clear();
                }
            }
        }
        this.f342315a.clear();
    }

    public boolean p() {
        if (!this.f342315a.isEmpty()) {
            return false;
        }
        ArrayList<IQueueTask> e16 = this.f342316b.e(0);
        if (e16 != null && !e16.isEmpty()) {
            Iterator<IQueueTask> it = e16.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != null) {
                    next.onRestore();
                    QZLog.i("[upload_PubAccountTaskManager]", "restore task id:" + next.getTaskId());
                }
            }
            this.f342315a.clear();
            this.f342315a.addAll(e16);
        }
        QZLog.i("[upload_PubAccountTaskManager]", "restore total size:" + this.f342315a.size());
        return this.f342315a.size() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean r() {
        boolean z16;
        int f16 = f();
        if (!NetworkState.isNetSupport()) {
            this.f342317c = f16 > 0;
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_MAX_PARALLEL_TASK_COUNT, f342313d);
        if (f16 <= config) {
            Iterator<IQueueTask> it = this.f342315a.iterator();
            z16 = false;
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != 0) {
                    if (next.getState() == 0 || next.getState() == 6) {
                        if (!next.isVideoTask() || g() <= 0) {
                            QZLog.i("[upload_PubAccountTaskManager]", "runTask id:" + next.getTaskId());
                            f16++;
                            next.setState(1);
                            QZoneBusinessLooper.getInstance().runTask((QZoneTask) next);
                            z16 = true;
                        }
                    }
                    if (f16 == config) {
                        break;
                    }
                }
            }
        } else {
            z16 = false;
        }
        this.f342317c = f16 > 0;
        return z16;
    }

    public boolean s(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f342315a.contains(iQueueTask)) {
            QZLog.i("[upload_PubAccountTaskManager]", "updateTask id:" + iQueueTask.getTaskId());
            this.f342316b.g(iQueueTask);
            return true;
        }
        QZLog.w("[upload_PubAccountTaskManager]", "updateTask error");
        return false;
    }

    public boolean q(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f342315a.contains(iQueueTask)) {
            QZLog.i("[upload_PubAccountTaskManager]", "resumeTask id:" + iQueueTask.getTaskId() + ", current state:" + iQueueTask.getState());
            int state = iQueueTask.getState();
            if (state != 2 && state != 5) {
                return true;
            }
            iQueueTask.onResume();
            if (NetworkState.isNetSupport()) {
                iQueueTask.setState(0);
            } else {
                iQueueTask.setState(6);
            }
            s(iQueueTask);
            return true;
        }
        QZLog.w("[upload_PubAccountTaskManager]", "resumeTask error");
        return false;
    }

    public boolean j() {
        for (int i3 = 0; i3 < this.f342315a.size(); i3++) {
            try {
                if (this.f342315a.get(i3).getState() == 6) {
                    return true;
                }
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
        return false;
    }
}
