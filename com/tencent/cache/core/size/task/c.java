package com.tencent.cache.core.size.task;

import com.tencent.cache.core.size.graph.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static d f98825a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static com.tencent.cache.core.size.self.b f98826b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final c f98827c;

    static {
        com.tencent.cache.core.size.self.b bVar;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14667);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f98827c = new c();
        f98825a = d.f98800b;
        try {
            com.tencent.cache.core.util.b.f98833f.j("SizeCalculator", 1, "use UnsafeSizeOf");
            bVar = com.tencent.cache.core.size.self.c.f98806b;
        } catch (Throwable th5) {
            com.tencent.cache.core.util.b.f98833f.j("SizeCalculator", 1, "change to ReflectionSizeOf", th5.getCause());
            bVar = com.tencent.cache.core.size.self.a.f98804a;
        }
        f98826b = bVar;
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
