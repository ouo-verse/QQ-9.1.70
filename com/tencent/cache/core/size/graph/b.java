package com.tencent.cache.core.size.graph;

import com.tencent.cache.core.size.graph.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final e<Class<?>, a> f98790a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f98791b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f98792a;

        /* renamed from: b, reason: collision with root package name */
        public final List<Integer> f98793b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f98792a = -1;
                this.f98793b = new ArrayList();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14062);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98791b = new b();
            f98790a = new e<>(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final a a(@NotNull Class<?> refClass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) refClass);
        }
        Intrinsics.checkNotNullParameter(refClass, "refClass");
        e<Class<?>, a> eVar = f98790a;
        eVar.a();
        a aVar = eVar.f98801a.get(new e.b(refClass, null));
        if (aVar == null) {
            a aVar2 = new a();
            eVar.a();
            eVar.f98801a.put(new e.b(refClass, eVar.f98802b), aVar2);
            return aVar2;
        }
        return aVar;
    }

    public final boolean b(@NotNull Class<?> refClass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) refClass)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(refClass, "refClass");
        if (Intrinsics.areEqual(refClass, Object.class) || Intrinsics.areEqual(refClass, String.class) || Intrinsics.areEqual(refClass, ReferenceQueue.class) || Reference.class.isAssignableFrom(refClass)) {
            return false;
        }
        return true;
    }
}
