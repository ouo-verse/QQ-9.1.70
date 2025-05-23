package com.qzone.publish.business.publishqueue;

import android.text.TextUtils;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.task.IQueueTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qzonehub.api.IQzoneStateStoreApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    private static int f51129e = 5;

    /* renamed from: f, reason: collision with root package name */
    private static f f51130f;

    /* renamed from: g, reason: collision with root package name */
    private static Object f51131g = new Object();

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<IQueueTask> f51132a = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f51134c = false;

    /* renamed from: b, reason: collision with root package name */
    private e f51133b = new e();

    /* renamed from: d, reason: collision with root package name */
    private boolean f51135d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("key_qzone_pic_comment_fail_remove_switch", true);

    f() {
    }

    public static f d() {
        if (f51130f == null) {
            synchronized (f51131g) {
                if (f51130f == null) {
                    f51130f = new f();
                }
            }
        }
        return f51130f;
    }

    private void u(boolean z16) {
        this.f51134c = z16;
        ((IQzoneStateStoreApi) QRoute.api(IQzoneStateStoreApi.class)).syncRunningTaskState(z16);
    }

    public boolean a(IQueueTask iQueueTask) {
        if (iQueueTask != null && !this.f51132a.contains(iQueueTask)) {
            QZLog.i("[upload2_QzoneTaskManager]", "addTask id:" + iQueueTask.getTaskId());
            this.f51132a.add(iQueueTask);
            this.f51133b.f(iQueueTask);
            return true;
        }
        QZLog.w("[upload2_QzoneTaskManager]", "addTask error");
        return false;
    }

    public boolean b(IQueueTask iQueueTask, boolean z16) {
        if (iQueueTask != null && this.f51132a.contains(iQueueTask)) {
            QZLog.i("[upload2_QzoneTaskManager]", "completeTask id:" + iQueueTask.getTaskId() + ", succeed:" + z16 + ", resultCode:" + iQueueTask.getResultCode() + "\uff0ctask:" + iQueueTask);
            if (z16) {
                iQueueTask.setState(3);
                this.f51132a.remove(iQueueTask);
                this.f51133b.d(iQueueTask);
                return true;
            }
            if (this.f51135d && (iQueueTask instanceof com.qzone.publish.business.task.a) && iQueueTask.getResultCode() != 0) {
                this.f51132a.remove(iQueueTask);
                this.f51133b.d(iQueueTask);
                QZLog.i("[upload2_QzoneTaskManager]", "completeTask  picComment fail remove");
            } else {
                iQueueTask.setState(2);
                this.f51133b.g(iQueueTask);
            }
            a9.b.f25722a.a(iQueueTask);
            return true;
        }
        QZLog.w("[upload2_QzoneTaskManager]", "completeTask error");
        return false;
    }

    public boolean c(IQueueTask iQueueTask) {
        return this.f51132a.contains(iQueueTask);
    }

    public long e() {
        Iterator<IQueueTask> it = this.f51132a.iterator();
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
        QZLog.i("[upload2_QzoneTaskManager]", 2, "getLeaveSize, the size of all task is:" + j3);
        return j3;
    }

    public int f() {
        int i3 = 0;
        if (this.f51132a.isEmpty()) {
            return 0;
        }
        Iterator<IQueueTask> it = this.f51132a.iterator();
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
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = this.f51132a;
        int i3 = 0;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IQueueTask> it = this.f51132a.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != null && next.isVideoTask() && (next.getState() == 1 || next.getState() == 4)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public IQueueTask h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (IQueueTask iQueueTask : this.f51132a) {
            if (str.equals(iQueueTask.getCommentUniKey())) {
                return iQueueTask;
            }
        }
        return null;
    }

    public int i() {
        return this.f51132a.size();
    }

    public CopyOnWriteArrayList<IQueueTask> j() {
        return (CopyOnWriteArrayList) this.f51132a.clone();
    }

    public List<IQueueTask> k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (IQueueTask iQueueTask : this.f51132a) {
            if (iQueueTask != null && str.equals(iQueueTask.getClientKey())) {
                arrayList.add(iQueueTask);
            }
        }
        return arrayList;
    }

    public boolean m() {
        return this.f51134c;
    }

    public void n() {
        if (this.f51132a.isEmpty()) {
            return;
        }
        QZLog.i("[upload2_QzoneTaskManager]", "pauseAllTasks");
        Iterator<IQueueTask> it = this.f51132a.iterator();
        while (it.hasNext()) {
            o(it.next());
        }
        u(false);
    }

    public boolean o(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f51132a.contains(iQueueTask)) {
            QZLog.i("[upload2_QzoneTaskManager]", "pauseTask id:" + iQueueTask.getTaskId());
            iQueueTask.cancel();
            iQueueTask.setState(2);
            v(iQueueTask);
            return true;
        }
        QZLog.w("[upload2_QzoneTaskManager]", "pauseTask error");
        return false;
    }

    public boolean p(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f51132a.contains(iQueueTask)) {
            QZLog.i("[upload2_QzoneTaskManager]", "removeTask id:" + iQueueTask.getTaskId());
            iQueueTask.setState(5);
            iQueueTask.onRemove();
            this.f51132a.remove(iQueueTask);
            this.f51133b.d(iQueueTask);
            return true;
        }
        QZLog.w("[upload2_QzoneTaskManager]", "removeTask error");
        return false;
    }

    public void q() {
        QZLog.i("[upload2_QzoneTaskManager]", "reset total size:" + this.f51132a.size());
        if (this.f51132a.size() > 0) {
            Iterator<IQueueTask> it = this.f51132a.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != null && !next.cancel()) {
                    next.clear();
                }
            }
        }
        this.f51132a.clear();
    }

    public boolean r() {
        ArrayList<IQueueTask> arrayList;
        if (!this.f51132a.isEmpty()) {
            return false;
        }
        try {
            arrayList = this.f51133b.e(0);
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<IQueueTask> it = arrayList.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != null) {
                    next.onRestore();
                    QZLog.i("[upload2_QzoneTaskManager]", "restore task id:" + next.getTaskId());
                }
            }
            this.f51132a.clear();
            this.f51132a.addAll(arrayList);
        }
        QZLog.i("[upload2_QzoneTaskManager]", "restore total size:" + this.f51132a.size());
        return this.f51132a.size() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean t() {
        boolean z16;
        int f16 = f();
        if (!NetworkState.isNetSupport()) {
            u(f16 > 0);
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_MAX_PARALLEL_TASK_COUNT, f51129e);
        if (f16 <= config) {
            Iterator<IQueueTask> it = this.f51132a.iterator();
            z16 = false;
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != 0) {
                    if (next.getState() == 0 || next.getState() == 6) {
                        if (!next.isVideoTask() || g() <= 0) {
                            QZLog.i("[upload2_QzoneTaskManager]", "runTask id:" + next.getTaskId());
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
            QZLog.i("[upload2_QzoneTaskManager]", "runningTaskCount:" + f16);
            z16 = false;
        }
        u(f16 > 0);
        return z16;
    }

    public boolean v(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f51132a.contains(iQueueTask)) {
            QZLog.i("[upload2_QzoneTaskManager]", "updateTask id:" + iQueueTask.getTaskId());
            this.f51133b.g(iQueueTask);
            return true;
        }
        QZLog.w("[upload2_QzoneTaskManager]", "updateTask error");
        return false;
    }

    public boolean s(IQueueTask iQueueTask) {
        if (iQueueTask != null && this.f51132a.contains(iQueueTask)) {
            QZLog.i("[upload2_QzoneTaskManager]", "resumeTask id:" + iQueueTask.getTaskId() + ", current state:" + iQueueTask.getState());
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
            v(iQueueTask);
            return true;
        }
        QZLog.w("[upload2_QzoneTaskManager]", "resumeTask error");
        return false;
    }

    public boolean l() {
        for (int i3 = 0; i3 < this.f51132a.size(); i3++) {
            try {
                if (this.f51132a.get(i3).getState() == 6) {
                    return true;
                }
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
        return false;
    }
}
