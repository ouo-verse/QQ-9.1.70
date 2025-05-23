package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Melon extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static Map<Integer, byte[]> f382923d;

    /* renamed from: e, reason: collision with root package name */
    public static Pomelo f382924e;

    /* renamed from: a, reason: collision with root package name */
    public int f382925a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, byte[]> f382926b;

    /* renamed from: c, reason: collision with root package name */
    public Pomelo f382927c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382923d = new HashMap();
        f382923d.put(0, new byte[]{0});
        f382924e = new Pomelo();
    }

    public Melon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382925a = 0;
        this.f382926b = null;
        this.f382927c = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382925a, 0);
        solar.a((Map) this.f382926b, 1);
        Pomelo pomelo = this.f382927c;
        if (pomelo != null) {
            solar.a((Taurus) pomelo, 2);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
            return;
        }
        this.f382925a = serpens.a(this.f382925a, 0, true);
        this.f382926b = (Map) serpens.a((Serpens) f382923d, 1, true);
        this.f382927c = (Pomelo) serpens.a((Taurus) f382924e, 2, false);
    }
}
