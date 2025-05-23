package com.tencent.mobileqq.contactsync.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.phonecontact.adapter.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SyncService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f203001d;

    /* renamed from: e, reason: collision with root package name */
    private static a f203002e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71349);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f203001d = new Object();
            f203002e = null;
        }
    }

    public SyncService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        return f203002e.getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onCreate();
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (com.tencent.common.a.a(this, false) && com.tencent.common.a.b(this, false)) {
            Intent intent = new Intent();
            intent.putExtra(CoreService.KEY_START_MODE, 1);
            mobileQQ.onActivityCreate(this, intent);
        }
        synchronized (f203001d) {
            if (f203002e == null) {
                f203002e = new a(getApplicationContext(), true);
            }
        }
    }
}
