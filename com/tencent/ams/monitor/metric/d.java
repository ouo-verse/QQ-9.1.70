package com.tencent.ams.monitor.metric;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<j> f70580a;

    public d(WeakReference<j> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
        } else {
            this.f70580a = weakReference;
        }
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            b(str, str2, null);
        }
    }

    public void b(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, th5);
            return;
        }
        WeakReference<j> weakReference = this.f70580a;
        if (weakReference == null) {
            Log.d(str, str2, th5);
            return;
        }
        j jVar = weakReference.get();
        if (jVar != null) {
            jVar.d(str, str2, th5);
        }
    }

    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        } else {
            d(str, str2, null);
        }
    }

    public void d(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, th5);
            return;
        }
        WeakReference<j> weakReference = this.f70580a;
        if (weakReference == null) {
            Log.e(str, str2, th5);
            return;
        }
        j jVar = weakReference.get();
        if (jVar != null) {
            jVar.e(str, str2, th5);
        }
    }

    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else {
            f(str, str2, null);
        }
    }

    public void f(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, th5);
            return;
        }
        WeakReference<j> weakReference = this.f70580a;
        if (weakReference == null) {
            Log.i(str, str2, th5);
            return;
        }
        j jVar = weakReference.get();
        if (jVar != null) {
            jVar.i(str, str2, th5);
        }
    }
}
