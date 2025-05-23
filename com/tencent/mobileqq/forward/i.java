package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static i f211026b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f211027a;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211027a = new HashMap();
        }
    }

    public static String a(String str) {
        i iVar = f211026b;
        if (iVar == null) {
            return null;
        }
        String remove = iVar.f211027a.remove(str);
        if (f211026b.f211027a.isEmpty()) {
            f211026b = null;
        }
        return remove;
    }

    public static i b() {
        if (f211026b == null) {
            f211026b = new i();
        }
        return f211026b;
    }

    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f211027a.put(str, str2);
        }
    }
}
