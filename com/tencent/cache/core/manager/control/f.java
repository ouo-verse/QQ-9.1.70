package com.tencent.cache.core.manager.control;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class f<T> implements Comparator<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f98737d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f98738e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f98739f;

    public f(int i3, long j3, long j16) {
        this.f98737d = i3;
        this.f98738e = j3;
        this.f98739f = j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t16, T t17) {
        float f16;
        int compareValues;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
        com.tencent.cache.api.b bVar = ((com.tencent.cache.core.manager.store.a) t16).f98772a.get();
        float f17 = 1.0f;
        if (bVar instanceof com.tencent.cache.core.collection.base.b) {
            f16 = h.a(h.f98741a, ((com.tencent.cache.core.collection.base.b) bVar).getCacheInfo(), this.f98737d, this.f98738e, this.f98739f);
        } else {
            f16 = 1.0f;
        }
        Float valueOf = Float.valueOf(f16);
        com.tencent.cache.api.b bVar2 = ((com.tencent.cache.core.manager.store.a) t17).f98772a.get();
        if (bVar2 instanceof com.tencent.cache.core.collection.base.b) {
            f17 = h.a(h.f98741a, ((com.tencent.cache.core.collection.base.b) bVar2).getCacheInfo(), this.f98737d, this.f98738e, this.f98739f);
        }
        compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Float.valueOf(f17));
        return compareValues;
    }
}
