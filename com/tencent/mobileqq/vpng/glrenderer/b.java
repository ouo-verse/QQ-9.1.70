package com.tencent.mobileqq.vpng.glrenderer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static b f313215c;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<a> f313216a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<VPNGRenderer> f313217b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f313215c = null;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f313216a = new LinkedList<>();
            this.f313217b = new ArrayList<>(5);
        }
    }

    private VPNGRenderer a(int i3, int i16) {
        return new VPNGRenderer(i3, i16);
    }

    public static b b() {
        if (f313215c == null) {
            synchronized (b.class) {
                if (f313215c == null) {
                    f313215c = new b();
                }
            }
        }
        return f313215c;
    }

    public VPNGRenderer c(a aVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VPNGRenderer) iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (this.f313217b.size() == 5) {
            this.f313216a.add(aVar);
            return null;
        }
        VPNGRenderer a16 = a(i3, i16);
        a16.K(aVar);
        this.f313217b.add(a16);
        return a16;
    }

    public void d(VPNGRenderer vPNGRenderer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) vPNGRenderer);
            return;
        }
        if (vPNGRenderer != null) {
            vPNGRenderer.n();
            this.f313217b.remove(vPNGRenderer);
            if (this.f313217b.size() < 5 && !this.f313216a.isEmpty()) {
                a first = this.f313216a.getFirst();
                VPNGRenderer a16 = a(first.getRenderWidth(), first.getRenderHeight());
                a16.K(first);
                this.f313217b.add(a16);
                first.onSetRenderer(a16);
            }
        }
    }
}
