package com.tencent.mobileqq.dt.app;

import com.tencent.mobileqq.dt.model.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static a f203717c;

    /* renamed from: a, reason: collision with root package name */
    private h f203718a;

    /* renamed from: b, reason: collision with root package name */
    private MMKVOptionEntity f203719b;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    public static a c() {
        if (f203717c == null) {
            synchronized (a.class) {
                if (f203717c == null) {
                    f203717c = new a();
                }
            }
        }
        return f203717c;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f203719b = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f203718a = new h();
        }
    }

    public h d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f203718a == null) {
            synchronized (this) {
                if (this.f203718a == null) {
                    b();
                }
            }
        }
        return this.f203718a;
    }
}
