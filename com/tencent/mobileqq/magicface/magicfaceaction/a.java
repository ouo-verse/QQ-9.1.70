package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f243374a;

    /* renamed from: b, reason: collision with root package name */
    public String f243375b;

    /* renamed from: c, reason: collision with root package name */
    public String f243376c;

    /* renamed from: d, reason: collision with root package name */
    public int f243377d;

    /* renamed from: e, reason: collision with root package name */
    public int f243378e;

    /* renamed from: f, reason: collision with root package name */
    public List<d> f243379f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243378e = -1;
            this.f243379f = new ArrayList();
        }
    }

    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        for (d dVar : this.f243379f) {
            if (dVar.f243386a <= i3 && dVar.f243387b > i3) {
                return dVar.f243388c;
            }
        }
        return 0;
    }
}
