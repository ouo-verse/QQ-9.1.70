package com.tencent.mobileqq.leba.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f240363a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f240363a = CommPluginHandler.class.getName();
        }
    }

    public static void a(AppRuntime appRuntime) {
        CommPluginHandler commPluginHandler = (CommPluginHandler) ((AppInterface) appRuntime).getBusinessHandler(f240363a);
        commPluginHandler.E2();
        commPluginHandler.F2();
    }

    public static void b(AppRuntime appRuntime) {
        ((CommPluginHandler) ((AppInterface) appRuntime).getBusinessHandler(f240363a)).H2(appRuntime);
    }
}
