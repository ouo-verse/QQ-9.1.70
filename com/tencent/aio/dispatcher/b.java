package com.tencent.aio.dispatcher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final List<b> f69241c;

    /* renamed from: a, reason: collision with root package name */
    Runnable f69242a;

    /* renamed from: b, reason: collision with root package name */
    b f69243b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f69241c = new ArrayList();
        }
    }

    b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
        } else {
            this.f69242a = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b(Runnable runnable) {
        List<b> list = f69241c;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                b remove = list.remove(size - 1);
                remove.f69242a = runnable;
                remove.f69243b = null;
                return remove;
            }
            return new b(runnable);
        }
    }

    static void c(b bVar) {
        bVar.f69242a = null;
        bVar.f69243b = null;
        List<b> list = f69241c;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(bVar);
            }
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f69242a.run();
            c(this);
        }
    }
}
