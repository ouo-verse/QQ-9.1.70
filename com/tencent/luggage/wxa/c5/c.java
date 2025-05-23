package com.tencent.luggage.wxa.c5;

import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.tn.c0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f123305a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final ArraySet f123306b = new ArraySet();

    /* renamed from: c, reason: collision with root package name */
    public static int f123307c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final a f123308d = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends LinkedHashMap {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.c5.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6095a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f123309a;

            public RunnableC6095a(b bVar) {
                this.f123309a = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f123309a.a(1);
            }
        }

        public /* bridge */ boolean a(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ b b(String str) {
            return (b) super.get(str);
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
            if (!(obj instanceof b)) {
                return false;
            }
            return a((b) obj);
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
            return a((String) obj, (b) obj2);
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
            b bVar;
            if (size() > c.f123305a.a()) {
                if (entry != null && (bVar = (b) entry.getValue()) != null) {
                    c0.a(new RunnableC6095a(bVar));
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

        public /* bridge */ boolean a(b bVar) {
            return super.containsValue(bVar);
        }

        public /* bridge */ Set b() {
            return super.keySet();
        }

        public /* bridge */ b c(String str) {
            return (b) super.remove(str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof b)) {
                return b((String) obj, (b) obj2);
            }
            return false;
        }

        public /* bridge */ Set a() {
            return super.entrySet();
        }

        public /* bridge */ boolean b(String str, b bVar) {
            return super.remove(str, bVar);
        }

        public /* bridge */ b a(String str, b bVar) {
            return (b) super.getOrDefault(str, bVar);
        }
    }

    public final int a() {
        return f123307c;
    }

    public final void b(b bVar) {
        boolean areEqual;
        if (bVar == null) {
            return;
        }
        a aVar = f123308d;
        synchronized (aVar) {
            areEqual = Intrinsics.areEqual(bVar, aVar.remove(bVar.getAppId()));
        }
        if (areEqual) {
            ArraySet arraySet = f123306b;
            synchronized (arraySet) {
            }
            Iterator<E> it = new ArraySet(arraySet).iterator();
            if (it.hasNext()) {
                com.tencent.luggage.wxa.k0.d.a(it.next());
                throw null;
            }
        }
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        a aVar = f123308d;
        synchronized (aVar) {
            aVar.remove(bVar.getAppId());
            String appId = bVar.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "rt.appId");
            aVar.put(appId, bVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final b a(String str) {
        b bVar;
        if (str == null) {
            return null;
        }
        a aVar = f123308d;
        synchronized (aVar) {
            bVar = (b) aVar.get(str);
        }
        return bVar;
    }
}
