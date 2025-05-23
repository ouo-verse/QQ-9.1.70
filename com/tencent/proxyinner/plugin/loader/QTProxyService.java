package com.tencent.proxyinner.plugin.loader;

import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;

/* loaded from: classes22.dex */
public class QTProxyService extends PluginProcessService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private PpsController f342215d;

    /* renamed from: e, reason: collision with root package name */
    private long f342216e;

    public QTProxyService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342216e = 0L;
        }
    }

    @Override // com.tencent.shadow.dynamic.host.PluginProcessService, android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IBinder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        IBinder onBind = super.onBind(intent);
        this.f342215d = PluginProcessService.wrapBinder(onBind);
        return onBind;
    }

    @Override // com.tencent.shadow.dynamic.host.BasePluginProcessService, android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            this.f342216e = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.tencent.shadow.dynamic.host.BasePluginProcessService, android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        SystemMethodProxy.killProcess(Process.myPid());
        PpsController ppsController = this.f342215d;
        if (ppsController != null) {
            try {
                ppsController.exit();
            } catch (RemoteException unused) {
            }
            this.f342215d = null;
        }
    }

    @Override // com.tencent.shadow.dynamic.host.BasePluginProcessService, android.app.Service
    public void onTaskRemoved(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.onTaskRemoved(intent);
        if (SystemClock.elapsedRealtime() - this.f342216e < 1000) {
            QLog.i("QTProxyService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
            return;
        }
        QLog.i("QTProxyService", 2, "onTaskRemoved");
        PpsController ppsController = this.f342215d;
        if (ppsController != null) {
            try {
                ppsController.exit();
            } catch (RemoteException e16) {
                throw new RuntimeException(e16);
            }
        } else {
            QLog.i("QTProxyService", 2, "ppsController null System.exit");
            System.exit(0);
        }
    }
}
