package com.tencent.mobileqq.phonecontact.permission;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<String> f258490a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f258491b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f258492c;

    /* renamed from: d, reason: collision with root package name */
    public int f258493d;

    /* renamed from: e, reason: collision with root package name */
    public int f258494e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        int i3 = this.f258494e;
        int i16 = this.f258493d;
        if ((i3 & i16) == i16) {
            return true;
        }
        return false;
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (a()) {
            Runnable runnable = this.f258491b;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        Runnable runnable2 = this.f258492c;
        if (runnable2 != null) {
            runnable2.run();
        }
    }
}
