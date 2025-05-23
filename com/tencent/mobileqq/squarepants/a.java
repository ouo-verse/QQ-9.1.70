package com.tencent.mobileqq.squarepants;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.squarepants.b
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            Log.d(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.squarepants.b
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            Log.e(str, str2);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.mobileqq.squarepants.b
    public void e(String str, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            Log.e(str, "", th5);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) th5);
        }
    }
}
