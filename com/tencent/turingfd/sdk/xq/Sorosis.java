package com.tencent.turingfd.sdk.xq;

import android.content.pm.FeatureInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Sorosis extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static Map<Integer, FeatureInfo> f383076c;

    /* renamed from: a, reason: collision with root package name */
    public Map<Integer, FeatureInfo> f383077a;

    /* renamed from: b, reason: collision with root package name */
    public int f383078b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12665);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383076c = new HashMap();
        f383076c.put(0, new FeatureInfo());
    }

    public Sorosis() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383077a = null;
            this.f383078b = 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
        } else {
            solar.a((Map) this.f383077a, 0);
            solar.a(this.f383078b, 1);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Sorosis)) {
            return false;
        }
        Sorosis sorosis = (Sorosis) obj;
        Map<Integer, FeatureInfo> map = this.f383077a;
        Map<Integer, FeatureInfo> map2 = sorosis.f383077a;
        int i3 = Triangulum.f383138a;
        if (map.equals(map2) && Triangulum.a(this.f383078b, sorosis.f383078b)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
        } else {
            this.f383077a = (Map) serpens.a((Serpens) f383076c, 0, true);
            this.f383078b = serpens.a(this.f383078b, 1, false);
        }
    }
}
