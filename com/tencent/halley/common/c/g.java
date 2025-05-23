package com.tencent.halley.common.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class g implements Serializable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    long f113405a;

    /* renamed from: b, reason: collision with root package name */
    String f113406b;

    /* renamed from: c, reason: collision with root package name */
    String f113407c;

    /* renamed from: d, reason: collision with root package name */
    long f113408d;

    /* renamed from: e, reason: collision with root package name */
    long f113409e;

    /* renamed from: f, reason: collision with root package name */
    private String f113410f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f113411g;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final synchronized String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return this.f113410f;
        }
        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public final synchronized Map<String, String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f113411g;
    }

    public final synchronized void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f113410f = str;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
    }

    public final synchronized void a(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f113411g = map;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) map);
        }
    }
}
