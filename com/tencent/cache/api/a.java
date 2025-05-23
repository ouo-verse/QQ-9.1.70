package com.tencent.cache.api;

import com.tencent.cache.core.manager.api.CacheConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    @JvmDefault
    public static void a(b cache, @NotNull Business business, @NotNull String subBusiness) {
        boolean z16;
        CopyOnWriteArrayList<com.tencent.cache.core.manager.store.a> copyOnWriteArrayList;
        Set set;
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) cache, (Object) business, (Object) subBusiness);
            return;
        }
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        Map<String, com.tencent.cache.core.manager.store.d> map = com.tencent.cache.core.manager.store.e.f98778a;
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        Intrinsics.checkNotNullParameter(cache, "cache");
        com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addCache, ");
        sb5.append("business:");
        sb5.append(business);
        sb5.append(", ");
        sb5.append("subBusiness:");
        StringBuilder a16 = h.a(sb5, subBusiness, ", ", "cache: ");
        a16.append(cache.getClass().getSimpleName());
        a16.append(", ");
        a16.append(cache.hashCode());
        boolean z17 = false;
        bVar.j("CacheStore", 1, a16.toString());
        Map<String, com.tencent.cache.core.manager.store.d> map2 = com.tencent.cache.core.manager.store.e.f98778a;
        String name = business.name();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) map2;
        Object obj = concurrentHashMap.get(name);
        if (obj == null) {
            obj = new com.tencent.cache.core.manager.store.d();
            concurrentHashMap.put(name, obj);
        }
        com.tencent.cache.core.manager.store.d dVar = (com.tencent.cache.core.manager.store.d) obj;
        Set set2 = (Set) ((ConcurrentHashMap) com.tencent.cache.core.manager.store.e.f98779b).get(business);
        if (set2 != null && set2.contains(subBusiness)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            copyOnWriteArrayList = dVar.f98776a;
        } else {
            copyOnWriteArrayList = dVar.f98777b;
        }
        try {
            copyOnWriteArrayList.add(new com.tencent.cache.core.manager.store.a(subBusiness, cache));
            if (CacheConfig.INSTANCE.a(business.name(), subBusiness) || ((set = (Set) ((ConcurrentHashMap) com.tencent.cache.core.manager.store.e.f98780c).get(business)) != null && set.contains(subBusiness))) {
                z17 = true;
            }
            if (z17 && (cache instanceof com.tencent.cache.core.collection.base.b)) {
                ((com.tencent.cache.core.collection.base.b) cache).getCollector().c().f98709h = true;
            }
            Iterator<com.tencent.cache.core.manager.store.a> it = copyOnWriteArrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "targetCache.iterator()");
            while (it.hasNext()) {
                com.tencent.cache.core.manager.store.a next = it.next();
                if (next != null && next.f98772a.get() == null) {
                    copyOnWriteArrayList.remove(next);
                }
            }
        } catch (Exception e16) {
            com.tencent.cache.core.util.b.f98833f.b("CacheStore", 1, "remove exception", e16);
        }
    }
}
