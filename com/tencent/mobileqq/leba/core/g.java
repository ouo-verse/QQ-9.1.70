package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f240380a;

    /* renamed from: b, reason: collision with root package name */
    protected static boolean f240381b;

    /* renamed from: c, reason: collision with root package name */
    protected static HashMap<String, String> f240382c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f240380a = "LebaWebPreloadHelper";
        f240381b = false;
        f240382c = new HashMap<>();
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void c(boolean z16) {
        f240381b = z16;
    }

    public boolean a(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        if (f240382c.isEmpty()) {
            d(appRuntime);
        }
        return f240382c.containsKey(str);
    }

    public void b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime == null) {
            QLog.i(f240380a, 1, "notifyRefreshWebProcess");
            return;
        }
        IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) appRuntime.getRuntimeService(IWebProcessManagerService.class, "");
        if (f240381b) {
            iWebProcessManagerService.startWebProcessUnderStrategy(2, null);
        }
    }

    public void d(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime == null) {
            QLog.i(f240380a, 1, "updateBuffer");
            return;
        }
        f240382c.clear();
        Set<String> k3 = t.m("busi_preload_").k("key_web_plugin_list" + appRuntime.getCurrentAccountUin(), null);
        if (k3 != null && !k3.isEmpty()) {
            for (String str : k3) {
                f240382c.put(str, str);
            }
        }
    }
}
