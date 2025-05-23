package com.tencent.halley.common.a.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f113259a;

    /* renamed from: b, reason: collision with root package name */
    public String f113260b;

    /* renamed from: c, reason: collision with root package name */
    public List<com.tencent.halley.common.a.a> f113261c;

    /* renamed from: d, reason: collision with root package name */
    public int f113262d;

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f113259a = str;
        this.f113260b = str2;
        this.f113261c = new ArrayList();
    }
}
