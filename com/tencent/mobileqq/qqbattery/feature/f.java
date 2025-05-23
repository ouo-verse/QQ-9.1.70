package com.tencent.mobileqq.qqbattery.feature;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqbattery.feature.e;
import java.lang.Number;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f<DIGIT extends Number> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final f f262355a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f262355a = new f();
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <DIGIT extends Number> e.a.b.AbstractC8294b<DIGIT> b(e.a.b.AbstractC8294b<DIGIT> abstractC8294b, e.a.b.AbstractC8294b<DIGIT> abstractC8294b2) {
        return f262355a.a(abstractC8294b, abstractC8294b2);
    }

    public e.a.b.AbstractC8294b<DIGIT> a(e.a.b.AbstractC8294b<DIGIT> abstractC8294b, e.a.b.AbstractC8294b<DIGIT> abstractC8294b2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e.a.b.AbstractC8294b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractC8294b, (Object) abstractC8294b2);
        }
        return e.a.b.AbstractC8294b.c(abstractC8294b2.a(abstractC8294b.f262353b));
    }
}
