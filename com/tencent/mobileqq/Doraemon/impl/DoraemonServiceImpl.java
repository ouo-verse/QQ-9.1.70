package com.tencent.mobileqq.Doraemon.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.Doraemon.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DoraemonServiceImpl implements IDoraemonService {
    static IPatchRedirector $redirector_;

    public DoraemonServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonService
    public DoraemonAPIManager createAPIManager(Activity activity, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? createAPIManager(activity, i3, str, null) : (DoraemonAPIManager) iPatchRedirector.redirect((short) 3, this, activity, Integer.valueOf(i3), str);
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonService
    public DoraemonAPIManager getDoraemonAPIModuleByUrl(com.tencent.mobileqq.webview.nativeapi.b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DoraemonAPIManager) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar, (Object) str);
        }
        if (bVar instanceof h) {
            return ((h) bVar).c(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonService
    public void prepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            DoraemonOpenAPI.b();
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonService
    public DoraemonAPIManager createAPIManager(Activity activity, int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? DoraemonOpenAPI.a(activity, i3, str, bundle) : (DoraemonAPIManager) iPatchRedirector.redirect((short) 4, this, activity, Integer.valueOf(i3), str, bundle);
    }
}
