package com.tencent.cache.core.collection.collector;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a<V> extends com.tencent.cache.core.collection.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public com.tencent.cache.core.collection.base.d f98715a;

    public a(@NotNull String business, @NotNull String subBusiness) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) business, (Object) subBusiness);
        } else {
            this.f98715a = new com.tencent.cache.core.collection.base.d(business, subBusiness, -1);
        }
    }

    @Override // com.tencent.cache.core.collection.base.c
    public long a(@NotNull Object target, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, this, target, Long.valueOf(j3))).longValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        long j16 = 0;
        if (!(target instanceof List)) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList();
        List list = (List) target;
        for (Object obj : list) {
            if (j16 >= j3) {
                break;
            }
            arrayList.add(obj);
            if (obj != null) {
                j16 += com.tencent.cache.api.util.c.e(com.tencent.cache.api.util.c.f98640a, obj, true, false, false, 8, null);
            }
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).removeAll(arrayList);
        } else if (list instanceof CopyOnWriteArrayList) {
            ((CopyOnWriteArrayList) list).removeAll(arrayList);
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
        return this.f98715a;
    }

    @Override // com.tencent.cache.core.collection.base.c
    public void h(@NotNull Object target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, target);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof ArrayList) {
            ((ArrayList) target).clear();
        } else if (target instanceof CopyOnWriteArrayList) {
            ((CopyOnWriteArrayList) target).clear();
        }
    }

    public final void i(@NotNull Collection<? extends V> c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) c16);
            return;
        }
        Intrinsics.checkNotNullParameter(c16, "c");
        Iterator<? extends V> it = c16.iterator();
        while (it.hasNext()) {
            f(null, it.next());
        }
    }

    public final void j(@NotNull Collection<? extends Object> c16, @NotNull List<? extends V> list) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) c16, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(list, "list");
        for (Object obj : c16) {
            contains = CollectionsKt___CollectionsKt.contains(list, obj);
            if (contains) {
                e(obj);
            }
        }
    }

    public final boolean k(@NotNull Predicate<V> filter, @NotNull List<? extends V> list) {
        boolean test;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) filter, (Object) list)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(list, "list");
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        for (V v3 : list) {
            if (v3 != null) {
                test = filter.test(v3);
                if (test) {
                    e(v3);
                }
            }
        }
        return true;
    }

    public final void l(@NotNull Collection<? extends Object> c16, @NotNull List<? extends V> list) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) c16, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(list, "list");
        for (Object obj : c16) {
            contains = CollectionsKt___CollectionsKt.contains(list, obj);
            if (!contains) {
                e(obj);
            }
        }
    }

    public final void m(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
            return;
        }
        c().g();
        if (v3 != null) {
            this.f98715a.f98704c++;
        } else {
            this.f98715a.f98705d++;
        }
    }
}
