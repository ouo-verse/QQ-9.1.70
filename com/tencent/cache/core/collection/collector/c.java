package com.tencent.cache.core.collection.collector;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c<K, V> extends com.tencent.cache.core.collection.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public com.tencent.cache.core.collection.base.d f98717a;

    public c(@NotNull String business, @NotNull String subBusiness, int i3) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, business, subBusiness, Integer.valueOf(i3));
        } else {
            this.f98717a = new com.tencent.cache.core.collection.base.d(business, subBusiness, i3);
        }
    }

    @Override // com.tencent.cache.core.collection.base.c
    public long a(@NotNull Object target, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, target, Long.valueOf(j3))).longValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof AbstractMap)) {
            return 0L;
        }
        Iterator<Map.Entry<K, V>> it = ((AbstractMap) target).entrySet().iterator();
        long j16 = 0;
        while (it.hasNext() && j16 < j3) {
            com.tencent.cache.api.util.c cVar = com.tencent.cache.api.util.c.f98640a;
            Intrinsics.checkNotNullExpressionValue(it.next().getValue(), "iterator.next().value");
            j16 += com.tencent.cache.api.util.c.e(cVar, r6, true, false, false, 8, null);
            it.remove();
        }
        com.tencent.cache.core.collection.base.d dVar = this.f98717a;
        long j17 = dVar.f98708g - j16;
        dVar.f98708g = j17;
        if (j17 < 0) {
            dVar.f98708g = 0L;
        }
        return j16;
    }

    @Override // com.tencent.cache.core.collection.base.c
    @NotNull
    public com.tencent.cache.core.collection.base.d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.cache.core.collection.base.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f98717a;
    }

    @Override // com.tencent.cache.core.collection.base.c
    public void h(@NotNull Object target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, target);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof AbstractMap) {
            ((AbstractMap) target).clear();
        }
    }

    public final void i(K k3, V v3, V v16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, k3, v3, v16);
            return;
        }
        f(v16, v3);
        if (v16 == null) {
            com.tencent.cache.core.size.task.a aVar = com.tencent.cache.core.size.task.a.D;
            com.tencent.cache.core.collection.base.d dVar = this.f98717a;
            Intrinsics.checkNotNull(k3);
            aVar.a(dVar, true, k3);
        }
    }

    public final void j(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
            return;
        }
        c().g();
        if (v3 != null) {
            this.f98717a.f98704c++;
        } else {
            this.f98717a.f98705d++;
        }
    }
}
