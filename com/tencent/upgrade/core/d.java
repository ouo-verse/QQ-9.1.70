package com.tencent.upgrade.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.upgrade.storage.b<Integer> f383820a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.upgrade.storage.b<Long> f383821b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static d f383822a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8385);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f383822a = new d(null);
            }
        }
    }

    /* synthetic */ d(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
    }

    public static d a() {
        return b.f383822a;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            com.tencent.upgrade.util.d.a("PopFrequencyLimiter", "onNotifyNewStrategy");
            this.f383820a.b(0);
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383820a = new com.tencent.upgrade.storage.b<>("dialog_pop_time", 0, j.l().n());
            this.f383821b = new com.tencent.upgrade.storage.b<>("dialog_last_show_time", 0L, j.l().n());
        }
    }
}
