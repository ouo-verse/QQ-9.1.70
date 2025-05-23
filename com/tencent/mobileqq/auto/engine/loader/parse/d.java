package com.tencent.mobileqq.auto.engine.loader.parse;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    public d(ASPluginBean aSPluginBean) {
        super(aSPluginBean);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean);
        }
    }

    private boolean g(ASPluginBean aSPluginBean) {
        if (aSPluginBean == null) {
            return false;
        }
        if (((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(aSPluginBean.getPluginMangerApkPath()) && ((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(aSPluginBean.getPluginZipPath())) {
            File file = new File(aSPluginBean.getPluginMangerApkPath());
            File file2 = new File(aSPluginBean.getPluginZipPath());
            if (file.length() == aSPluginBean.getManagerFileLength() && file2.length() == aSPluginBean.getZipFileLength()) {
                QLog.i("ASDynamicEngine", 1, "parseNet#fileLengthValid():true");
                return true;
            }
        }
        QLog.i(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, "parseNet#fileLengthValid():false");
        return false;
    }

    private ASPluginBean h() {
        String pluginZipPath = this.f199872h.getPluginZipPath();
        String pluginMangerApkPath = this.f199872h.getPluginMangerApkPath();
        if (((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(pluginZipPath) && ((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(pluginMangerApkPath) && g(this.f199872h)) {
            QLog.i(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, "parseNet#:net plugin has in folder");
            String j3 = c.j(new File(pluginZipPath));
            if (!e(j3, pluginZipPath, "parseNet#")) {
                return null;
            }
            ASPluginBean c16 = c(d(new File(this.f199874m.e(j3, new File(pluginZipPath)), "config.json").getAbsolutePath()));
            if (!i(c16)) {
                return null;
            }
            c16.setType(this.f199871f).setBusinessKey(this.f199872h.getBusinessKey()).setPluginZipPath(pluginZipPath).setPluginMangerApkPath(pluginMangerApkPath).setManagerFileLength(this.f199872h.getManagerFileLength()).setZipFileLength(this.f199872h.getZipFileLength()).setVersionCode(this.f199873i);
            return c16;
        }
        QLog.i(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, "parseNet#:net plugin not valid");
        return null;
    }

    private boolean i(ASPluginBean aSPluginBean) {
        if (aSPluginBean == null) {
            return false;
        }
        if (aSPluginBean.getVersionCode() != this.f199873i) {
            QLog.i(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, "parseNet#:version not match,config version:" + aSPluginBean.getVersionCode() + " netVersion:" + this.f199873i);
            return false;
        }
        if (aSPluginBean.getSupportMinHostVersion() <= a()) {
            return true;
        }
        QLog.i("ASDynamicEngine", 1, "parseNet#:version not match,host version too low supportMinHostVersion:" + aSPluginBean.getSupportMinHostVersion() + " hostVersion:" + a());
        return false;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ASPluginBean call() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return h();
    }
}
