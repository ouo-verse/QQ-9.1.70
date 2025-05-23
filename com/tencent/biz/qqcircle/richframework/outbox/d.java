package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.NetworkState;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static int f91916d = 5;

    /* renamed from: e, reason: collision with root package name */
    private static volatile d f91917e;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<b> f91918a = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f91920c = false;

    /* renamed from: b, reason: collision with root package name */
    private c f91919b = new c("QCircleOutboxTaskCacheManager_outbox_queue");

    d() {
    }

    public static d d() {
        if (f91917e == null) {
            synchronized (d.class) {
                if (f91917e == null) {
                    f91917e = new d();
                }
            }
        }
        return f91917e;
    }

    private void i(b bVar) {
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_OUTBOX_TASK_RESEND_EVENT_FINAL, (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("ret_code", bVar.getResultCode() + ""), QCircleReportHelper.newEntry("url", bVar.getResultMsg()), QCircleReportHelper.newEntry("refer", bVar.c() + ""), QCircleReportHelper.newEntry("count", bVar.getRetryNum() + ""), QCircleReportHelper.newEntry("attach_info", bVar.getTaskId() + "_" + Arrays.toString(bVar.a()) + "_" + bVar.getResultCode() + "_" + bVar.getResultMsg() + "_state=" + bVar.getState())));
    }

    public boolean a(b bVar) {
        if (bVar != null && !this.f91918a.contains(bVar)) {
            QLog.i("QCircleOutboxTaskManager", 1, "addTask id:" + bVar.getTaskId());
            this.f91918a.add(bVar);
            this.f91919b.d(bVar);
            return true;
        }
        QLog.w("QCircleOutboxTaskManager", 1, "addTask error");
        return false;
    }

    public boolean b(b bVar, boolean z16) {
        if (bVar != null && this.f91918a.contains(bVar)) {
            if (z16) {
                bVar.setState(3);
                this.f91918a.remove(bVar);
                this.f91919b.b(bVar);
                i(bVar);
            } else {
                this.f91918a.remove(bVar);
                bVar.setState(2);
                this.f91919b.e(bVar);
            }
            QLog.i("QCircleOutboxTaskManager", 1, "completeTask id:" + bVar.getTaskId() + ", succeed:" + z16 + ", resultCode:" + bVar.getResultCode() + ", resultMsg:" + bVar.getResultMsg());
            return true;
        }
        QLog.w("QCircleOutboxTaskManager", 1, "completeTask error");
        return false;
    }

    public boolean c(b bVar) {
        return this.f91918a.contains(bVar);
    }

    public int e() {
        int i3 = 0;
        if (this.f91918a.isEmpty()) {
            return 0;
        }
        Iterator<b> it = this.f91918a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.getState() == 1) {
                if (System.currentTimeMillis() - next.getTime() < 60000) {
                    i3++;
                } else {
                    next.setState(2);
                    next.e("QCircleOutboxTaskManager", "getRunningTaskCount resend timeout!", true);
                }
            }
        }
        return i3;
    }

    public int f() {
        return this.f91918a.size();
    }

    public CopyOnWriteArrayList<b> g() {
        return (CopyOnWriteArrayList) this.f91918a.clone();
    }

    public boolean h(b bVar) {
        if (bVar != null && this.f91918a.contains(bVar)) {
            QLog.i("QCircleOutboxTaskManager", 1, "removeTask id:" + bVar.getTaskId());
            bVar.setState(4);
            bVar.onRemove();
            this.f91918a.remove(bVar);
            this.f91919b.b(bVar);
            return true;
        }
        QLog.w("QCircleOutboxTaskManager", 1, "removeTask error");
        return false;
    }

    public void j() {
        QLog.i("QCircleOutboxTaskManager", 1, "reset total size:" + this.f91918a.size());
        if (this.f91918a.size() > 0) {
            Iterator<b> it = this.f91918a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.clear();
                }
            }
        }
        this.f91918a.clear();
        f91917e = null;
    }

    public boolean k() {
        if (!this.f91918a.isEmpty()) {
            return false;
        }
        ArrayList<b> c16 = this.f91919b.c();
        if (c16 != null && !c16.isEmpty()) {
            Iterator<b> it = c16.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.d("QCircleOutboxTaskManager", CanvasView.ACTION_RESTORE);
                if (next.getState() != 1) {
                    next.onRestore();
                }
            }
            this.f91918a.clear();
            this.f91918a.addAll(c16);
        }
        QLog.i("QCircleOutboxTaskManager", 1, "restore total size:" + this.f91918a.size());
        if (this.f91918a.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean l(b bVar) {
        if (bVar != null && this.f91918a.contains(bVar)) {
            QLog.i("QCircleOutboxTaskManager", 1, "resumeTask id:" + bVar.getTaskId() + ", current state:" + bVar.getState());
            bVar.onResume();
            return true;
        }
        QLog.w("QCircleOutboxTaskManager", 1, "resumeTask error");
        return false;
    }

    public boolean m() {
        boolean z16;
        int e16 = e();
        boolean z17 = true;
        if (!NetworkState.isNetSupport()) {
            if (e16 <= 0) {
                z17 = false;
            }
            this.f91920c = z17;
            return false;
        }
        int intValue = uq3.c.X0("qqcircle", "qqcircle_max_parallel_task_count", Integer.valueOf(f91916d)).intValue();
        if (e16 <= intValue) {
            Iterator<b> it = this.f91918a.iterator();
            z16 = false;
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    if (next.getState() == 2) {
                        QLog.i("QCircleOutboxTaskManager", 1, "runTask id:" + next.getTaskId());
                        e16++;
                        next.setState(1);
                        next.f();
                        z16 = true;
                    }
                    if (e16 == intValue) {
                        break;
                    }
                }
            }
        } else {
            z16 = false;
        }
        if (e16 <= 0) {
            z17 = false;
        }
        this.f91920c = z17;
        return z16;
    }
}
