package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashSet;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f384392a;

    /* renamed from: b, reason: collision with root package name */
    public final String f384393b;

    /* renamed from: c, reason: collision with root package name */
    public String f384394c;

    /* renamed from: d, reason: collision with root package name */
    public int f384395d;

    /* renamed from: e, reason: collision with root package name */
    public int f384396e;

    /* renamed from: f, reason: collision with root package name */
    public Locale f384397f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f384398g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f384399h;

    /* renamed from: i, reason: collision with root package name */
    public int f384400i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f384401j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f384402k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashSet<ww4.a> f384403l;

    public d(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.f384403l = new LinkedHashSet<>();
        if (str != null) {
            this.f384392a = str;
            this.f384393b = str;
            this.f384395d = i3;
            this.f384400i = 2;
            this.f384396e = 25;
            this.f384397f = Locale.getDefault();
            this.f384394c = (i3 & 256) != 0 ? "vfslog" : null;
            return;
        }
        throw new IllegalArgumentException("path must not be null.");
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f384392a.equalsIgnoreCase(":memory:");
    }

    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
            return;
        }
        if (dVar != null) {
            if (this.f384392a.equals(dVar.f384392a)) {
                this.f384395d = dVar.f384395d;
                this.f384396e = dVar.f384396e;
                this.f384397f = dVar.f384397f;
                this.f384398g = dVar.f384398g;
                this.f384399h = dVar.f384399h;
                this.f384401j = dVar.f384401j;
                this.f384402k = dVar.f384402k;
                this.f384400i = dVar.f384400i;
                this.f384394c = dVar.f384394c;
                this.f384403l.clear();
                this.f384403l.addAll(dVar.f384403l);
                return;
            }
            throw new IllegalArgumentException("other configuration must refer to the same database.");
        }
        throw new IllegalArgumentException("other must not be null.");
    }

    public d(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        this.f384403l = new LinkedHashSet<>();
        if (dVar != null) {
            this.f384392a = dVar.f384392a;
            this.f384393b = dVar.f384393b;
            b(dVar);
            return;
        }
        throw new IllegalArgumentException("other must not be null.");
    }
}
