package com.tencent.mobileqq.qqlive.trtc.ipc;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

/* loaded from: classes17.dex */
public class TRTCPreloadService extends AppService {
    static IPatchRedirector $redirector_;

    public TRTCPreloadService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        QLog.i("TRTCPreloadService", 2, "onBind");
        return null;
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            QLog.d("TRTCPreloadService", 1, 1, "service oncreate");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.i("TRTCPreloadService", 2, "onDestroy start");
            super.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onLowMemory();
            QLog.i("TRTCPreloadService", 2, "onLowMemory");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        QLog.d("TRTCPreloadService", 1, 1, "onStartCommand " + intent);
        if (intent != null) {
            intent.getStringExtra("key_trtc_so_path");
            TRTCClientIPCModule.e().init(this);
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent)).booleanValue();
        }
        QLog.i("TRTCPreloadService", 2, "onUnbind");
        return super.onUnbind(intent);
    }
}
