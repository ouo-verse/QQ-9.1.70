package com.tencent.cache.core.manager.control;

import android.util.Pair;
import com.tencent.cache.core.manager.api.CacheConfig;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f98745a;

    /* renamed from: b, reason: collision with root package name */
    public static float f98746b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f98747c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final k f98748d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ClearMode f98749d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f98750e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f98751f;

        public a(ClearMode clearMode, float f16, String str) {
            this.f98749d = clearMode;
            this.f98750e = f16;
            this.f98751f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, clearMode, Float.valueOf(f16), str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:143:0x03be  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x03eb  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0410  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0440  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x05da  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x054a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:195:0x0489 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:216:0x05ac  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x03de -> B:107:0x03b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x042e -> B:121:0x0405). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            com.tencent.cache.core.manager.report.c cVar;
            com.tencent.cache.core.manager.api.b b16;
            long j3;
            List sortedWith;
            ArrayList arrayList;
            int collectionSizeOrDefault;
            List sortedWith2;
            int i3;
            long j16;
            Iterator it;
            long j17;
            Iterator it5;
            List sortedWith3;
            Iterator it6;
            com.tencent.cache.api.b bVar;
            com.tencent.cache.core.manager.report.c cVar2;
            Iterator it7;
            String str;
            boolean z16;
            int i16;
            com.tencent.cache.api.c cVar3;
            com.tencent.cache.api.c cacheListener;
            int i17;
            a aVar = this;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) aVar);
                return;
            }
            com.tencent.cache.core.manager.report.c cVar4 = new com.tencent.cache.core.manager.report.c(aVar.f98749d);
            com.tencent.cache.core.manager.api.c cVar5 = com.tencent.cache.core.manager.api.c.f98725d;
            if (cVar5.d().l()) {
                com.tencent.cache.core.manager.store.i iVar = com.tencent.cache.core.manager.store.i.f98787d;
                float f16 = aVar.f98750e;
                com.tencent.cache.core.util.b bVar2 = com.tencent.cache.core.util.b.f98833f;
                bVar2.j("GlobalImageCache", 1, "trimToSize start");
                long e16 = iVar.e();
                int a16 = com.tencent.cache.core.manager.store.i.f98786c.a();
                com.tencent.cache.core.bitmap.cache.c<String, Object> cVar6 = com.tencent.cache.core.manager.store.i.f98785b;
                int k3 = cVar6.k();
                int floatValue = (int) (com.tencent.cache.core.manager.store.i.f98784a.getFirst().floatValue() * f16);
                Pair<Integer, Integer> b17 = cVar6.b(floatValue, e.f98736b.c());
                String str2 = "sImageCache: {before=" + k3 + ", after=" + cVar6.k() + ", removed=" + ((Integer) b17.first) + ", ignored=" + ((Integer) b17.second) + ", target=" + floatValue + ", max:" + com.tencent.cache.core.manager.store.i.f98784a.getFirst().intValue() + '}';
                long e17 = iVar.e();
                bVar2.j("GlobalImageCache", 1, "trimToSize complete, Total: {beforeSize=" + e16 + ", afterSize=" + e17 + ", removed=" + (e16 - e17) + "}, sBitmapPool: {removed=" + a16 + "}, " + str2);
            }
            if (cVar5.d().k()) {
                h hVar = h.f98741a;
                float f17 = aVar.f98750e;
                com.tencent.cache.core.util.b bVar3 = com.tencent.cache.core.util.b.f98833f;
                bVar3.j("CacheStore", 1, "trimToSize start");
                hVar.b(null);
                com.tencent.cache.core.manager.store.e eVar = com.tencent.cache.core.manager.store.e.f98781d;
                long a17 = ((float) eVar.a()) * f17;
                long c16 = eVar.c();
                if (c16 < a17) {
                    bVar3.j("CacheStore", 1, "trimToSize ignore, targetSize: " + a17 + ", beforeSize: " + c16);
                    cVar = cVar4;
                    cVar.c(aVar.f98751f, Float.valueOf(aVar.f98750e));
                    b16 = com.tencent.cache.core.manager.api.c.f98725d.b();
                    if (b16 != null) {
                        b16.a(aVar.f98749d, aVar.f98750e);
                    }
                    k.f98747c = false;
                }
                long j18 = c16 - a17;
                synchronized (d.f98734g) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, Map<String, Integer>> entry : d.f98731d.entrySet()) {
                        if (Intrinsics.areEqual(entry.getKey(), d.f98730c)) {
                            i17 = 3;
                        } else {
                            i17 = 1;
                        }
                        for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                            String key = entry2.getKey();
                            long j19 = j18;
                            String key2 = entry2.getKey();
                            Object obj = linkedHashMap.get(key2);
                            if (obj == null) {
                                obj = 0;
                                linkedHashMap.put(key2, obj);
                            }
                            linkedHashMap.put(key, Integer.valueOf((entry2.getValue().intValue() * i17) + ((Number) obj).intValue()));
                            j18 = j19;
                        }
                    }
                    j3 = j18;
                    sortedWith = CollectionsKt___CollectionsKt.sortedWith(linkedHashMap.entrySet(), new c());
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(sortedWith, 10);
                    arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it8 = sortedWith.iterator();
                    while (it8.hasNext()) {
                        arrayList.add((String) ((Map.Entry) it8.next()).getKey());
                    }
                }
                Set<String> c17 = e.f98736b.c();
                Map<String, com.tencent.cache.core.manager.store.d> map = com.tencent.cache.core.manager.store.e.f98778a;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry3 : ((ConcurrentHashMap) map).entrySet()) {
                    if (!c17.contains(entry3.getKey())) {
                        linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                    }
                }
                if (f17 != 0.0f) {
                    sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(linkedHashMap2.entrySet(), new g(arrayList));
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it9 = sortedWith2.iterator();
                    while (it9.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ((com.tencent.cache.core.manager.store.d) ((Map.Entry) it9.next()).getValue()).f98776a);
                    }
                    if (!arrayList2.isEmpty()) {
                        Iterator it10 = arrayList2.iterator();
                        if (it10.hasNext()) {
                            com.tencent.cache.api.b bVar4 = ((com.tencent.cache.core.manager.store.a) it10.next()).f98772a.get();
                            if (bVar4 instanceof com.tencent.cache.core.collection.base.b) {
                                i3 = ((com.tencent.cache.core.collection.base.b) bVar4).getCacheInfo().f();
                            } else {
                                i3 = 0;
                            }
                            while (it10.hasNext()) {
                                com.tencent.cache.api.b bVar5 = ((com.tencent.cache.core.manager.store.a) it10.next()).f98772a.get();
                                if (bVar5 instanceof com.tencent.cache.core.collection.base.b) {
                                    i16 = ((com.tencent.cache.core.collection.base.b) bVar5).getCacheInfo().f();
                                } else {
                                    i16 = 0;
                                }
                                if (i3 < i16) {
                                    i3 = i16;
                                }
                            }
                            Iterator it11 = arrayList2.iterator();
                            if (it11.hasNext()) {
                                com.tencent.cache.api.b bVar6 = ((com.tencent.cache.core.manager.store.a) it11.next()).f98772a.get();
                                if (bVar6 instanceof com.tencent.cache.core.collection.base.b) {
                                    long j26 = ((com.tencent.cache.core.collection.base.b) bVar6).getCacheInfo().e();
                                    j16 = j26;
                                    while (it11.hasNext()) {
                                        com.tencent.cache.api.b bVar7 = ((com.tencent.cache.core.manager.store.a) it11.next()).f98772a.get();
                                        if (bVar7 instanceof com.tencent.cache.core.collection.base.b) {
                                            j26 = ((com.tencent.cache.core.collection.base.b) bVar7).getCacheInfo().e();
                                        } else {
                                            j26 = Long.MAX_VALUE;
                                        }
                                        if (j16 > j26) {
                                            j16 = j26;
                                            while (it11.hasNext()) {
                                            }
                                        }
                                    }
                                    it = arrayList2.iterator();
                                    if (!it.hasNext()) {
                                        com.tencent.cache.api.b bVar8 = ((com.tencent.cache.core.manager.store.a) it.next()).f98772a.get();
                                        if (bVar8 instanceof com.tencent.cache.core.collection.base.b) {
                                            long j27 = ((com.tencent.cache.core.collection.base.b) bVar8).getCacheInfo().f98708g;
                                            j17 = j27;
                                            while (it.hasNext()) {
                                                com.tencent.cache.api.b bVar9 = ((com.tencent.cache.core.manager.store.a) it.next()).f98772a.get();
                                                if (bVar9 instanceof com.tencent.cache.core.collection.base.b) {
                                                    j27 = ((com.tencent.cache.core.collection.base.b) bVar9).getCacheInfo().f98708g;
                                                } else {
                                                    j27 = Long.MAX_VALUE;
                                                }
                                                if (j17 > j27) {
                                                    j17 = j27;
                                                    while (it.hasNext()) {
                                                    }
                                                }
                                            }
                                            ArrayList arrayList3 = new ArrayList();
                                            it5 = arrayList2.iterator();
                                            while (it5.hasNext()) {
                                                Object next = it5.next();
                                                if (((com.tencent.cache.core.manager.store.a) next).f98772a.get() != null) {
                                                    z16 = true;
                                                } else {
                                                    z16 = false;
                                                }
                                                if (z16) {
                                                    arrayList3.add(next);
                                                }
                                            }
                                            sortedWith3 = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new f(i3, j16, j17));
                                            it6 = sortedWith3.iterator();
                                            long j28 = j3;
                                            while (it6.hasNext() && j28 >= 0) {
                                                com.tencent.cache.core.manager.store.a aVar2 = (com.tencent.cache.core.manager.store.a) it6.next();
                                                bVar = aVar2.f98772a.get();
                                                if (bVar == null) {
                                                    Intrinsics.checkNotNullExpressionValue(bVar, "cacheItem.cachedObject.get() ?: continue");
                                                    long trimMemory = bVar.trimMemory(j28);
                                                    if (trimMemory > 0) {
                                                        com.tencent.cache.core.util.b bVar10 = com.tencent.cache.core.util.b.f98833f;
                                                        if (bVar10.i()) {
                                                            String msg2 = "trim complete, clearSize: " + trimMemory + ", " + bVar.getClass();
                                                            Intrinsics.checkNotNullParameter(msg2, "msg");
                                                            if (bVar10.i()) {
                                                                System.out.println((Object) msg2);
                                                            }
                                                        }
                                                        if (com.tencent.cache.core.manager.api.c.f98725d.d().w()) {
                                                            it7 = it6;
                                                            Object[] objArr = new Object[1];
                                                            StringBuilder sb5 = new StringBuilder();
                                                            cVar2 = cVar4;
                                                            sb5.append("removed Detail Info, ");
                                                            sb5.append("businessInfo: ");
                                                            StringBuilder a18 = com.tencent.cache.api.h.a(sb5, aVar2.f98773b, ", ", "cacheType: ");
                                                            a18.append(bVar.getClass());
                                                            a18.append(", ");
                                                            a18.append("cacheItemType: ");
                                                            if (bVar instanceof com.tencent.cache.core.collection.base.b) {
                                                                str = ((com.tencent.cache.core.collection.base.b) bVar).getItemType();
                                                            } else {
                                                                str = "unknown";
                                                            }
                                                            StringBuilder a19 = com.tencent.cache.api.h.a(a18, str, ", ", "removedSize: ");
                                                            a19.append(trimMemory);
                                                            objArr[0] = a19.toString();
                                                            bVar10.j("CacheStore", 1, objArr);
                                                            j28 -= trimMemory;
                                                            it6 = it7;
                                                            cVar4 = cVar2;
                                                        }
                                                    }
                                                    cVar2 = cVar4;
                                                    it7 = it6;
                                                    j28 -= trimMemory;
                                                    it6 = it7;
                                                    cVar4 = cVar2;
                                                }
                                            }
                                        } else {
                                            j17 = Long.MAX_VALUE;
                                            while (it.hasNext()) {
                                            }
                                            ArrayList arrayList32 = new ArrayList();
                                            it5 = arrayList2.iterator();
                                            while (it5.hasNext()) {
                                            }
                                            sortedWith3 = CollectionsKt___CollectionsKt.sortedWith(arrayList32, new f(i3, j16, j17));
                                            it6 = sortedWith3.iterator();
                                            long j282 = j3;
                                            while (it6.hasNext()) {
                                                com.tencent.cache.core.manager.store.a aVar22 = (com.tencent.cache.core.manager.store.a) it6.next();
                                                bVar = aVar22.f98772a.get();
                                                if (bVar == null) {
                                                }
                                            }
                                        }
                                    } else {
                                        throw new NoSuchElementException();
                                    }
                                } else {
                                    j16 = Long.MAX_VALUE;
                                    while (it11.hasNext()) {
                                    }
                                    it = arrayList2.iterator();
                                    if (!it.hasNext()) {
                                    }
                                }
                            } else {
                                throw new NoSuchElementException();
                            }
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it12 = linkedHashMap2.entrySet().iterator();
                    while (it12.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList4, ((com.tencent.cache.core.manager.store.d) ((Map.Entry) it12.next()).getValue()).f98776a);
                    }
                    Iterator it13 = arrayList4.iterator();
                    while (it13.hasNext()) {
                        com.tencent.cache.api.b bVar11 = ((com.tencent.cache.core.manager.store.a) it13.next()).f98772a.get();
                        if (bVar11 instanceof com.tencent.cache.core.collection.base.b) {
                            com.tencent.cache.core.collection.base.b bVar12 = (com.tencent.cache.core.collection.base.b) bVar11;
                            if (bVar12.getCacheInfo().f98709h) {
                                com.tencent.cache.core.collection.base.d cacheInfo = bVar12.getCacheInfo();
                                if (!CacheConfig.INSTANCE.a(cacheInfo.f98712k, cacheInfo.f98713l) && (cVar3 = cacheInfo.f98710i) != null) {
                                    cVar3.onClearEnd();
                                }
                            }
                        }
                        if (bVar11 != null && (cacheListener = bVar11.getCacheListener()) != null) {
                            cacheListener.onClearStart();
                        }
                        if (bVar11 instanceof com.tencent.cache.api.collection.b) {
                            ((com.tencent.cache.api.collection.b) bVar11).getCollector().h(bVar11);
                        } else if (bVar11 != null) {
                            bVar11.clear();
                        }
                        if (bVar11 != null && (cVar3 = bVar11.getCacheListener()) != null) {
                            cVar3.onClearEnd();
                        }
                    }
                }
                cVar = cVar4;
                com.tencent.cache.core.manager.store.e eVar2 = com.tencent.cache.core.manager.store.e.f98781d;
                long c18 = eVar2.c();
                com.tencent.cache.core.util.b.f98833f.j("CacheStore", 1, "trimToSize complete, beforeSize:" + c16 + ", afterSize:" + c18 + ", removed:" + (c16 - c18) + ", targetSize:" + a17 + ", maxSize:" + eVar2.a());
            } else {
                cVar = cVar4;
            }
            aVar = this;
            cVar.c(aVar.f98751f, Float.valueOf(aVar.f98750e));
            b16 = com.tencent.cache.core.manager.api.c.f98725d.b();
            if (b16 != null) {
            }
            k.f98747c = false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13854);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98748d = new k();
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(float f16, ClearMode clearMode, String str) {
        int F;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), clearMode, str);
            return;
        }
        com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
        if (!cVar.d().l() && !cVar.d().k()) {
            return;
        }
        if (e.f98736b.e() == null) {
            com.tencent.cache.core.util.b.f98833f.j("TrimStrategy", 1, "trimMemoryToThreshold ignore, from:" + clearMode + ", currentBusiness is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = i.f98742a[clearMode.ordinal()];
        CacheConfig d16 = cVar.d();
        if (i3 != 1) {
            F = d16.E();
        } else {
            F = d16.F();
        }
        if (currentTimeMillis - f98745a < F && f16 >= f98746b) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
            if (bVar.i()) {
                bVar.j("TrimStrategy", 3, "trimMemoryToThreshold ignore, from:" + clearMode + ", trimTimeInternal limit");
            }
        } else if (f98747c) {
            com.tencent.cache.core.util.b.f98833f.j("TrimStrategy", 1, "trimMemoryToThreshold ignore, from:" + clearMode + ", isTrimming is true");
        } else {
            f98747c = true;
            f98746b = f16;
            f98745a = currentTimeMillis;
            z17 = true;
            if (z17) {
                return;
            }
            com.tencent.cache.core.util.b.f98833f.j("TrimStrategy", 1, "trimToThreshold, from:" + clearMode + ", rate: " + f16);
            com.tencent.cache.core.size.task.a.D.c(new a(clearMode, f16, str));
            return;
        }
        z17 = false;
        if (z17) {
        }
    }

    public final void b(float f16, @NotNull String fromDetail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), fromDetail);
        } else {
            Intrinsics.checkNotNullParameter(fromDetail, "fromDetail");
            a(f16, ClearMode.LowMemory, fromDetail);
        }
    }
}
