package com.tencent.mobileqq.beancurd;

import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<aj> f200338a;

    /* renamed from: b, reason: collision with root package name */
    private String f200339b;

    /* renamed from: c, reason: collision with root package name */
    private int f200340c;

    /* renamed from: d, reason: collision with root package name */
    private int f200341d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f200342e;

    public b(aj ajVar, String str, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ajVar, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.f200338a = new WeakReference<>(ajVar);
        this.f200339b = str;
        this.f200340c = i3;
        this.f200341d = i16;
        this.f200342e = z16;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f200341d;
    }

    public WeakReference<aj> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f200338a;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f200339b;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f200340c;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f200342e;
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f200342e = z16;
        }
    }
}
