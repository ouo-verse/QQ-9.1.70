package com.tencent.mobileqq.uniformdownload.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UniformDownloadUtilImpl implements IUniformDownloadUtil {
    static IPatchRedirector $redirector_;

    public UniformDownloadUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil
    public String getApkName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return UniformDownloadUtil.c(str);
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil
    public void getFileInfoOfUrlAsync(String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
        } else {
            UniformDownloadUtil.e(str, aVar);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil
    public void installAPK(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            UniformDownloadUtil.g(str);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil
    public int openApk(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        return UniformDownloadUtil.j(str);
    }
}
