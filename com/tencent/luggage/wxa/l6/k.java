package com.tencent.luggage.wxa.l6;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f133084a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f133085b = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends HashMap {
        public /* bridge */ boolean a(com.tencent.luggage.wxa.xd.o oVar) {
            return super.containsValue(oVar);
        }

        public /* bridge */ Set b() {
            return super.keySet();
        }

        public /* bridge */ int c() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            boolean z16;
            if (obj == null) {
                z16 = true;
            } else {
                z16 = obj instanceof String;
            }
            if (!z16) {
                return false;
            }
            return a((String) obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (!(obj instanceof com.tencent.luggage.wxa.xd.o)) {
                return false;
            }
            return a((com.tencent.luggage.wxa.xd.o) obj);
        }

        public /* bridge */ Collection d() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set entrySet() {
            return a();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            boolean z16;
            if (obj == null) {
                z16 = true;
            } else {
                z16 = obj instanceof String;
            }
            if (!z16) {
                return null;
            }
            return b((String) obj);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            boolean z16;
            if (obj == null) {
                z16 = true;
            } else {
                z16 = obj instanceof String;
            }
            if (!z16) {
                return obj2;
            }
            return a((String) obj, (com.tencent.luggage.wxa.xd.o) obj2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return c((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection values() {
            return d();
        }

        public /* bridge */ Set a() {
            return super.entrySet();
        }

        public /* bridge */ boolean b(String str, com.tencent.luggage.wxa.xd.o oVar) {
            return super.remove(str, oVar);
        }

        public /* bridge */ com.tencent.luggage.wxa.xd.o c(String str) {
            return (com.tencent.luggage.wxa.xd.o) super.remove(str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj == null ? true : obj instanceof String) && (obj2 instanceof com.tencent.luggage.wxa.xd.o)) {
                return b((String) obj, (com.tencent.luggage.wxa.xd.o) obj2);
            }
            return false;
        }

        public /* bridge */ com.tencent.luggage.wxa.xd.o a(String str, com.tencent.luggage.wxa.xd.o oVar) {
            return (com.tencent.luggage.wxa.xd.o) super.getOrDefault(str, oVar);
        }

        public com.tencent.luggage.wxa.xd.o b(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = str.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return (com.tencent.luggage.wxa.xd.o) super.get(lowerCase);
        }

        public boolean a(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = str.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return super.containsKey(lowerCase);
        }
    }

    public final Map a() {
        Set<com.tencent.luggage.wxa.xd.a> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new com.tencent.luggage.wxa.xd.a[]{new i(), new p(), new b(), new l(), new c(), new o(), new f(), new m(), new e(), new g(), new d(), new n(), new h(), new j()});
        a aVar = new a();
        for (com.tencent.luggage.wxa.xd.a aVar2 : of5) {
            String name = aVar2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = name.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            aVar.put(lowerCase, aVar2);
        }
        aVar.putAll(f133085b);
        return aVar;
    }
}
