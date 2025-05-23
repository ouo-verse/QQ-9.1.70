package com.tencent.biz.qqcircle.richframework.outbox;

import android.os.Handler;
import android.os.Message;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.outbox.QCircleNetDetectHelper;
import cooperation.qqcircle.utils.NetworkState;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleOutboxTaskQueue extends a implements Handler.Callback, NetworkState.NetworkStateListener {

    /* renamed from: h, reason: collision with root package name */
    private static volatile QCircleOutboxTaskQueue f91897h = null;

    /* renamed from: i, reason: collision with root package name */
    private static int f91898i = 3;

    /* renamed from: m, reason: collision with root package name */
    private static final long f91899m = TimeZone.getTimeZone(DateUtil.TIME_ZONE_8).getRawOffset();

    /* renamed from: d, reason: collision with root package name */
    private Handler f91900d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f91901e = new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue.1

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue$1$a */
        /* loaded from: classes5.dex */
        class a implements QCircleNetDetectHelper.DetectListener {
            a() {
            }

            @Override // cooperation.qqcircle.report.outbox.QCircleNetDetectHelper.DetectListener
            public void onDetectResult(boolean z16, long j3, String str) {
                if (z16) {
                    QLog.d("QCircleOutboxTaskQueue", 1, "detectQCirclenNetConnection available,resumeOutboxTasks");
                    if (QCircleOutboxTaskQueue.this.f91900d != null) {
                        QCircleOutboxTaskQueue.this.f91900d.removeCallbacks(QCircleOutboxTaskQueue.this.f91902f);
                        QCircleOutboxTaskQueue.this.f91900d.post(QCircleOutboxTaskQueue.this.f91902f);
                        return;
                    }
                    return;
                }
                if (QCircleOutboxTaskQueue.this.f91900d != null) {
                    QCircleOutboxTaskQueue.this.f91900d.removeCallbacks(QCircleOutboxTaskQueue.this.f91901e);
                    QCircleOutboxTaskQueue.this.f91900d.postDelayed(QCircleOutboxTaskQueue.this.f91901e, 10000L);
                }
                QLog.d("QCircleOutboxTaskQueue", 1, "detectQCirclenNetConnection blocked,retry again!retCode:" + j3 + ",errMsg:" + str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!NetworkState.isNetSupport()) {
                return;
            }
            if (QCircleOutboxTaskQueue.this.l() > 0) {
                QCircleNetDetectHelper.detectQCircleNetConnection(new a());
            } else {
                QLog.d("QCircleOutboxTaskQueue", 1, "no outbox tasks left,direct return!");
            }
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private Runnable f91902f = new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue.2
        @Override // java.lang.Runnable
        public void run() {
            QCircleOutboxTaskQueue.this.z();
        }
    };

    QCircleOutboxTaskQueue() {
        QLog.d("QCircleOutboxTaskQueue", 1, "new instance");
        this.f91900d = RFWThreadManager.createNewThreadHandler("QCircleOutboxTaskQueue", 10);
        NetworkState.addListener(this);
    }

    private void A(b bVar) {
        if (bVar != null && this.f91900d != null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = bVar;
            this.f91900d.sendMessage(obtain);
        }
    }

    private boolean B() {
        return d.d().m();
    }

    private boolean j(b bVar) {
        return d.d().c(bVar);
    }

    public static a k() {
        if (uq3.c.X0("qqcircle", "qqcircle_outbox_switch", 0).intValue() == 0) {
            if (f91897h == null) {
                synchronized (QCircleOutboxTaskQueue.class) {
                    if (f91897h == null) {
                        f91897h = new QCircleOutboxTaskQueue();
                        f91897h.x();
                    }
                }
            }
            return f91897h;
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        return d.d().f();
    }

    private CopyOnWriteArrayList<b> m() {
        long currentTimeMillis = System.currentTimeMillis();
        CopyOnWriteArrayList<b> g16 = d.d().g();
        QLog.d("QCircleOutboxTaskQueue", 1, "getTaskList timeCost:" + (System.currentTimeMillis() - currentTimeMillis));
        return g16;
    }

    private boolean n(b bVar) {
        if (bVar == null) {
            return false;
        }
        f91898i = uq3.c.X0("qqcircle", "qqcircle_max_retry_count", Integer.valueOf(f91898i)).intValue();
        if (bVar.getState() != 2 || !y(bVar) || bVar.getRetryNum() >= f91898i) {
            return false;
        }
        return true;
    }

    private void o(Message message) {
        b bVar = (b) message.obj;
        if (bVar == null) {
            return;
        }
        bVar.d("QCircleOutboxTaskQueue", "onAddTask");
        d.d().a(bVar);
        B();
    }

    private void p(Message message) {
        b bVar = (b) message.obj;
        if (bVar == null) {
            return;
        }
        bVar.d("QCircleOutboxTaskQueue", "onCompleteTask");
        d d16 = d.d();
        boolean z16 = true;
        if (message.arg1 != 1) {
            z16 = false;
        }
        d16.b(bVar, z16);
        B();
    }

    private void q(Message message) {
        b bVar = (b) message.obj;
        if (bVar == null) {
            return;
        }
        bVar.e("QCircleOutboxTaskQueue", "onRemoveTask", true);
        d.d().h(bVar);
        B();
    }

    private void r() {
        QLog.i("QCircleOutboxTaskQueue", 1, "onResetTask task size:" + l());
        d.d().j();
        u();
    }

    private void s() {
        if (d.d().k()) {
            Handler handler = this.f91900d;
            if (handler == null) {
                return;
            }
            handler.removeCallbacks(this.f91901e);
            this.f91900d.postDelayed(this.f91901e, 3000L);
        }
        QLog.i("QCircleOutboxTaskQueue", 1, "onRestore taskList size:" + l());
    }

    private void t(Message message) {
        b bVar = (b) message.obj;
        if (bVar == null) {
            return;
        }
        bVar.d("QCircleOutboxTaskQueue", "onResumeTask");
        d.d().l(bVar);
        B();
    }

    private void u() {
        QLog.i("QCircleOutboxTaskQueue", 1, "release uin:" + HostDataTransUtils.getAccount());
        if (this.f91900d != null) {
            RFWThreadManager.getInstance().releaseHandler(this.f91900d);
        }
        this.f91900d = null;
        f91897h = null;
    }

    private boolean v(b bVar) {
        boolean z16 = false;
        if (bVar != null && this.f91900d != null) {
            bVar.e("QCircleOutboxTaskQueue", "removeTask", true);
            if (j(bVar)) {
                if (bVar.getState() == 2) {
                    z16 = true;
                } else {
                    QLog.d("QCircleOutboxTaskQueue", 1, "removeTask id:" + bVar.getTaskId() + ",unexpect state:" + bVar.getState());
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = bVar;
            this.f91900d.sendMessage(obtain);
        }
        return z16;
    }

    private void w(b bVar) {
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_OUTBOX_TASK_RESEND_EVENT_FINAL, (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("ret_code", bVar.getResultCode() + ""), QCircleReportHelper.newEntry("url", bVar.getResultMsg()), QCircleReportHelper.newEntry("refer", bVar.c() + ""), QCircleReportHelper.newEntry("count", bVar.getRetryNum() + ""), QCircleReportHelper.newEntry("attach_info", bVar.getTaskId() + "_" + Arrays.toString(bVar.a()) + "_" + bVar.getResultCode() + "_" + bVar.getResultMsg() + "_state=" + bVar.getState())));
    }

    private void x() {
        if (this.f91900d == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        this.f91900d.sendMessage(obtain);
    }

    private boolean y(b bVar) {
        boolean z16;
        long resultCode = bVar.getResultCode();
        long[] a16 = bVar.a();
        if (a16 != null && a16.length > 0) {
            z16 = false;
            for (long j3 : a16) {
                if (j3 != resultCode) {
                }
            }
            QLog.d("QCircleOutboxTaskQueue", 1, "resultCodeCanRetry id:" + bVar.getTaskId() + " ,state:" + bVar.getState() + " ,info:" + bVar.c() + " ,retCode:" + bVar.getResultCode() + " ,curRetryNum:" + bVar.getRetryNum() + " ,retryCodes:" + Arrays.toString(bVar.a()) + " ,canRetry:" + z16);
            return z16;
        }
        z16 = true;
        QLog.d("QCircleOutboxTaskQueue", 1, "resultCodeCanRetry id:" + bVar.getTaskId() + " ,state:" + bVar.getState() + " ,info:" + bVar.c() + " ,retCode:" + bVar.getResultCode() + " ,curRetryNum:" + bVar.getRetryNum() + " ,retryCodes:" + Arrays.toString(bVar.a()) + " ,canRetry:" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        CopyOnWriteArrayList<b> m3 = m();
        if (m3 != null) {
            int size = m3.size();
            QLog.i("QCircleOutboxTaskQueue", 1, "checkRetry taskList size:" + size);
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = m3.get(i3);
                bVar.d("QCircleOutboxTaskQueue", "checkRetry");
                if (bVar.getState() != 1) {
                    if (n(bVar)) {
                        QLog.d("QCircleOutboxTaskQueue", 1, "retryTask id:" + bVar.getTaskId() + " ,state:" + bVar.getState() + " ,info:" + bVar.c() + " ,curRetryNum:" + bVar.getRetryNum());
                        A(bVar);
                    } else {
                        w(bVar);
                        QLog.d("QCircleOutboxTaskQueue", 1, "removeTask id:" + bVar.getTaskId() + " ,state:" + bVar.getState() + " ,info:" + bVar.c() + " ,curRetryNum:" + bVar.getRetryNum() + " ,resultCode:" + bVar.getResultCode());
                        v(bVar);
                    }
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.a
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.setState(2);
        b(bVar);
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.a
    public void b(b bVar) {
        if (bVar != null && this.f91900d != null) {
            bVar.setTime(System.currentTimeMillis());
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bVar;
            this.f91900d.sendMessage(obtain);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.a
    public void c() {
        if (this.f91900d == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 6;
        this.f91900d.sendMessage(obtain);
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.a
    public void d(b bVar, boolean z16) {
        if (bVar != null && this.f91900d != null) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.arg1 = z16 ? 1 : 0;
            obtain.obj = bVar;
            this.f91900d.sendMessage(obtain);
            return;
        }
        QLog.i("QCircleOutboxTaskQueue", 1, "completeTask null");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                o(message);
                return false;
            case 2:
                t(message);
                return false;
            case 3:
                q(message);
                return false;
            case 4:
                s();
                return false;
            case 5:
                p(message);
                return false;
            case 6:
                r();
                return false;
            default:
                return false;
        }
    }

    @Override // cooperation.qqcircle.utils.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        Handler handler;
        if (z16 && (handler = this.f91900d) != null) {
            handler.removeCallbacks(this.f91901e);
            this.f91900d.postDelayed(this.f91901e, 10000L);
        }
    }
}
