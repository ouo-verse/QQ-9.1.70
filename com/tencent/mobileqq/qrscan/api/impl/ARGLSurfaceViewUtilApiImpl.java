package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qrscan.api.IARGLSurfaceViewUtilApi;
import com.tencent.mobileqq.qrscan.utils.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ARGLSurfaceViewUtilApiImpl implements IARGLSurfaceViewUtilApi {
    static IPatchRedirector $redirector_;

    public ARGLSurfaceViewUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IARGLSurfaceViewUtilApi
    public boolean doNotInterceptOpenCamera(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (appRuntime == null) {
            return false;
        }
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("scan_intercept_open_camera");
    }

    @Override // com.tencent.mobileqq.qrscan.api.IARGLSurfaceViewUtilApi
    public boolean isNeedCloseCamera(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return a.a().b(appRuntime);
    }
}
