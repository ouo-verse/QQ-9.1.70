package com.tencent.luggage.wxa.eg;

import android.os.Looper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.eg.b;
import com.tencent.luggage.wxa.hn.jg;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f124762a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f124763b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f124764c;

    /* renamed from: d, reason: collision with root package name */
    public static final e0 f124765d;

    /* renamed from: e, reason: collision with root package name */
    public static final HashSet f124766e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f124767f;

    /* renamed from: g, reason: collision with root package name */
    public static long f124768g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final C6166a f124769e = new C6166a(null);

        /* renamed from: a, reason: collision with root package name */
        public final b.c f124770a;

        /* renamed from: b, reason: collision with root package name */
        public final int f124771b;

        /* renamed from: c, reason: collision with root package name */
        public final LinkedList f124772c;

        /* renamed from: d, reason: collision with root package name */
        public long f124773d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.eg.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6166a {
            public C6166a() {
            }

            public /* synthetic */ C6166a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(b.c priority, int i3) {
            Intrinsics.checkNotNullParameter(priority, "priority");
            this.f124770a = priority;
            this.f124771b = i3;
            this.f124772c = new LinkedList();
        }

        public final b.c a() {
            return this.f124770a;
        }

        public long b() {
            long j3;
            synchronized (this.f124772c) {
                j3 = this.f124773d;
            }
            return j3;
        }

        public boolean a(d entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            if (entry.f() > this.f124771b) {
                w.b("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.f124770a.name() + "], entry[" + entry.a() + ", " + entry.d() + ", " + entry.g() + ']');
                return false;
            }
            synchronized (this.f124772c) {
                this.f124772c.addLast(entry);
                this.f124773d += entry.c().length();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }

        public List a(long j3) {
            List emptyList;
            synchronized (this.f124772c) {
                if (this.f124772c.isEmpty()) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    return emptyList;
                }
                if (j3 < 0) {
                    j3 = ((d) this.f124772c.peekFirst()).c().length();
                }
                LinkedList linkedList = new LinkedList();
                long j16 = j3;
                while (!this.f124772c.isEmpty() && j16 > 0) {
                    Object pollFirst = this.f124772c.pollFirst();
                    d dVar = (d) pollFirst;
                    dVar.a(dVar.f() + 1);
                    j16 -= dVar.c().length();
                    linkedList.addLast(pollFirst);
                }
                long j17 = this.f124773d - (j3 - j16);
                this.f124773d = j17;
                if (j17 < 0) {
                    w.b("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", '[' + this.f124770a.name() + "] poll(" + j3 + ") final bytesCount becomes minus");
                    this.f124773d = 0L;
                }
                return linkedList;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        TIMER_PERIOD,
        REACH_SLICE_LIMIT,
        RUNTIME_KILLED,
        IMMEDIATE
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f124780a;

        /* renamed from: b, reason: collision with root package name */
        public final int f124781b;

        /* renamed from: c, reason: collision with root package name */
        public final String f124782c;

        /* renamed from: d, reason: collision with root package name */
        public final b.c f124783d;

        /* renamed from: e, reason: collision with root package name */
        public final WeakReference f124784e;

        /* renamed from: f, reason: collision with root package name */
        public final String f124785f;

        /* renamed from: g, reason: collision with root package name */
        public int f124786g;

        public d(int i3, int i16, String content, b.c priority, com.tencent.luggage.wxa.ic.d component) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(component, "component");
            this.f124780a = i3;
            this.f124781b = i16;
            this.f124782c = content;
            this.f124783d = priority;
            this.f124784e = new WeakReference(component);
            String appId = component.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
            this.f124785f = appId;
        }

        public final String a() {
            return this.f124785f;
        }

        public final com.tencent.luggage.wxa.ic.d b() {
            return (com.tencent.luggage.wxa.ic.d) this.f124784e.get();
        }

        public final String c() {
            return this.f124782c;
        }

        public final int d() {
            return this.f124780a;
        }

        public final b.c e() {
            return this.f124783d;
        }

        public final int f() {
            return this.f124786g;
        }

        public final int g() {
            return this.f124781b;
        }

        public final void a(int i3) {
            this.f124786g = i3;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eg.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6167e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6167e f124787a = new C6167e();

        public C6167e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.zj.b invoke() {
            return (com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f124788a;

        static {
            int[] iArr = new int[b.c.values().length];
            iArr[b.c.IMMEDIATE.ordinal()] = 1;
            f124788a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements c.InterfaceC6640c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f124790a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f124791a;

            static {
                int[] iArr = new int[com.tencent.luggage.wxa.qc.b.values().length];
                iArr[com.tencent.luggage.wxa.qc.b.DESTROYED.ordinal()] = 1;
                iArr[com.tencent.luggage.wxa.qc.b.FOREGROUND.ordinal()] = 2;
                f124791a = iArr;
            }
        }

        public h(com.tencent.luggage.wxa.ic.d dVar) {
            this.f124790a = dVar;
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public final void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            int i3;
            if (bVar == null) {
                i3 = -1;
            } else {
                i3 = a.f124791a[bVar.ordinal()];
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    e.f124762a.d();
                }
            } else {
                e eVar = e.f124762a;
                eVar.a(c.RUNTIME_KILLED);
                eVar.a(this.f124790a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        public static final i f124792a = new i();

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            e.f124762a.a(c.TIMER_PERIOD);
            return true;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(C6167e.f124787a);
        f124763b = lazy;
        f124764c = TimeUnit.MINUTES.toMillis(5L);
        f124765d = new e0(Looper.getMainLooper(), (e0.a) i.f124792a, true);
        f124766e = new HashSet();
        f124767f = new b();
    }

    public final com.tencent.luggage.wxa.zj.b c() {
        return (com.tencent.luggage.wxa.zj.b) f124763b.getValue();
    }

    public final synchronized void d() {
        long j3 = f124768g;
        if (j3 > 0 && w0.e(j3) >= f124764c) {
            a(c.TIMER_PERIOD);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final a[] f124774a = {new a(b.c.IMMEDIATE, 3), new a(b.c.HIGH, 3), new a(b.c.LOW, 1)};

        public boolean a(d entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            for (a aVar : this.f124774a) {
                if (aVar.a() == entry.e()) {
                    return aVar.a(entry);
                }
            }
            return false;
        }

        public List a(long j3) {
            LinkedList linkedList = new LinkedList();
            long j16 = 0;
            for (a aVar : this.f124774a) {
                long b16 = aVar.b();
                linkedList.addAll(aVar.a(j3 - j16));
                j16 += b16 - aVar.b();
            }
            return linkedList;
        }

        public long a() {
            long sumOfLong;
            a[] aVarArr = this.f124774a;
            ArrayList arrayList = new ArrayList(aVarArr.length);
            for (a aVar : aVarArr) {
                arrayList.add(Long.valueOf(aVar.b()));
            }
            sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList);
            return sumOfLong;
        }
    }

    public final void a(com.tencent.luggage.wxa.ic.d component, int i3, int i16, String content, b.c priority) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(priority, "priority");
        HashSet hashSet = f124766e;
        synchronized (hashSet) {
            com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.sdk.runtime.AppBrandRuntimeLU");
            boolean add = hashSet.add((com.tencent.luggage.wxa.c5.e) runtime);
            if (add && hashSet.size() == 1) {
                f124765d.a(f124764c);
            }
            if (add) {
                component.getRuntime().c0().a(new h(component));
            }
            Unit unit = Unit.INSTANCE;
        }
        c().a(1074L, 0L);
        synchronized (this) {
            b bVar = f124767f;
            bVar.a(new d(i3, i16, content, priority, component));
            b.d dVar = new b.d();
            dVar.a(component);
            dVar.a(i3);
            dVar.b(i16);
            dVar.a(priority);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long j3 = f124764c;
            dVar.a(timeUnit.toSeconds(j3));
            dVar.c(0);
            dVar.a(b.d.EnumC6165b.Enqueued);
            dVar.e();
            if (f.f124788a[priority.ordinal()] == 1) {
                f124762a.a(bVar.a(65536L), c.IMMEDIATE);
            } else if (bVar.a() >= 65536) {
                f124762a.a(bVar.a(65536L), c.REACH_SLICE_LIMIT);
            } else {
                long j16 = f124768g;
                if (j16 > 0 && w0.e(j16) >= j3) {
                    w.d("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "enqueue, Util.ticksToNow(lastDoCgiTick) >= REPORT_PERIOD_INTERVAL");
                    f124762a.a(c.TIMER_PERIOD);
                }
            }
        }
    }

    public final void a(com.tencent.luggage.wxa.ic.d dVar) {
        HashSet hashSet = f124766e;
        synchronized (hashSet) {
            com.tencent.luggage.wxa.ic.g runtime = dVar.getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.sdk.runtime.AppBrandRuntimeLU");
            hashSet.remove((com.tencent.luggage.wxa.c5.e) runtime);
            if (hashSet.size() == 0) {
                f124765d.f();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(c cVar) {
        a(f124767f.a(65536L), cVar);
    }

    public final synchronized void a(List list, c cVar) {
        f124765d.a(f124764c);
        f124768g = w0.a();
        w.d("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "doCgi queue.size=" + list.size() + ", reason=" + cVar.name());
        if (list.isEmpty()) {
            return;
        }
        c().a(1074L, 1L, list.size());
        c().a(1074L, 4L);
        com.tencent.luggage.wxa.eg.a aVar = new com.tencent.luggage.wxa.eg.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            LinkedList linkedList = aVar.a().f128832e;
            jg jgVar = new jg();
            jgVar.f127961d = dVar.g();
            jgVar.f127962e = com.tencent.luggage.wxa.fn.c.a(dVar.c());
            jgVar.f127963f = dVar.a();
            linkedList.add(jgVar);
        }
        aVar.a(null, new g(list));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f124789a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(List list) {
            super(2);
            this.f124789a = list;
        }

        public final void a(boolean z16, com.tencent.luggage.wxa.bj.a aVar) {
            int i3;
            int collectionSizeOrDefault;
            long sumOfLong;
            int collectionSizeOrDefault2;
            List list;
            w.d("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, isSucceed:" + z16 + ", exception:" + aVar);
            WeakHashMap weakHashMap = new WeakHashMap();
            if (z16) {
                for (d dVar : this.f124789a) {
                    a(weakHashMap, dVar.b(), dVar);
                    b.d dVar2 = new b.d();
                    dVar2.a(dVar.b());
                    dVar2.a(dVar.d());
                    dVar2.b(dVar.g());
                    dVar2.a(dVar.e());
                    dVar2.a(TimeUnit.MILLISECONDS.toSeconds(e.f124764c));
                    dVar2.c(dVar.f() - 1);
                    dVar2.a(b.d.EnumC6165b.Succeed);
                    dVar2.e();
                }
                e eVar = e.f124762a;
                eVar.c().a(1074L, 2L, this.f124789a.size());
                eVar.c().a(1074L, 5L);
            } else {
                int i16 = 0;
                for (d dVar3 : this.f124789a) {
                    if (e.f124767f.a(dVar3)) {
                        i16++;
                    } else {
                        a(weakHashMap, dVar3.b(), dVar3);
                        b.d dVar4 = new b.d();
                        dVar4.a(dVar3.b());
                        dVar4.a(dVar3.d());
                        dVar4.b(dVar3.g());
                        dVar4.a(dVar3.e());
                        dVar4.a(TimeUnit.MILLISECONDS.toSeconds(e.f124764c));
                        dVar4.c(dVar3.f() - 1);
                        dVar4.a(b.d.EnumC6165b.Failed);
                        dVar4.e();
                    }
                }
                if (i16 > 0) {
                    e.f124762a.c().a(1074L, 0L, i16);
                }
            }
            Set<Map.Entry> entrySet = weakHashMap.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "component2EntryMap.entries");
            for (Map.Entry entry : entrySet) {
                com.tencent.luggage.wxa.xd.d dVar5 = (com.tencent.luggage.wxa.xd.d) entry.getKey();
                if (dVar5 != null && dVar5.isRunning()) {
                    p context = new b.C6164b().setContext(dVar5);
                    HashMap hashMap = new HashMap();
                    if (z16) {
                        i3 = 0;
                    } else {
                        i3 = a.EnumC6074a.SERVER == (aVar != null ? aVar.f122898a : null) ? aVar.f122899b : -9999;
                    }
                    hashMap.put("errcode", Integer.valueOf(i3));
                    hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, aVar != null ? aVar.f122900c : null);
                    Object value = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "entry.value");
                    Iterable iterable = (Iterable) value;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((d) it.next()).c().length()));
                    }
                    sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList);
                    hashMap.put("dataSize", Long.valueOf(sumOfLong));
                    Object value2 = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value2, "entry.value");
                    Iterable iterable2 = (Iterable) value2;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    Iterator it5 = iterable2.iterator();
                    while (it5.hasNext()) {
                        arrayList2.add(Integer.valueOf(((d) it5.next()).d()));
                    }
                    list = CollectionsKt___CollectionsKt.toList(arrayList2);
                    hashMap.put("idList", new JSONArray((Collection) list));
                    context.setData(hashMap).dispatch();
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Boolean) obj).booleanValue(), (com.tencent.luggage.wxa.bj.a) obj2);
            return Unit.INSTANCE;
        }

        public static final void a(WeakHashMap weakHashMap, com.tencent.luggage.wxa.xd.d dVar, d dVar2) {
            if (dVar != null) {
                LinkedList linkedList = (LinkedList) weakHashMap.get(dVar);
                if (linkedList == null) {
                    linkedList = new LinkedList();
                    weakHashMap.put(dVar, linkedList);
                }
                linkedList.addLast(dVar2);
            }
        }
    }
}
