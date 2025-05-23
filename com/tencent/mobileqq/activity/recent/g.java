package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final String f185396c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile g f185397d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f185398a;

    /* renamed from: b, reason: collision with root package name */
    public final List<RecentBaseData> f185399b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37603);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f185396c = g.class.getSimpleName();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185398a = false;
            this.f185399b = new ArrayList(com.tencent.mobileqq.imcore.proxy.a.f238018a);
        }
    }

    public static g c() {
        if (f185397d == null) {
            synchronized (g.class) {
                if (f185397d == null) {
                    f185397d = new g();
                }
            }
        }
        return f185397d;
    }

    public static String d(String str, int i3) {
        return str + "-" + i3;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f185399b.clear();
        }
    }

    public RecentBaseData b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecentBaseData) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return null;
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }
}
