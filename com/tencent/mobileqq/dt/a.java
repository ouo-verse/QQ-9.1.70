package com.tencent.mobileqq.dt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.remoteconfig.CommonRemoteConfig;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends CommonRemoteConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f203614a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f203614a = new d();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public String getConfigByKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return this.f203614a.a();
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public boolean isInitialized() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.CommonRemoteConfig
    protected void onInit(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.CommonRemoteConfig
    protected void onLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f203614a = d.b();
        QLog.d("QMCRemoteConfig", 1, "loadConfig callback, config: " + this.f203614a.a() + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        onRemoteConfigLoaded();
    }
}
