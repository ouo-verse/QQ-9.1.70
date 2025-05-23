package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.hn.rf;
import com.tencent.luggage.wxa.hn.sf;
import com.tencent.luggage.wxa.hn.tf;
import com.tencent.luggage.wxa.hn.uf;
import com.tencent.luggage.wxa.hn.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final a f129287a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f129288a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rf f129289b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129290c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129291a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HashMap f129292b;

            public a(com.tencent.luggage.wxa.p5.f fVar, HashMap hashMap) {
                this.f129291a = fVar;
                this.f129292b = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f129291a.B1().a(this.f129292b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rf rfVar, com.tencent.luggage.wxa.p5.f fVar, Continuation continuation) {
            super(2, continuation);
            this.f129289b = rfVar;
            this.f129290c = fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f129289b, this.f129290c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f129288a;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.luggage.wxa.i3.c cVar = new com.tencent.luggage.wxa.i3.c(this.f129289b);
                    this.f129288a = 1;
                    obj = cVar.a(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                sf sfVar = (sf) obj;
                HashMap hashMap = new HashMap(sfVar.f128689e.size());
                LinkedList<uf> linkedList = sfVar.f128689e;
                Intrinsics.checkNotNullExpressionValue(linkedList, "resp.appinfo_list");
                for (uf ufVar : linkedList) {
                    if (ufVar.f128847f == 0) {
                        tf tfVar = ufVar.f128845d;
                        if (tfVar.f128767e == 2) {
                            com.tencent.luggage.wxa.ii.z.f130599a.a(tfVar.f128766d, ufVar.f128846e);
                            String str = ufVar.f128845d.f128766d;
                            Intrinsics.checkNotNullExpressionValue(str, "it.appInfo.appid");
                            hashMap.put(str, new com.tencent.luggage.wxa.rj.b(ufVar.f128846e));
                        }
                    }
                }
                if (!this.f129290c.w0() && !this.f129290c.t0()) {
                    com.tencent.luggage.wxa.p5.f fVar = this.f129290c;
                    fVar.c(new a(fVar, hashMap));
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.SubProcessGetPluginJsApiInfo", "asyncRequestJsApiInfo(appId:" + this.f129290c.getAppId() + ") get exception:" + e16);
                return Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f129293a;

        /* renamed from: b, reason: collision with root package name */
        public Object f129294b;

        /* renamed from: c, reason: collision with root package name */
        public Object f129295c;

        /* renamed from: d, reason: collision with root package name */
        public Object f129296d;

        /* renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f129297e;

        /* renamed from: g, reason: collision with root package name */
        public int f129299g;

        public c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f129297e = obj;
            this.f129299g |= Integer.MIN_VALUE;
            return k.this.a(null, null, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedList f129300a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LinkedList linkedList) {
            super(1);
            this.f129300a = linkedList;
        }

        public final void a(Object it) {
            boolean z16;
            Intrinsics.checkNotNullParameter(it, "it");
            if (it instanceof JSONObject) {
                String optString = ((JSONObject) it).optString("plugin_id");
                if (optString != null && optString.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    LinkedList linkedList = this.f129300a;
                    com.tencent.luggage.wxa.ji.b bVar = new com.tencent.luggage.wxa.ji.b();
                    bVar.f131184a = optString;
                    bVar.f131185b = 2;
                    linkedList.add(bVar);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0144 A[Catch: all -> 0x003b, TryCatch #2 {all -> 0x003b, blocks: (B:12:0x0036, B:13:0x0130, B:14:0x0132, B:15:0x013e, B:17:0x0144, B:20:0x014e, B:23:0x0154, B:34:0x017d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.luggage.wxa.i3.k] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(com.tencent.luggage.wxa.p5.f fVar, n0.g gVar, Continuation continuation) {
        c cVar;
        ?? coroutine_suspended;
        int i3;
        ?? r132;
        Throwable th5;
        ?? r06;
        z0 z0Var;
        int collectionSizeOrDefault;
        k kVar;
        com.tencent.luggage.wxa.p5.f fVar2;
        HashMap hashMap;
        Exception e16;
        LinkedList linkedList;
        Map emptyMap;
        try {
            if (continuation instanceof c) {
                c cVar2 = (c) continuation;
                int i16 = cVar2.f129299g;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    cVar2.f129299g = i16 - Integer.MIN_VALUE;
                    cVar = cVar2;
                    Object obj = cVar.f129297e;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = cVar.f129299g;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        List a16 = a(fVar, gVar);
                        LinkedList linkedList2 = new LinkedList();
                        if (a16.isEmpty()) {
                            emptyMap = MapsKt__MapsKt.emptyMap();
                            return emptyMap;
                        }
                        HashMap hashMap2 = new HashMap(a16.size());
                        try {
                            Iterator it = a16.iterator();
                            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.MutableIterator<com.tencent.mm.plugin.appbrand.launching.cgi.WxaJsApiAppInfo>");
                            Iterator asMutableIterator = TypeIntrinsics.asMutableIterator(it);
                            do {
                                com.tencent.luggage.wxa.ji.b bVar = (com.tencent.luggage.wxa.ji.b) asMutableIterator.next();
                                int i17 = bVar.f131185b;
                                if (i17 == 1) {
                                    i6 a17 = com.tencent.luggage.wxa.ii.t.a().a(bVar.f131184a);
                                    z0Var = a17 != null ? a17.f127859f : null;
                                } else if (i17 == 2) {
                                    z0Var = com.tencent.luggage.wxa.ii.z.f130599a.a(bVar.f131184a);
                                }
                                if (z0Var != null) {
                                    asMutableIterator.remove();
                                    linkedList2.add(bVar);
                                    String str = bVar.f131184a;
                                    Intrinsics.checkNotNullExpressionValue(str, "key.appId");
                                    hashMap2.put(str, new com.tencent.luggage.wxa.rj.b(z0Var));
                                }
                            } while (asMutableIterator.hasNext());
                            if (a16.isEmpty()) {
                                a(fVar, linkedList2);
                                return hashMap2;
                            }
                            rf rfVar = new rf();
                            LinkedList linkedList3 = new LinkedList();
                            rfVar.f128627e = linkedList3;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            Iterator it5 = a16.iterator();
                            while (it5.hasNext()) {
                                arrayList.add(a((com.tencent.luggage.wxa.ji.b) it5.next()));
                            }
                            linkedList3.addAll(arrayList);
                            k1 k1Var = new k1();
                            k1Var.f127976d = fVar.L1().f122984c;
                            k1Var.f127977e = fVar.y1();
                            k1Var.f127978f = 101;
                            rfVar.f128628f = k1Var;
                            try {
                                com.tencent.luggage.wxa.i3.c cVar3 = new com.tencent.luggage.wxa.i3.c(rfVar);
                                cVar.f129293a = this;
                                cVar.f129294b = fVar;
                                cVar.f129295c = linkedList2;
                                cVar.f129296d = hashMap2;
                                cVar.f129299g = 1;
                                Object a18 = cVar3.a(cVar);
                                if (a18 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                kVar = this;
                                fVar2 = fVar;
                                hashMap = hashMap2;
                                obj = a18;
                                linkedList = linkedList2;
                            } catch (Exception e17) {
                                kVar = this;
                                fVar2 = fVar;
                                hashMap = hashMap2;
                                e16 = e17;
                                linkedList = linkedList2;
                                com.tencent.luggage.wxa.tn.w.b("Luggage.SubProcessGetPluginJsApiInfo", "SubProcessGetPluginJsApiInfo(appId:" + fVar2.getAppId() + ") get exception:" + e16);
                                kVar.a(fVar2, linkedList);
                                return hashMap;
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            r06 = this;
                            r132 = linkedList2;
                            r06.a(fVar, r132);
                            throw th5;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        hashMap = (HashMap) cVar.f129296d;
                        linkedList = (LinkedList) cVar.f129295c;
                        fVar2 = (com.tencent.luggage.wxa.p5.f) cVar.f129294b;
                        kVar = (k) cVar.f129293a;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e18) {
                            e16 = e18;
                            com.tencent.luggage.wxa.tn.w.b("Luggage.SubProcessGetPluginJsApiInfo", "SubProcessGetPluginJsApiInfo(appId:" + fVar2.getAppId() + ") get exception:" + e16);
                            kVar.a(fVar2, linkedList);
                            return hashMap;
                        }
                    }
                    LinkedList<uf> linkedList4 = ((sf) obj).f128689e;
                    Intrinsics.checkNotNullExpressionValue(linkedList4, "resp.appinfo_list");
                    for (uf ufVar : linkedList4) {
                        if (ufVar.f128847f == 0) {
                            tf tfVar = ufVar.f128845d;
                            if (tfVar.f128767e == 2) {
                                com.tencent.luggage.wxa.ii.z.f130599a.a(tfVar.f128766d, ufVar.f128846e);
                                String str2 = ufVar.f128845d.f128766d;
                                Intrinsics.checkNotNullExpressionValue(str2, "it.appInfo.appid");
                                hashMap.put(str2, new com.tencent.luggage.wxa.rj.b(ufVar.f128846e));
                            }
                        }
                    }
                    kVar.a(fVar2, linkedList);
                    return hashMap;
                }
            }
            if (i3 != 0) {
            }
            LinkedList<uf> linkedList42 = ((sf) obj).f128689e;
            Intrinsics.checkNotNullExpressionValue(linkedList42, "resp.appinfo_list");
            while (r13.hasNext()) {
            }
            kVar.a(fVar2, linkedList);
            return hashMap;
        } catch (Throwable th7) {
            r132 = gVar;
            th5 = th7;
            fVar = coroutine_suspended;
            r06 = cVar;
        }
        cVar = new c(continuation);
        Object obj2 = cVar.f129297e;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = cVar.f129299g;
    }

    public final void a(com.tencent.luggage.wxa.p5.f fVar, List list) {
        int collectionSizeOrDefault;
        if (list.isEmpty() || fVar.w0() || fVar.t0()) {
            return;
        }
        rf rfVar = new rf();
        LinkedList linkedList = new LinkedList();
        rfVar.f128627e = linkedList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((com.tencent.luggage.wxa.ji.b) it.next()));
        }
        linkedList.addAll(arrayList);
        k1 k1Var = new k1();
        k1Var.f127976d = fVar.L1().f122984c;
        k1Var.f127977e = fVar.y1();
        k1Var.f127978f = 102;
        rfVar.f128628f = k1Var;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new b(rfVar, fVar, null), 2, null);
    }

    public final tf a(com.tencent.luggage.wxa.ji.b bVar) {
        tf tfVar = new tf();
        tfVar.f128766d = bVar.f131184a;
        tfVar.f128767e = bVar.f131185b;
        return tfVar;
    }

    public final List a(com.tencent.luggage.wxa.p5.f fVar, n0.g gVar) {
        List emptyList;
        if (fVar.Q1()) {
            LinkedList linkedList = new LinkedList();
            List list = gVar.C;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                List<n0.e> list2 = ((n0.i) it.next()).f125946c;
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                for (n0.e eVar : list2) {
                    if (eVar.f125914f.contains(3)) {
                        com.tencent.luggage.wxa.ji.b bVar = new com.tencent.luggage.wxa.ji.b();
                        bVar.f131184a = eVar.f125909a;
                        bVar.f131185b = 2;
                        linkedList.add(bVar);
                    }
                }
            }
            return linkedList;
        }
        String str = gVar.f125931l;
        if (str == null || str.length() == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        LinkedList linkedList2 = new LinkedList();
        try {
            JSONArray optJSONArray = new JSONObject(gVar.f125931l).optJSONArray("call_plugin_info");
            if (optJSONArray != null) {
                com.tencent.luggage.wxa.e5.f.a(optJSONArray, new d(linkedList2));
            }
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.SubProcessGetPluginJsApiInfo", "collectPluginIdList for appId:" + fVar.getAppId() + ", parse call_plugin_info get exception:" + e16);
        }
        return linkedList2;
    }
}
