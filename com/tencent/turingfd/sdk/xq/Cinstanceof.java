package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.instanceof, reason: invalid class name */
/* loaded from: classes27.dex */
public final class Cinstanceof extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static Map<Integer, Integer> f383372b;

    /* renamed from: a, reason: collision with root package name */
    public Map<Integer, Integer> f383373a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13640);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383372b = new HashMap();
            f383372b.put(0, 0);
        }
    }

    public Cinstanceof() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383373a = null;
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        Map<Integer, Integer> map = this.f383373a;
        if (map != null) {
            solar.a((Map) map, 0);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f383373a = (Map) serpens.a((Serpens) f383372b, 0, false);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
        }
    }
}
