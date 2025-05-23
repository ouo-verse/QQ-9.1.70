package com.tencent.proxyinner.plugin.loader;

import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.intervideo.f;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.MultiLoaderPpsController;
import com.tencent.shadow.dynamic.host.QShadowMultiLoaderPluginProcessService;

/* loaded from: classes22.dex */
public class ShadowPluginsProcessService extends QShadowMultiLoaderPluginProcessService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private MultiLoaderPpsController f342217d;

    /* renamed from: e, reason: collision with root package name */
    private long f342218e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            try {
                LoggerFactory.setILoggerFactory(f.a());
            } catch (Throwable unused) {
            }
        }
    }

    public ShadowPluginsProcessService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342218e = 0L;
        }
    }

    @Override // com.tencent.shadow.dynamic.host.QShadowMultiLoaderPluginProcessService, android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IBinder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        }
        IBinder onBind = super.onBind(intent);
        this.f342217d = QShadowMultiLoaderPluginProcessService.wrapBinder(onBind);
        return onBind;
    }

    @Override // com.tencent.shadow.dynamic.host.BasePluginProcessService, android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
            this.f342218e = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.tencent.shadow.dynamic.host.BasePluginProcessService, android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        SystemMethodProxy.killProcess(Process.myPid());
        MultiLoaderPpsController multiLoaderPpsController = this.f342217d;
        if (multiLoaderPpsController != null) {
            try {
                multiLoaderPpsController.exit();
            } catch (RemoteException unused) {
            }
            this.f342217d = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        super.onStartCommand(intent, i3, i16);
        return 2;
    }

    @Override // com.tencent.shadow.dynamic.host.BasePluginProcessService, android.app.Service
    public void onTaskRemoved(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        super.onTaskRemoved(intent);
        if (SystemClock.elapsedRealtime() - this.f342218e < 1000) {
            QLog.i("ShadowPluginsProcessService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
            return;
        }
        QLog.i("ShadowPluginsProcessService", 2, "onTaskRemoved");
        MultiLoaderPpsController multiLoaderPpsController = this.f342217d;
        if (multiLoaderPpsController != null) {
            try {
                multiLoaderPpsController.exit();
            } catch (RemoteException e16) {
                throw new RuntimeException(e16);
            }
        } else {
            QLog.i("ShadowPluginsProcessService", 2, "ppsController null System.exit");
            System.exit(0);
        }
    }
}
