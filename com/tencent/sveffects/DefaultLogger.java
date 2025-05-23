package com.tencent.sveffects;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DefaultLogger implements Logger {
    static IPatchRedirector $redirector_;

    public DefaultLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.sveffects.Logger
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        } else {
            Log.d(str, str2);
        }
    }

    @Override // com.tencent.sveffects.Logger
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            Log.e(str, str2);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.sveffects.Logger
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else {
            Log.i(str, str2);
        }
    }

    @Override // com.tencent.sveffects.Logger
    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.sveffects.Logger
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        } else {
            Log.w(str, str2);
        }
    }

    @Override // com.tencent.sveffects.Logger
    public void e(String str, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            Log.e(str, "", th5);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) th5);
        }
    }

    @Override // com.tencent.sveffects.Logger
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            Log.e(str, str2, th5);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, str2, th5);
        }
    }
}
