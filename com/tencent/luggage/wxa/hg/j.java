package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f127133a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f127134b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f127135a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            int mapCapacity;
            int coerceAtLeast;
            int collectionSizeOrDefault;
            int mapCapacity2;
            int coerceAtLeast2;
            boolean z16;
            o[] values = o.values();
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(values.length);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (o oVar : values) {
                n[] values2 = n.values();
                ArrayList arrayList = new ArrayList();
                for (n nVar : values2) {
                    if (oVar == nVar.b()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(nVar);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
                for (Object obj : arrayList) {
                    linkedHashMap2.put(((n) obj).c(), obj);
                }
                Pair pair = TuplesKt.to(oVar, linkedHashMap2);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f127135a);
        f127134b = lazy;
    }

    public final Map a() {
        return (Map) f127134b.getValue();
    }

    public final m a(o category, com.tencent.luggage.wxa.r4.d env, JSONObject data) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        w.d("MicroMsg.AppBrand.SmCryptoInvoker", "invoke, data: " + data);
        try {
            String string = data.getString("type");
            Object obj = a().get(category);
            Intrinsics.checkNotNull(obj);
            com.tencent.luggage.wxa.hg.a aVar = (com.tencent.luggage.wxa.hg.a) ((Map) obj).get(string);
            if (aVar == null) {
                com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA = com.tencent.luggage.wxa.af.e.f121315k;
                Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA, "INVALID_REQUEST_DATA");
                return new m(INVALID_REQUEST_DATA, null, 2, null);
            }
            m a16 = aVar.a(new l(env, data));
            w.d("MicroMsg.AppBrand.SmCryptoInvoker", "invoke, result: " + a16);
            return a16;
        } catch (JSONException unused) {
            com.tencent.luggage.wxa.af.c INVALID_REQUEST_DATA2 = com.tencent.luggage.wxa.af.e.f121315k;
            Intrinsics.checkNotNullExpressionValue(INVALID_REQUEST_DATA2, "INVALID_REQUEST_DATA");
            return new m(INVALID_REQUEST_DATA2, null, 2, null);
        }
    }
}
