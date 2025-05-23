package com.tencent.mobileqq.magicface.magicfaceaction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.math.BigDecimal;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f243383a;

    /* renamed from: b, reason: collision with root package name */
    public String f243384b;

    /* renamed from: c, reason: collision with root package name */
    public String f243385c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String a(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16));
        }
        String str = this.f243385c;
        if (str != null) {
            return str.replaceFirst("%param%", "" + i3).replaceFirst("%param%", "" + new BigDecimal((double) f16).setScale(1, 4).floatValue());
        }
        return null;
    }
}
