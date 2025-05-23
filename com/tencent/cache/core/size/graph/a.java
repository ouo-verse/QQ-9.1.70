package com.tencent.cache.core.size.graph;

import com.tencent.cache.core.size.graph.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final e<Class<?>, Long> f98788a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f98789b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98789b = new a();
            f98788a = new e<>(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public long a(@NotNull Object requestObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, requestObj)).longValue();
        }
        Intrinsics.checkNotNullParameter(requestObj, "requestObj");
        Class<?> cls = requestObj.getClass();
        e<Class<?>, Long> eVar = f98788a;
        eVar.a();
        Long l3 = eVar.f98801a.get(new e.b(cls, null));
        if (l3 != null) {
            return l3.longValue();
        }
        long a16 = com.tencent.cache.core.size.task.c.f98826b.a(requestObj);
        if (!cls.isArray()) {
            Long valueOf = Long.valueOf(a16);
            eVar.a();
            eVar.f98801a.put(new e.b(cls, eVar.f98802b), valueOf);
        }
        return a16;
    }
}
