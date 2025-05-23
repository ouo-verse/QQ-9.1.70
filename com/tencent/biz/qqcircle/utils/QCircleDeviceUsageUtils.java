package com.tencent.biz.qqcircle.utils;

import android.os.Process;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDeviceUsageUtils {

    /* renamed from: f, reason: collision with root package name */
    private static volatile QCircleDeviceUsageUtils f92526f;

    /* renamed from: a, reason: collision with root package name */
    private float f92527a;

    /* renamed from: b, reason: collision with root package name */
    private int f92528b;

    /* renamed from: c, reason: collision with root package name */
    private int f92529c;

    /* renamed from: d, reason: collision with root package name */
    private UpdateDeviceStatusTask f92530d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f92531e = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class UpdateDeviceStatusTask implements Runnable {
        UpdateDeviceStatusTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QCircleDeviceUsageUtils.e().f92531e.get()) {
                QCircleDeviceUsageUtils.e().k();
                QCircleDeviceUsageUtils.e().h(true);
            }
        }
    }

    private int d() {
        return uq3.o.S(5000);
    }

    public static QCircleDeviceUsageUtils e() {
        if (f92526f == null) {
            synchronized (QCircleDeviceUsageUtils.class) {
                if (f92526f == null) {
                    f92526f = new QCircleDeviceUsageUtils();
                }
            }
        }
        return f92526f;
    }

    private boolean f() {
        return uq3.o.c1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z16) {
        if (!f()) {
            return;
        }
        this.f92530d = new UpdateDeviceStatusTask();
        if (z16) {
            RFWThreadManager.getInstance().execOnFileThread(this.f92530d, d());
        } else {
            RFWThreadManager.getInstance().execOnFileThread(this.f92530d, 0L);
        }
    }

    private void j() {
        this.f92527a = CpuUtil.f258160a.g(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            if (!BaseGesturePWDUtil.isAppOnForeground(BaseApplication.context)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            j();
            l();
            QLog.d("QCircleDeviceUsageUtils", 1, "[updateDeviceUsageInfo] cpu:" + this.f92527a + " | currentFd:" + this.f92528b + " | maxFdLimit: " + this.f92529c + " | cost: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th5) {
            QLog.d("QCircleDeviceUsageUtils", 2, "[updateDeviceUsageInfo] ex: ", th5);
        }
    }

    private void l() {
        this.f92528b = com.tencent.qqperf.tools.e.a();
        this.f92529c = com.tencent.qqperf.tools.e.c();
    }

    public void g() {
        if (this.f92530d != null) {
            RFWThreadManager.getInstance().remove(this.f92530d);
        }
        this.f92531e.set(false);
    }

    public void i() {
        this.f92531e.set(true);
        h(false);
    }
}
