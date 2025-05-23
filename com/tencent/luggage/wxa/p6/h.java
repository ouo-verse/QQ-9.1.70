package com.tencent.luggage.wxa.p6;

import android.os.Build;
import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.tn.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f137365a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final ArraySet f137366b = new ArraySet();

    /* renamed from: c, reason: collision with root package name */
    public static int f137367c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final b f137368d = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(com.tencent.luggage.wxa.p5.f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends LinkedHashMap {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f137369a;

            public a(com.tencent.luggage.wxa.p5.f fVar) {
                this.f137369a = fVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!this.f137369a.B0()) {
                    this.f137369a.c(1);
                }
            }
        }

        public /* bridge */ boolean a(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ com.tencent.luggage.wxa.p5.f b(String str) {
            return (com.tencent.luggage.wxa.p5.f) super.get(str);
        }

        public /* bridge */ int c() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return a((String) obj);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (!(obj instanceof com.tencent.luggage.wxa.p5.f)) {
                return false;
            }
            return a((com.tencent.luggage.wxa.p5.f) obj);
        }

        public /* bridge */ Collection d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (!(obj instanceof String)) {
                return null;
            }
            return b((String) obj);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            if (!(obj instanceof String)) {
                return obj2;
            }
            return a((String) obj, (com.tencent.luggage.wxa.p5.f) obj2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            com.tencent.luggage.wxa.p5.f fVar;
            if (size() > h.f137365a.a()) {
                if (entry != null && (fVar = (com.tencent.luggage.wxa.p5.f) entry.getValue()) != null) {
                    c0.a(new a(fVar));
                }
                return true;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection values() {
            return d();
        }

        public /* bridge */ boolean a(com.tencent.luggage.wxa.p5.f fVar) {
            return super.containsValue(fVar);
        }

        public /* bridge */ Set b() {
            return super.keySet();
        }

        public /* bridge */ com.tencent.luggage.wxa.p5.f c(String str) {
            return (com.tencent.luggage.wxa.p5.f) super.remove(str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof com.tencent.luggage.wxa.p5.f)) {
                return b((String) obj, (com.tencent.luggage.wxa.p5.f) obj2);
            }
            return false;
        }

        public /* bridge */ Set a() {
            return super.entrySet();
        }

        public /* bridge */ boolean b(String str, com.tencent.luggage.wxa.p5.f fVar) {
            return super.remove(str, fVar);
        }

        public /* bridge */ com.tencent.luggage.wxa.p5.f a(String str, com.tencent.luggage.wxa.p5.f fVar) {
            return (com.tencent.luggage.wxa.p5.f) super.getOrDefault(str, fVar);
        }
    }

    public static final com.tencent.luggage.wxa.p5.f b(String str) {
        com.tencent.luggage.wxa.p5.f fVar;
        if (str == null) {
            return null;
        }
        b bVar = f137368d;
        synchronized (bVar) {
            fVar = (com.tencent.luggage.wxa.p5.f) bVar.get(str);
        }
        return fVar;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        ArraySet arraySet = f137366b;
        synchronized (arraySet) {
            arraySet.add(aVar);
        }
    }

    public final int c() {
        int size;
        b bVar = f137368d;
        synchronized (bVar) {
            size = bVar.size();
        }
        return size;
    }

    public final void b(com.tencent.luggage.wxa.p5.f fVar) {
        boolean areEqual;
        if (fVar == null) {
            return;
        }
        b bVar = f137368d;
        synchronized (bVar) {
            areEqual = Intrinsics.areEqual(fVar, bVar.remove(fVar.getAppId()));
        }
        if (areEqual) {
            ArraySet arraySet = f137366b;
            synchronized (arraySet) {
            }
            Iterator<E> it = new ArraySet(arraySet).iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(fVar);
            }
        }
    }

    public final int a() {
        return f137367c;
    }

    public final void a(com.tencent.luggage.wxa.p5.f fVar) {
        if (fVar == null) {
            return;
        }
        b bVar = f137368d;
        synchronized (bVar) {
            bVar.remove(fVar.getAppId());
            String appId = fVar.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "rt.appId");
            bVar.put(appId, fVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final com.tencent.luggage.wxa.p5.f a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        b bVar = f137368d;
        synchronized (bVar) {
            Set<Map.Entry> entrySet = bVar.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "runtimeMap.entries");
            for (Map.Entry entry : entrySet) {
                Intrinsics.checkNotNullExpressionValue(entry, "(appId, runtime)");
                com.tencent.luggage.wxa.p5.f fVar = (com.tencent.luggage.wxa.p5.f) entry.getValue();
                if (Intrinsics.areEqual(str, fVar.S().k())) {
                    return fVar;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    public final boolean b() {
        boolean isEmpty;
        b bVar = f137368d;
        synchronized (bVar) {
            isEmpty = bVar.isEmpty();
        }
        return isEmpty;
    }

    public final void a(int i3, Function1 condition) {
        ArrayList<com.tencent.luggage.wxa.p5.f> arrayList;
        Intrinsics.checkNotNullParameter(condition, "condition");
        b bVar = f137368d;
        synchronized (bVar) {
            arrayList = new ArrayList();
            Iterator it = bVar.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                com.tencent.luggage.wxa.p5.f fVar = ((Boolean) condition.invoke(entry.getValue())).booleanValue() ? (com.tencent.luggage.wxa.p5.f) entry.getValue() : null;
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
            for (com.tencent.luggage.wxa.p5.f fVar2 : arrayList) {
                if (Build.VERSION.SDK_INT >= 24) {
                    f137368d.remove(fVar2.getAppId(), fVar2);
                } else {
                    f137368d.remove(fVar2.getAppId());
                }
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((com.tencent.luggage.wxa.p5.f) it5.next()).c(i3);
        }
    }

    public static final void a(com.tencent.luggage.wxa.ic.g gVar) {
        LinkedList linkedList = new LinkedList();
        b bVar = f137368d;
        synchronized (bVar) {
            Collection<com.tencent.luggage.wxa.p5.f> values = bVar.values();
            Intrinsics.checkNotNullExpressionValue(values, "runtimeMap.values");
            for (com.tencent.luggage.wxa.p5.f fVar : values) {
                if (fVar != null && fVar.Q1() && !Intrinsics.areEqual(fVar, gVar)) {
                    linkedList.add(fVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((com.tencent.luggage.wxa.ic.g) it.next()).c(1);
        }
    }
}
