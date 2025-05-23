package com.tencent.ams.fusion.service.b.a;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements jt.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // jt.a
    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            Log.v(str, str2);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // jt.a
    public void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str2.length() < 4000) {
            Log.d(str, str2);
            return;
        }
        int length = (str2.length() / 4000) + 1;
        int i3 = 0;
        while (i3 < length) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("part ");
            sb5.append(i3);
            sb5.append(", ");
            int i16 = i3 * 4000;
            i3++;
            sb5.append(str2.substring(i16, Math.min(i3 * 4000, str2.length())));
            Log.d(str, sb5.toString());
        }
    }

    @Override // jt.a
    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else {
            Log.i(str, str2);
        }
    }

    @Override // jt.a
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            Log.w(str, str2);
        }
    }

    @Override // jt.a
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        } else {
            Log.e(str, str2);
        }
    }

    @Override // jt.a
    public void a(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            Log.e(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, th5);
        }
    }
}
