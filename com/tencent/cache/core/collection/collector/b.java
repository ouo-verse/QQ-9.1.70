package com.tencent.cache.core.collection.collector;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b extends com.tencent.cache.core.collection.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public com.tencent.cache.core.collection.base.d f98716a;

    public b(@NotNull String business, @NotNull String subBusiness, int i3) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, business, subBusiness, Integer.valueOf(i3));
        } else {
            this.f98716a = new com.tencent.cache.core.collection.base.d(business, subBusiness, i3);
        }
    }

    @Override // com.tencent.cache.core.collection.base.c
    public long a(@NotNull Object target, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, target, Long.valueOf(j3))).longValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof com.tencent.cache.core.bitmap.base.lrucache.b)) {
            return 0L;
        }
        com.tencent.cache.core.bitmap.base.lrucache.b bVar = (com.tencent.cache.core.bitmap.base.lrucache.b) target;
        Map p16 = bVar.p();
        Intrinsics.checkNotNullExpressionValue(p16, "target.snapshot()");
        Iterator it = p16.entrySet().iterator();
        long j16 = 0;
        while (it.hasNext() && j16 < j3) {
            Map.Entry entry = (Map.Entry) it.next();
            com.tencent.cache.api.util.c cVar = com.tencent.cache.api.util.c.f98640a;
            Intrinsics.checkNotNullExpressionValue(entry.getValue(), "entry.value");
            j16 += com.tencent.cache.api.util.c.e(cVar, r9, true, false, false, 8, null);
            bVar.k(entry.getKey());
        }
        com.tencent.cache.core.collection.base.d dVar = this.f98716a;
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
        return this.f98716a;
    }

    @Override // com.tencent.cache.core.collection.base.c
    public void h(@NotNull Object target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, target);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof com.tencent.cache.core.bitmap.base.lrucache.b) {
            ((com.tencent.cache.core.bitmap.base.lrucache.b) target).d();
            com.tencent.cache.core.collection.base.c.d(this, false, 1, null);
        }
    }
}
