package com.tencent.mobileqq.uniformdownload.api.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.d;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UniformDownloadMgrImpl implements IUniformDownloadMgr {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UniformDownloadMgrImpl";

    public UniformDownloadMgrImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public AppRuntime getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return UniformDownloadMgr.m().k();
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public boolean isExistedDownloadOfUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        return UniformDownloadMgr.m().q(str);
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public void onActiveAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            UniformDownloadMgr.m().s();
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public void onAppInit(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
        } else {
            UniformDownloadMgr.m().u(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime);
        } else if (!(appRuntime instanceof BaseQQAppInterface)) {
            QLog.d(TAG, 1, "[onCreate] can not get app, only support process main.");
        } else {
            QLog.d(TAG, 1, "[onCreate] run UniformDownloadMgr onAppInit...");
            UniformDownloadMgr.m().u(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            UniformDownloadMgr.m().t();
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public void onQQProcessExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            UniformDownloadMgr.m().v();
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public void removeOuterListenner(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            UniformDownloadMgr.m().y(str);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public void startDownload(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            UniformDownloadMgr.m().B(str, bundle);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public void startDownloadNoSzie(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bundle);
        } else {
            UniformDownloadMgr.m().E(str, bundle);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr
    public void startDownload(String str, Bundle bundle, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            UniformDownloadMgr.m().C(str, bundle, dVar);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, bundle, dVar);
        }
    }
}
