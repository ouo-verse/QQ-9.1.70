package com.tencent.mobileqq.qqsomonitor.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qqsomonitor.b;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SoMonitorApiImpl implements ISoMonitorApi {
    static IPatchRedirector $redirector_;

    public SoMonitorApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public int getSoFileFlag(Context context, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) file)).intValue();
        }
        return b.a(context, file);
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public String getSoFileMd5(Context context, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) file);
        }
        return b.b(context, file);
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public boolean isSoFileLegal(Context context, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) file)).booleanValue();
        }
        return b.c(context, file);
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public int isSoFileLegalDetail(Context context, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) file)).intValue();
        }
        return b.d(context, file);
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public boolean isSoFileRegistered(Context context, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) file)).booleanValue();
        }
        return b.e(context, file);
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public boolean isSoPathLegal(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        return b.f(context, str);
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public boolean isSoPathRegistered(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        return b.g(context, str);
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public void registerSoFile(Context context, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) file);
        } else {
            b.h(context, file);
        }
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi
    public void registerSoFilePath(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        } else {
            b.i(context, str);
        }
    }
}
