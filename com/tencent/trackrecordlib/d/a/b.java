package com.tencent.trackrecordlib.d.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f381089a;

    /* renamed from: b, reason: collision with root package name */
    Map<String, ?> f381090b;

    /* renamed from: c, reason: collision with root package name */
    String f381091c;

    /* renamed from: d, reason: collision with root package name */
    Map<String, ?> f381092d;

    /* renamed from: e, reason: collision with root package name */
    Map<String, Object> f381093e;

    /* renamed from: f, reason: collision with root package name */
    Map<String, Object> f381094f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DataEntity [elementId=" + this.f381089a + ", elementParams=" + this.f381090b + ", elementDynamicParams=" + this.f381093e + ", pageId=" + this.f381091c + ", pageParams=" + this.f381092d + ", innerParams=" + this.f381094f + "]";
    }
}
