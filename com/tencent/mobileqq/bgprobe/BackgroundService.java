package com.tencent.mobileqq.bgprobe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BackgroundService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private long f200351d;

    public BackgroundService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onCreate();
        this.f200351d = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("BackgroundService", 2, "onCreate: invoked.  mCreateTimeMs: " + this.f200351d);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        long currentTimeMillis = (System.currentTimeMillis() - this.f200351d) / 1000;
        if (QLog.isColorLevel()) {
            QLog.i("BackgroundService", 2, "onDestroy: invoked.  durationSecond: " + currentTimeMillis);
        }
    }
}
