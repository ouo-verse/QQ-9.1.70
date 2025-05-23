package com.tencent.adelie.av.qav;

import android.os.SystemClock;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.mini.servlet.MiniAppGeneralServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AsyncExitTask {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f61371c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f61372d;

    /* renamed from: a, reason: collision with root package name */
    private final Object f61373a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private int f61374b = -1;

    static {
        f61372d = DeviceInfoMonitor.getModel().equalsIgnoreCase("LYA-AL00") || DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 9") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y66") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y67") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y67A") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y67L") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9Plus") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9Plus L") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s L") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s Plus") || DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s Plus L") || DeviceInfoMonitor.getModel().equalsIgnoreCase("Redmi S2");
    }

    public static void f() {
        if (f61372d || f61371c) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AsyncExitTask.1
            @Override // java.lang.Runnable
            public void run() {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                QRoute.api(IDPCApi.class);
                AsyncExitTask.f61371c = true;
                if (QLog.isColorLevel()) {
                    QLog.i("AsyncExitTask", 2, "checkAndPreloadDpcMng, cost[" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "], model[" + DeviceInfoMonitor.getModel() + "]");
                }
            }
        }, 16, null, true);
    }

    public int e(final QQGAudioCtrl qQGAudioCtrl) {
        this.f61374b = MiniAppGeneralServlet.ERR_MSF_EXCEPTION;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AsyncExitTask.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom start.");
                QQGAudioCtrl qQGAudioCtrl2 = qQGAudioCtrl;
                if (qQGAudioCtrl2 != null) {
                    AsyncExitTask.this.f61374b = qQGAudioCtrl2.quitRoom(0);
                }
                QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom end. quitResult = " + AsyncExitTask.this.f61374b);
                synchronized (AsyncExitTask.this.f61373a) {
                    AsyncExitTask.this.f61373a.notify();
                }
            }
        }, 16, null, false);
        synchronized (this.f61373a) {
            try {
                this.f61373a.wait(2000);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        int i3 = this.f61374b == -1000001 ? 261 : -1;
        QLog.d("AsyncExitTask", 1, "asyncExitRoom.quitRoom end. continue. quitResult = " + this.f61374b);
        return i3;
    }
}
