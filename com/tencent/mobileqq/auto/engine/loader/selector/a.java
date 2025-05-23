package com.tencent.mobileqq.auto.engine.loader.selector;

import android.content.SharedPreferences;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a implements g<ASPluginBean> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(ASPluginBean aSPluginBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aSPluginBean)).booleanValue();
        }
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("AS_SHARE_PREFERENCE", 0);
        int versionCode = aSPluginBean.getVersionCode();
        if (sharedPreferences.getInt("AS_CRASH_COUNT_" + aSPluginBean.getBusinessKey() + versionCode, 0) < uq3.c.f3()) {
            return true;
        }
        com.tencent.mobileqq.auto.engine.loader.a.e(aSPluginBean.getBusinessKey()).m().e(versionCode, aSPluginBean.getBusinessKey());
        QLog.i(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "crashValidEnable():net plugin ,current version:" + versionCode + ",crashed to many times");
        return false;
    }
}
