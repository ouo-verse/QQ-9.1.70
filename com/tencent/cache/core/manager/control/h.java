package com.tencent.cache.core.manager.control;

import com.tencent.cache.api.Business;
import com.tencent.cache.core.manager.api.CacheConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f98741a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98741a = new h();
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final float a(h hVar, com.tencent.cache.core.collection.base.d dVar, int i3, long j3, long j16) {
        float f16;
        float f17;
        float f18 = 1.0f;
        if (i3 != 0) {
            f16 = dVar.f() / i3;
        } else {
            f16 = 1.0f;
        }
        if (dVar.e() != 0) {
            f17 = ((float) j3) / ((float) dVar.e());
        } else {
            f17 = 1.0f;
        }
        long j17 = dVar.f98708g;
        if (j17 != 0) {
            f18 = ((float) j16) / ((float) j17);
        }
        com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
        return (cVar.d().f() * f18) + (cVar.d().h() * f17) + (cVar.d().g() * f16);
    }

    public final void b(@Nullable Business business) {
        CopyOnWriteArrayList<com.tencent.cache.core.manager.store.a> copyOnWriteArrayList;
        String str;
        String joinToString$default;
        String joinToString$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) business);
            return;
        }
        com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
        bVar.j("CacheStore", 1, "trimBusiness start, targetBusiness:" + business);
        long c16 = com.tencent.cache.core.manager.store.e.f98781d.c();
        if (business == null) {
            Set<String> c17 = e.f98736b.c();
            Map<String, com.tencent.cache.core.manager.store.d> map = com.tencent.cache.core.manager.store.e.f98778a;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : ((ConcurrentHashMap) map).entrySet()) {
                if (!c17.contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<T> it5 = ((com.tencent.cache.core.manager.store.d) ((Map.Entry) it.next()).getValue()).f98777b.iterator();
                while (it5.hasNext()) {
                    f98741a.c(((com.tencent.cache.core.manager.store.a) it5.next()).f98772a.get());
                }
            }
        } else {
            com.tencent.cache.core.manager.store.d dVar = (com.tencent.cache.core.manager.store.d) ((ConcurrentHashMap) com.tencent.cache.core.manager.store.e.f98778a).get(business.name());
            if (com.tencent.cache.core.manager.api.c.f98725d.d().w()) {
                Object[] objArr = new Object[1];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("trimBusiness start, ");
                sb5.append("business cache detail: ");
                if (dVar != null) {
                    StringBuilder a16 = com.tencent.cache.api.collection.c.a("white(");
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(dVar.f98776a, null, null, null, 0, null, com.tencent.cache.core.manager.store.b.f98774a, 31, null);
                    a16.append(joinToString$default);
                    a16.append("), nonWhite(");
                    joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(dVar.f98777b, null, null, null, 0, null, com.tencent.cache.core.manager.store.c.f98775a, 31, null);
                    a16.append(joinToString$default2);
                    a16.append(")");
                    str = a16.toString();
                } else {
                    str = null;
                }
                sb5.append(str);
                objArr[0] = sb5.toString();
                bVar.j("CacheStore", 1, objArr);
            }
            if (dVar != null && (copyOnWriteArrayList = dVar.f98777b) != null) {
                Iterator<T> it6 = copyOnWriteArrayList.iterator();
                while (it6.hasNext()) {
                    f98741a.c(((com.tencent.cache.core.manager.store.a) it6.next()).f98772a.get());
                }
            }
        }
        long c18 = com.tencent.cache.core.manager.store.e.f98781d.c();
        com.tencent.cache.core.util.b.f98833f.j("CacheStore", 1, "trimBusiness complete, beforeSize:" + c16 + ", afterSize:" + c18 + ", removed:" + (c16 - c18));
    }

    public final void c(com.tencent.cache.api.b bVar) {
        com.tencent.cache.api.c cacheListener;
        com.tencent.cache.api.c cacheListener2;
        com.tencent.cache.api.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            return;
        }
        if (bVar instanceof com.tencent.cache.core.collection.base.b) {
            com.tencent.cache.core.collection.base.b bVar2 = (com.tencent.cache.core.collection.base.b) bVar;
            if (bVar2.getCacheInfo().f98709h) {
                com.tencent.cache.core.collection.base.d cacheInfo = bVar2.getCacheInfo();
                if (!CacheConfig.INSTANCE.a(cacheInfo.f98712k, cacheInfo.f98713l) && (cVar = cacheInfo.f98710i) != null) {
                    cVar.onClearEnd();
                    return;
                }
                return;
            }
        }
        if (bVar != null && (cacheListener2 = bVar.getCacheListener()) != null) {
            cacheListener2.onClearStart();
        }
        if (bVar instanceof com.tencent.cache.api.collection.b) {
            ((com.tencent.cache.api.collection.b) bVar).getCollector().h(bVar);
        } else if (bVar != null) {
            bVar.clear();
        }
        if (bVar != null && (cacheListener = bVar.getCacheListener()) != null) {
            cacheListener.onClearEnd();
        }
    }
}
