package com.tencent.cache.core.manager.control;

import com.tencent.cache.api.Business;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class e implements com.tencent.cache.core.manager.api.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static CopyOnWriteArrayList<com.tencent.cache.api.d> f98735a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final e f98736b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98736b = new e();
            f98735a = new CopyOnWriteArrayList<>();
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cache.core.manager.api.a
    public void a(@Nullable com.tencent.cache.api.memory.b bVar, @Nullable com.tencent.cache.api.memory.d dVar) {
        k kVar;
        float floatValue;
        StringBuilder a16;
        float n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar, (Object) dVar);
            return;
        }
        if (bVar != null) {
            float e16 = bVar.e();
            com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
            if (e16 >= cVar.d().o()) {
                kVar = k.f98748d;
                floatValue = cVar.d().d()[2].floatValue();
                a16 = com.tencent.cache.api.collection.c.a("low_app_");
                n3 = cVar.d().o();
            } else if (bVar.e() >= cVar.d().n()) {
                kVar = k.f98748d;
                floatValue = cVar.d().d()[1].floatValue();
                a16 = com.tencent.cache.api.collection.c.a("low_app_");
                n3 = cVar.d().n();
            } else {
                return;
            }
            a16.append(n3);
            kVar.b(floatValue, a16.toString());
            return;
        }
        com.tencent.cache.core.manager.api.c cVar2 = com.tencent.cache.core.manager.api.c.f98725d;
        if (cVar2.d().i() && dVar != null && dVar.i() * 1024 > cVar2.d().z()) {
            k.f98748d.b(cVar2.d().d()[0].floatValue(), "low_app_native");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.cache.core.manager.api.a
    public void b(@Nullable com.tencent.cache.api.d dVar, @Nullable com.tencent.cache.api.d dVar2) {
        boolean z16;
        Map<String, Integer> putIfAbsent;
        String joinToString$default;
        List removedBusinessList;
        boolean z17;
        List takeLast;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z18;
        List split$default;
        List split$default2;
        List split$default3;
        List split$default4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar, (Object) dVar2);
            return;
        }
        if (dVar2 != null) {
            com.tencent.cache.api.d e16 = e();
            if (!Intrinsics.areEqual(e16, dVar2)) {
                d dVar3 = d.f98734g;
                Business toBusiness = dVar2.b();
                synchronized (dVar3) {
                    Intrinsics.checkNotNullParameter(toBusiness, "toBusiness");
                    com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
                    int i3 = 0;
                    if (cVar.b() != null) {
                        if (d.f98731d.isEmpty()) {
                            com.tencent.cache.core.manager.api.b b16 = cVar.b();
                            Intrinsics.checkNotNull(b16);
                            String recordStr = b16.b("key_day_to_access_record");
                            if (recordStr.length() > 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                Intrinsics.checkNotNullParameter(recordStr, "recordStr");
                                split$default = StringsKt__StringsKt.split$default((CharSequence) recordStr, new String[]{";"}, false, 0, 6, (Object) null);
                                Iterator it = split$default.iterator();
                                while (it.hasNext()) {
                                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{":"}, false, 0, 6, (Object) null);
                                    if (split$default2.size() > 1) {
                                        split$default3 = StringsKt__StringsKt.split$default((CharSequence) split$default2.get(1), new String[]{","}, false, 0, 6, (Object) null);
                                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                                        Iterator it5 = split$default3.iterator();
                                        while (it5.hasNext()) {
                                            split$default4 = StringsKt__StringsKt.split$default((CharSequence) it5.next(), new String[]{"-"}, false, 0, 6, (Object) null);
                                            if (split$default4.size() > 1) {
                                                try {
                                                    linkedHashMap.put(split$default4.get(i3), Integer.valueOf(Integer.parseInt((String) split$default4.get(1))));
                                                } catch (NumberFormatException e17) {
                                                    com.tencent.cache.core.util.b.f98833f.b("AccessRecorder", 1, "parseAccessRecordStr has NumberFormatException! recordStr\uff1a" + recordStr, e17);
                                                    i3 = 0;
                                                }
                                            }
                                        }
                                        d.f98731d.put(split$default2.get(0), linkedHashMap);
                                        i3 = 0;
                                    }
                                }
                            }
                        }
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - d.f98729b > 3600000) {
                            d.f98729b = currentTimeMillis;
                            dVar3.a();
                        }
                        ConcurrentHashMap<String, Map<String, Integer>> concurrentHashMap = d.f98731d;
                        String str = d.f98730c;
                        Map<String, Integer> map = concurrentHashMap.get(str);
                        if (map == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (map = new LinkedHashMap<>()))) != null) {
                            map = putIfAbsent;
                        }
                        Map<String, Integer> currentDayInfo = map;
                        Intrinsics.checkNotNullExpressionValue(currentDayInfo, "currentDayInfo");
                        String name = toBusiness.name();
                        String name2 = toBusiness.name();
                        Integer num = currentDayInfo.get(name2);
                        if (num == null) {
                            num = 0;
                            currentDayInfo.put(name2, num);
                        }
                        currentDayInfo.put(name, Integer.valueOf(num.intValue() + 1));
                        if (currentTimeMillis - d.f98733f > 600000) {
                            d.f98733f = currentTimeMillis;
                            com.tencent.cache.core.manager.api.b b17 = com.tencent.cache.core.manager.api.c.f98725d.b();
                            if (b17 != null) {
                                Set<Map.Entry<String, Map<String, Integer>>> entrySet = d.f98731d.entrySet();
                                Intrinsics.checkNotNullExpressionValue(entrySet, "dayToAccessRecord.entries");
                                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(entrySet, ";", null, null, 0, null, b.f98727a, 30, null);
                                b17.c("key_day_to_access_record", joinToString$default);
                            }
                        }
                        com.tencent.cache.core.util.b.f98833f.j("AccessRecorder", 1, "recordAction, currentDay: " + d.f98730c + ", dayToBusinessCount:" + d.f98731d);
                    }
                }
                Business business = null;
                if (com.tencent.cache.api.state.a.f98635c.b().contains(dVar2.b())) {
                    CopyOnWriteArrayList<com.tencent.cache.api.d> copyOnWriteArrayList = f98735a;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(copyOnWriteArrayList, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                    Iterator<T> it6 = copyOnWriteArrayList.iterator();
                    while (it6.hasNext()) {
                        arrayList.add(((com.tencent.cache.api.d) it6.next()).b());
                    }
                    removedBusinessList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                    f98735a.clear();
                } else {
                    removedBusinessList = null;
                }
                int indexOf = f98735a.indexOf(dVar2);
                if (indexOf != -1) {
                    takeLast = CollectionsKt___CollectionsKt.takeLast(f98735a, indexOf);
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(takeLast, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it7 = takeLast.iterator();
                    while (it7.hasNext()) {
                        arrayList2.add(((com.tencent.cache.api.d) it7.next()).b());
                    }
                    removedBusinessList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
                    f98735a = new CopyOnWriteArrayList<>(f98735a.subList(0, indexOf));
                }
                f98735a.add(dVar2);
                if (removedBusinessList != null && !removedBusinessList.isEmpty()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it8 = removedBusinessList.iterator();
                    while (it8.hasNext()) {
                        Iterable iterable = (Set) com.tencent.cache.api.state.a.f98635c.a().get((Business) it8.next());
                        if (iterable == null) {
                            iterable = CollectionsKt__CollectionsKt.emptyList();
                        }
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList3, iterable);
                    }
                    removedBusinessList.addAll(arrayList3);
                    removedBusinessList.removeAll(d());
                    if (e16 != null) {
                        business = e16.b();
                    }
                    Intrinsics.checkNotNullParameter(removedBusinessList, "removedBusinessList");
                    com.tencent.cache.core.manager.api.c cVar2 = com.tencent.cache.core.manager.api.c.f98725d;
                    if (cVar2.d().l() || cVar2.d().k()) {
                        com.tencent.cache.core.size.task.a.D.c(new j(removedBusinessList, business));
                    }
                }
                com.tencent.cache.core.util.b.f98833f.j("CacheControl", 1, "onPageChange, from:" + dVar + ", to:" + dVar2 + ", businessStack:" + f98735a + ", removeBusinessList:" + removedBusinessList);
            }
        }
    }

    @NotNull
    public final Set<String> c() {
        int collectionSizeOrDefault;
        Set<String> set;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        List<Business> d16 = d();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = d16.iterator();
        while (it.hasNext()) {
            arrayList.add(((Business) it.next()).name());
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        return set;
    }

    public final List<Business> d() {
        List mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        CopyOnWriteArrayList<com.tencent.cache.api.d> copyOnWriteArrayList = f98735a;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.cache.api.d dVar : copyOnWriteArrayList) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(dVar.b());
            Set<Business> set = com.tencent.cache.api.state.a.f98635c.a().get(dVar.b());
            if (set != null) {
                mutableListOf.addAll(set);
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, mutableListOf);
        }
        return arrayList;
    }

    @Nullable
    public final com.tencent.cache.api.d e() {
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            try {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) f98735a);
                return (com.tencent.cache.api.d) lastOrNull;
            } catch (IndexOutOfBoundsException e16) {
                com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
                StringBuilder a16 = com.tencent.cache.api.collection.c.a("getCurrentPage fail, ");
                a16.append(e16.getMessage());
                bVar.h("CacheControl", 1, a16.toString());
                return null;
            }
        }
        return (com.tencent.cache.api.d) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.cache.core.manager.api.a
    public void onAppBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        k kVar = k.f98748d;
        Intrinsics.checkNotNullParameter("back_app", "fromDetail");
        kVar.a(com.tencent.cache.core.manager.api.c.f98725d.d().e(), ClearMode.Background, "back_app");
    }

    @Override // com.tencent.cache.core.manager.api.a
    public void onLowMemory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            k.f98748d.b(com.tencent.cache.core.manager.api.c.f98725d.d().D()[1].floatValue(), HippyReporter.RemoveEngineReason.LOW_MEMORY);
        }
    }

    @Override // com.tencent.cache.core.manager.api.a
    public void onTrimMemory(int i3) {
        Float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
        com.tencent.cache.core.manager.api.b b16 = cVar.b();
        if (b16 != null) {
            b16.onTrimMemory(i3);
        }
        if (i3 == 20) {
            k kVar = k.f98748d;
            Intrinsics.checkNotNullParameter("back_sys", "fromDetail");
            kVar.a(cVar.d().e(), ClearMode.Background, "back_sys");
            return;
        }
        k kVar2 = k.f98748d;
        if (i3 != 10) {
            if (i3 != 15 && i3 != 40) {
                if (i3 != 60) {
                    Float[] D = cVar.d().D();
                    if (i3 != 80) {
                        f16 = D[0];
                    } else {
                        f16 = D[3];
                    }
                } else {
                    f16 = cVar.d().D()[2];
                }
            } else {
                f16 = cVar.d().D()[1];
            }
        } else {
            f16 = cVar.d().D()[0];
        }
        kVar2.b(f16.floatValue(), "low_sys_" + i3);
    }
}
