package com.tencent.mobileqq.uniformdownload.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, com.tencent.mobileqq.uniformdownload.util.d> f305888a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305888a = new HashMap();
        }
    }

    public synchronized void a(String str, com.tencent.mobileqq.uniformdownload.util.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) dVar);
            return;
        }
        if (str != null && dVar != null) {
            this.f305888a.put(str, dVar);
        }
    }

    public synchronized com.tencent.mobileqq.uniformdownload.util.d b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.uniformdownload.util.d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return this.f305888a.remove(str);
    }

    public synchronized com.tencent.mobileqq.uniformdownload.util.d c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.uniformdownload.util.d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        return this.f305888a.get(str);
    }
}
