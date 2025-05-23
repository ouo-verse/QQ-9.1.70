package com.tencent.mobileqq.login.verify;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f242688d;

    /* renamed from: a, reason: collision with root package name */
    protected int f242689a;

    /* renamed from: b, reason: collision with root package name */
    protected int f242690b;

    /* renamed from: c, reason: collision with root package name */
    protected String f242691c;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        if (f242688d == null) {
            synchronized (a.class) {
                if (f242688d == null) {
                    f242688d = new a();
                }
            }
        }
        return f242688d;
    }

    public void b(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            ReportController.r(appRuntime, "dc00898", "", this.f242691c, str, str, this.f242689a, 0, String.valueOf(this.f242690b), "", "", this.f242691c);
        }
    }
}
