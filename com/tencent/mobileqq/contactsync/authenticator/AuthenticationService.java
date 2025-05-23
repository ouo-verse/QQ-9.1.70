package com.tencent.mobileqq.contactsync.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AuthenticationService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f202999d;

    public AuthenticationService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IBinder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        return this.f202999d.getIBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            this.f202999d = new a(this);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
