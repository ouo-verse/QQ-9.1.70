package com.tencent.common.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f99536a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f99537b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66007);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99536a = new AtomicBoolean(false);
            f99537b = false;
        }
    }

    public static void a() {
        QLog.d("LaunchReportHelper", 1, "launchFromIconClickToUnreadRefresh onRegisterProxyAllEnd");
        f99537b = true;
    }
}
