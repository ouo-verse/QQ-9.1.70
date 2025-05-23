package com.tencent.tuxmetersdk.impl;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxLogImpl implements ITuxLog {
    static IPatchRedirector $redirector_;

    public TuxLogImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean isLogParamsEmpty(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            if (isLogParamsEmpty(str, str2)) {
                return;
            }
            Log.d(str, str2);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        } else {
            if (isLogParamsEmpty(str, str2)) {
                return;
            }
            Log.e(str, str2);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else {
            if (isLogParamsEmpty(str, str2)) {
                return;
            }
            Log.i(str, str2);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
    public void v(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            if (isLogParamsEmpty(str, str2)) {
                return;
            }
            Log.v(str, str2);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            if (isLogParamsEmpty(str, str2)) {
                return;
            }
            Log.w(str, str2);
        }
    }
}
