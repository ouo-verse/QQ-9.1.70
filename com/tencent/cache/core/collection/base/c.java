package com.tencent.cache.core.collection.base;

import com.tencent.cache.core.manager.api.CacheConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void d(c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        cVar.g(z16);
    }

    public abstract long a(@NotNull Object obj, long j3);

    public final long b(@NotNull Object target, long j3, boolean z16) {
        long j16;
        long coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, this, target, Long.valueOf(j3), Boolean.valueOf(z16))).longValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (c().f98709h) {
            if (CacheConfig.INSTANCE.a(c().f98712k, c().f98713l)) {
                return 0L;
            }
            long j17 = c().f98708g;
            com.tencent.cache.api.c cVar = c().f98710i;
            if (cVar != null) {
                cVar.onClearEnd();
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j17 - c().f98708g, 0L);
            return coerceAtLeast;
        }
        com.tencent.cache.api.c cVar2 = c().f98710i;
        if (cVar2 != null) {
            cVar2.onClearStart();
        }
        if (z16 || c().f98708g < j3) {
            j16 = c().f98708g;
            h(target);
        } else {
            j16 = a(target, j3);
        }
        com.tencent.cache.api.c cVar3 = c().f98710i;
        if (cVar3 != null) {
            cVar3.onClearEnd();
        }
        return j16;
    }

    @NotNull
    public abstract d c();

    public final void e(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
            return;
        }
        c().f98703b++;
        c().g();
        if (obj != null) {
            com.tencent.cache.core.size.task.a.D.a(c(), false, obj);
        }
    }

    public final void f(@Nullable Object obj, @Nullable Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2);
            return;
        }
        c().f98702a++;
        c().g();
        if (obj2 != null) {
            com.tencent.cache.core.size.task.a.D.a(c(), true, obj2);
        }
        if (obj != null) {
            com.tencent.cache.core.size.task.a.D.a(c(), false, obj);
        }
    }

    public final void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (z16) {
            c().f98708g = 0L;
        }
        c().f98711j.d();
    }

    public abstract void h(@NotNull Object obj);
}
