package com.tencent.could.component.common.ai.log;

import com.tencent.could.component.common.ai.utils.SimplePool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public SimplePool<d> f99969a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final e f99970a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14166);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f99970a = new e();
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99969a = new SimplePool<>(30, "LogInfoPool");
        }
    }

    public void a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        dVar.f99963a = 2;
        dVar.f99964b = 0L;
        dVar.f99965c = "";
        dVar.f99966d = "";
        dVar.f99967e = "";
        dVar.f99968f = "";
        synchronized (e.class) {
            this.f99969a.release(dVar);
        }
    }
}
