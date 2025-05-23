package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import com.tencent.gathererga.core.AppInfoProvider;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements AppInfoProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f108250a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.gathererga.core.AppInfoProvider
    @InfoID(id = 502)
    public f getAppVersionName(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar);
        }
        try {
            return new com.tencent.gathererga.core.internal.provider.c(0L, InstalledAppListMonitor.getPackageInfo(this.f108250a.getPackageManager(), this.f108250a.getPackageName(), 0).versionName);
        } catch (Throwable unused) {
            return new com.tencent.gathererga.core.internal.provider.c(-500L, null);
        }
    }

    @Override // com.tencent.gathererga.core.AppInfoProvider
    @InfoID(id = 501)
    public f getPackageName(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, this.f108250a.getPackageName());
    }

    @Override // com.tencent.gathererga.core.AppInfoProvider, com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.f108250a = context;
        }
    }
}
