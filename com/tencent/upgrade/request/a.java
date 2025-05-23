package com.tencent.upgrade.request;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import pw4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f383882a;

    /* renamed from: b, reason: collision with root package name */
    private d f383883b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f383884c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f383885d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f383886e;

    public a(boolean z16, boolean z17, boolean z18, Map<String, String> map, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map, dVar);
            return;
        }
        HashMap hashMap = new HashMap();
        this.f383882a = hashMap;
        this.f383884c = z16;
        this.f383885d = z17;
        this.f383886e = z18;
        if (map != null) {
            hashMap.putAll(map);
        }
        this.f383883b = dVar;
    }

    public Map<String, String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f383882a;
    }

    public d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f383883b;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f383884c;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f383886e;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f383885d;
    }
}
