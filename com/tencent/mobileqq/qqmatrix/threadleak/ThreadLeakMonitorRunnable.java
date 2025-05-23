package com.tencent.mobileqq.qqmatrix.threadleak;

import com.tencent.mobileqq.qqmatrix.b;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ThreadLeakMonitorRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final zi2.a f274134d;

    @Override // java.lang.Runnable
    public void run() {
        if (this.f274134d == null) {
            QLog.d("ThreadLeakMonitorRunnable", 2, "QQThreadMonitorManager has been cleared.");
            return;
        }
        if (!a.o()) {
            QLog.d("ThreadLeakMonitorRunnable", 2, "check last time, don`t need to monitor.");
            return;
        }
        int e16 = a.e();
        boolean b16 = this.f274134d.b();
        QLog.d("ThreadLeakMonitorRunnable", 1, "threadCountNum\uff1a" + e16);
        if (!b16 && e16 >= b.b().f()) {
            QLog.d("ThreadLeakMonitorRunnable", 1, "initMatrixHooks");
            b16 = this.f274134d.a();
        } else {
            QLog.d("ThreadLeakMonitorRunnable", 1, "Don`t Need to initMatrixHooks");
        }
        if (b16 && e16 >= b.b().c()) {
            QLog.d("ThreadLeakMonitorRunnable", 1, "start dump thread info");
            JSONObject b17 = a.b();
            if (a.g(b17, e16)) {
                a.l(b17);
                a.p();
                return;
            } else {
                QLog.w("ThreadLeakMonitorRunnable", 1, "errors happen while parcelling result.");
                return;
            }
        }
        QLog.d("ThreadLeakMonitorRunnable", 1, "Don`t reach threshold or Matrix don`t load.");
    }
}
