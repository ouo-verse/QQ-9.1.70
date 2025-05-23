package com.tencent.qimei.ag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Set<String> f342977a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<String> f342978b;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashSet hashSet = new HashSet();
        this.f342977a = hashSet;
        this.f342978b = new HashSet();
        hashSet.add("j1");
    }

    public final synchronized boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        boolean contains = this.f342978b.contains(str);
        if (!contains) {
            this.f342978b.add(str);
        }
        return contains;
    }
}
